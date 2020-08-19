package com.park.parkingmanagment.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "idgenrationcontroller")
public class IdGenrationControl {
	@Id
	@Basic(optional = false)
	@Column(name = "code")
	private String code;
	@Column(name = "lastid")
	private int lastid;
	public IdGenrationControl(String code, int lastid) {
		super();
		this.code = code;
		this.lastid = lastid;
	}
	public IdGenrationControl() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getLastid() {
		return lastid;
	}
	public void setLastid(int lastid) {
		this.lastid = lastid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + lastid;
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
		IdGenrationControl other = (IdGenrationControl) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (lastid != other.lastid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IdGenrationControl [code=" + code + ", lastid=" + lastid + "]";
	}
	
}
