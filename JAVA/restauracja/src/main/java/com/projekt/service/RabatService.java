package com.projekt.service;


import com.projekt.dto.Rabat;
import com.projekt.repository.RabatRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class RabatService {

    private final RabatRepository rabatRespository;

    @Inject
    public RabatService(RabatRepository rabatRespository) {
        this.rabatRespository = rabatRespository;
    }

    public List<Rabat> getAll(){return rabatRespository.getAll();}


    public void dodajRabat(Rabat rabat){rabatRespository.save(rabat);}

    public void usunRabat(Rabat rabat){rabatRespository.remove(rabat);}


}
