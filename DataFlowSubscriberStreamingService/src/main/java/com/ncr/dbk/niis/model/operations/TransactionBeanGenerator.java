package com.ncr.dbk.niis.model.operations;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ncr.dbk.niis.model.AccountHolderHostIdType;
import com.ncr.dbk.niis.model.Amount;
import com.ncr.dbk.niis.model.AncillaryKeys;
import com.ncr.dbk.niis.model.BalanceVerification;
import com.ncr.dbk.niis.model.CustomerHostIds;
import com.ncr.dbk.niis.model.DescriptionSource;
import com.ncr.dbk.niis.model.FeeApplicationType;
import com.ncr.dbk.niis.model.FromAccountHolder;
import com.ncr.dbk.niis.model.FromHostAccountId;
import com.ncr.dbk.niis.model.HostIdType;
import com.ncr.dbk.niis.model.PaymentContributionType;
import com.ncr.dbk.niis.model.PaymentOptionType;
import com.ncr.dbk.niis.model.PinType;
import com.ncr.dbk.niis.model.ToAccountHolder;
import com.ncr.dbk.niis.model.ToHostAccountId;
import com.ncr.dbk.niis.model.TransactionAmount;
import com.ncr.dbk.niis.model.TransactionBean;
import com.ncr.dbk.niis.model.TransferOwnershipType;
import com.ncr.dbk.niis.model.TransferType;

@Component
public class TransactionBeanGenerator implements Serializable {

	public TransactionBean getBean(Map<String, String> payloadMap) {
		// Declare Beans
		TransactionBean tBean = new TransactionBean();
		CustomerHostIds cIds = new CustomerHostIds();
		TransactionAmount tAmounts = new TransactionAmount();
		FromHostAccountId fhi = new FromHostAccountId();
		ToHostAccountId thi = new ToHostAccountId();
		FromAccountHolder fch = new FromAccountHolder();
		ToAccountHolder tah = new ToAccountHolder();
		Amount amount = new Amount();
		AncillaryKeys aKey = new AncillaryKeys();
		// start
		Iterator<String> itr = payloadMap.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			if (key.equals("DINUM")) {
				tBean.setInstitutionId(payloadMap.get(key));
			} else if (key.equals("USR")) {
				cIds.setHostId(payloadMap.get(key));
			} else if (key.equals("PIN")) {
				cIds.setPin(payloadMap.get(key));
			} else if (key.equals("TXTYP")) {
				TransferType tType = null;
				if (payloadMap.get(key).equals("0")) {
					tType = TransferType.TRANSFER;
				} else if (payloadMap.get(key).equals("3")) {
					tType = TransferType.TRANSFER_TO_GL;
				} else if (payloadMap.get(key).equals("4")) {
					tType = TransferType.TRANSFER_TO_EXTERNAL;
				} else if (payloadMap.get(key).equals("5")) {
					tType = TransferType.LOC_PAYDOWN;
				} else if (payloadMap.get(key).equals("6")) {
					tType = TransferType.TRANSFER_TO_FI_OWNED;
				} else if (payloadMap.get(key).equals("7")) {
					tType = TransferType.TRANSFER_FROM_FI_OWNED;
				} else if (payloadMap.get(key).equals("8")) {
					tType = TransferType.CD_REDEMPTION;
				} else if (payloadMap.get(key).equals("9")) {
					tType = TransferType.INTRA_INSTITUTION_TRANSFER;
				} else if (payloadMap.get(key).equals("10")) {
					tType = TransferType.LOAN_PAYOFF;
				} else if (payloadMap.get(key).equals("11")) {
					tType = TransferType.TRANSFER_FROM_GL;
				}
				tBean.setTransferType(tType);
			} else if (key.equals("XTX")) {
				TransferOwnershipType tot = null;
				if (payloadMap.get(key).equals("0")) {
					tot = TransferOwnershipType.UNKNOWN;
				} else if (payloadMap.get(key).equals("1")) {
					tot = TransferOwnershipType.JOINT_USER_TRANSFER;
				} else if (payloadMap.get(key).equals("2")) {
					tot = TransferOwnershipType.CROSS_USER_TRANSFER;
				}
				tBean.setTransferOwnershipType(tot);
			} else if (key.equals("TXWAIVEFEE")) {
				FeeApplicationType fat = null;
				if (payloadMap.get(key).equals("0")) {
					fat = FeeApplicationType.UNKNOWN;
				} else if (payloadMap.get(key).equals("1")) {
					fat = FeeApplicationType.WAIVE_FEE;
				} else if (payloadMap.get(key).equals("2")) {
					fat = FeeApplicationType.CHARGE_FEE;
				}
				tBean.setFeeApplicationType(fat);
			} else if (key.equals("TKEY")) {
				tBean.setTransactionId(payloadMap.get(key));
			} else if (key.equals("TAMT")) {
				amount.setValue(Integer.parseInt(payloadMap.get(key)));
			} else if (key.equals("FUSR")) {
				fch.setHostId(payloadMap.get(key));
			} else if (key.equals("FACIF")) {
				fch.setHostId(payloadMap.get(key));
			} else if (key.equals("FNUM")) {
				fhi.setHostAccountId(payloadMap.get(key));
			} else if (key.equals("NOBALCHK")) {
				BalanceVerification bvn = null;
				if (payloadMap.get(key).equals("0")) {
					bvn = BalanceVerification.VERIFY;
				} else if (payloadMap.get(key).equals("1")) {
					bvn = BalanceVerification.DO_NOT_VERIFY;
				}
				tBean.setBalanceVerification(bvn);
			} else if (key.equals("FCLNUM")) {
				fhi.setHostAccountId(payloadMap.get(key));
			} else if (key.equals("FNNUM")) {
				fhi.setHostAccountId(payloadMap.get(key));
			} else if (key.equals("FTYP")) {
				tBean.setFromAccountType(payloadMap.get(key));
			} else if (key.equals("REGE")) {
				tBean.setConfirmation(payloadMap.get(key));
			} else if (key.equals("HIDDEN")) {
				aKey.setKey("Default");
				aKey.setValue("Test");
				tBean.setAncillaryKeys(aKey);
			} else if (key.equals("AP2NXT")) {
				PaymentContributionType pcType = PaymentContributionType.NOT_APPLICABLE;
				tBean.setPaymentContributionType(pcType);
			} else if (key.equals("FCRNCY")) {
				fhi.setCurrencyCode(payloadMap.get(key));
			} else if (key.equals("TPAYOPT")) {
				PaymentOptionType poType = null;
				if (payloadMap.get(key).equals("0")) {
					poType = PaymentOptionType.DEFAULT;
				} else if (payloadMap.get(key).equals("1")) {
					poType = PaymentOptionType.MULTIPLE_PAYMENT;
				} else if (payloadMap.get(key).equals("2")) {
					poType = PaymentOptionType.INTEREST_ONLY;
				} else if (payloadMap.get(key).equals("3")) {
					poType = PaymentOptionType.PRINCIPAL_ONLY;
				} else if (payloadMap.get(key).equals("4")) {
					poType = PaymentOptionType.EXCESS_TO_INTEREST;
				} else if (payloadMap.get(key).equals("5")) {
					poType = PaymentOptionType.EXCESS_TO_PRINCIPAL;
				} else if (payloadMap.get(key).equals("6")) {
					poType = PaymentOptionType.ESCROW_ONLY;
				} else if (payloadMap.get(key).equals("7")) {
					poType = PaymentOptionType.FEES_ONLY;
				}
				tBean.setPaymentOptionType(poType);
			} else if (key.equals("NPAYMNT")) {
				tBean.setNumberOfPayments(Integer.parseInt(payloadMap.get(key)));
			} else if (key.equals("PRIORYEAR")) {
				PaymentContributionType pct = null;
				if (payloadMap.get(key).endsWith("0")) {
					pct = PaymentContributionType.CONTRIBUTION_CURRENT_YEAR;
				} else if (payloadMap.get(key).endsWith("1")) {
					pct = PaymentContributionType.CONTRIBUTION_LAST_YEAR;
				} else {
					pct = PaymentContributionType.DEFAULT;
				}
				tBean.setPaymentContributionType(pct);
			} else if (key.equals("TDESC")) {
				tBean.setDescription(payloadMap.get(key));
			} else if (key.equals("TDESCSRC")) {
				DescriptionSource ds = null;
				if (payloadMap.get(key).equals("0")) {
					ds = DescriptionSource.USER_PROVIDED;
				} else if (payloadMap.get(key).equals("1")) {
					ds = DescriptionSource.APPLICATION_PROVIDED;
				}
				tBean.setDescriptionSource(ds);
			} else if (key.equals("TACIF")) {
				tah.setHostId(payloadMap.get(key));
			} else if (key.equals("TNUM")) {
				thi.setHostAccountId(payloadMap.get(key));
			} else if (key.equals("TCLNUM")) {
				thi.setHostAccountId(payloadMap.get(key));
			} else if (key.equals("TNNUM")) {
				thi.setHostAccountId(payloadMap.get(key));
			} else if (key.equals("TTYP")) {
				tBean.setToAccountType(payloadMap.get(key));
			} else if (key.equals("TCRNCY")) {
				thi.setCurrencyCode(payloadMap.get(key));
			} else if (key.equals("PASSCODE")) {
				tBean.setTransferPin(payloadMap.get(key));
			} /*
				 * else if (key.equals("ABBR")) { tBean.setAbbreviated(payloadMap.get(key)); }
				 */
			// Unknown tags based on discussion with Manoj(5/10/2020)
			cIds.setHostIdType(HostIdType.UNKNOWN);
			cIds.setPinType(PinType.UNKNOWN);
			amount.setCurrencyCode("UNKNOWN");
			tAmounts.setAmount(amount);
			tAmounts.setType(null);
			fhi.setHostAccountIdType(null);
			thi.setHostAccountIdType(null);
			fch.setName("UNKNOWN");
			fch.setPin("UNKNOWN");
			fch.setAccountHolderType(null);
			fch.setHostIdType(AccountHolderHostIdType.UNKNOWN);
			fch.setPintype(PinType.UNKNOWN);
			tah.setName("UNKNOWN");
			tah.setPin("UNKNOWN");
			tah.setAccountHolderType(null);
			tah.setHostIdType(AccountHolderHostIdType.UNKNOWN);
			tah.setPintype(PinType.UNKNOWN);
			//
			tBean.setCustomerHostIds(cIds);
			tBean.setTransactionAmounts(tAmounts);
			tBean.setFromHostAccountId(fhi);
			tBean.setToHostAccountId(thi);
			tBean.setFromAccountHolder(fch);
			tBean.setToAccountHolder(tah);

		}
		return tBean;
	}
}
