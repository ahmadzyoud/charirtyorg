package com.zyoud.charirtyorg.service;

import com.zyoud.charirtyorg.domain.Aid;
import com.zyoud.charirtyorg.domain.Beneficiary;

import java.util.List;

public interface AidService {

    List<Aid> getAllAids();

    List<Aid> getAidByBeneficiary(Beneficiary beneficiary);

    void addAid(Aid aid);
}
