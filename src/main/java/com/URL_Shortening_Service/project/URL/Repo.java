package com.URL_Shortening_Service.project.URL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Url,Integer> {

    Url findByShortcode(String shortCode);
    boolean existsByShortcode(String Shortcode);

    void deleteByShortCode(String shortcode);
}
