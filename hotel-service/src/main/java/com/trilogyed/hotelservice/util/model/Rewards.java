package com.trilogyed.hotelservice.util.model;

import java.util.Objects;

public class Rewards {
    private Integer id;
    private String roomType;
    private Float discount;
    private Integer points;
    private Boolean canDouble;

    public Rewards() {
    }

    public Rewards(Integer id, String roomType, Float discount, Integer points, Boolean canDouble) {
        this.id = id;
        this.roomType = roomType;
        this.discount = discount;
        this.points = points;
        this.canDouble = canDouble;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return id.equals(rewards.id) &&
                roomType.equals(rewards.roomType) &&
                discount.equals(rewards.discount) &&
                points.equals(rewards.points) &&
                canDouble.equals(rewards.canDouble);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomType, discount, points, canDouble);
    }


}
