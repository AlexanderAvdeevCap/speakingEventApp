package com.javamasterclass.alex.speakingevents.model;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
    private String street_name;
    private String street_number;
    private String postcode;
    private String city;
}
