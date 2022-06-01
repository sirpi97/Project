package com.main.Project.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Project.Entity.Reservation;
import com.main.Project.Entity.User;
import com.main.Project.Repository.ReservationRep;
import com.main.Project.Service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class HotelReservationController
{
	private ReservationService reservationService;
	
	public HotelReservationController(ReservationService reservationService)
	{
		super();
		this.reservationService=reservationService;
	}
	


		@GetMapping
		public  List<Reservation> listAllReservation() {
			
			return reservationService.listAllReservation();
			
		}
		
		
		@GetMapping("{id}")
		public  Reservation getReservationById(@PathVariable("id") int id) {
			
			return reservationService.getReservationById(id) ;
			
		}
		@PostMapping
		public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
			return new ResponseEntity<Reservation>(reservationService.saveReservation(reservation), HttpStatus.CREATED);
			
		}
		
		@DeleteMapping("{id}")

		public String deleteReservation(@PathVariable("id") int id){
			reservationService.deleteReservation(id);
			return ("Reservation record deleted ");
			
		}
		@PutMapping("{id}")
		public ResponseEntity<Reservation> updateReservation(@PathVariable("id")int id , @RequestBody Reservation reservation) {
			return new ResponseEntity<Reservation>(reservationService.updateReservation( id, reservation), HttpStatus.OK);
			
		}

	
	
}