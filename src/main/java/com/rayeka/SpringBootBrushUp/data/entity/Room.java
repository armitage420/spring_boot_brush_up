package com.rayeka.SpringBootBrushUp.data.entity;

import javax.persistence.*;

@Entity
@Table(name="ROOM")
public class Room {
    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;

    @Column(name="NAME")
    private String name;

    @Column(name="ROOM_NUMBER")
    private Long roomNumber;

    @Column(name="BED_INFO")
    private String bedInfo;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }
}
