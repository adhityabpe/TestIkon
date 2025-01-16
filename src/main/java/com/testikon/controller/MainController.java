package com.testikon.controller;

import com.testikon.config.Constant;
import com.testikon.model.JsonPlaceHolderModel;
import com.testikon.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private ReadService readService;

    @GetMapping("/json")
    public List<JsonPlaceHolderModel> getAllJson() {
        return readService.getTitlesAndBodies(Constant.URL_JSON);
    }

    @GetMapping("/visualize")
    public String visualizeJson() {
        return readService.getTitlesAndBodiesAsHtml(Constant.URL_JSON);
    }

}
