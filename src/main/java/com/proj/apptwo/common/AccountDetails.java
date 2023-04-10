package com.proj.apptwo.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDetails {
    Long id;
    Long accountNumber;
    Date createOn;
    long bsb;
    Date updatedOn;
    String status;
}
