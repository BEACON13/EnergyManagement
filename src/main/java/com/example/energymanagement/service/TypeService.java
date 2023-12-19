package com.example.energymanagement.service;

import com.example.energymanagement.model.domain.Type;
import com.example.energymanagement.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> listAllTypeNames() {
        return typeRepository.listAllTypeNames();
    }

    public List<Type> listAllModel(String tname) {
        return typeRepository.listAllModel(tname);
    }

    public List<Type> listAllTypes() {
        return typeRepository.listAllTypes();
    }
}
