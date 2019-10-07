package com.trilogyed.hotelservice.util.feign;

import com.trilogyed.hotelservice.util.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="room-service")
public interface RoomService {
    @GetMapping(value = "/room/{number}")
    public Room getRoom(@PathVariable int number);

    @GetMapping(value = "/room")
    public List<Room> getAllRooms();
}
