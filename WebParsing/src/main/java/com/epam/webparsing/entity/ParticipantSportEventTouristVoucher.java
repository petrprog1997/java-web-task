package com.epam.webparsing.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "participant-sport-event-tourist-voucher", namespace = "http://www.example.com/tourist-vouchers")
@XmlType(name = "participant-sport-event-voucher", propOrder = {
        "team",
        "typeOfSport"
})
public class ParticipantSportEventTouristVoucher extends SportEventTouristVoucher {
    @XmlElement(name = "team", required = true)
    private String team;
    @XmlElement(name = "type-of-sport", required = true)
    private String typeOfSport;

    public ParticipantSportEventTouristVoucher() { }

    public ParticipantSportEventTouristVoucher(int price, String country, Transport transport, Hotel hotel, String daysOfEvent,String nameOfSportEvent,String team, String typeOfSport) {
        super(price, country, transport, hotel, daysOfEvent, nameOfSportEvent);
        this.team = team;
        this.typeOfSport = typeOfSport;
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTypeOfSport() {
        return typeOfSport;
    }

    public void setTypeOfSport(String typeOfSport) {
        this.typeOfSport = typeOfSport;
    }

    @Override
    public String toString() {
        return "\nParticipantSportEventTouristVoucher{\n" +
                "team = " + team + '\n' +
                "typeOfSport = " + typeOfSport + '\n' +
                "nameOfSportEvent = " + super.getNameOfSportEvent() + '\n' +
                "daysOfEvent = " + super.getDaysOfEvent() + '\n' +
                "price = " + super.getPrice() + '\n' +
                "country = " + super.getCountry() + '\n' +
                "transport = " + super.getTransport() + '\n' +
                "hotel = " + super.getHotel() + '\n';
    }
}
