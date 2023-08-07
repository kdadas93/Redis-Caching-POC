package com.vinesh.rediscache.controller;

import com.vinesh.rediscache.entity.CountryCode;
import com.vinesh.rediscache.service.CountryCodesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countrycodes")
class CountryCodesController {
    public static final Logger log = LoggerFactory.getLogger(CountryCodesController.class);

    @Autowired
    CountryCodesService countryCodesService;

    @GetMapping
    public List<CountryCode> getCountryCodes(){
        log.info(">> CountryCodesController: get country codes");
        try {
            return countryCodesService.getCountryCodes();
        }catch (Exception e) {
            log.info(">> CountryCodesController: Exception");
            log.info(">> CountryCodesController: Exception");
        }
        return countryCodesService.getCountryCodes();
    }

    @PutMapping
    public List<CountryCode> update(){
        log.info(">> CountryCodesController: update country codes");
        return null;
    }


    @DeleteMapping
    public void removeCountryCodes(){
        log.info(">> CountryCodesController: clear country codes");
    }
}
