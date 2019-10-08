package com.trilogyed.hotelservice.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.hotelservice.ServiceLayer.HotelServiceLayer;
import com.trilogyed.hotelservice.ViewModel.HotelViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelController.class)
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getBooking() throws Exception {
        HotelViewModel hvm = new HotelViewModel();
        hvm.setRoomNumber(1);
        hvm.setRoomType("VIP");
        hvm.setRewardsMember(true);
        hvm.setDoubleBonusDay(true);
        hvm.setBaseRate(new Float("100"));
        hvm.setMemberDiscount(new Float(".50"));
        hvm.setBaseRewardsPoints(10);
        hvm.setCanDouble(true);
        hvm.setFinalCost(new Float("50"));
        hvm.setTotalRewardsPoints(20);

        String outputJson = mapper.writeValueAsString(hvm);
        when(service.getBooking(1, true, true)).thenReturn(hvm);

        this.mockMvc.perform(get("/hotelRewards/1?rewardsMember=true&doubleBonusDay=true")
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().json(outputJson));
    }
}