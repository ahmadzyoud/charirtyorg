package com.zyoud.charirtyorg.service.impl;

import com.zyoud.charirtyorg.domain.Donor;
import com.zyoud.charirtyorg.repository.DonorRepository;
import com.zyoud.charirtyorg.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {
    @Autowired
    private DonorRepository donorRepository;


    @Override
    public Donor findByName(String name) {
        return donorRepository.findByName(name);
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public void save(Donor donor) {
        donorRepository.save(donor);
    }
}
