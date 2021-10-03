package com.rayeka.SpringBootBrushUp.Business.Service;

import com.rayeka.SpringBootBrushUp.Business.Domain.RoomReservation;
import com.rayeka.SpringBootBrushUp.data.entity.Guest;
import com.rayeka.SpringBootBrushUp.data.entity.Reservation;
import com.rayeka.SpringBootBrushUp.data.entity.Room;
import com.rayeka.SpringBootBrushUp.data.repository.GuestRepository;
import com.rayeka.SpringBootBrushUp.data.repository.ReservationRepository;
import com.rayeka.SpringBootBrushUp.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    List<RoomReservation> getRoomReservationByDate(Date date){
        Iterable<Room> rooms = this.roomRepository.findAll();
        HashMap<Long, RoomReservation> roomReservationHashMap = new HashMap<>();
        rooms.forEach( room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getName());
            roomReservationHashMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.getReservationsByDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationHashMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        ArrayList<RoomReservation> roomReservationArrayList = new ArrayList<>();
        for (Long id: roomReservationHashMap.keySet()){
            roomReservationArrayList.add(roomReservationHashMap.get(id));
        }
        return roomReservationArrayList;
    }
}
