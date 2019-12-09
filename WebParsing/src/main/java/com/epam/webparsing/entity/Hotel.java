package com.epam.webparsing.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotel", propOrder = {
        "numberOfStars",
        "capacity",
        "nutrition",
        "conditioner",
        "tv"
})
public class Hotel {

    @XmlElement(name = "number-of-stars", required = true)
    private int numberOfStars;
    @XmlElement(required = true)
    private int capacity;
    @XmlElement(required = true)
    private Nutrition nutrition;
    @XmlElement(required = true)
    private boolean conditioner;
    @XmlElement(required = true)
    private boolean tv;

    public Hotel() { }

    public Hotel(int numberOfStars, int capacity, Nutrition nutrition, boolean conditioner, boolean tv) {
        this.numberOfStars = numberOfStars;
        this.capacity = capacity;
        this.nutrition = nutrition;
        this.conditioner = conditioner;
        this.tv = tv;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (numberOfStars != hotel.numberOfStars) return false;
        if (capacity != hotel.capacity) return false;
        if (conditioner != hotel.conditioner) return false;
        if (tv != hotel.tv) return false;
        return nutrition == hotel.nutrition;
    }

    @Override
    public int hashCode() {
        int result = numberOfStars;
        result = 31 * result + capacity;
        result = 31 * result + (nutrition != null ? nutrition.hashCode() : 0);
        result = 31 * result + (conditioner ? 1 : 0);
        result = 31 * result + (tv ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "numberOfStars=" + numberOfStars +
                ", capacity=" + capacity +
                ", nutrition=" + nutrition +
                ", conditioner=" + conditioner +
                ", tv=" + tv +
                '}';
    }
}
