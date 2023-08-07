package com.vinesh.rediscache.controller;

import com.vinesh.rediscache.entity.CountryCode;
import com.vinesh.rediscache.service.CountryCodesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countrycodesmaster")
class MasterCountryCodesController {
    public static final Logger log = LoggerFactory.getLogger(MasterCountryCodesController.class);

    @Autowired
    CountryCodesService countryCodesService;

    @GetMapping
    public List<CountryCode> getCountryCodes(){
        log.info(">> CountryCodesController: get masterCountryCodes");
        return countryCodesService.getMasterCountryCodes();
    }

    @PutMapping
    public List<CountryCode> update(){
        log.info(">> CountryCodesController: update masterCountryCodes");
        return countryCodesService.updateCountryCodes();
    }


    @DeleteMapping
    public void removeCountryCodes(){
        log.info(">> CountryCodesController: clear masterCountryCodes");
        countryCodesService.delete();
    }
}
