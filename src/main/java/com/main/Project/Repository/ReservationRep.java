package com.main.Project.Repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.Project.Entity.Reservation;

@Repository
public interface ReservationRep extends JpaRepository<Reservation, Integer> {
	
	/*Optional<Reservation> findById(int resId);
	
	Collection<ReservationRep> findAllByUserId(int userId);

	static Reservation save(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	Reservation saveReservation(Reservation reservation);

	static Optional<Reservation> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	void deleteById(Long id);

	Optional<Reservation> findById(Long id);*/

}