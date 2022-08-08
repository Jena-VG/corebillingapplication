package com.cba.gst.integration.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cba.gst.integration.dto.Buyerdtl;
import com.cba.gst.integration.dto.Docdtl;
import com.cba.gst.integration.dto.GSTIntegrationDTO;
import com.cba.gst.integration.dto.Itemdtl;
import com.cba.gst.integration.dto.Sellerdtl;
import com.cba.gst.integration.dto.Trandtl;

@Component
public class GSTPortalDataValidator {

	public static final Logger logger = LoggerFactory.getLogger(GSTPortalDataValidator.class);

	public ArrayList<String> validateEinvoice(GSTIntegrationDTO einvoice, ArrayList<String> errorList) {
		// Validate Self GSTN
		String selfGstn = einvoice.getSelf_gstin();
		if (isAlphaNumeric(selfGstn)) {
			if (selfGstn.length() > 15) {
				errorList.add("Self GSTN must be max l5 char length.");
			}
		} else if (selfGstn.length() > 15) {
			errorList.add("Self GSTN must be valid alphanumeric string.");
			errorList.add("Self GSTN must be max l5 char length.");
		} else {
			errorList.add("Self GSTN must be valid alphanumeric string.");
		}

		// Validat IRN request
		String irnReq = einvoice.getIrnreq();
		switch (irnReq) {
		case "Y":
		case "N":
			break;
		default:
			errorList.add("Irnreq must be either 'Y' or 'N'.");
			break;
		}

		errorList = validateTranDtl(einvoice.getTrandtl(), errorList);
		errorList = validateDocDtl(einvoice.getDocdtl(), errorList);
		errorList = validateSupplierDtl(einvoice.getSupplierdtl(), errorList);
		errorList = validateBuyerDtl(einvoice.getBuyerdtl(), errorList);
		errorList = validateItemDtl(einvoice.getItemdtls(), errorList);

		return errorList;
	}

	private ArrayList<String> validateTranDtl(Trandtl trandtl, ArrayList<String> errorList) {
		// Validate trancategory
		String tranCategory = trandtl.getTrancatg();
		switch (tranCategory) {
		case "B2B":
		case "B2G":
			break;
		case "EXP":
			// TODO : validate export details
			break;

		case "B2C":
			break;

		default:
			errorList.add("Transaction category must be in 'B2B', 'B2G', 'B2C' or 'EXP'.");
			break;
		}

		// Validate reverse charge
		String revcharge = trandtl.getReversecharge();
		switch (revcharge) {
		case "Y":
		case "N":
			break;
		default:
			errorList.add("Reverse charge must be either 'Y' or 'N'.");
			break;
		}

		// Validate transaction mode
		String tranMode = trandtl.getTransactionmode();
		switch (tranMode) {
		case "REG":
		case "DIS":
		case "SHP":
		case "CMB":
			break;

		default:
			errorList.add("Transaction mode must be in 'REG', 'DIS', 'SHP' or 'CMB'.");
			break;
		}

		return errorList;
	}

	private ArrayList<String> validateDocDtl(Docdtl docdtl, ArrayList<String> errorList) {
		// Validate document type
		String docType = docdtl.getDocument_type();
		switch (docType) {
		case "INV":
		case "CRN":
		case "DBN":
		case "CHL":
		case "BIL":
		case "OTH":
			break;

		default:
			errorList.add("Document type should be INV, CRN, DBN, CHL, BIL or OTH");
			break;
		}

		String docNumber = docdtl.getDocno();

		if (docNumber == null) {
			errorList.add("Document number is mandatory.");
		} else {
			String regex = "[0-9|A-Z|a-z|/|-]{1,16}";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(docNumber);
			if (!m.matches()) {
				errorList.add(
						"Document number must be max 16 character, alphanumeric without special character except / and -.");
			}
		}

		String docDate = docdtl.getDocdt();
		if (docDate == null || docDate.equals("")) {
			errorList.add("Document date is mandatory.");
		}

		return errorList;
	}

	private ArrayList<String> validateSupplierDtl(Sellerdtl supdtl, ArrayList<String> errorList) {

		String sellerGSTN = supdtl.getSupplier_gstin();
		if (sellerGSTN == null || sellerGSTN.equals("")) {
			errorList.add("Supplier GSTN is required");
		} else if (isAlphaNumeric(sellerGSTN)) {
			if (sellerGSTN.length() > 15) {
				errorList.add("Supplier GSTN must be max l5 char length.");
			}
		} else if (sellerGSTN.length() > 15) {
			errorList.add("Supplier GSTN must be valid alphanumeric string.");
			errorList.add("Supplier GSTN must be max l5 char length.");
		} else {
			errorList.add("Supplier GSTN must be valid alphanumeric string.");
		}

		String sellerLegalName = supdtl.getSupplier_lglnm();
		String sellerTradeName = supdtl.getSupplier_trdnm();
		if ((sellerLegalName == null || sellerLegalName.length() < 3 || sellerLegalName.length() > 100)
				&& (sellerTradeName == null || sellerTradeName.length() < 3 || sellerTradeName.length() > 100)) {
			errorList.add("Supplier legal name must be between 3 - 100 char length.");
		}

		if (!isValidPin(supdtl.getSupplier_pin())) {
			errorList.add("Please provide valid supplier pincode.");
		}

		return errorList;
	}

	private ArrayList<String> validateBuyerDtl(Buyerdtl buyerdtl, ArrayList<String> errorList) {

		String buyerGSTN = buyerdtl.getBuyer_gstin();
		if (buyerGSTN == null || buyerGSTN.equals("")) {
			errorList.add("Buyer GSTN is required");
		} else if (isAlphaNumeric(buyerGSTN)) {
			if (buyerGSTN.length() > 15) {
				errorList.add("Buyer GSTN must be max l5 char length.");
			}
		} else if (buyerGSTN.length() > 15) {
			errorList.add("Buyer GSTN must be valid alphanumeric string.");
			errorList.add("Buyer GSTN must be max l5 char length.");
		} else {
			errorList.add("Buyer GSTN must be valid alphanumeric string.");
		}

		String buyerLegalName = buyerdtl.getBuyer_lglnm();
		String buyerTradeName = buyerdtl.getBuyer_trdnm();
		if ((buyerLegalName == null || buyerLegalName.length() < 3 || buyerLegalName.length() > 100)
				&& (buyerTradeName == null || buyerTradeName.length() < 3 || buyerTradeName.length() > 100)) {
			errorList.add("Buyer legal or trade name is required and must be between 3 - 100 char length.");
		}

		if (!isValidPin(buyerdtl.getBuyer_pin())) {
			errorList.add("Please provide valid Buyer pincode.");
		}

		return errorList;
	}

	private ArrayList<String> validateItemDtl(List<Itemdtl> itemdtls, ArrayList<String> errorList) {
		for (Itemdtl itemdtl : itemdtls) {
			String productName = itemdtl.getPrdnm();
			if (productName == null || productName.length() < 3 || productName.length() > 100) {
				errorList.add("Product name is mandatory.");
			}

			String hsn = itemdtl.getHsncd();
			if (hsn == null || hsn.length() < 2 || hsn.length() > 8) {
				errorList.add("HSN code is mandatory, must be 2-8 character length.");
			}

			Double qty = itemdtl.getQty();
			if (qty == null || qty <= 0) {
				errorList.add("Quantity is required.");
			}

			String unitQtyCode = itemdtl.getUqc();
			if (unitQtyCode == null || unitQtyCode.equals("") || unitQtyCode.length() > 3) {
				errorList.add("Valid unit quantity code is required.");
			}

			Double unitRate = itemdtl.getUnitrate();
			if (unitRate == null || unitRate < 0) {
				errorList.add("Unit rate is required.");
			}

			Double grossAmount = itemdtl.getGrossamt();
			if (grossAmount == null || grossAmount < 0) {
				errorList.add("Total amount is required.");
			}

			Double assassableAmount = itemdtl.getAssamt();
			if (assassableAmount == null || assassableAmount < 0) {
				errorList.add("Assassable amount is required.");
			}

			String taxability = itemdtl.getTaxability();
			switch (taxability) {
			case "NGT":
			case "TAX":
			case "EXM":
			case "NIL":
				break;

			default:
				errorList.add("Taxability must be in NGT, TAX, EXM or NIL.");
				break;
			}

		}
		return errorList;
	}

	private boolean isAlphaNumeric(String str) {
		// Regex to check string is alphanumeric or not.
		String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		if (str == null) {
			return false;
		}

		// To find matching between given string
		// and regular expression.
		Matcher m = p.matcher(str);

		return m.matches();
	}

	@SuppressWarnings("unused")
	private boolean isValidPin(String pin) {
		try {
			if (pin.length() == 6) {
				Long numPin = Long.parseLong(pin);
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}



}
