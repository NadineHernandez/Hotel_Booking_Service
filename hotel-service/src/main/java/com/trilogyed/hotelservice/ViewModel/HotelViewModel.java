package com.trilogyed.hotelservice.ViewModel;

import java.util.Objects;

public class HotelViewModel {
    private int roomNumber;
    private String roomType;
    private boolean rewardsMember;
    private boolean doubleBonusDay;
    private Float baseRate;
    private Float memberDiscount;
    private int baseRewardsPoints;
    private boolean canDouble;
    private Float finalCost;
    private int totalRewardsPoints;

    public HotelViewModel() {
    }

    public HotelViewModel(int roomNumber, String roomType, boolean rewardsMember, boolean doubleBonusDay, Float baseRate, Float memberDiscount, int baseRewardsPoints, boolean canDouble, Float finalCost, int totalRewardsPoints) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.rewardsMember = rewardsMember;
        this.doubleBonusDay = doubleBonusDay;
        this.baseRate = baseRate;
        this.memberDiscount = memberDiscount;
        this.baseRewardsPoints = baseRewardsPoints;
        this.canDouble = canDouble;
        this.finalCost = finalCost;
        this.totalRewardsPoints = totalRewardsPoints;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public boolean isDoubleBonusDay() {
        return doubleBonusDay;
    }

    public void setDoubleBonusDay(boolean doubleBonusDay) {
        this.doubleBonusDay = doubleBonusDay;
    }

    public Float getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Float baseRate) {
        this.baseRate = baseRate;
    }

    public Float getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(Float memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public int getBaseRewardsPoints() {
        return baseRewardsPoints;
    }

    public void setBaseRewardsPoints(int baseRewardsPoints) {
        this.baseRewardsPoints = baseRewardsPoints;
    }

    public boolean isCanDouble() {
        return canDouble;
    }

    public void setCanDouble(boolean canDouble) {
        this.canDouble = canDouble;
    }

    public Float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Float finalCost) {
        this.finalCost = finalCost;
    }

    public int getTotalRewardsPoints() {
        return totalRewardsPoints;
    }

    public void setTotalRewardsPoints(int totalRewardsPoints) {
        this.totalRewardsPoints = totalRewardsPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelViewModel that = (HotelViewModel) o;
        return roomNumber == that.roomNumber &&
                rewardsMember == that.rewardsMember &&
                doubleBonusDay == that.doubleBonusDay &&
                baseRewardsPoints == that.baseRewardsPoints &&
                canDouble == that.canDouble &&
                totalRewardsPoints == that.totalRewardsPoints &&
                roomType.equals(that.roomType) &&
                baseRate.equals(that.baseRate) &&
                memberDiscount.equals(that.memberDiscount) &&
                finalCost.equals(that.finalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, rewardsMember, doubleBonusDay, baseRate, memberDiscount, baseRewardsPoints, canDouble, finalCost, totalRewardsPoints);
    }
}
