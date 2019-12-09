package com.epam.webparsing.parser;

import com.epam.webparsing.entity.*;
import com.epam.webparsing.parser.Parser;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    private  List<TouristVoucher> touristVouchers;
    private DocumentBuilder documentBuilder;
    private TouristVoucher touristVoucher;

   public DomParser() {
        this.touristVouchers = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // в метод
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера:" + e);
        }
    }

   public List<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    public List<TouristVoucher> parse(String path) {
        Document document;
        try {
            document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();

            String eventTouristVoucher ="ns2:event-tourist-voucher";
            makeNodeList(root,eventTouristVoucher);

            String sportEventTouristVoucher = "ns2:sport-event-tourist-voucher";
            makeNodeList(root,sportEventTouristVoucher);

            String fanSportEventTouristVoucher = "ns2:fan-sport-event-tourist-voucher";
            makeNodeList(root,fanSportEventTouristVoucher);

            String participantSportEventTouristVoucher = "ns2:participant-sport-event-tourist-voucher";
            makeNodeList(root,participantSportEventTouristVoucher);

        } catch (SAXException e) {
            System.err.println("File error or I/O error:" + e);
        } catch (IOException e) {
            e.getMessage();
            System.err.println("Parsing failure :" + e);
        }
        return touristVouchers;
    }

    private void makeNodeList(Element root, String element){
        NodeList touristVoucherList = root.getElementsByTagName(element);
        for(int i = 0; i<touristVoucherList.getLength(); i++) {
            Element touristVoucherElement = (Element) touristVoucherList.item(i);
            switch (element) {
                case "ns2:event-tourist-voucher":
                    TouristVoucher eventTouristVoucher = buildEventTouristVoucher(touristVoucherElement,new EventTouristVoucher());
                    touristVouchers.add(eventTouristVoucher);
                    break;
                case "ns2:sport-event-tourist-voucher":
                    TouristVoucher sportEventTouristVoucher = buildSportEventTouristVoucher(touristVoucherElement,new SportEventTouristVoucher());
                    touristVouchers.add(sportEventTouristVoucher);
                    break;
                case "ns2:fan-sport-event-tourist-voucher":
                    TouristVoucher fanSportEventTouristVoucher = buildFanSportEventTouristVoucher(touristVoucherElement,new FanSportEventTouristVoucher());
                    touristVouchers.add(fanSportEventTouristVoucher);
                    break;
                case "ns2:participant-sport-event-tourist-voucher":
                    TouristVoucher participantSportEventTouristVoucher = buildParticipantSportEventTouristVoucher(touristVoucherElement,new ParticipantSportEventTouristVoucher());
                    touristVouchers.add(participantSportEventTouristVoucher);
                    break;
                default:
                    System.out.println("  ");
            }
        }
    }

    private Hotel getVoucherHotel(Element touristVoucherElement) {
        Hotel hotel = new Hotel();
        Element hotelElement = (Element) touristVoucherElement.getElementsByTagName("hotel").item(0);
        hotel.setCapacity(Integer.parseInt(getElementTextContent(hotelElement,"capacity")));
        hotel.setConditioner(Boolean.parseBoolean(getElementTextContent(hotelElement,"conditioner")));
        hotel.setNumberOfStars(Integer.parseInt(getElementTextContent(hotelElement,"number-of-stars")));
        hotel.setNutrition(Nutrition.valueOf(getElementTextContent(hotelElement,"nutrition")));
        hotel.setTv(Boolean.parseBoolean(getElementTextContent(hotelElement,"tv")));
        return hotel;
    }

    private EventTouristVoucher buildEventTouristVoucher(Element eventTouristVoucherElement,EventTouristVoucher eventTouristVoucher) {
        eventTouristVoucher.setCountry(getElementTextContent(eventTouristVoucherElement,"country"));
        eventTouristVoucher.setPrice(Integer.parseInt(getElementTextContent(eventTouristVoucherElement,"price")));
        eventTouristVoucher.setTransport(Transport.valueOf(getElementTextContent(eventTouristVoucherElement,"transport")));
        Hotel hotel = getVoucherHotel(eventTouristVoucherElement);
        eventTouristVoucher.setHotel(hotel);
        eventTouristVoucher.setDaysOfEvent(getElementTextContent(eventTouristVoucherElement,"days-of-event"));
        return eventTouristVoucher;
    }

    private SportEventTouristVoucher buildSportEventTouristVoucher(Element sportEventTouristVoucherElement, SportEventTouristVoucher sportEventTouristVoucher) {
        sportEventTouristVoucher = (SportEventTouristVoucher) buildEventTouristVoucher(sportEventTouristVoucherElement,sportEventTouristVoucher);
        sportEventTouristVoucher.setNameOfSportEvent(sportEventTouristVoucherElement.getAttribute("name-of-sport-event"));
        return sportEventTouristVoucher;
    }

    private FanSportEventTouristVoucher buildFanSportEventTouristVoucher(Element fanSportEventTouristVoucherElement, FanSportEventTouristVoucher fanSportEventTouristVoucher) {
        fanSportEventTouristVoucher = (FanSportEventTouristVoucher) buildEventTouristVoucher(fanSportEventTouristVoucherElement,fanSportEventTouristVoucher);
        fanSportEventTouristVoucher.setPlaceOnTribune(getElementTextContent(fanSportEventTouristVoucherElement,"place-on-tribune"));
        return fanSportEventTouristVoucher;
    }

    private ParticipantSportEventTouristVoucher buildParticipantSportEventTouristVoucher(Element participantSportEventTouristVoucherElement, ParticipantSportEventTouristVoucher participantSportEventTouristVoucher) {
        participantSportEventTouristVoucher = (ParticipantSportEventTouristVoucher) buildEventTouristVoucher(participantSportEventTouristVoucherElement, participantSportEventTouristVoucher);
        participantSportEventTouristVoucher.setTypeOfSport(getElementTextContent(participantSportEventTouristVoucherElement,"type-of-sport"));
        participantSportEventTouristVoucher.setTeam(getElementTextContent(participantSportEventTouristVoucherElement,"team"));
        return participantSportEventTouristVoucher;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
