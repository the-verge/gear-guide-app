package com.verge.dto;

public class GuitarInfo extends BaseGearInfo {

    private String pickups;

    private Double scale;

    public String getPickups() {
        return pickups;
    }

    public void setPickups(String pickups) {
        this.pickups = pickups;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

}
