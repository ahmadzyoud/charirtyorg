package com.zyoud.charirtyorg.service.impl;

import com.zyoud.charirtyorg.domain.Aid;
import com.zyoud.charirtyorg.domain.Beneficiary;
import com.zyoud.charirtyorg.repository.AidRepository;
import com.zyoud.charirtyorg.service.AidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AidServiceImpl implements AidService {
    @Autowired
    private AidRepository aidRepository;

    @Override
    public List<Aid> getAllAids() {
        return aidRepository.findAll();
    }

    @Override
    public List<Aid> getAidByBeneficiary(Beneficiary beneficiary) {
        return aidRepository.findByBeneficiary(beneficiary);
    }

    @Override
    public void addAid(Aid aid) {
        aidRepository.save(aid);

    }
}
