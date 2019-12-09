package com.epam.webparsing.parser;

import com.epam.webparsing.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {
    public List<TouristVoucher> parse(String path) throws JAXBException {
        //File file = new File(path);
        List<TouristVoucher> list = new ArrayList<>();
        TouristVouchers voucher;
        JAXBContext jc = JAXBContext.newInstance(TouristVouchers.class);
//        try {
//
//            Marshaller m = jc.createMarshaller();
//            TouristVouchers touristVouchers = new TouristVouchers() {
//                {
//                    Hotel hotel1 = new Hotel(4, 2, Nutrition.HB, true, true);
//                    TouristVoucher touristVoucher1 = new EventTouristVoucher(2500, "Belarus", Transport.PLANE, hotel1, "20.06.2019-28.07.2019");
//                    this.add(touristVoucher1);
//                    Hotel hotel2 = new Hotel(5, 1, Nutrition.AL, true, false);
//                    TouristVoucher touristVoucher2 = new EventTouristVoucher(7000, "Great Britain", Transport.SHIP, hotel2, "14.01.2018-03.02.2018");
//                    this.add(touristVoucher2);
//                    Hotel hotel3 = new Hotel(4, 2, Nutrition.HB, true, true);
//                    TouristVoucher touristVoucher3 = new SportEventTouristVoucher(2500, "Belarus", Transport.PLANE, hotel3, "20.06.2019-28.07.2019", "European Games");
//                    this.add(touristVoucher3);
//                    Hotel hotel4 = new Hotel(5, 1, Nutrition.AL, true, false);
//                    TouristVoucher touristVoucher4 = new SportEventTouristVoucher(7000, "Great Britain", Transport.SHIP, hotel4, "12.07.2018-19.07.2018", "Wimbledon");
//                    this.add(touristVoucher4);
//                    Hotel hotel5 = new Hotel(5, 3, Nutrition.AL, true, false);
//                    TouristVoucher touristVoucher5 = new FanSportEventTouristVoucher(3500, "Brasilia", Transport.PLANE, hotel5, "12.07.2019-20.07.2019", "Olympiad", "sector 1 row 12 place 18");
//                    this.add(touristVoucher5);
//                    Hotel hotel6 = new Hotel(4, 2, Nutrition.HB, false, true);
//                    TouristVoucher touristVoucher6 = new FanSportEventTouristVoucher(12000, "USA", Transport.PLANE, hotel6, "25.09.2020-10.10.2020", "Ice Hokey World Championship", "sector 3 row 4 place 5");
//                    this.add(touristVoucher6);
//                    Hotel hotel7 = new Hotel(5, 2, Nutrition.HB, false, true);
//                    TouristVoucher touristVoucher7 = new ParticipantSportEventTouristVoucher(2400, "Denmark", Transport.CAR, hotel7, "1.12.2019-19.12.2019", "Soccer-World-Cup", "ManchesterUnited", "soccer");
//                    this.add(touristVoucher7);
//                    Hotel hotel8 = new Hotel(4, 4, Nutrition.BB, true, true);
//                    TouristVoucher touristVoucher8 = new ParticipantSportEventTouristVoucher(1400, "Germany", Transport.TRAIN, hotel8, "04.03.2019-20.03.2019", "Olympiad", "Russia", "sprint");
//                    this.add(touristVoucher8);
//                }
//            };
//            m.marshal(touristVouchers, new FileOutputStream(path));
//            m.marshal(touristVouchers, System.out);
//            System.out.println("XML-файл создан");
//        } catch (FileNotFoundException e) {
//            System.out.println("XML-файл не модет быть создан" + e);
//        } catch (JAXBException e) {
//            System.out.println("JAXB-контент ошибочен" + e);
//        }
        try {
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            voucher = (TouristVouchers) unmarshaller.unmarshal(new FileReader(path));
            return voucher.getTouristVouchers();
        } catch (JAXBException | FileNotFoundException e) {
            throw new JAXBException(e);
        }
       // return list;
    }

}