package com.trilogyed.hotelservice.Controller;

import com.trilogyed.hotelservice.ServiceLayer.HotelServiceLayer;
import com.trilogyed.hotelservice.ViewModel.HotelViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/hotelRewards")
public class HotelController {
    @Autowired
    HotelServiceLayer service;

    @GetMapping(value = "/{roomId}",
            params = {"rewardsMember", "doubleBonusDay"})
    @ResponseStatus(value = HttpStatus.OK)
    public HotelViewModel getBooking(@PathVariable int roomId,
                                     @RequestParam(value = "rewardsMember") boolean rewardsMember,
                                     @RequestParam(value = "doubleBonusDay") boolean doubleBonusDay) {
       return service.getBooking(roomId, rewardsMember, doubleBonusDay);
    }
}
