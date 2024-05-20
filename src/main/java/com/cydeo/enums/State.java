package com.cydeo.enums;

import lombok.Getter;

@Getter
public enum State {
    CALIFORNIA("CALIFORNIA"),TEXAS("TEXAS"),NEW_YORK("NEW_YORK")
    ,ILLINOIS("ILLINOIS"),FLORIDA("FLORIDA"),COLORADO("COLORADO"),HAWAII("HAWAII");
    private String value;

    State(String value) {
        this.value = value;
    }
}
