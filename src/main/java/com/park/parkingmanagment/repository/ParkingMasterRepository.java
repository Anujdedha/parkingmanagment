package com.park.parkingmanagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.park.parkingmanagment.model.ParkingMaster;


@Repository
public interface ParkingMasterRepository extends CrudRepository<ParkingMaster, String> {
	public ParkingMaster findByparkingcode(String vehiclecode);

	@Query("select 1  from ParkingMaster pm where pm.id.parkingid not in (:parkingid) and upper(pm.parkingcode) = :parkingcode")
	public List getParkingcode(@Param("parkingid") String parkingid, @Param("parkingcode") String parkingcode);
}
