package com.trilogyed.hotelservice.ServiceLayer;

import com.trilogyed.hotelservice.ViewModel.HotelViewModel;
import com.trilogyed.hotelservice.util.feign.RewardService;
import com.trilogyed.hotelservice.util.feign.RoomService;
import com.trilogyed.hotelservice.util.model.Rewards;
import com.trilogyed.hotelservice.util.model.Room;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.doReturn;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class HotelServiceLayerTest {
    @InjectMocks
    private HotelServiceLayer serviceLayer;
    @Mock
    private RewardService rewardService;
    @Mock
    private RoomService roomService;

    @Before
    public void setUp() throws Exception {
        setUpRewardServiceMock();
        setUpRoomServiceMock();

    }

    @Test
    public void getBooking() {
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

         HotelViewModel tested = serviceLayer.getBooking(1, true, true);

        assertEquals(hvm, serviceLayer.getBooking(1, true, true));

    }


    public void setUpRewardServiceMock() {
        Rewards expected = new Rewards();
        expected.setId(1);
        expected.setRoomType("VIP");
        expected.setDiscount(new Float(".50"));
        expected.setPoints(10);
        expected.setCanDouble(true);

        doReturn(expected).when(rewardService).getRewards("VIP");


    }

    public void setUpRoomServiceMock() {
        Room expected = new Room();
        expected.setNumber(1);
        expected.setRoomType("VIP");
        expected.setBaseRate(new Float("100"));

        doReturn(expected).when(roomService).getRoom(expected.getNumber());
    }

    @After
    public void tearDown() throws Exception {

    }
}