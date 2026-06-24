package com.URL_Shortening_Service.project.URL;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;

@AllArgsConstructor
@Service
public class Services {
Repo repo;

public ResponseEntity<String> ConvertUrl(String url){

    String encoded = Base64.getEncoder()
            .encodeToString(url.getBytes());
    if(repo.existsByShortcode(encoded)){
       Url url1= repo.findByShortcode(encoded);
        url1.setAccessCount(url1.getAccessCount()+1);
    }
    return new ResponseEntity<>(encoded,HttpStatus.CREATED);
}

public ResponseEntity<String> Save(String url){
    Url url1=new Url();
    String encoded = Base64.getEncoder()
            .encodeToString(url.getBytes());
    url1.setShortcode(encoded);
    url1.setUrl(url);
    url1.setCreatedAt(Instant.now());
    url1.setUpdatedAt(Instant.now());
    url1.setAccessCount(0);
    repo.save(url1);
    return new ResponseEntity<>("Short Url saved",HttpStatus.CREATED);
}
@Transactional
public ResponseEntity<String> Update(String shortCode,String updated){
        Url url= repo.findByShortcode(shortCode);
        ResponseEntity newCode=ConvertUrl(updated);
        Object encoded=newCode.getBody();
        String str=encoded.toString();
        url.setShortcode(str);
        url.setUrl(updated);
        url.setAccessCount(url.getAccessCount()+1);
        url.setUpdatedAt(Instant.now());
        repo.save(url);
    return new ResponseEntity<>("Short Url updated",HttpStatus.CREATED);
}
public ResponseEntity<String> Delete(String shortCode){
    repo.deleteByShortCode(shortCode);
    return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
}
}
