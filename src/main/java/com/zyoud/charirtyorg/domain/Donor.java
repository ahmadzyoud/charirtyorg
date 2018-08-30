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

import com.zyoud.charirtyorg.domain.enumeration.TimeType;

import com.zyoud.charirtyorg.domain.enumeration.PeriodType;

/**
 * A Donor.
 */
@Entity
@Table(name = "donor")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "donor")
public class Donor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 150)
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "donation_time_type", nullable = false)
    private TimeType donationTimeType;

    @Column(name = "address")
    private String address;

    @Size(min = 14, max = 14)
    @Pattern(regexp = "00962[0-9]{9}")
    @Column(name = "mobile_no", length = 14)
    private String mobileNo;

    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @Column(name = "email")
    private String email;

    @Column(name = "notified_by_sms")
    private Boolean notifiedBySms;

    @Column(name = "notified_by_email")
    private Boolean notifiedByEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "donation_period_type")
    private PeriodType donationPeriodType;

    @OneToMany(mappedBy = "donor")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Donation> donations = new HashSet<>();

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

    public Donor name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeType getDonationTimeType() {
        return donationTimeType;
    }

    public Donor donationTimeType(TimeType donationTimeType) {
        this.donationTimeType = donationTimeType;
        return this;
    }

    public void setDonationTimeType(TimeType donationTimeType) {
        this.donationTimeType = donationTimeType;
    }

    public String getAddress() {
        return address;
    }

    public Donor address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public Donor mobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public Donor email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isNotifiedBySms() {
        return notifiedBySms;
    }

    public Donor notifiedBySms(Boolean notifiedBySms) {
        this.notifiedBySms = notifiedBySms;
        return this;
    }

    public void setNotifiedBySms(Boolean notifiedBySms) {
        this.notifiedBySms = notifiedBySms;
    }

    public Boolean isNotifiedByEmail() {
        return notifiedByEmail;
    }

    public Donor notifiedByEmail(Boolean notifiedByEmail) {
        this.notifiedByEmail = notifiedByEmail;
        return this;
    }

    public void setNotifiedByEmail(Boolean notifiedByEmail) {
        this.notifiedByEmail = notifiedByEmail;
    }

    public PeriodType getDonationPeriodType() {
        return donationPeriodType;
    }

    public Donor donationPeriodType(PeriodType donationPeriodType) {
        this.donationPeriodType = donationPeriodType;
        return this;
    }

    public void setDonationPeriodType(PeriodType donationPeriodType) {
        this.donationPeriodType = donationPeriodType;
    }

    public Set<Donation> getDonations() {
        return donations;
    }

    public Donor donations(Set<Donation> donations) {
        this.donations = donations;
        return this;
    }

    public Donor addDonation(Donation donation) {
        this.donations.add(donation);
        donation.setDonor(this);
        return this;
    }

    public Donor removeDonation(Donation donation) {
        this.donations.remove(donation);
        donation.setDonor(null);
        return this;
    }

    public void setDonations(Set<Donation> donations) {
        this.donations = donations;
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
        Donor donor = (Donor) o;
        if (donor.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), donor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Donor{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", donationTimeType='" + getDonationTimeType() + "'" +
            ", address='" + getAddress() + "'" +
            ", mobileNo='" + getMobileNo() + "'" +
            ", email='" + getEmail() + "'" +
            ", notifiedBySms='" + isNotifiedBySms() + "'" +
            ", notifiedByEmail='" + isNotifiedByEmail() + "'" +
            ", donationPeriodType='" + getDonationPeriodType() + "'" +
            "}";
    }
}
