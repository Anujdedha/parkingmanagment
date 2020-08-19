package com.park.parkingmanagment.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicletype")
public class VehicleType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "vehicletypeID")
	private String vehicletypeID;
	@Column(name = "vehiclecode")
	private String vehiclecode;
	@Column(name = "vehiclecharge")
	private int vehiclecharge;

	public VehicleType() {
		super();
	}

	public VehicleType(String vehicletypeID, String vehiclecode, int vehiclecharge) {
		super();
		this.vehicletypeID = vehicletypeID;
		this.vehiclecode = vehiclecode;
		this.vehiclecharge = vehiclecharge;
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

	public int getVehiclecharge() {
		return vehiclecharge;
	}

	public void setVehiclecharge(int vehiclecharge) {
		this.vehiclecharge = vehiclecharge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vehiclecharge;
		result = prime * result + ((vehiclecode == null) ? 0 : vehiclecode.hashCode());
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
		VehicleType other = (VehicleType) obj;
		if (vehiclecharge != other.vehiclecharge)
			return false;
		if (vehiclecode == null) {
			if (other.vehiclecode != null)
				return false;
		} else if (!vehiclecode.equals(other.vehiclecode))
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
		return "VehicleType [vehicletypeID=" + vehicletypeID + ", vehiclecode=" + vehiclecode + ", vehiclecharge="
				+ vehiclecharge + "]";
	}

	
}