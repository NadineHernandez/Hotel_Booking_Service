package com.trilogyed.hotelservice.Controller;

import com.trilogyed.hotelservice.ServiceLayer.HotelServiceLayer;
import com.trilogyed.hotelservice.ViewModel.HotelViewModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HotelController {

    HotelServiceLayer service;

    @GetMapping(value = "/hotelRewards/{roomId}?rewardsMember=[true|false]&doubleBonusDay=[true|false]")
    public HotelViewModel getBooking(@PathVariable int roomId, @PathParam("rewardsMember") boolean rewardsMember, @PathParam("doubleBonusDay") boolean doubleBonusDay) {
       return service.getBooking(roomId, rewardsMember, doubleBonusDay);
    }
}
