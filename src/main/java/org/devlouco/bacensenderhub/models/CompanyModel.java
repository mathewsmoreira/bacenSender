package org.devlouco.bacensenderhub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CompanyModel {

    public CompanyModel(int coop, String cnpj) {
        this.coop = coop;
        this.cnpj = cnpj;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long ID;


    @Min(1)
    @Max(4)
    @Column(unique = true, nullable = false, length = 4)
    private int coop;

    @NotBlank
    @Size(max = 14)
    @Column(unique = true, nullable = false)
    private String cnpj;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private CredentialsModel credentials;

    public static Builder builder(){
        return new Builder();
    }

    public final static class Builder{

        private Long ID;
        private int coop;
        private String cnpj;
        private CredentialsModel credentials;

        public Builder withID(Long ID){
            this.ID = ID;
            return this;
        }


        public Builder withCoop(int coop){
            this.coop = coop;
            return this;
        }

        public Builder withCnpj(String cnpj){
            this.cnpj = cnpj;
            return this;
        }

        public Builder withCredentials(CredentialsModel credentials){
            this.credentials = credentials;
            return this;
        }

        public CompanyModel build(){
            return new CompanyModel(this.ID,this.coop,this.cnpj,this.credentials);
        }

    }



}
