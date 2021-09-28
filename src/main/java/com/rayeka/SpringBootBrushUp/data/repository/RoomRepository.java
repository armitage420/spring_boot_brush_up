package com.rayeka.SpringBootBrushUp.data.repository;

import com.rayeka.SpringBootBrushUp.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
