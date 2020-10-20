package com.ncr.dbk.niis.model;

public class CustomerHostIds{

	private String hostId;
	private String pin;
	private HostIdType hostIdType;
	private PinType pinType;
	
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public HostIdType getHostIdType() {
		return hostIdType;
	}
	public void setHostIdType(HostIdType hostIdType) {
		this.hostIdType = hostIdType;
	}
	public PinType getPinType() {
		return pinType;
	}
	public void setPinType(PinType pinType) {
		this.pinType = pinType;
	}
	
	
}
