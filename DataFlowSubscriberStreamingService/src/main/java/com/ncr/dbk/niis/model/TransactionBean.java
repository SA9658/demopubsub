package com.ncr.dbk.niis.model;

public class TransactionBean {
	// Properties
	private String institutionId;
	private CustomerHostIds customerHostIds;
	private FromAccountHolder fromAccountHolder;
	private FromHostAccountId fromHostAccountId;
	private String fromHostProductCode;
	private String fromAccountType;
	private ToAccountHolder toAccountHolder;
	private ToHostAccountId toHostAccountId;
	private String toHostProductCode;
	private String toAccountType;
	private String transferPin;
	private TransferType transferType;
	private TransferOwnershipType transferOwnershipType;
	private FeeApplicationType feeApplicationType;
	private String transactionId;
	private TransactionAmount transactionAmounts;
	private BalanceVerification balanceVerification;
	private AncillaryKeys ancillaryKeys;
	private PaymentOptionType paymentOptionType;
	private PaymentContributionType paymentContributionType;
	private int numberOfPayments;
	private String description;
	private DescriptionSource descriptionSource;
	private String confirmation;
	private AdditionalInfo additionalInfo;
	/*
	 * private String additionalProperties; private String abbreviated;
	 */

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public CustomerHostIds getCustomerHostIds() {
		return customerHostIds;
	}

	public void setCustomerHostIds(CustomerHostIds customerHostIds) {
		this.customerHostIds = customerHostIds;
	}

	public FromAccountHolder getFromAccountHolder() {
		return fromAccountHolder;
	}

	public void setFromAccountHolder(FromAccountHolder fromAccountHolder) {
		this.fromAccountHolder = fromAccountHolder;
	}

	public FromHostAccountId getFromHostAccountId() {
		return fromHostAccountId;
	}

	public void setFromHostAccountId(FromHostAccountId fromHostAccountId) {
		this.fromHostAccountId = fromHostAccountId;
	}

	public String getFromHostProductCode() {
		return fromHostProductCode;
	}

	public void setFromHostProductCode(String fromHostProductCode) {
		this.fromHostProductCode = fromHostProductCode;
	}

	public String getFromAccountType() {
		return fromAccountType;
	}

	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}

	public ToAccountHolder getToAccountHolder() {
		return toAccountHolder;
	}

	public void setToAccountHolder(ToAccountHolder toAccountHolder) {
		this.toAccountHolder = toAccountHolder;
	}

	public ToHostAccountId getToHostAccountId() {
		return toHostAccountId;
	}

	public void setToHostAccountId(ToHostAccountId toHostAccountId) {
		this.toHostAccountId = toHostAccountId;
	}

	public String getToHostProductCode() {
		return toHostProductCode;
	}

	public void setToHostProductCode(String toHostProductCode) {
		this.toHostProductCode = toHostProductCode;
	}

	public String getToAccountType() {
		return toAccountType;
	}

	public void setToAccountType(String toAccountType) {
		this.toAccountType = toAccountType;
	}

	public String getTransferPin() {
		return transferPin;
	}

	public void setTransferPin(String transferPin) {
		this.transferPin = transferPin;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public TransferOwnershipType getTransferOwnershipType() {
		return transferOwnershipType;
	}

	public void setTransferOwnershipType(TransferOwnershipType transferOwnershipType) {
		this.transferOwnershipType = transferOwnershipType;
	}

	public FeeApplicationType getFeeApplicationType() {
		return feeApplicationType;
	}

	public void setFeeApplicationType(FeeApplicationType feeApplicationType) {
		this.feeApplicationType = feeApplicationType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionAmount getTransactionAmounts() {
		return transactionAmounts;
	}

	public void setTransactionAmounts(TransactionAmount transactionAmounts) {
		this.transactionAmounts = transactionAmounts;
	}

	public BalanceVerification getBalanceVerification() {
		return balanceVerification;
	}

	public void setBalanceVerification(BalanceVerification balanceVerification) {
		this.balanceVerification = balanceVerification;
	}

	public AncillaryKeys getAncillaryKeys() {
		return ancillaryKeys;
	}

	public void setAncillaryKeys(AncillaryKeys ancillaryKeys) {
		this.ancillaryKeys = ancillaryKeys;
	}

	public PaymentOptionType getPaymentOptionType() {
		return paymentOptionType;
	}

	public void setPaymentOptionType(PaymentOptionType paymentOptionType) {
		this.paymentOptionType = paymentOptionType;
	}

	public PaymentContributionType getPaymentContributionType() {
		return paymentContributionType;
	}

	public void setPaymentContributionType(PaymentContributionType paymentContributionType) {
		this.paymentContributionType = paymentContributionType;
	}

	public int getNumberOfPayments() {
		return numberOfPayments;
	}

	public void setNumberOfPayments(int numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DescriptionSource getDescriptionSource() {
		return descriptionSource;
	}

	public void setDescriptionSource(DescriptionSource descriptionSource) {
		this.descriptionSource = descriptionSource;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	/*
	 * public String getAdditionalProperties() { return additionalProperties; }
	 * 
	 * public void setAdditionalProperties(String additionalProperties) {
	 * this.additionalProperties = additionalProperties; }
	 * 
	 * public String isAbbreviated() { return abbreviated; }
	 * 
	 * public void setAbbreviated(String string) { this.abbreviated = string; }
	 */
}
