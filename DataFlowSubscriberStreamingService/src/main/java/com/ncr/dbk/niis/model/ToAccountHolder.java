package com.ncr.dbk.niis.model;

public class ToAccountHolder {
	private String hostId;
	private String name;
	private String pin;
	private AccountHolderHostIdType hostIdType;
	private AccountHolderType accountHolderType;
	private PinType pintype;

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public AccountHolderHostIdType getHostIdType() {
		return hostIdType;
	}

	public void setHostIdType(AccountHolderHostIdType hostIdType) {
		this.hostIdType = hostIdType;
	}

	public AccountHolderType getAccountHolderType() {
		return accountHolderType;
	}

	public void setAccountHolderType(AccountHolderType accountHolderType) {
		this.accountHolderType = accountHolderType;
	}

	public PinType getPintype() {
		return pintype;
	}

	public void setPintype(PinType pintype) {
		this.pintype = pintype;
	}
}