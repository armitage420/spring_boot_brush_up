package com.rayeka.SpringBootBrushUp.data.repository;

import com.rayeka.SpringBootBrushUp.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
    Iterable<Guest> getGuestByGuestId(Long guestId);
}
