package com.adactin.entitymanager;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingData {

    @JsonProperty("id")
    private String id;

    @JsonProperty("location")
    private String location;

    @JsonProperty("hotelName")
    private String hotelName;
    @JsonProperty("checkIn")
    private String checkIn;

    @JsonProperty("checkOut")
    private String checkOut;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("adultsPerRoom")
    private String adultsPerRoom;

    @JsonProperty("childrenPerRoom")
    private String childrenPerRoom;

    @JsonProperty("roomType")
    private String roomType;

    @JsonProperty("noOfRooms")
    private String noOfRooms;

    @JsonProperty("billingAddress")
    private String billingAddress;

    @JsonProperty("ccNum")
    private String ccNum;

    @JsonProperty("ccType")
    private String ccType;

    @JsonProperty("ccExpiry")
    private String ccExpiry;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("pricePerNight")
    private String pricePerNight;

    @JsonProperty("totalPriceExcGST")
    private String totalPriceExcGST;

    @JsonProperty("gst")
    private String gst;

    @JsonProperty("totalPriceIncGST")
    private String totalPriceIncGST;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @JsonProperty("orderNumber")
    private String orderNumber;

    public String getTotalPriceIncGST() {
        return totalPriceIncGST;
    }

    public void setTotalPriceIncGST(String totalPriceIncGST) {
        this.totalPriceIncGST = totalPriceIncGST;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdultsPerRoom() {
        return adultsPerRoom;
    }

    public void setAdultsPerRoom(String adultsPerRoom) {
        this.adultsPerRoom = adultsPerRoom;
    }

    public String getChildrenPerRoom() {
        return childrenPerRoom;
    }

    public void setChildrenPerRoom(String childrenPerRoom) {
        this.childrenPerRoom = childrenPerRoom;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public String getCcExpiry() {
        return ccExpiry;
    }

    public void setCcExpiry(String ccExpiry) {
        this.ccExpiry = ccExpiry;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(String pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getTotalPriceExcGST() {
        return totalPriceExcGST;
    }

    public void setTotalPriceExcGST(String totalPriceExcGST) {
        this.totalPriceExcGST = totalPriceExcGST;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

}
