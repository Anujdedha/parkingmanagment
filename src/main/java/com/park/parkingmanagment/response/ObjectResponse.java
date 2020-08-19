package com.park.parkingmanagment.response;

import java.io.Serializable;

public class ObjectResponse<T> implements Serializable {

	private StatusType status;
	private T response;

	public StatusType getStatus() {
		return this.status;
	}

	public void setStatus(final StatusType status) {
		this.status = status;
	}

	public T getResponse() {
		return this.response;
	}

	public void setResponse(final T response) {
		this.response = response;
	}

	@SuppressWarnings("unchecked")
	public ObjectResponse() {
		status = new StatusType(null, null);
		response = (T) new Object();
	}
}
