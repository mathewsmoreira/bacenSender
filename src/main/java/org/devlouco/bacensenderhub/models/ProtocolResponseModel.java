package org.devlouco.bacensenderhub.models;

import io.micrometer.core.instrument.binder.netty4.NettyAllocatorMetrics;
import jakarta.persistence.*;
import org.devlouco.bacensenderhub.services.exceptions.NotNullValidationService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@Entity
@XmlRootElement(name = "Resultado")
@XmlType(propOrder = {"protocol","linkContent"})
public class ProtocolResponseModel {

    private final String messageNotNull = "The Parameter cannot be null";
    private final String messageBlank = "The Parameter cannot be null or empty";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String protocol;


    @Embedded
    private LinkResponseModel linkContent;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel companyModel;

    public ProtocolResponseModel(Long ID, String protocol, LinkResponseModel linkContent, CompanyModel companyModel) {
        this.ID = ID;
        this.protocol = protocol;
        this.linkContent = linkContent;
        this.companyModel = companyModel;
    }

    public ProtocolResponseModel() {}

    public ProtocolResponseModel(String protocol, LinkResponseModel linkContent, CompanyModel companyModel) {
        this.protocol = protocol;
        this.linkContent = linkContent;
        this.companyModel = companyModel;
    }



    @XmlTransient
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        NotNullValidationService.notNull(ID,messageNotNull);
        this.ID = ID;
    }

    @XmlElement(name = "Protocolo")
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        NotNullValidationService.notBlank(protocol,messageBlank);
        this.protocol = protocol;
    }

    @XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
    public LinkResponseModel getLinkContent() {
        return linkContent;
    }

    public void setLinkContent(LinkResponseModel linkContent) {
        NotNullValidationService.notBlank(linkContent,messageBlank);
        this.linkContent = linkContent;
    }

    @XmlTransient
    public CompanyModel getCompanyModel() {
        return companyModel;
    }

    public void setCompanyModel(CompanyModel companyModel) {
        NotNullValidationService.notNull(companyModel,messageNotNull);
        this.companyModel = companyModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProtocolResponseModel that)) return false;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }

    @Override
    public String toString() {
        return "ProtocolResponseModel{" +
                "ID=" + ID +
                ", protocol='" + protocol + '\'' +
                ", linkContent='" + linkContent + '\'' +
                ", companyModel=" + companyModel +
                '}';
    }
}
