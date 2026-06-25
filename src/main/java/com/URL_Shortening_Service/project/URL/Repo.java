package com.URL_Shortening_Service.project.URL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Url,Integer> {

    Url findByShortcode(String shortcode);

    boolean existsByShortcode(String Shortcode);

    void deleteByShortcode(String shortcode);
}
