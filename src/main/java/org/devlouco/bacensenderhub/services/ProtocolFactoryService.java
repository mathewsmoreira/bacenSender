package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.util.Sha256Hash;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProtocolFactoryService {

    private List<ProtocolModel> protocols;
    private Sha256Hash sha256;
    private CompanyModelRepositoryService companyModelRepository;

    public ProtocolFactoryService(Sha256Hash sha256, CompanyModelRepositoryService companyModelRepositoryService) {
        this.sha256 = sha256;
        this.companyModelRepository = companyModelRepositoryService;
    }

    //Esse metodo implementa a logica de buscar os files no diretorio e apartir das informações do file
    //ele faz o Builder do ProtocolModel, o formato do nome do file deve ser numero cooperativa_nomedoarquivo.extensão


    public List<ProtocolModel> createAllFilesProtcol(String path, String identification) throws IOException {

        protocols = new ArrayList<ProtocolModel>();
        File file = new File(path);
        if (file.exists()) {
            for (File f : file.listFiles()) {
                System.out.println(f.getName().substring(0,4));
                if (f.isFile()) {
                    System.out.println(f.getName().substring(0,3));
                    CompanyModel companyModel = companyModelRepository.getCompanyModelByCoop(Integer.valueOf(f.getName().substring(0,4)));
                    ProtocolModel protocol = ProtocolModel
                            .builder()
                            .withDate(LocalDate.now())
                            .withIdetification(identification)
                            .withHash(sha256.calcularHashSHA256(f))
                            .withSize(f.length())
                            .withDocName(f.getName())
                            .withFilesBytes(getBytes(f))
                            .withCompany(companyModel)
                            .build();

                    protocols.add(protocol);
                }
            }
        }
        return protocols;
    }


    public byte[] getBytes(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }


}
