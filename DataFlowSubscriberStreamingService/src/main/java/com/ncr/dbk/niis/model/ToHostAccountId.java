package com.ncr.dbk.niis.model;

public class ToHostAccountId {
	private String hostAccountId;
	private String currencyCode;
	private HostAccountIdType hostAccountIdType;
	public String getHostAccountId() {
		return hostAccountId;
	}
	public void setHostAccountId(String hostAccountId) {
		this.hostAccountId = hostAccountId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public HostAccountIdType getHostAccountIdType() {
		return hostAccountIdType;
	}
	public void setHostAccountIdType(HostAccountIdType hostAccountIdType) {
		this.hostAccountIdType = hostAccountIdType;
	}

}
