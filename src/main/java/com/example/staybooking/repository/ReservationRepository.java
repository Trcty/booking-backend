package com.example.staybooking.repository;

import com.example.staybooking.model.Reservation;
import com.example.staybooking.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.staybooking.model.User;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    //List<Reservation> findByGuest(User guest);


    List<Reservation> findByGuest_Username(String username);


    //List<Reservation> findByStay(Stay stay);


    List<Reservation> findByStay_Id(Long stayId);


    //Reservation findByIdAndGuest(Long id, User guest);


    Reservation findByIdAndGuest_Username(Long id, String username);


    List<Reservation> findByStayAndCheckoutDateAfter(Stay stay, LocalDate date);

}
