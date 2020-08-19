package com.park.parkingmanagment.response;

public class ParkingExceptions extends Exception{

    private static final long serialVersionUID = 1L;
    private final String identifier;
    public ParkingExceptions() {
        super();
        identifier="";
    }

    public ParkingExceptions(final String arg0, String id) {
        super(arg0);
        identifier=id;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIdentifier() {
		return identifier;
	} 

}
