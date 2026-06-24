package com.URL_Shortening_Service.project.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String url;
    String shortcode;
    Instant createdAt;
    Instant updatedAt;
    int accessCount;
}
