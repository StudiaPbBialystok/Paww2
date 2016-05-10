package com.mycompany.zadanie6_test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kamil
 */
@Controller
@RequestMapping
public class TripController {

    /**
     * @return the cityList
     */
    @Autowired
    private Services service;
    private int selectedTripId;
    private int dodal = 0;
    private static int prawda = 0;
    private static List<Country> countrylist;
    private static List<City> cityList;
    private int selectedCityId;

    public TripController() {
    }

    @RequestMapping("/")
    public String showStartPage(Model model) {
        model.addAttribute("trip", service.findAllTrips());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String logUser(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String mail = request.getParameter("email");
        model.addAttribute("trip", service.findAllTrips());
        List<Userx> users = (List<Userx>) service.findUserxByEmail(mail);
        if (users.size() > 0) {
            String password = request.getParameter("password");
            if (users.get(0).getPassword().equals(password)) {
                model.addAttribute("trips", service.findAllTrips());
                return "/about";
            }

        }
        String message = "Błędny login/hasło";
        request.getSession().setAttribute("message", message);
        return "/index";
    }

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String logUser4(Model model, HttpServletRequest request) {
        return "map";

    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String logUser2(Model model, HttpServletRequest request) {
        model.addAttribute("trip", service.findAllTrips());
        return "/about";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String showTrips(Model model, HttpServletRequest request) {
        Trip newTrip = new Trip();
        newTrip.setId(service.getMaxId(service.findAllTrips()) + 1);
        int id = service.getMaxId(service.findAllTrips()) + 1;
        System.out.print(id);
        newTrip.setName(request.getParameter("tripName"));
        newTrip.setCreated(Calendar.getInstance().getTime());
        service.addTrip(newTrip);
        model.addAttribute("trip", service.findAllTrips());
        List<Trip> trips = service.findAllTrips();
        dodal = 1;
        return "redirect:/about";
    }

    @RequestMapping(value = "stops/{TripId}", method = RequestMethod.GET)
    public String showStops(Model model, HttpServletRequest request, @PathVariable int TripId) {
        List<Stop> stops = service.findStopByTripId(TripId);
        model.addAttribute("stops", service.findStopByTripId(TripId));
        model.addAttribute("tripId", TripId);
        System.out.print("asdasdasd");
        return "stops";
    }

    @RequestMapping(value = "stops/{TripId}", method = RequestMethod.POST)
    public String addStop(Model model, HttpServletRequest request, @PathVariable int TripId) throws MalformedURLException, IOException, URISyntaxException, ParseException {
        model.addAttribute("stops", service.findStopByTripId(TripId));
        String bingKey = "ApLLvLinHIpgXBUi0cesivXMcJcuN26H2uE5vJbOZvEe5afTKoKFrBD5RlgeVb_q";
        String encodedName = request.getParameter("location");
        String url = "http://dev.virtualearth.net/REST/v1/Locations?q=" + encodedName + "&key=" + bingKey;
        String document = Jsoup.connect(url).ignoreContentType(true).execute().body();
        JSONObject obj = new JSONObject(document);
        JSONObject arr = (JSONObject) (obj.getJSONArray("resourceSets").get(0));
        JSONObject arr2 = (JSONObject) arr.getJSONArray("resources").get(0);
        JSONObject arr3 = (JSONObject) arr2.getJSONArray("geocodePoints").get(0);
        JSONArray arr4 = arr3.getJSONArray("coordinates");
        Stop newStop = new Stop();
        newStop.setId(service.getMaxIdStops(service.findAllStops()) + 1);
        newStop.setLatitude((double) arr4.getDouble(0));
        newStop.setLongitude((double) arr4.getDouble(1));
        newStop.setName(request.getParameter("location"));
        newStop.setTripid(TripId);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        newStop.setArrival(format.parse(request.getParameter("date")));
        service.addStop(newStop);
        return "redirect:/stops/" + Integer.toString(TripId);

    }

    @RequestMapping(value = "edit/{TripId}", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request, @PathVariable int TripId) {
        System.out.print("nowytest");
        Trip selectedTrip = service.findById(TripId);
        selectedTripId = TripId;
        return "edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editTrip(Model model, HttpServletRequest request) {
        Trip selectedTrip = service.findById(selectedTripId);
        System.out.print("xdxdxd");
        selectedTrip.setName(request.getParameter("tripName"));
        service.editTrip(selectedTrip);
        return "redirect:/about";
    }

    @RequestMapping(value = "stops/delete/{TripId}/{stopId}", method = RequestMethod.GET)
    public String deleteStop(Model model, HttpServletRequest request, @PathVariable int TripId, @PathVariable int stopId) {
        Stop selectedStop = service.findStopById(stopId);
        service.deleteStop(selectedStop);
        return "redirect:/stops/" + Integer.toString(TripId);
    }

    @RequestMapping(value = "delete/{TripId}", method = RequestMethod.GET)
    public String deleteTrip(Model model, HttpServletRequest request, @PathVariable int TripId) {
        Trip selectedTrip = service.findById(TripId);
        service.deleteTrip(selectedTrip);
        return "redirect:/about";
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public String coutryDescription(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("message", null);
        return "country";

    }

    @RequestMapping(value = "/attractions/{CityId}", method = RequestMethod.GET)
    public String attractions(Model model, HttpServletRequest request, @PathVariable int CityId) {
        model.addAttribute("attraction", service.findAttractionsByCityId(CityId));
        return "attractions";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        String countryName = request.getParameter("countryName");
        List<Country> count = service.findCountryByName(countryName);

        if (count.size() > 0) {
            request.getSession().setAttribute("message", null);
            setPrawda(1);
            setCoutryList(count);
            cityList = service.findAllCities();
            model.addAttribute("city", service.findCityByCountryId(count.get(0).getId()));
            return "country";
        }

        String message = "Niestety, nie mamy jeszcze tego kraju w bazie";
        request.getSession().setAttribute("message", message);
        return "country";

    }

    public static int getPrawda() {
        return prawda;
    }

    public void setPrawda(int prawda) {
        this.prawda = prawda;
    }

    public static List<Country> getCountryList() {
        return countrylist;
    }

    public void setCoutryList(List<Country> countrylist) {
        this.countrylist = countrylist;
    }

    public static List<City> getCityList() {
        return cityList;
    }

    public static void setCityList(List<City> aCityList) {
        cityList = aCityList;
    }

}
