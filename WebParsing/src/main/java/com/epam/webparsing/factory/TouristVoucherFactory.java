package com.epam.webparsing.factory;

import com.epam.webparsing.parser.DomParser;
import com.epam.webparsing.parser.JaxbParser;
import com.epam.webparsing.parser.Parser;
import com.epam.webparsing.parser.SaxParser;

public class TouristVoucherFactory {
    private enum TypeParser {
        SAX, DOM, JAXB
    }
    public Parser createParser(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());

        switch (type) {
            case DOM:
                return new DomParser();
            case SAX:
                return new SaxParser();
            case JAXB:
                return new JaxbParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(),type.name());
        }
    }
}



