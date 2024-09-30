package org.devlouco.bacensenderhub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@Entity
@XmlRootElement(name = "Parametros")
@XmlType(propOrder = {"idetification","hash","size","docName","observation","recipient"})
public class ProtocolModel {

    public ProtocolModel(Long ID, LocalDate date, String idetification, String hash, long size, String docName, String observation, String recipient, CompanyModel company, byte[] filesBytes) {
        this.ID = ID;
        this.date = date;
        this.idetification = idetification;
        this.hash = hash;
        this.size = size;
        this.docName = docName;
        this.observation = observation;
        this.recipient = recipient;
        this.company = company;
        this.filesBytes = filesBytes;
    }

    public ProtocolModel() {}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    private LocalDate date;


    @NotBlank
    private String idetification;

    @NotBlank
    @Size(max = 64)
    private String hash;


    private long size;

    @NotBlank
    private String docName;

    private String observation;

    @NotBlank

    private String recipient;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    private byte filesBytes[];


    @XmlTransient
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @XmlTransient
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @XmlElement(name = "IdentificadorDocumento")
    public String getIdetification() {
        return idetification;
    }

    public void setIdetification(String idetification) {
        this.idetification = idetification;
    }

    @XmlElement(name = "Hash")
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @XmlElement(name = "Tamanho")
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
    @XmlElement(name = "NomeArquivo")
    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    @XmlElement(name = "Observacao")
    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @XmlElement(name = "Destinatarios")
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @XmlTransient
    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    @XmlTransient
    public byte[] getFilesBytes() {
        return filesBytes;
    }

    public void setFilesBytes(byte[] filesBytes) {
        this.filesBytes = filesBytes;
    }

    public static Builder builder(){
        return new Builder();
    }

    public final static class Builder {


        private Long ID;
        private LocalDate date;
        private String idetification;
        private String hash;
        private long size;
        private String docName;
        private String observation;
        private String recipient;
        private CompanyModel company;
        private byte filesBytes[];

        public Builder withID(Long ID) {
            this.ID = ID;
            return this;
        }
        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder withIdetification(String idetification) {
            this.idetification = idetification;
            return this;
        }
        public Builder withHash(String hash) {
            this.hash = hash;
            return this;
        }
        public Builder withSize(long size) {
            this.size = size;
            return this;
        }
        public Builder withDocName(String docName) {
            this.docName = docName;
            return this;
        }
        public Builder withObservation(String observation) {
            this.observation = observation;
            return this;
        }
        public Builder withRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }
        public Builder withCompany(CompanyModel company) {
            this.company = company;
            return this;
        }
        public Builder withFilesBytes(byte[] filesBytes) {
            this.filesBytes = filesBytes;
            return this;
        }

        public ProtocolModel build() {
            return new ProtocolModel(
                   ID,date,idetification,hash,size,docName,observation,recipient,company,filesBytes
            );
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProtocolModel that)) return false;
        return Objects.equals(ID, that.ID);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }

    @Override
    public String toString() {
        return "ProtocolModel{" +
                "ID=" + ID +
                ", date=" + date +
                ", idetification='" + idetification + '\'' +
                ", hash='" + hash + '\'' +
                ", size=" + size +
                ", docName='" + docName + '\'' +
                ", observation='" + observation + '\'' +
                ", recipient='" + recipient + '\'' +
                ", company=" + company +
                ", filesBytes=" + Arrays.toString(filesBytes) +
                '}';
    }


}
