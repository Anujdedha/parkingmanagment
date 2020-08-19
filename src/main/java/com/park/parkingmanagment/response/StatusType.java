package com.park.parkingmanagment.response;


import java.util.List;

public class StatusType {
    private String responseStatus;
    private List<Error> errors;
    private String identifier;

    public StatusType(final String responseStatus, final List<Error> errors) {
        super();
        this.responseStatus = responseStatus;
        this.errors = errors;
    }
    public StatusType(final String responseStatus) {
        super();
        this.responseStatus = responseStatus;
        errors=null;
        identifier=null;
         
    }

    public StatusType(final String responseStatus, final String identifier,  final List<Error> errors) {
        super();
        this.responseStatus = responseStatus;
        this.errors = errors;
        this.identifier=identifier;
    }

    public String getResponseStatus() {
        return this.responseStatus;
    }

    public void setResponseStatus(final String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public void setErrors(final List<Error> errors) {
        this.errors = errors;
    }

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
    

}
