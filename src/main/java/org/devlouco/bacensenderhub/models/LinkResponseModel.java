package org.devlouco.bacensenderhub.models;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@XmlType(propOrder = {"href", "rel","type"})
public class LinkResponseModel {

    @XmlAttribute(name ="href")
    private String href;

    @XmlAttribute(name = "rel")
    private String rel;

    @XmlAttribute(name = "type")
    private String type;



}
