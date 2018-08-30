package com.zyoud.charirtyorg.repository;

import com.zyoud.charirtyorg.domain.Aid;
import com.zyoud.charirtyorg.domain.Beneficiary;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Aid entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AidRepository extends JpaRepository<Aid, Long> {

    List<Aid> findByBeneficiary(Beneficiary beneficiary);

}
