package com.main.Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.edu.SpringBoot.Entity.Employee;
import com.main.Project.Exception.ResourceNotFoundException;
//import com.edu.SpringBoot.Entity.Employee;
//import com.edu.SpringBoot.Entity.Employee;
import com.main.Project.Controller.HotelReservationController;
import com.main.Project.Entity.Reservation;
import com.main.Project.Repository.ReservationRep;

@Service
public class ReservationServiceImpl  implements ReservationService {

	 ReservationRep reservationrep;
	 
	 
	public ReservationServiceImpl(ReservationRep reservationrep) {
		super();
		this.reservationrep = reservationrep;
	}


	@Override
	public List<Reservation> listAllReservation() {
		// TODO Auto-generated method stub
		return reservationrep.findAll();
	}


	@Override
	public Reservation getReservationById(int id) {
		// TODO Auto-generated method stub
		Optional<Reservation> reservation = reservationrep.findById(id);
		
		if(reservation.isPresent()) {
			return reservation.get();
		}
		else {
			throw new ResourceNotFoundException("Reservation","Id",id);
		}
	}
	


	@Override
	public void deleteReservation(int id) {
		reservationrep.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Reservation","Id",id));
		
		reservationrep.deleteById(id);//13
		
	}


	@Override
	public Reservation saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationrep.save(reservation);
	}


	@Override
	public Reservation updateReservation(int id, Reservation reservation) {
		Reservation res = new Reservation();
		 try {
			 //orElseThrow();
			   res = reservationrep.findById(id).orElseThrow(
					 ()-> 		 new ResourceNotFoundException("Reservation","Id",id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String room=reservation.getRoomtype();
		res.setRoomtype(room);
		res.setPrice(reservation.getPrice());
		res.setNoofrooms(reservation.getNoofrooms());
		res.setNoofpersons(reservation.getNoofpersons());
		res.setNoofchildren(reservation.getNoofchildren());
		//res.setInTime(reservation.getInTime());
		//res.setOutTime(reservation.getInTime());
		//res.setArrivalDate(reservation.getArrivalDate());
		res.setCheckInDate(reservation.getCheckInDate());
		res.setCheckOutDate(reservation.getCheckOutDate());
		res.setStayDays(reservation.getStayDays());
		res.setGuestName(reservation.getGuestName());
		reservationrep.save(res);
		return res;
		}


	}
	
	



	

	