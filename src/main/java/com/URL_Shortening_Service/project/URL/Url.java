package com.URL_Shortening_Service.project.URL;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String url;
    @Column(unique = true)
    String shortcode;
    Instant createdAt;
    Instant updatedAt;
    int accessCount;
}
