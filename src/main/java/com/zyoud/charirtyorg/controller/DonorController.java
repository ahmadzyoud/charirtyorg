package com.zyoud.charirtyorg.controller;

import com.zyoud.charirtyorg.domain.Donor;
import com.zyoud.charirtyorg.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(name = "/donor")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping(value = "/findByName")
    public ResponseEntity<Donor> findByName(String name) {
        Donor donor = donorService.findByName(name);
        ResponseEntity<Donor> responseEntity = new ResponseEntity<Donor>(donor, HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping(value = "findAll")
    public ResponseEntity<List<Donor>> findAll() {
        List<Donor> allDonors = donorService.findAll();
        ResponseEntity<List<Donor>> responseEntity = new ResponseEntity<List<Donor>>(allDonors, HttpStatus.OK);
        return responseEntity;

    }

    @PostMapping(value = "/saveDonor")
    public ResponseEntity<Void> save(@RequestBody Donor donor, UriComponentsBuilder builder) {
        donorService.save(donor);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/saveDonor/{id}").buildAndExpand(donor.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
