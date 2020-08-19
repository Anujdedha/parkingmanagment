package com.park.parkingmanagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import com.park.parkingmanagment.model.ParkingSlotDetails;
@Repository
public interface ParkingSlotDetailsRepository extends CrudRepository<ParkingSlotDetails, String>{

	@Query("select COUNT(pd.parkingstatus) from ParkingSlotDetails pd"
			+ " where pd.parkingid=:parkingid and pd.parkingstatus='P' ")
	public int getOccupied(@Param("parkingid") String parkingid);
	
	@Query("select pd.parkingstatus from ParkingSlotDetails pd"
			+ " where pd.parkingid=:parkingid and pd.parkingstatus='P' and pd.parkingslot=:parkingslot ")
	public List getBusySlot(@Param("parkingid") String parkingid,@Param("parkingslot") String parkingslot);
	
	@Query(" from ParkingSlotDetails pd"
			+ " where pd.parkingid=:parkingid and pd.parkingstatus='P' and pd.parkingslot=:parkingslot ")
	public List getSlotDetails(@Param("parkingid") String parkingid,@Param("parkingslot") String parkingslot);


}
