package com.countryapp.assignment;

import com.countryapp.assignment.entities.Country;
import com.countryapp.assignment.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CountryAssignmentApplicationTests {

	@Autowired
	CountryService cServ;

	@Test
	void contextLoads() {
	}

	@Test
	public void getList() {
		System.out.println(cServ.getCountryList());
	}

	@Test
	public void printByName() {
		System.out.println(cServ.getCountry("Egypt"));
	}

	@Test
	public void populateCountries() {
		List<Country> myList = new ArrayList<>();
		myList.add(new Country("United States", 9831510, 328.2,"Washington, D.C.", 21433.23));
		myList.add(new Country("Poland", 312680, 37.97,"Warsaw", 595.86));
		myList.add(new Country("Uzbekistan",447400 , 33.58,"Tashkent", 57.92));
		myList.add(new Country("Cameroon", 475440, 25.88,"Yaoundé", 39.01));
		myList.add(new Country("New Zealand", 267710, 4.917,"Wellington", 206.93));

		for(Country x : myList) cServ.saveCountry(x);
	}

	@Test
	public void printCountrySearch() {
		System.out.println(cServ.getCountry("Egypt"));
	}

	@Test
	public void addCountry() {
		Country testNewCountry = new Country("Egypt", 1001450, 100.4, "Cairo", 303.09);

		cServ.saveCountry(testNewCountry);
	}

}
