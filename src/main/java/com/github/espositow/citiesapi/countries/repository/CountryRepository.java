package com.github.espositow.citiesapi.countries.repository;

import com.github.espositow.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
