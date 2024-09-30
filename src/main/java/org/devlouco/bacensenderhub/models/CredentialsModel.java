package org.devlouco.bacensenderhub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CredentialsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long ID;

    @NotBlank
    @NotNull
    @Column(unique = true, nullable = false)
    private String login;

    @NotBlank
    @NotNull
    @Column(unique = true, nullable = false)
    private String password;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "ID")
    private CompanyModel company;

    public static Builder builder(){
        return new Builder();
    }

    public final static class Builder{

        private Long ID;
        private String login;
        private String password;
        private CompanyModel company;

        public Builder withID(Long ID){
            this.ID = ID;
            return this;
        }
        public Builder withLogin(String login){
            this.login = login;
            return this;
        }
        public Builder withPassword(String password){
            this.password = password;
            return this;
        }
        public Builder withCompany(CompanyModel company){
            this.company = company;
            return this;
        }

        public CredentialsModel build(){
            return new CredentialsModel(ID, login, password, company);
        }

    }

}
