package com.park.parkingmanagment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "amountreceipt")
public class AmountReceipt implements Serializable {
	@Id
	@Basic(optional = false)
	@Column(name = "receiptno")
	private String receiptno;
	@Column(name = "vehicleno")
	private String vehicleno;
	@Column(name = "parkingid")
	private String parkingid;
	@Column(name = "parkingcode")
	private String parkingcode;
	@Column(name = "parkingname")
	private String parkingname;
	@Column(name = "parkingaddress")
	private String parkingaddress;
	@Column(name = "parkingamount")
	private int parkingamount;
	@Column(name = "createdon")
	private Date createdon;
	public AmountReceipt(String receiptno, String vehicleno, String parkingid, String parkingcode, String parkingname,
			String parkingaddress, int parkingamount, Date createdon) {
		super();
		this.receiptno = receiptno;
		this.vehicleno = vehicleno;
		this.parkingid = parkingid;
		this.parkingcode = parkingcode;
		this.parkingname = parkingname;
		this.parkingaddress = parkingaddress;
		this.parkingamount = parkingamount;
		this.createdon = createdon;
	}
	public AmountReceipt() {
		super();
	}
	public String getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
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
	public int getParkingamount() {
		return parkingamount;
	}
	public void setParkingamount(int parkingamount) {
		this.parkingamount = parkingamount;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdon == null) ? 0 : createdon.hashCode());
		result = prime * result + ((parkingaddress == null) ? 0 : parkingaddress.hashCode());
		result = prime * result + parkingamount;
		result = prime * result + ((parkingcode == null) ? 0 : parkingcode.hashCode());
		result = prime * result + ((parkingid == null) ? 0 : parkingid.hashCode());
		result = prime * result + ((parkingname == null) ? 0 : parkingname.hashCode());
		result = prime * result + ((receiptno == null) ? 0 : receiptno.hashCode());
		result = prime * result + ((vehicleno == null) ? 0 : vehicleno.hashCode());
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
		AmountReceipt other = (AmountReceipt) obj;
		if (createdon == null) {
			if (other.createdon != null)
				return false;
		} else if (!createdon.equals(other.createdon))
			return false;
		if (parkingaddress == null) {
			if (other.parkingaddress != null)
				return false;
		} else if (!parkingaddress.equals(other.parkingaddress))
			return false;
		if (parkingamount != other.parkingamount)
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
		if (receiptno == null) {
			if (other.receiptno != null)
				return false;
		} else if (!receiptno.equals(other.receiptno))
			return false;
		if (vehicleno == null) {
			if (other.vehicleno != null)
				return false;
		} else if (!vehicleno.equals(other.vehicleno))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AmountReceipt [receiptno=" + receiptno + ", vehicleno=" + vehicleno + ", parkingid=" + parkingid
				+ ", parkingcode=" + parkingcode + ", parkingname=" + parkingname + ", parkingaddress=" + parkingaddress
				+ ", parkingamount=" + parkingamount + ", createdon=" + createdon + "]";
	}
	
}
