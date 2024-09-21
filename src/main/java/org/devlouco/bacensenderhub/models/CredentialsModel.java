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

}
