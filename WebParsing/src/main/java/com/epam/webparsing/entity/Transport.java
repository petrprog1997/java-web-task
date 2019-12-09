package com.epam.webparsing.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "transport")
@XmlEnum
public enum Transport {
    @XmlEnumValue("PLANE")
    PLANE,
    @XmlEnumValue("TRAIN")
    TRAIN,
    @XmlEnumValue("CAR")
    CAR,
    @XmlEnumValue("SHIP")
    SHIP
}
