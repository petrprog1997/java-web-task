package com.epam.webparsing.parser;

import com.epam.webparsing.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class TouristVoucherHandler extends DefaultHandler  {

    private List<TouristVoucher> vouchers;
    private TouristVoucher currentVoucher = null;
    private TouristVoucherEnum currentEnum = null;
   private EnumSet<TouristVoucherEnum> withText;


    public TouristVoucherHandler() {
        vouchers = new ArrayList<TouristVoucher>();
        withText = EnumSet.range(TouristVoucherEnum.PRICE,TouristVoucherEnum.TEAM);
    }

    public List<TouristVoucher> getTouristVouchers() {
        return  vouchers;
    }

    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }

    @Override
    public  void startElement(String uri, String localName, String qName, Attributes attributes){
        if("event-tourist-voucher".equals(localName)) {
            EventTouristVoucher event = new EventTouristVoucher();
            currentVoucher = new EventTouristVoucher();
            //System.out.println(currentVoucher);
        }

        else if ("sport-event-tourist-voucher".equals(localName)) {
            SportEventTouristVoucher sport = new SportEventTouristVoucher();
            sport.setNameOfSportEvent(attributes.getValue(0));
            currentVoucher = sport;
            //System.out.println(currentVoucher);
        }

        if("fan-sport-event-tourist-voucher".equals(localName)) {
            FanSportEventTouristVoucher fan = new FanSportEventTouristVoucher();
            fan.setNameOfSportEvent(attributes.getValue(0));
            currentVoucher = fan;
            //System.out.println(currentVoucher);
        }
        else if ("participant-sport-event-tourist-voucher".equals(localName)) {
            ParticipantSportEventTouristVoucher participant = new ParticipantSportEventTouristVoucher();
            participant.setNameOfSportEvent(attributes.getValue(0));
            currentVoucher = participant;
            //System.out.println(currentVoucher);
        }
        else {
            TouristVoucherEnum temp = TouristVoucherEnum.valueOf(localName.toUpperCase().replaceAll("-","_"));
            if(withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
      //  vouchers.add(currentVoucher);
        if(localName.equals("event-tourist-voucher")) {
            vouchers.add(currentVoucher);
        }
        else if(localName.equals("sport-event-tourist-voucher")){
            vouchers.add(currentVoucher);
        }
        else if(localName.equals("fan-sport-event-tourist-voucher")) {
            vouchers.add(currentVoucher);
        }
        else if(localName.equals("participant-sport-event-tourist-voucher")) {
            vouchers.add(currentVoucher);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        Hotel hotel = new Hotel();
       String s = new String(ch, start, length).replaceAll("\n","").trim();
       if(currentEnum != null) {
           switch (currentEnum) {
               case COUNTRY:
                   currentVoucher.setCountry(s);
                   break;
               case PRICE:
                   currentVoucher.setPrice(Integer.parseInt(s));
                   break;
               case TRANSPORT:
                   currentVoucher.setTransport(Transport.valueOf(s));
                   break;
               case NUMBER_OF_STARS:
                   hotel.setNumberOfStars(Integer.parseInt(s));
                   currentVoucher.setHotel(hotel);
                   break;
               case CAPACITY:
                   currentVoucher.getHotel().setCapacity(Integer.parseInt(s));
                   break;
               case NUTRITION:
                   currentVoucher.getHotel().setNutrition(Nutrition.valueOf(s));
                   break;
               case CONDITIONER:
                   currentVoucher.getHotel().setConditioner(Boolean.parseBoolean(s));
                   break;
               case TV:
                   currentVoucher.getHotel().setTv(Boolean.parseBoolean(s));
                   break;
               case DAYS_OF_EVENT:
                   ((EventTouristVoucher) currentVoucher).setDaysOfEvent(s);
                   break;
               case NAME_OF_SPORT_EVENT:
                   ((SportEventTouristVoucher) currentVoucher).setNameOfSportEvent(s);
                   break;
               case PLACE_ON_TRIBUNE:
                   ((FanSportEventTouristVoucher) currentVoucher).setPlaceOnTribune(s);
                   break;
               case TYPE_OF_SPORT:
                   ((ParticipantSportEventTouristVoucher) currentVoucher).setTypeOfSport(s);
                   break;
               case TEAM:
                   ((ParticipantSportEventTouristVoucher) currentVoucher).setTeam(s);
                   break;
               default:
                   throw new EnumConstantNotPresentException(
                           currentEnum.getDeclaringClass(), currentEnum.name());
           }
       }
       currentEnum = null;
    }
}
