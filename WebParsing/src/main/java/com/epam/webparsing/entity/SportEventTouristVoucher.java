package com.epam.webparsing.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sport-event-tourist-voucher", namespace = "http://www.example.com/tourist-vouchers")
@XmlType(name = "sport-event-tourist-voucher", propOrder = {
        "nameOfSportEvent"
})
@XmlSeeAlso({FanSportEventTouristVoucher.class,ParticipantSportEventTouristVoucher.class})
public class SportEventTouristVoucher extends EventTouristVoucher {
    @XmlAttribute(required = true)
    private String nameOfSportEvent;

    public SportEventTouristVoucher() { }

    public SportEventTouristVoucher(String daysOfEvent, String nameOfSportEvent) {
        super(daysOfEvent);
        this.nameOfSportEvent = nameOfSportEvent;
    }
    public SportEventTouristVoucher(int price, String country, Transport transport, Hotel hotel, String daysOfEvent, String nameOfSportEvent) {
        super(price, country, transport, hotel, daysOfEvent);
        this.nameOfSportEvent = nameOfSportEvent;
    }

    public String getNameOfSportEvent() {
        return nameOfSportEvent;
    }

    public void setNameOfSportEvent(String nameOfSportEvent) {
        this.nameOfSportEvent = nameOfSportEvent;
    }

    @Override
    public String toString() {
        return "SportEventTouristVoucher {\n" +"nameOfSportEvent = " + nameOfSportEvent + '\n' +
                "daysOfEvent = " + super.getDaysOfEvent() + '\n' +
                "price = " + super.getPrice() + '\n' +
                "country = " + super.getCountry() + '\n' +
                "transport = " + super.getTransport() + '\n' +
                "hotel = " + super.getHotel() + '\n';
    }
}
