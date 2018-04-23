package com.example.bimalka.busticketmachine;

/**
 * Created by Bimalka on 30/01/2018.
 */

public class SaveBusDetails {
    private String busNumber;
    private String from;
    private String to;
    private String seatsAvailable;
    private double longtitude;
    private double latitude;


    public SaveBusDetails(String busNumber,String from,String to,String seatsAvailable/*,double longtitude,double latitude*/) {
        this.busNumber = busNumber;
        this.from = from;
        this.to = to;
        this.seatsAvailable = seatsAvailable;
        /*this.longtitude = longtitude;
        this.latitude = latitude;*/
    }
    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    public String getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(String seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
   /*public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }*/


}
