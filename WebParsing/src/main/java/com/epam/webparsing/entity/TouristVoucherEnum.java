package com.epam.webparsing.entity;

public enum TouristVoucherEnum {
    TOURIST_VOUCHERS("tourist-vouchers"),
    TOURIST_VOUCHER("tourist-voucher"),
    EVENT_TOURIST_VOUCHER("event-tourist-voucher"),
    SPORT_EVENT_TOURIST_VOUCHER("sport-event-tourist-voucher"),
    FAN_SPORT_EVENT_TOURIST_VOUCHER("fan-sport-event-tourist-voucher"),
    PARTICIPANT_SPORT_EVENT_TOURIST_VOUCHER("participant-sport-event-tourist-voucher"),
    PRICE("price"),
    COUNTRY("country"),
    TRANSPORT("transport"),
    NUMBER_OF_STARS("number-of-stars"),
    CAPACITY("capacity"),
    NUTRITION("nutrition"),
    CONDITIONER("conditioner"),
    TV("tv"),
    DAYS_OF_EVENT("days-of-event"),
    NAME_OF_SPORT_EVENT("name-of-sport-event"),
    PLACE_ON_TRIBUNE("place-on-tribune"),
    TYPE_OF_SPORT("type-of-sport"),
    TEAM("team"),
    HOTEL("hotel");

    private String value;
    private TouristVoucherEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
