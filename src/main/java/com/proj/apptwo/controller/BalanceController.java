package com.proj.apptwo.controller;

import com.proj.apptwo.service.BalanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @Autowired
    private BalanceServiceImpl balanceService;

    @GetMapping("/balance")
    public double getBalance(@RequestHeader Long accountNumber) throws Exception {
        return balanceService.getBalance(accountNumber);
    }

}
