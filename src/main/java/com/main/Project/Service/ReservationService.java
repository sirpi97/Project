package com.main.Project.Service;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.main.Project.Controller.HotelReservationController;
import com.main.Project.Entity.Reservation;
import com.main.Project.Repository.ReservationRep;

//Service Pattern for Reservation
public interface ReservationService {

	//List<ReservationRep> listAllEmployee();

	Reservation getReservationById(int id);

	

	void deleteReservation(int id);

	//Reservation saveEmployee(Reservation reservation);

	Reservation updateReservation(int id, Reservation reservation);

	List<Reservation> listAllReservation();



	Reservation saveReservation(Reservation reservation);

	

	
	

	

}
