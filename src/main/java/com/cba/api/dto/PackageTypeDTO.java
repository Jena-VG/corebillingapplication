/**
 * 
 */
package com.cba.api.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author subashkumar.t
 *
 */
@Validated
public class PackageTypeDTO {
	
		
		private Integer pkgTypeId;
	
		@NotNull(message = "please enter package code ")
		private String pkgCode;
		
		@NotNull(message = "please enter duration ")
		private int duration;
	
		@NotBlank(message = "please enter package description ")
		private String pkgDesc;
		
		@NotNull(message = "please enter package price ")
		private Double pkgPrice;
	
		@NotNull(message = "please enter rsa price ")
		private Double rsaPrice;
		
		private String isActive;
		
		private Integer createdBy;

		@Temporal(TemporalType.DATE)
		@JsonFormat(pattern = "dd-MM-yyyy")
		private Date createdDate;
		
		private Integer updatedBy;

		@Temporal(TemporalType.DATE)
		@JsonFormat(pattern = "dd-MM-yyyy")
		private Date updatedDate;

	
		
		/**
		 * @return the pkgTypeId
		 */
		public Integer getPkgTypeId() {
			return pkgTypeId;
		}

		/**
		 * @param pkgTypeId the pkgTypeId to set
		 */
		public void setPkgTypeId(Integer pkgTypeId) {
			this.pkgTypeId = pkgTypeId;
		}

		/**
		 * @return the pkgCode
		 */
		public String getPkgCode() {
			return pkgCode;
		}

		/**
		 * @param pkgCode the pkgCode to set
		 */
		public void setPkgCode(String pkgCode) {
			this.pkgCode = pkgCode;
		}

		/**
		 * @return the duration
		 */
		public int getDuration() {
			return duration;
		}



		/**
		 * @param duration the duration to set
		 */
		public void setDuration(int duration) {
			this.duration = duration;
		}



		/**
		 * @return the pkgDesc
		 */
		public String getPkgDesc() {
			return pkgDesc;
		}



		/**
		 * @param pkgDesc the pkgDesc to set
		 */
		public void setPkgDesc(String pkgDesc) {
			this.pkgDesc = pkgDesc;
		}



		/**
		 * @return the pkgPrice
		 */
		public Double getPkgPrice() {
			return pkgPrice;
		}



		/**
		 * @param pkgPrice the pkgPrice to set
		 */
		public void setPkgPrice(Double pkgPrice) {
			this.pkgPrice = pkgPrice;
		}



		/**
		 * @return the rsaPrice
		 */
		public Double getRsaPrice() {
			return rsaPrice;
		}



		/**
		 * @param rsaPrice the rsaPrice to set
		 */
		public void setRsaPrice(Double rsaPrice) {
			this.rsaPrice = rsaPrice;
		}



		/**
		 * @return the isActive
		 */
		public String getIsActive() {
			return isActive;
		}



		/**
		 * @param isActive the isActive to set
		 */
		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}



		/**
		 * @return the createdBy
		 */
		public Integer getCreatedBy() {
			return createdBy;
		}



		/**
		 * @param createdBy the createdBy to set
		 */
		public void setCreatedBy(Integer createdBy) {
			this.createdBy = createdBy;
		}



		/**
		 * @return the createdDate
		 */
		public Date getCreatedDate() {
			return createdDate;
		}



		/**
		 * @param createdDate the createdDate to set
		 */
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}



		/**
		 * @return the updatedBy
		 */
		public Integer getUpdatedBy() {
			return updatedBy;
		}



		/**
		 * @param updatedBy the updatedBy to set
		 */
		public void setUpdatedBy(Integer updatedBy) {
			this.updatedBy = updatedBy;
		}



		/**
		 * @return the updatedDate
		 */
		public Date getUpdatedDate() {
			return updatedDate;
		}



		/**
		 * @param updatedDate the updatedDate to set
		 */
		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}



		@Override
		public String toString() {
			return "PackageTypeDTO [pkgTypeId=" + pkgTypeId + ", pkgCode=" + pkgCode + ", duration=" + duration
					+ ", pkgDesc=" + pkgDesc + ", pkgPrice=" + pkgPrice + ", rsaPrice=" + rsaPrice + ", isActive="
					+ isActive + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
					+ updatedBy + ", updatedDate=" + updatedDate + "]";
		}
	

		
}
