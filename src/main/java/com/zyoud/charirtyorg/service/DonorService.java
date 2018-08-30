package com.zyoud.charirtyorg.service;

import com.zyoud.charirtyorg.domain.Donor;

import java.util.List;

public interface DonorService {

    Donor findByName(String name);

    List<Donor> findAll();

    void save(Donor donor);

}
