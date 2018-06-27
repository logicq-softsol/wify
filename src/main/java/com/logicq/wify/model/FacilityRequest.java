package com.logicq.wify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FACILITY_REQUEST")
public class FacilityRequest {
	
	@Id
	@Column(name = "REQ_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;

    @Column(name = "FACILITY_ID", nullable = false)
	private Long facilityId;
    
    @Column(name = "STATUS")
    private String status;

    @Column(name = "REQUESTER_NAME")
    private String requester;
    
    @Column(name = "REQUESTER_MOBILE")
    private String mobileNo;
    
    @Column(name = "COMMENT")
    private String comment;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	@Override
	public String toString() {
		return "FacilityRequest [requestId=" + requestId + ", facilityId=" + facilityId + ", status=" + status
				+ ", requester=" + requester + ", mobileNo=" + mobileNo + ", comment=" + comment + "]";
	}


	
    
}
