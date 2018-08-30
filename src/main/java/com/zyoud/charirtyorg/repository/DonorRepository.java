package com.zyoud.charirtyorg.repository;

import com.zyoud.charirtyorg.domain.Donor;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Donor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

    Donor findByName(String name);

}
