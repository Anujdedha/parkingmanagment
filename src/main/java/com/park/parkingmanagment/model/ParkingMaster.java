package com.park.parkingmanagment.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkingmasterdata")
public class ParkingMaster implements Serializable {
	@Id
	@Basic(optional = false)
	@Column(name = "parkingid")
	private String parkingid;
	@Column(name = "parkingcode")
	private String parkingcode;
	@Column(name = "parkingname")
	private String parkingname;
	@Column(name = "parkingaddress")
	private String parkingaddress;
	@Column(name = "parkingtype")
	private String parkingtype;
	@Column(name = "parkingslots")
	private int parkingslots;

	public ParkingMaster() {
		super();
	}

	

	public ParkingMaster(String parkingid, String parkingcode, String parkingname, String parkingaddress,
			String parkingtype, int parkingslots) {
		super();
		this.parkingid = parkingid;
		this.parkingcode = parkingcode;
		this.parkingname = parkingname;
		this.parkingaddress = parkingaddress;
		this.parkingtype = parkingtype;
		this.parkingslots = parkingslots;
	}



	public String getParkingid() {
		return parkingid;
	}



	public void setParkingid(String parkingid) {
		this.parkingid = parkingid;
	}



	public String getParkingcode() {
		return parkingcode;
	}



	public void setParkingcode(String parkingcode) {
		this.parkingcode = parkingcode;
	}



	public String getParkingname() {
		return parkingname;
	}



	public void setParkingname(String parkingname) {
		this.parkingname = parkingname;
	}



	public String getParkingaddress() {
		return parkingaddress;
	}



	public void setParkingaddress(String parkingaddress) {
		this.parkingaddress = parkingaddress;
	}



	public String getParkingtype() {
		return parkingtype;
	}



	public void setParkingtype(String parkingtype) {
		this.parkingtype = parkingtype;
	}



	public int getParkingslots() {
		return parkingslots;
	}



	public void setParkingslots(int parkingslots) {
		this.parkingslots = parkingslots;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parkingaddress == null) ? 0 : parkingaddress.hashCode());
		result = prime * result + ((parkingcode == null) ? 0 : parkingcode.hashCode());
		result = prime * result + ((parkingid == null) ? 0 : parkingid.hashCode());
		result = prime * result + ((parkingname == null) ? 0 : parkingname.hashCode());
		result = prime * result + parkingslots;
		result = prime * result + ((parkingtype == null) ? 0 : parkingtype.hashCode());
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
		ParkingMaster other = (ParkingMaster) obj;
		if (parkingaddress == null) {
			if (other.parkingaddress != null)
				return false;
		} else if (!parkingaddress.equals(other.parkingaddress))
			return false;
		if (parkingcode == null) {
			if (other.parkingcode != null)
				return false;
		} else if (!parkingcode.equals(other.parkingcode))
			return false;
		if (parkingid == null) {
			if (other.parkingid != null)
				return false;
		} else if (!parkingid.equals(other.parkingid))
			return false;
		if (parkingname == null) {
			if (other.parkingname != null)
				return false;
		} else if (!parkingname.equals(other.parkingname))
			return false;
		if (parkingslots != other.parkingslots)
			return false;
		if (parkingtype == null) {
			if (other.parkingtype != null)
				return false;
		} else if (!parkingtype.equals(other.parkingtype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParkingMaster [parkingid=" + parkingid + ", parkingcode=" + parkingcode + ", parkingname=" + parkingname
				+ ", parkingaddress=" + parkingaddress + ", parkingtype=" + parkingtype + ", parkingslots="
				+ parkingslots + "]";
	}

}
