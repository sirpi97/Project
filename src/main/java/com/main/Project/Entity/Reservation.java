package com.main.Project.Entity;


import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity


public class Reservation {
	
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)

	@Column
	private int reserveid;

	@Column
	private String roomtype;

	@Column
	private int price;

	@Column
	private int noofrooms;

	@Column
	private int noofpersons;

	@Column
	private int noofchildren;

	/*@Column(name="CheckInTime")
	private Time InTime;
	@Column(name="CheckOutTime")
	private Time OutTime;*/


	@Temporal(TemporalType.TIMESTAMP)
	private Date CheckInDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date CheckOutDate;

	@Column
	private int stayDays;
	@Column
	private String guestName;
	@Column
	private int guestId;
	
	@Column
	private int RoomAvailable;
	/*@Column
	private String role;
	@Column
	private boolean active;
	@Column
	private String password;*/
	
	
	@PrePersist
	public void preMethod()
	{
		//this.role="RESERVATION";
		this.price=500*stayDays;
		this.CheckInDate=new Date();
		this.CheckOutDate=new Date();
		//this.active=true;
				
	}
	
	@ManyToOne(fetch= FetchType.LAZY)
	//@JoinColumn(name="userId")
   @JsonIgnoreProperties("reservation")
	private User user;


	public int getReserveid() {
		return reserveid;
	}

	public void setReserveid(int reserveid) {
		this.reserveid = reserveid;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}

	public int getNoofpersons() {
		return noofpersons;
	}

	public void setNoofpersons(int noofpersons) {
		this.noofpersons = noofpersons;
	}

	public int getNoofchildren() {
		return noofchildren;
	}

	public void setNoofchildren(int noofchildren) {
		this.noofchildren = noofchildren;
	}

	public Date getCheckInDate() {
		return CheckInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		CheckInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return CheckOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		CheckOutDate = checkOutDate;
	}

	public int getStayDays() {
		return stayDays;
	}

	public void setStayDays(int stayDays) {
		this.stayDays = stayDays;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public int getRoomAvailable() {
		return RoomAvailable;
	}

	public void setRoomAvailable(int roomAvailable) {
		RoomAvailable = roomAvailable;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reservation [reserveid=" + reserveid + ", roomtype=" + roomtype + ", price=" + price + ", noofrooms="
				+ noofrooms + ", noofpersons=" + noofpersons + ", noofchildren=" + noofchildren + ", CheckInDate="
				+ CheckInDate + ", CheckOutDate=" + CheckOutDate + ", stayDays=" + stayDays + ", guestName=" + guestName
				+ ", guestId=" + guestId + ", RoomAvailable=" + RoomAvailable +  ", user=" + user + "]";
	}

	public Reservation(int reserveid, String roomtype, int price, int noofrooms, int noofpersons, int noofchildren,
			Date checkInDate, Date checkOutDate, int stayDays, String guestName, int guestId, int roomAvailable,
			String role, boolean active, String password, User user) {
		super();
		this.reserveid = reserveid;
		this.roomtype = roomtype;
		this.price = price;
		this.noofrooms = noofrooms;
		this.noofpersons = noofpersons;
		this.noofchildren = noofchildren;
		CheckInDate = checkInDate;
		CheckOutDate = checkOutDate;
		this.stayDays = stayDays;
		this.guestName = guestName;
		this.guestId = guestId;
		RoomAvailable = roomAvailable;
		
		this.user = user;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	
	
	
	
	
	
	
	
	
	
	

	