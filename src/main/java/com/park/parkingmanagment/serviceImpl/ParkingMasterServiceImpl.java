package com.park.parkingmanagment.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.parkingmanagment.model.IdGenrationControl;
import com.park.parkingmanagment.model.ParkingMaster;
import com.park.parkingmanagment.repository.IdGenrationControlRepository;
import com.park.parkingmanagment.repository.ParkingMasterRepository;
import com.park.parkingmanagment.response.ParkingExceptions;
import com.park.parkingmanagment.service.ParkingMasterService;
@Service
public class ParkingMasterServiceImpl implements ParkingMasterService {
	@Autowired
	ParkingMasterRepository parkingmasterrepository;

	@Autowired
	IdGenrationControlRepository idgenration;

	@SuppressWarnings("unused")
	@Override
	public Map save(Map jsonMap) throws ParkingExceptions {
		ParkingMaster parkmaster = null;
		IdGenrationControl idgen = null;
		Map saveStatus = new HashMap();
		try {
			ParkingMaster list = parkingmasterrepository.findByparkingcode(jsonMap.get("parkingcode").toString());
			IdGenrationControl id = idgenration.findById("parkcode").orElse(null);
			if (id != null) {
				if (list == null) {
					parkmaster = new ParkingMaster();
					parkmaster.setParkingcode(jsonMap.get("parkingcode").toString());
					parkmaster.setParkingid("park" + String.valueOf(id.getLastid() + 1));
					parkmaster.setParkingaddress(jsonMap.get("parkingaddress").toString());
					parkmaster.setParkingname(jsonMap.get("parkingname").toString());
					parkmaster.setParkingslots(Integer.valueOf(jsonMap.get("parkingslots").toString()));
					parkmaster.setParkingtype(jsonMap.get("parkingtype").toString());
					parkingmasterrepository.save(parkmaster);
					id.setCode("parkcode");
					id.setLastid(id.getLastid() + 1);
					idgenration.save(id);
					saveStatus.put("status", "SAVE_SUCCESSFULLY");
				} else {
					throw new ParkingExceptions("ParkingCode "+jsonMap.get("parkingcode").toString()+" already exist ", "");

				}
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
	public Map getParkingData() throws ParkingExceptions {
		Map depdata = new HashMap();
		try {
			List typedata = (List) parkingmasterrepository.findAll();
			depdata.put("parkingdata", typedata);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return depdata;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map update(Map jsonMap) throws ParkingExceptions {
		Map saveStatus = new HashMap();
		try {
			List list = parkingmasterrepository.getParkingcode(jsonMap.get("parkingid").toString(),
					jsonMap.get("parkingcode").toString());
			if (list == null || list.size() == 0) {
				ParkingMaster parkmaster = parkingmasterrepository.findById(jsonMap.get("parkingid").toString()).get();
				if (parkmaster != null) {
					parkmaster.setParkingcode(jsonMap.get("parkingcode").toString());
					parkmaster.setParkingaddress(jsonMap.get("parkingaddress").toString());
					parkmaster.setParkingname(jsonMap.get("parkingname").toString());
					parkmaster.setParkingslots(Integer.valueOf(jsonMap.get("parkingslots").toString()));
					parkmaster.setParkingtype(jsonMap.get("parkingtype").toString());
					parkingmasterrepository.save(parkmaster);
					saveStatus.put("status", "UPDATE_SUCCESSFULLY");
				}
			} else {
				throw new ParkingExceptions("parkingcode already exist", "");
			}
			return saveStatus;
		} catch (ParkingExceptions e) {
			throw new ParkingExceptions(e.getMessage(), "");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return saveStatus;
	}
}
