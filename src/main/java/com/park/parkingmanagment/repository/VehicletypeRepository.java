package com.park.parkingmanagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.park.parkingmanagment.model.VehicleType;


public interface VehicletypeRepository extends CrudRepository<VehicleType, String>{
	public VehicleType findByVehiclecode(String vehiclecode);
	@SuppressWarnings("rawtypes")
	@Query("select 1  from VehicleType vt where vt.id.vehicletypeID not in (:vehicletypeID) and upper(vt.vehiclecode) = :vehiclecode")
	public List getVehiclecode(@Param("vehicletypeID") String vehicletypeID,@Param("vehiclecode") String vehiclecode);
}
