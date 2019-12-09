package com.epam.webparsing.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "nutrition")
@XmlEnum
public enum Nutrition {
    @XmlEnumValue("NONE")
    NONE,
    @XmlEnumValue("HB")
    HB,
    @XmlEnumValue("BB")
    BB,
    @XmlEnumValue("AL")
    AL
}
