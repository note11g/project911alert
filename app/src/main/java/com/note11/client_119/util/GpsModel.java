package com.note11.client_119.util;

public class GpsModel {

    Double Longitude, Latitude;
    Long type;

    public GpsModel(){}

    public GpsModel(Double longitude, Double latitude, Long type) {
        Longitude = longitude;
        Latitude = latitude;
        this.type = type;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
