package com.cba.api.dto;

import java.util.Date;

public class VehicleDetailsDTO {

	private String vinNumber;

	private String modelName;

	private String fuelType;

	private String variantName;

	private Date vehicleSoldDate;

	private String regNumber;

	private Date regDate;

	private String odometerReading;

	/**
	 * @return the vinNumber
	 */
	public String getVinNumber() {
		return vinNumber;
	}

	/**
	 * @param vinNumber the vinNumber to set
	 */
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @return the fuelType
	 */
	public String getFuelType() {
		return fuelType;
	}

	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * @return the variantName
	 */
	public String getVariantName() {
		return variantName;
	}

	/**
	 * @param variantName the variantName to set
	 */
	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	/**
	 * @return the vehicleSoldDate
	 */
	public Date getVehicleSoldDate() {
		return vehicleSoldDate;
	}

	/**
	 * @param vehicleSoldDate the vehicleSoldDate to set
	 */
	public void setVehicleSoldDate(Date vehicleSoldDate) {
		this.vehicleSoldDate = vehicleSoldDate;
	}

	/**
	 * @return the regNumber
	 */
	public String getRegNumber() {
		return regNumber;
	}

	/**
	 * @param regNumber the regNumber to set
	 */
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the odometerReading
	 */
	public String getOdometerReading() {
		return odometerReading;
	}

	/**
	 * @param odometerReading the odometerReading to set
	 */
	public void setOdometerReading(String odometerReading) {
		this.odometerReading = odometerReading;
	}

	@Override
	public String toString() {
		return "VehicleDetailsDTO [vinNumber=" + vinNumber + ", modelName=" + modelName + ", fuelType=" + fuelType
				+ ", variantName=" + variantName + ", vehicleSoldDate=" + vehicleSoldDate + ", regNumber=" + regNumber
				+ ", regDate=" + regDate + ", odometerReading=" + odometerReading + "]";
	}
	
	

}
