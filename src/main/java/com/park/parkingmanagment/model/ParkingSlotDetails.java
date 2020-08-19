package com.park.parkingmanagment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "parkingslotdata")
public class ParkingSlotDetails implements Serializable {
	@Id
	@Basic(optional = false)
	@Column(name = "parkingslotid")
	private String parkingslotid;
	@Column(name = "parkingid")
	private String parkingid;
	@Column(name = "vehicletypeID")
	private String vehicletypeID;
	@Column(name = "vehiclecode")
	private String vehiclecode;
	@Column(name = "vehicleno")
	private String vehicleno;
	@Column(name = "parkingstatus")
	private Character parkingstatus;
	@Column(name = "parkingdate")
	 @Temporal(TemporalType.TIMESTAMP)
	private Date parkingdate;
	
   
	@Column(name = "unparkingdate")
	 @Temporal(TemporalType.TIMESTAMP)
	private Date unparkingdate;
	@Column(name = "parkingslot")
	private String parkingslot;
	@Column(name = "parkingamount")
	private String parkingamount;
	@JoinColumn(name = "vehicletypeID", referencedColumnName = "vehicletypeID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private VehicleType vehicletype;
	@JoinColumn(name = "parkingid", referencedColumnName = "parkingid", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private ParkingMaster parkinmaster;
	public String getParkingid() {
		return parkingid;
	}
	public void setParkingid(String parkingid) {
		this.parkingid = parkingid;
	}
	public String getVehicletypeID() {
		return vehicletypeID;
	}
	public void setVehicletypeID(String vehicletypeID) {
		this.vehicletypeID = vehicletypeID;
	}
	public String getVehiclecode() {
		return vehiclecode;
	}
	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}
	public Character getParkingstatus() {
		return parkingstatus;
	}
	public void setParkingstatus(Character parkingstatus) {
		this.parkingstatus = parkingstatus;
	}
	public Date getParkingdate() {
		return parkingdate;
	}
	public void setParkingdate(Date parkingdate) {
		this.parkingdate = parkingdate;
	}
	public Date getUnparkingdate() {
		return unparkingdate;
	}
	public void setUnparkingdate(Date unparkingdate) {
		this.unparkingdate = unparkingdate;
	}
	public String getParkingslot() {
		return parkingslot;
	}
	public void setParkingslot(String parkingslot) {
		this.parkingslot = parkingslot;
	}
	public String getParkingamount() {
		return parkingamount;
	}
	public void setParkingamount(String parkingamount) {
		this.parkingamount = parkingamount;
	}
	public VehicleType getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(VehicleType vehicletype) {
		this.vehicletype = vehicletype;
	}
	public ParkingMaster getParkinmaster() {
		return parkinmaster;
	}
	public void setParkinmaster(ParkingMaster parkinmaster) {
		this.parkinmaster = parkinmaster;
	}
	public String getParkingslotid() {
		return parkingslotid;
	}
	public void setParkingslotid(String parkingslotid) {
		this.parkingslotid = parkingslotid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parkingamount == null) ? 0 : parkingamount.hashCode());
		result = prime * result + ((parkingdate == null) ? 0 : parkingdate.hashCode());
		result = prime * result + ((parkingid == null) ? 0 : parkingid.hashCode());
		result = prime * result + ((parkingslot == null) ? 0 : parkingslot.hashCode());
		result = prime * result + ((parkingslotid == null) ? 0 : parkingslotid.hashCode());
		result = prime * result + ((parkingstatus == null) ? 0 : parkingstatus.hashCode());
		result = prime * result + ((parkinmaster == null) ? 0 : parkinmaster.hashCode());
		result = prime * result + ((unparkingdate == null) ? 0 : unparkingdate.hashCode());
		result = prime * result + ((vehiclecode == null) ? 0 : vehiclecode.hashCode());
		result = prime * result + ((vehicleno == null) ? 0 : vehicleno.hashCode());
		result = prime * result + ((vehicletype == null) ? 0 : vehicletype.hashCode());
		result = prime * result + ((vehicletypeID == null) ? 0 : vehicletypeID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSlotDetails other = (ParkingSlotDetails) obj;
		if (parkingamount == null) {
			if (other.parkingamount != null)
				return false;
		} else if (!parkingamount.equals(other.parkingamount))
			return false;
		if (parkingdate == null) {
			if (other.parkingdate != null)
				return false;
		} else if (!parkingdate.equals(other.parkingdate))
			return false;
		if (parkingid == null) {
			if (other.parkingid != null)
				return false;
		} else if (!parkingid.equals(other.parkingid))
			return false;
		if (parkingslot == null) {
			if (other.parkingslot != null)
				return false;
		} else if (!parkingslot.equals(other.parkingslot))
			return false;
		if (parkingslotid == null) {
			if (other.parkingslotid != null)
				return false;
		} else if (!parkingslotid.equals(other.parkingslotid))
			return false;
		if (parkingstatus == null) {
			if (other.parkingstatus != null)
				return false;
		} else if (!parkingstatus.equals(other.parkingstatus))
			return false;
		if (parkinmaster == null) {
			if (other.parkinmaster != null)
				return false;
		} else if (!parkinmaster.equals(other.parkinmaster))
			return false;
		if (unparkingdate == null) {
			if (other.unparkingdate != null)
				return false;
		} else if (!unparkingdate.equals(other.unparkingdate))
			return false;
		if (vehiclecode == null) {
			if (other.vehiclecode != null)
				return false;
		} else if (!vehiclecode.equals(other.vehiclecode))
			return false;
		if (vehicleno == null) {
			if (other.vehicleno != null)
				return false;
		} else if (!vehicleno.equals(other.vehicleno))
			return false;
		if (vehicletype == null) {
			if (other.vehicletype != null)
				return false;
		} else if (!vehicletype.equals(other.vehicletype))
			return false;
		if (vehicletypeID == null) {
			if (other.vehicletypeID != null)
				return false;
		} else if (!vehicletypeID.equals(other.vehicletypeID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ParkingSlotDetails [parkingslotid=" + parkingslotid + ", parkingid=" + parkingid + ", vehicletypeID="
				+ vehicletypeID + ", vehiclecode=" + vehiclecode + ", vehicleno=" + vehicleno + ", parkingstatus="
				+ parkingstatus + ", parkingdate=" + parkingdate + ", unparkingdate=" + unparkingdate + ", parkingslot="
				+ parkingslot + ", parkingamount=" + parkingamount + ", vehicletype=" + vehicletype + ", parkinmaster="
				+ parkinmaster + "]";
	}
	
}
