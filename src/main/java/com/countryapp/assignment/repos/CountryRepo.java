package com.countryapp.assignment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.countryapp.assignment.entities.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {

    List<Country> findAll();

    public Optional<Country> findById(Long id);

    @Query(nativeQuery = true, value="SELECT * FROM country WHERE country_name = ?1")
    public Optional<Country> findByName(String name);

    @Query(nativeQuery = true, value="SELECT COUNT(country_name) FROM country WHERE country_name = ?1")
    public Integer checkExists(String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="UPDATE country SET populationmillion = ?2, gdpbillion = ?3 WHERE country_name = ?1")
    public void updateCountry(String name, Double populationmillion, Double gdpbillion);

    void deleteById(Long id);

}

