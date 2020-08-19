package com.park.parkingmanagment.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.parkingmanagment.model.IdGenrationControl;
import com.park.parkingmanagment.model.VehicleType;
import com.park.parkingmanagment.repository.IdGenrationControlRepository;
import com.park.parkingmanagment.repository.VehicletypeRepository;
import com.park.parkingmanagment.response.ParkingExceptions;
import com.park.parkingmanagment.service.VehicletypeService;

@Service
public class VehicletypeServiceImpl implements VehicletypeService {
	@Autowired
	VehicletypeRepository vehicletyperepository;

	@Autowired
	IdGenrationControlRepository idgenration;

	@SuppressWarnings("unused")
	@Override
	public Map save(Map jsonMap) throws ParkingExceptions {
		VehicleType vehiclemodel = null;
		IdGenrationControl idgen = null;
		Map saveStatus = new HashMap();
		String accountgroupid = "";
		try {
			VehicleType list = vehicletyperepository.findByVehiclecode(jsonMap.get("vehiclecode").toString());
			IdGenrationControl id = idgenration.findById("vehiclecod").orElse(null);
			if (id != null) {
				if (list == null) {
					vehiclemodel = new VehicleType();
					vehiclemodel.setVehiclecode(jsonMap.get("vehiclecode").toString());
					vehiclemodel.setVehiclecharge(Integer.valueOf(jsonMap.get("vehiclecharge").toString()));
					vehiclemodel.setVehicletypeID("veh" + String.valueOf(id.getLastid() + 1));
					vehicletyperepository.save(vehiclemodel);
					id.setCode("vehiclecod");
					id.setLastid(id.getLastid() + 1);
					idgenration.save(id);
					saveStatus.put("status", "SAVE_SUCCESSFULLY");
				} else {
					throw new ParkingExceptions("vehiclecode already exist", "vehiclecode already exist");

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
	public Map getVehicle() throws ParkingExceptions {
		Map depdata = new HashMap();
		try {
			List typedata = (List) vehicletyperepository.findAll();
			depdata.put("vehicledata", typedata);
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
			List list = vehicletyperepository.getVehiclecode(jsonMap.get("vehicletypeID").toString(),
					jsonMap.get("vehiclecode").toString());
			if (list == null || list.size() == 0) {
				VehicleType dto = vehicletyperepository.findById(jsonMap.get("vehicletypeID").toString()).get();
				if (dto != null) {
					dto.setVehiclecode(jsonMap.get("vehiclecode").toString());
					dto.setVehiclecharge(Integer.valueOf(jsonMap.get("vehiclecharge").toString()));
					vehicletyperepository.save(dto);
					saveStatus.put("status", "UPDATE_SUCCESSFULLY");
				}
			} else {
				throw new ParkingExceptions("vehiclecode already exist", "vehiclecode already exist");
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
