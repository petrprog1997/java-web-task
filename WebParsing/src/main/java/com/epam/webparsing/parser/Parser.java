package com.epam.webparsing.parser;

import com.epam.webparsing.entity.TouristVoucher;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface Parser {

    List<TouristVoucher> parse(String path) throws JAXBException;
}
