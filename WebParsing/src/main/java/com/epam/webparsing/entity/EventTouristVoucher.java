package com.epam.webparsing.entity;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "event-tourist-voucher", namespace = "http://www.example.com/tourist-vouchers")
@XmlType(name = "event-tourist-voucher", propOrder = {"daysOfEvent"})
@XmlSeeAlso(SportEventTouristVoucher.class)
public class EventTouristVoucher extends TouristVoucher {

    public EventTouristVoucher() { }

    public EventTouristVoucher(String daysOfEvent) {
        this.daysOfEvent = daysOfEvent;
    }

    public EventTouristVoucher(int price, String country, Transport transport, Hotel hotel, String daysOfEvent) {
        super(price, country, transport, hotel);
        this.daysOfEvent = daysOfEvent;
    }

    @XmlElement(name = "days-of-event", required = true)
    private String daysOfEvent;

    public String getDaysOfEvent() {
        return daysOfEvent;
    }

    public void setDaysOfEvent(String daysOfEvent) {
        this.daysOfEvent = daysOfEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EventTouristVoucher that = (EventTouristVoucher) o;

        return daysOfEvent != null ? daysOfEvent.equals(that.daysOfEvent) : that.daysOfEvent == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (daysOfEvent != null ? daysOfEvent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventTouristVoucher {\n" +"daysOfEvent = " + daysOfEvent + '\n' +
                "price = " + super.getPrice() + '\n' +
                "country = " + super.getCountry() + '\n' +
                "transport = " + super.getTransport() + '\n' +
                "hotel = " + super.getHotel() + '\n';
    }
}
