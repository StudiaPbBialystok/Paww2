/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zadanie6_test;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

    @Autowired
    private Itrip tripDao;
    @Autowired
    private UserxDao userxDao;
    @Autowired
    private StopDao stopDao;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private CityDao cityDao;
    @Autowired
    private AttractionDao attractionDao;

    public List<Attraction> findAllAttractions() {
        return attractionDao.findAll();
    }

    public List<Attraction> findAttractionsByCityId(int cityId) {
        return attractionDao.findByCityId(cityId);
    }

    public City findCityById(int id) {
        return cityDao.findById(id);
    }

    public List<City> findCityByCountryId(int id) {
        return cityDao.findByCountryId(id);

    }

    public List<City> findAllCities() {
        return cityDao.findAll();
    }

    public Trip findById(int id) {
        return tripDao.findById(id);
    }

    public Stop findStopById(int id) {
        return stopDao.findById(id);
    }

    public List<Country> findCountryByName(String name) {
        return countryDao.findByName(name);
    }

    public List<Trip> findByName(String name) {
        return tripDao.findByName(name);
    }

    public boolean addUser(Userx user) {
        return userxDao.addUser(user);
    }

    public List<Userx> findAllUsers() {
        return userxDao.findAll();
    }

    public List<Userx> findUserxByEmail(String email) {
        return userxDao.findByEmail(email);
    }

    public Userx findUserEmail(String email) {
        return userxDao.findUserEmail2(email);
    }

    public Userx findUserxLogins(String email, String password) {
        return userxDao.findUser(email, password);
    }

    public List<Trip> findAllTrips() {
        return tripDao.findAll();
    }

    public List<Stop> findStopByTripId(int tripId) {
        return stopDao.findByTripId(tripId);
    }

    public List<Stop> findAllStops() {
        return stopDao.findAll();
    }

    public boolean addStop(Stop newStop) {
        return stopDao.addStop(newStop);
    }

    public boolean addTrip(Trip trip) {
        return tripDao.addTrip(trip);
    }

    public boolean editTrip(Trip trip) {
        return tripDao.editTrip(trip);
    }

    public boolean deleteTrip(Trip trip) {
        return tripDao.deleteTrip(trip);
    }

    public boolean deleteStop(Stop stop) {
        return stopDao.deleteStop(stop);
    }

    public List<Stop> findAfterDate(String date) {
        return stopDao.findAfterDate(date);
    }

    public int getMaxUserId(List<Userx> userxs) {
        int max = 0;
        for (Userx userx : userxs) {
            if (userx.getId() > max) {
                max = userx.getId();
            }
        }
        return max;
    }

    public int getMaxId(List<Trip> trips) {
        int max = 0;
        for (Trip trip : trips) {
            if (trip.getId() > max) {
                max = trip.getId();
            }
        }
        return max;
    }

    public int getMaxIdStops(List<Stop> stops) {
        int max = 0;
        for (Stop stop : stops) {
            if (stop.getId() > max) {
                max = stop.getId();
            }
        }
        return max;
    }

}
