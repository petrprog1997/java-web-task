package com.epam.webparsing.parser;

import com.epam.webparsing.entity.TouristVoucher;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    private List<TouristVoucher> vouchers;
    private TouristVoucherHandler touristVoucherHandler;
    private XMLReader reader;

    public SaxParser() {
        touristVoucherHandler = new TouristVoucherHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(touristVoucherHandler);
        } catch (SAXException e) {
            System.err.println("Ошибка SAX парсера: " + e);
        }
    }

    @Override
    public List<TouristVoucher> parse(String path) {
        try {
            reader.parse(path);
        } catch (SAXException e) {
            System.err.println("Ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка I/O потока: " + e);
        }
        vouchers = touristVoucherHandler.getTouristVouchers();
        return vouchers;
    }
}
