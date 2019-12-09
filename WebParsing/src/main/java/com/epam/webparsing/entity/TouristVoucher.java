package com.epam.webparsing.entity;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tourist-voucher", namespace = "http://www.example.com/tourist-vouchers")
@XmlType(name = "tourist-voucher", propOrder = {
        "country",
        "price",
        "transport",
        "hotel",
})
@XmlSeeAlso({EventTouristVoucher.class})
public abstract class TouristVoucher {

    @XmlElement(name = "price")
    private int price;

    @XmlElement(name = "country")
    private String country;

    @XmlElement(name = "transport")
    private Transport transport;

    @XmlElement(name = "hotel")
    private Hotel hotel;

    public TouristVoucher(){ }

    public TouristVoucher(int price, String country, Transport transport, Hotel hotel) {
        this.price = price;
        this.country = country;
        this.transport = transport;
        this.hotel = hotel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;}
        if (o == null || getClass() != o.getClass()) {
            return false;}

        TouristVoucher that = (TouristVoucher) o;

        if (Double.compare(that.price, price) != 0) {
            return false;
        }
        if (!that.country.equals(country)) {
            return false;
        }

        if(!hotel.equals(that.hotel)) {
            return false;
        }
        return transport != null ? transport.equals(that.transport) : that.transport == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "price = " + price + '\n' +
                "country = " + country + '\n' +
                "transport = " + transport + '\n' +
                "hotel = " + hotel + '\n';
    }
}
