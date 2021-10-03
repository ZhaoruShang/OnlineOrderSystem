package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.Business;
import com.laioffer.onlineOrder.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BusinessSignUpController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value ="/signup/business", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody Business business) {
        businessService.signUp(business);
    }
}
