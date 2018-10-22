package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity
@Table(name="bill")
@NamedQuery(name="BillEntity.findAll", query="SELECT b FROM BillEntity b")
public class BillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_id")
	private int billId;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="delivery_date")
	private Date deliveryDate;

	@Column(name="phone_number")
	private String phoneNumber;

	private byte status;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

	//bi-directional many-to-one association to BillDetailEntity
	@OneToMany(mappedBy="bill")
	private List<BillDetailEntity> billDetails;

	public BillEntity() {
	}

	public int getBillId() {
		return this.billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<BillDetailEntity> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(List<BillDetailEntity> billDetails) {
		this.billDetails = billDetails;
	}

	public BillDetailEntity addBillDetail(BillDetailEntity billDetail) {
		getBillDetails().add(billDetail);
		billDetail.setBill(this);

		return billDetail;
	}

	public BillDetailEntity removeBillDetail(BillDetailEntity billDetail) {
		getBillDetails().remove(billDetail);
		billDetail.setBill(null);

		return billDetail;
	}

}