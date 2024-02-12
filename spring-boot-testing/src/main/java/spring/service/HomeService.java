package spring.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String greet() {
        return "Hello home";
    }

    public void printHome() {}
}
