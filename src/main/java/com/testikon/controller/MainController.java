package com.testikon.controller;

import com.testikon.config.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/try")
    public String getAllPos() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(Constant.URL_JSON,String.class);

        return result;
    }

}
