package com.proj.apptwo.service;

import com.proj.apptwo.common.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BalanceServiceImpl implements BalanceService {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.appone.getaccounturl}")
    private String accountUrl;


    @Override
    public double getBalance(Long accountNumber) throws Exception {


        //Validate account
        AccountDetails accountDetails = getAccountDetails(accountNumber);
        if (accountDetails != null){
            //Get Balance
            return 1442.98;
        }
        else {
            throw new Exception("No account found");
        }

    }

    public AccountDetails getAccountDetails(Long accountNumber){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("accountNumber", String.valueOf(accountNumber));

        HttpEntity requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<AccountDetails> response = restTemplate.exchange(accountUrl, HttpMethod.GET, requestEntity, AccountDetails.class);
        return response.getBody();

    }
}
