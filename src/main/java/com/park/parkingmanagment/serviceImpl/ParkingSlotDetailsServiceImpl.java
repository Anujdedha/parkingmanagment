package com.park.parkingmanagment.serviceImpl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.parkingmanagment.model.AmountReceipt;
import com.park.parkingmanagment.model.IdGenrationControl;
import com.park.parkingmanagment.model.ParkingMaster;
import com.park.parkingmanagment.model.ParkingSlotDetails;
import com.park.parkingmanagment.model.VehicleType;
import com.park.parkingmanagment.repository.AmountReceiptRepository;
import com.park.parkingmanagment.repository.IdGenrationControlRepository;
import com.park.parkingmanagment.repository.ParkingMasterRepository;
import com.park.parkingmanagment.repository.ParkingSlotDetailsRepository;
import com.park.parkingmanagment.repository.VehicletypeRepository;
import com.park.parkingmanagment.response.ParkingExceptions;
import com.park.parkingmanagment.service.ParkingSlotDetailsService;

@Service
public class ParkingSlotDetailsServiceImpl implements ParkingSlotDetailsService {
	@Autowired
	ParkingSlotDetailsRepository parkingslotrepository;
	@Autowired
	IdGenrationControlRepository idgenration;
	@Autowired
	VehicletypeRepository vehiclerepository;
	@Autowired
	ParkingMasterRepository parkingmasterrepository;
	@Autowired
	AmountReceiptRepository amountrepoasitory;

	@Override
	public Map parkVehicle(Map jsonMap) throws ParkingExceptions {
		ParkingSlotDetails slotdata = null;
		IdGenrationControl idgen = null;
		Map saveStatus = new HashMap();
		try {
			ParkingMaster parkmaster = parkingmasterrepository.findById(jsonMap.get("parkingid").toString()).get();
			List busyslot = parkingslotrepository.getBusySlot(jsonMap.get("parkingid").toString(),
					jsonMap.get("parkingslot").toString());
			if (!busyslot.isEmpty()) {
				throw new ParkingExceptions("Slot Already Busy", "");
			}

			if (parkmaster.getParkingslots() < Integer.valueOf(jsonMap.get("parkingslot").toString())) {
				throw new ParkingExceptions("Slot not Avilable", "");
			}
			IdGenrationControl id = idgenration.findById("vehpark").orElse(null);
			if (id != null) {
				slotdata = new ParkingSlotDetails();
				slotdata.setParkingslotid("vehpark" + String.valueOf(id.getLastid() + 1));
				slotdata.setParkingid(jsonMap.get("parkingid").toString());
				slotdata.setParkingstatus('P');
				slotdata.setParkingdate(new Date());
				slotdata.setParkingslot(jsonMap.get("parkingslot").toString());
				slotdata.setVehiclecode(jsonMap.get("vehiclecode").toString());
				slotdata.setVehicleno(jsonMap.get("vehicleno").toString());
				slotdata.setVehicletypeID(jsonMap.get("vehicletypeID").toString());
				parkingslotrepository.save(slotdata);
				id.setCode("vehpark");
				id.setLastid(id.getLastid() + 1);
				idgenration.save(id);
				saveStatus.put("status", "SAVE_SUCCESSFULLY");

			} else {
				throw new ParkingExceptions("Please define id genration", "");
			}
		} catch (ParkingExceptions e) {
			throw new ParkingExceptions(e.getMessage(), "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public Map unparkVehicle(Map jsonMap) throws ParkingExceptions {
		IdGenrationControl idgen = null;
		Map saveStatus = new HashMap();
		int parkinghours = 0;
		VehicleType vechiledata = null;
		int parkingamount = 0;
		AmountReceipt amount = null;
		try {
			ParkingMaster parkmaster = parkingmasterrepository.findById(jsonMap.get("parkingid").toString()).get();
			ParkingSlotDetails slotdata = parkingslotrepository.findById(jsonMap.get("parkingslotid").toString())
					.orElse(null);
			if (slotdata != null) {
				slotdata.setParkingstatus('U');
				slotdata.setUnparkingdate(new Date());

				LocalDateTime ldt1 = LocalDateTime.ofInstant(slotdata.getParkingdate().toInstant(),
						ZoneId.systemDefault());
				LocalDateTime ldt2 = LocalDateTime.ofInstant(slotdata.getUnparkingdate().toInstant(),
						ZoneId.systemDefault());
				parkinghours = (int) ChronoUnit.MINUTES.between(ldt1, ldt2) / 60;
				if (parkinghours == 0) {
					parkinghours = 1;
				}
				vechiledata = vehiclerepository.findById(slotdata.getVehicletypeID()).orElse(null);
				if (vechiledata != null) {
					parkingamount = vechiledata.getVehiclecharge() * parkinghours;
				}
				slotdata.setParkingamount(String.valueOf(parkingamount));
				// creating parking receipt data
				IdGenrationControl id = idgenration.findById("recptno").orElse(null);
				if (id != null) {
					amount=new AmountReceipt();
					amount.setReceiptno("recpt" + String.valueOf(id.getLastid() + 1));
					amount.setCreatedon(new Date());
					amount.setParkingaddress(parkmaster.getParkingaddress());
					amount.setParkingamount(parkingamount);
					amount.setParkingcode(parkmaster.getParkingcode());
					amount.setParkingid(parkmaster.getParkingid());
					amount.setParkingname(parkmaster.getParkingname());
					amount.setVehicleno(slotdata.getVehicleno());
				} else {
					throw new ParkingExceptions("Please define id genration", "");
				}
				id.setCode("recptno");
				id.setLastid(id.getLastid() + 1);
				idgenration.save(id);
				parkingslotrepository.save(slotdata);
				amountrepoasitory.save(amount);
				saveStatus.put("Parkingamount", amount);
			} else {
				throw new ParkingExceptions("NO Data Found", "");
			}
		} catch (ParkingExceptions e) {
			throw new ParkingExceptions(e.getMessage(), "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public Map checkAvilablespace(Map jsonMap) throws ParkingExceptions {
		Map returnmap = new HashMap();
		int avilablespace = 0;
		try {
			int count = parkingslotrepository.getOccupied(jsonMap.get("parkingid").toString());
			ParkingMaster parkmaster = parkingmasterrepository.findById(jsonMap.get("parkingid").toString()).get();
			avilablespace = parkmaster.getParkingslots() - count;
			returnmap.put("avilableslots", avilablespace);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getSlotIsEmpty(Map jsonMap) throws ParkingExceptions {
		Map returnmap = new HashMap();
		try {
			List slotdetails = parkingslotrepository.getSlotDetails(jsonMap.get("parkingid").toString(),
					jsonMap.get("parkingslot").toString());
			if (slotdetails.isEmpty()) {
				returnmap.put("avilableslots", "Slot Is Empty");
			} else {
				returnmap.put("avilableslots", "Slot  In Use");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getSlotDetails(Map jsonMap) throws ParkingExceptions {
		Map returnmap = new HashMap();

		try {
			List slotdetails = parkingslotrepository.getSlotDetails(jsonMap.get("parkingid").toString(),
					jsonMap.get("parkingslot").toString());
			if (!slotdetails.isEmpty()) {
				returnmap.put("avilableslots", slotdetails);
			} else {
				returnmap.put("avilableslots", "Slot Not In Use");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}

	@Override
	public Map getAllData() throws ParkingExceptions {
		Map returnmap = new HashMap();

		try {
			List parkingdata = (List) parkingslotrepository.findAll();
			returnmap.put("avilableslots", parkingdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}
}
