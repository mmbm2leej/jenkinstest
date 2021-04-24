package com.countryapp.assignment.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.countryapp.assignment.entities.*;
import com.countryapp.assignment.repos.*;
@Service
public class CountryService {

    @Autowired
    CountryRepo myCR;

    public List<Country> getCountryList() {
        List<Country> resList = myCR.findAll();
        //Collections.sort(resList);    //need to add comparable for sorting by name
        return resList;
    }

    public void saveCountry(Country c)
    {
        //if country exists
        if (checkExistByName(c.getCountry_name()) > 0) {
            myCR.updateCountry(c.getCountry_name(),c.getPopulationmillion(),c.getGdpbillion());
        }
        else myCR.save(c);
    }

    public Country findByID(Long id) { return myCR.findById(id).get();}

    public Integer checkExistByName(String name) {
        return myCR.checkExists(name);
    }

    public Country getCountry(String name)
    {
        return myCR.findByName(name).get();
    }
    public void deleteCountry(Long id)
    {
        myCR.deleteById(id);
    }
}
