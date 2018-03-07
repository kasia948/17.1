package com.springboot.demo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class Database {
    ArrayList<User> uzytkownicy = new ArrayList<>();

    public Database() {
        User user1 = new User("Jan", "Kowalski", 25) ;
        User user2 = new User("Barbara", "Hil", 15) ;
        User user3 = new User("Olaf", "Barbaruk", 35) ;
        uzytkownicy.add(user1);
        uzytkownicy.add(user2);
        uzytkownicy.add(user3);
    }
}

