package com.epam.webparsing.parser.jaxbparser;

import com.epam.webparsing.entity.*;
import com.epam.webparsing.parser.JaxbParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class JaxbParserTest {

    private JaxbParser jaxbParser = new JaxbParser();

    @Test
    public void testDomParserShouldReturnListOfEightTouristVouchersWhenEightTouristVoucersGivenAndAddInLIst() throws JAXBException {
        String givenPath = ".\\src\\main\\resources\\vouchers1.xml";
        List<TouristVoucher> givenVouchers = new ArrayList<>();
        Hotel hotel1 = new Hotel(4,2, Nutrition.HB,true,true);
        TouristVoucher touristVoucher1 = new EventTouristVoucher(2500,"Belarus", Transport.PLANE,hotel1,"20.06.2019-28.07.2019");
        givenVouchers.add(touristVoucher1);
        Hotel hotel2 = new Hotel(5,1,Nutrition.AL,true,false);
        TouristVoucher touristVoucher2 = new EventTouristVoucher(7000,"Great Britain",Transport.SHIP,hotel2,"14.01.2018-03.02.2018");
        givenVouchers.add(touristVoucher2);
        Hotel hotel3 = new Hotel(4,2,Nutrition.HB,true,true);
        TouristVoucher touristVoucher3 = new SportEventTouristVoucher(2500,"Belarus",Transport.PLANE,hotel3,"20.06.2019-28.07.2019","European Games");
        givenVouchers.add(touristVoucher3);
        Hotel hotel4 = new Hotel(5,1,Nutrition.AL,true,false);
        TouristVoucher touristVoucher4 = new SportEventTouristVoucher(7000,"Great Britain",Transport.SHIP,hotel4,"12.07.2018-19.07.2018","Wimbledon");
        givenVouchers.add(touristVoucher4);
        Hotel hotel5 = new Hotel(5,3,Nutrition.AL,true,false);
        TouristVoucher touristVoucher5 = new FanSportEventTouristVoucher(3500,"Brasilia",Transport.PLANE,hotel5,"12.07.2019-20.07.2019","Olympiad","sector 1 row 12 place 18");
        givenVouchers.add(touristVoucher5);
        Hotel hotel6 = new Hotel(4,2,Nutrition.HB,false,true);
        TouristVoucher touristVoucher6 = new FanSportEventTouristVoucher(12000,"USA",Transport.PLANE,hotel6,"25.09.2020-10.10.2020","Ice Hokey World Championship","sector 3 row 4 place 5");
        givenVouchers.add(touristVoucher6);
        Hotel hotel7 = new Hotel(5,2,Nutrition.HB,false,true);
        TouristVoucher touristVoucher7 = new ParticipantSportEventTouristVoucher(2400,"Denmark",Transport.CAR,hotel7,"1.12.2019-19.12.2019","Soccer-World-Cup","ManchesterUnited","soccer");
        givenVouchers.add(touristVoucher7);
        Hotel hotel8 = new Hotel(4,4,Nutrition.BB,true,true);
        TouristVoucher touristVoucher8 = new ParticipantSportEventTouristVoucher(1400,"Germany",Transport.TRAIN,hotel8,"04.03.2019-20.03.2019","Olympiad","Russia","sprint");
        givenVouchers.add(touristVoucher8);

        List<TouristVoucher> actualVouchers =  jaxbParser.parse(givenPath);
//        System.out.println(jaxbParser.parse(givenPath));
//        System.out.println(givenVouchers);
//        System.out.println(actualVouchers);
        Assert.assertEquals(givenVouchers,actualVouchers);
    }
}