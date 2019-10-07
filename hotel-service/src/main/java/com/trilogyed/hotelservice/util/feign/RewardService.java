package com.trilogyed.hotelservice.util.feign;

import com.trilogyed.hotelservice.util.model.Rewards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="rewards-service")
public interface RewardService {
    @GetMapping(value="/rewards/type/{roomType}")
    public Rewards getRewards(@PathVariable String roomType);

    @GetMapping(value = "/rewards")
    public List<Rewards> getAllRewards();
}
