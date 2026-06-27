package com.URL_Shortening_Service.project.URL;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class UrlController {
Services services;
    @PostMapping("/convert")
    public ResponseEntity<String> ConvertToUrl(@Valid @RequestBody PayLoad load){
        return services.ConvertUrl(load.getUrl());
    }

    @GetMapping("/Retrieve")
    public ResponseEntity<Url> GetUrl(@Valid @RequestBody Request request){
        return services.Retreive(request.getShortcode());
    }

    @PostMapping("/save")
    public ResponseEntity<String> SaveUrl(@Valid @RequestBody PayLoad load){
        return services.Save(load.getUrl());
    }

@PostMapping("/update")
    public ResponseEntity<String> UpdateUrl(@Valid @RequestBody BothRequest request){
        return services.Update(request.getShortcode(), request.getUrl());
    }

@PostMapping("delete")
    public ResponseEntity<String> DeleteUrl(@Valid @RequestBody Request request){
        return services.Delete(request.getShortcode());
    }

}
