package com.zyoud.charirtyorg.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.zyoud.charirtyorg.domain.enumeration.PeriodType;

/**
 * A Beneficiary.
 */
@Entity
@Table(name = "beneficiary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "beneficiary")
public class Beneficiary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 150)
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "family_count")
    private Integer familyCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "distribution_type")
    private PeriodType distributionType;

    @OneToMany(mappedBy = "beneficiary")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Aid> aid = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Beneficiary name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFamilyCount() {
        return familyCount;
    }

    public Beneficiary familyCount(Integer familyCount) {
        this.familyCount = familyCount;
        return this;
    }

    public void setFamilyCount(Integer familyCount) {
        this.familyCount = familyCount;
    }

    public PeriodType getDistributionType() {
        return distributionType;
    }

    public Beneficiary distributionType(PeriodType distributionType) {
        this.distributionType = distributionType;
        return this;
    }

    public void setDistributionType(PeriodType distributionType) {
        this.distributionType = distributionType;
    }

    public Set<Aid> getAid() {
        return aid;
    }

    public Beneficiary aid(Set<Aid> aid) {
        this.aid = aid;
        return this;
    }

    public Beneficiary addAid(Aid aid) {
        this.aid.add(aid);
        aid.setBeneficiary(this);
        return this;
    }

    public Beneficiary removeAid(Aid aid) {
        this.aid.remove(aid);
        aid.setBeneficiary(null);
        return this;
    }

    public void setAid(Set<Aid> aid) {
        this.aid = aid;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Beneficiary beneficiary = (Beneficiary) o;
        if (beneficiary.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiary.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", familyCount=" + getFamilyCount() +
            ", distributionType='" + getDistributionType() + "'" +
            "}";
    }
}
