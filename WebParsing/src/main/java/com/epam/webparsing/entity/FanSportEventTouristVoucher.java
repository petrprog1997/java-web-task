package com.epam.webparsing.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "fan-sport-event-tourist-voucher", namespace = "http://www.example.com/tourist-vouchers")
@XmlType(name = "fan-sport-event-tourist-voucher")
public class FanSportEventTouristVoucher extends SportEventTouristVoucher {
    @XmlElement(name = "place-on-tribune")
    private String placeOnTribune;

    public FanSportEventTouristVoucher() { }

    public FanSportEventTouristVoucher(int price, String country, Transport transport, Hotel hotel, String daysOfEvent, String nameOfSportEvent, String placeOnTribune) {
        super(price, country, transport, hotel, daysOfEvent, nameOfSportEvent);
        this.placeOnTribune = placeOnTribune;
    }

    public String getPlaceOnTribune() {
        return placeOnTribune;
    }

    public void setPlaceOnTribune(String placeOnTribune) {
        this.placeOnTribune = placeOnTribune;
    }

    @Override
    public String toString() {
        return "\nFanSportEventTouristVoucher{\n" +
                "placeOnTribune = " + placeOnTribune + '\n' +
                "nameOfSportEvent = " + super.getNameOfSportEvent() + '\n' +
                "daysOfEvent = " + super.getDaysOfEvent() + '\n' +
                "price = " + super.getPrice() + '\n' +
                "country = " + super.getCountry() + '\n' +
                "transport = " + super.getTransport() + '\n' +
                "hotel = " + super.getHotel() + '\n';
    }
}
