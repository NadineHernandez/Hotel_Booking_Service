package com.trilogyed.hotelservice.ServiceLayer;

import com.trilogyed.hotelservice.ViewModel.HotelViewModel;
import com.trilogyed.hotelservice.util.feign.RewardService;
import com.trilogyed.hotelservice.util.feign.RoomService;
import com.trilogyed.hotelservice.util.model.Rewards;
import com.trilogyed.hotelservice.util.model.Room;
import org.springframework.stereotype.Component;

@Component
public class HotelServiceLayer {
    RewardService rewardService;
    RoomService roomService;

    public HotelServiceLayer(RewardService rewardService, RoomService roomService) {
        this.rewardService = rewardService;
        this.roomService = roomService;
    }

    public HotelViewModel getBooking(int roomId, boolean rewardsMember, boolean doubleBonusDay) {
        Room room = roomService.getRoom(roomId);
        Rewards rewards = rewardService.getRewards(room.getRoomType());

        HotelViewModel hvm = new HotelViewModel();
        hvm.setRoomNumber(room.getNumber());
        hvm.setRoomType(room.getRoomType());
        hvm.setRewardsMember(rewardsMember);
        hvm.setDoubleBonusDay(doubleBonusDay);
        hvm.setBaseRate(room.getBaseRate());
        hvm.setMemberDiscount(rewards.getDiscount());
        hvm.setBaseRewardsPoints(rewards.getPoints());
        hvm.setCanDouble(rewards.getCanDouble());

        if(rewardsMember) {
            if (doubleBonusDay && rewards.getCanDouble()) {
                hvm.setTotalRewardsPoints(rewards.getPoints() * 2);
            }
            hvm.setFinalCost((room.getBaseRate() * (1 - rewards.getDiscount())));
        } else {
            hvm.setTotalRewardsPoints(0);
            hvm.setFinalCost(room.getBaseRate());
        }
        return hvm;
    }
}
