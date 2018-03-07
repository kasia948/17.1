package com.springboot.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class UsersController {
    private Database datba;

    public UsersController(Database database) {
        this.datba = database;
    }

    @RequestMapping("/users")
    @ResponseBody
    public String printUsers() {

        String tekst = "";
        for (int i = 0; i < datba.uzytkownicy.size(); i++) {
            User user = datba.uzytkownicy.get(i);
            tekst += user.getFirstName() + " " + user.getLastName() + " " + user.getAge() + "<br>";
        }
        return tekst;
    }

    @RequestMapping("/add")
    public String add(@RequestParam(value="imie", required = false, defaultValue = "Anonim")String firstName, @RequestParam(value = "nazwisko", required = true, defaultValue = "Kowalski")String lastName,  @RequestParam(value = "wiek", required = true, defaultValue = "10") String ageString) {
        int age = Integer.parseInt(ageString);
        User user = new User();
        if (firstName != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAge(age);
            datba.uzytkownicy.add(user);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }


//    @RequestMapping("/add")
//    public String add(HttpServletRequest request) {
//        String firstName = request.getParameter("imie");
//        String lastName = request.getParameter("nazwisko");
//        if (lastName == null || lastName.equals("")) {
//            lastName="Kowalski";
//        }
//        String ageString = request.getParameter("wiek");
//        int age = Integer.parseInt(ageString);
//        User user = new User();
//
//        if (firstName != null) {
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setAge(age);
//            datba.uzytkownicy.add(user);
//            return "redirect:/success.html";
//        } else {
//            return "redirect:/err.html";
//        }
//    }
}
