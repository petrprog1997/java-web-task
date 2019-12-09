package com.epam.webparsing.director;

import com.epam.webparsing.parser.DomParser;
import com.epam.webparsing.parser.JaxbParser;

import javax.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        System.out.println(jaxbParser.parse(".\\src\\main\\resources\\vouchers.xml"));
        DomParser domParser = new DomParser();
        System.out.println(domParser.parse(".\\src\\main\\resources\\vouchers.xml"));
    }
}
