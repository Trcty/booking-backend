package com.example.staybooking.service;

import com.example.staybooking.model.Stay;
import com.example.staybooking.repository.LocationRepository;
import com.example.staybooking.repository.StayRepository;
import com.example.staybooking.repository.StayReservationDateRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
public class SearchService {
    private final StayRepository stayRepository;
    private final StayReservationDateRepository stayReservationDateRepository;
    private final LocationRepository locationRepository;


    public SearchService(StayRepository stayRepository, StayReservationDateRepository stayReservationDateRepository, LocationRepository locationRepository) {
        this.stayRepository = stayRepository;
        this.stayReservationDateRepository = stayReservationDateRepository;
        this.locationRepository = locationRepository;
    }


    public List<Stay> search(int guestNumber, LocalDate checkinDate, LocalDate checkoutDate, double lat, double lon, String distance) {
        List<Long> stayIds = locationRepository.searchByDistance(lat, lon, distance); // find all stays winthin the ranhge
        if (stayIds == null || stayIds.isEmpty()) {
            return Collections.emptyList();
        }

        // get those that are booked
        Set<Long> reservedStayIds = stayReservationDateRepository.findByIdInAndDateBetween(stayIds, checkinDate, checkoutDate.minusDays(1));
        List<Long> filteredStayIds = stayIds.stream()
                .filter(stayId -> !reservedStayIds.contains(stayId))
                .collect(Collectors.toList());// filter out those are already booked
        return stayRepository.findByIdInAndGuestNumberGreaterThanEqual(filteredStayIds, guestNumber);
    }
}
