package com.security.oauth2.resource.server.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.security.oauth2.resource.server.dto.City;

@Controller
@RequestMapping(value = "/city/")
public class CityController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	@ResponseBody
	public City findCityById(@PathVariable Integer id, Principal principal) {
		System.out.println(principal.getName());
		//@formatter:off
		Optional<City> city =
				CityRepositoryMock.db()
					.stream()
					.filter(c -> c.getId() == id)
					.collect(Collectors.toList())
					.stream()
					.findFirst();
		//@formatter:on
		return city.orElse(null);
	}
	
	@RequestMapping("/user/details")
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/name/{name}")
	@ResponseBody
	public City findCityByName(@PathVariable String name) {
		//@formatter:off
		Optional<City> city =
				CityRepositoryMock.db()
					.stream()
					.filter(c -> c.getName().equalsIgnoreCase(name))
					.collect(Collectors.toList())
					.stream()
					.findFirst();
		//@formatter:on
		return city.orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/capitals")
	@ResponseBody
	public List<City> findCapitalCities() {
		//@formatter:off
		List<City> capitals =
				CityRepositoryMock.db()
					.stream()
					.filter(c -> c.isCapital())
					.collect(Collectors.toList());
		//@formatter:on
		return capitals;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/list")
	@ResponseBody
	public List<City> listAll() {
		return CityRepositoryMock.db();
	}
	
	private static class CityRepositoryMock {
		
		public static List<City> db() {
			List<City> cities = new ArrayList<City>();
			int i = 0;
			cities.add(new City(++i, "Madrid", true, Country.SPAIN.name()));
			cities.add(new City(++i, "Barcelona", false, Country.SPAIN.name()));
			cities.add(new City(++i, "Valencia", false, Country.SPAIN.name()));
			cities.add(new City(++i, "Sevilla", false, Country.SPAIN.name()));
			cities.add(new City(++i, "Granada", false, Country.SPAIN.name()));
			cities.add(new City(++i, "Bilbao", false, Country.SPAIN.name()));
			cities.add(new City(++i, "Toledo", false, Country.SPAIN.name()));
			cities.add(new City(++i, "Salamanca", false, Country.SPAIN.name()));
			cities.add(new City(++i, "Málaga", false, Country.SPAIN.name()));
			cities.add(new City(++i, "London", true, Country.ENGLAND.name()));
			cities.add(new City(++i, "Manchester", false, Country.ENGLAND.name()));
			cities.add(new City(++i, "Liverpool", false, Country.ENGLAND.name()));
			cities.add(new City(++i, "Bristol", false, Country.ENGLAND.name()));
			cities.add(new City(++i, "York", false, Country.ENGLAND.name()));
			cities.add(new City(++i, "Oxford", false, Country.ENGLAND.name()));
			cities.add(new City(++i, "Cambridge", false, Country.ENGLAND.name()));
			cities.add(new City(++i, "Paris", true, Country.FRANCE.name()));
			cities.add(new City(++i, "Marseille", false, Country.FRANCE.name()));
			cities.add(new City(++i, "Lyon", false, Country.FRANCE.name()));
			cities.add(new City(++i, "Rouen", false, Country.FRANCE.name()));
			cities.add(new City(++i, "Avignon", false, Country.FRANCE.name()));
			cities.add(new City(++i, "Calais", false, Country.FRANCE.name()));
			cities.add(new City(++i, "Cannes", false, Country.FRANCE.name()));
			cities.add(new City(++i, "Berlin", true, Country.GERMANY.name()));
			cities.add(new City(++i, "Frankfurt", false, Country.GERMANY.name()));
			cities.add(new City(++i, "Trier", false, Country.GERMANY.name()));
			cities.add(new City(++i, "Jena", false, Country.GERMANY.name()));
			cities.add(new City(++i, "Weimar", false, Country.GERMANY.name()));
			cities.add(new City(++i, "Wurzburg", false, Country.GERMANY.name()));
			cities.add(new City(++i, "Roma", true, Country.ITALY.name()));
			cities.add(new City(++i, "Florence", false, Country.ITALY.name()));
			cities.add(new City(++i, "Milan", false, Country.ITALY.name()));
			cities.add(new City(++i, "Turin", false, Country.ITALY.name()));
			cities.add(new City(++i, "Siena", false, Country.ITALY.name()));
			cities.add(new City(++i, "Stockholm", true, Country.SWEDEN.name()));
			cities.add(new City(++i, "Gothenburg", false, Country.SWEDEN.name()));
			cities.add(new City(++i, "Helsingborg", false, Country.SWEDEN.name()));
			cities.add(new City(++i, "Lund", false, Country.SWEDEN.name()));
			cities.add(new City(++i, "Oslo", true, Country.NORWAY.name()));
			cities.add(new City(++i, "Bergen", false, Country.NORWAY.name()));
			cities.add(new City(++i, "Stavanger", false, Country.NORWAY.name()));
			cities.add(new City(++i, "Trondheim", false, Country.NORWAY.name()));
			return cities;
		}
		
		public  enum Country {
			SPAIN, ENGLAND, FRANCE, GERMANY, ITALY, SWEDEN, NORWAY;
		}
	}
	
	/*
	public static void main(String[] args) {
		RegionController r = new RegionController();
		System.out.println(r.findCityById(123456465));
		System.out.println(r.findCityById(3));
		System.out.println(r.findCityByName("Barcelonxxa"));
		System.out.println(r.findCityByName("Barcelona"));
		r.findCapitalCities().forEach(System.out::print);
		r.listAll().forEach(System.out::print);
	}
	*/

}
