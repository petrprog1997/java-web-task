package com.epam.webparsing.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "touristVouchers"

})
@XmlRootElement(name = "tourist-vouchers")
public class TouristVouchers {

    //@XmlElement(name = "tourist-voucher")
   @XmlElementRefs(value = {@XmlElementRef(name = "event-tourist-voucher"),@XmlElementRef(name = "sport-event-tourist-voucher"),@XmlElementRef(name = "fan-sport-event-tourist-voucher"),@XmlElementRef(name = "participant-sport-event-tourist-voucher")})
    private List<TouristVoucher> touristVouchers = new ArrayList<>();

    public TouristVouchers() {
        super();
    }

    public void setTouristVoucherList(List<TouristVoucher> touristVouchers) {
        this.touristVouchers = touristVouchers;
    }

    public List<TouristVoucher> getTouristVouchers() {
        if(touristVouchers  == null) {
            touristVouchers = new ArrayList<>();
        }
        return touristVouchers;
    }

    public boolean add(TouristVoucher voucher) {
        return touristVouchers.add(voucher);
    }

    @Override
    public String toString() {
        return "TouristVouchers[" +
                "list=" + touristVouchers +
                ']';
    }
}
