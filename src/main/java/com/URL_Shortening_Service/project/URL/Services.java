package com.URL_Shortening_Service.project.URL;

import com.URL_Shortening_Service.project.GlobalExceptionHandler.AlreadyExists;
import com.URL_Shortening_Service.project.GlobalExceptionHandler.NotFound;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;


@Service
public class Services {
Repo repo;
    public Services(Repo repo) {
        this.repo = repo;
    }
@Transactional
public ResponseEntity<String> ConvertUrl(String url){

    String encoded = Base64.getEncoder()
            .encodeToString(url.getBytes());

    if(repo.existsByShortcode(encoded)){
       Url url1= repo.findByShortcode(encoded);
        url1.setAccessCount(url1.getAccessCount()+1);
    }
    return new ResponseEntity<>(encoded,HttpStatus.CREATED);
}
@Transactional
public ResponseEntity<Url> Retreive(String shortcode){
        if(!repo.existsByShortcode(shortcode)) throw  new NotFound("No element found ");

    if(repo.existsByShortcode(shortcode)){
        Url url1= repo.findByShortcode(shortcode);
        url1.setAccessCount(url1.getAccessCount()+1);
    }

        return ResponseEntity.ok(repo.findByShortcode(shortcode));
}

public ResponseEntity<String> Save(String url){
    String encoded = Base64.getEncoder()
            .encodeToString(url.getBytes());
    if(repo.existsByShortcode(encoded)) throw new AlreadyExists("Content already exisits");
    Url url1=new Url();
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
    if(!repo.existsByShortcode(shortCode)) throw  new NotFound("No element found ");
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


@Transactional
    public ResponseEntity<String> Delete(String shortCode){
        if(!repo.existsByShortcode(shortCode)) throw  new NotFound("No element found ");

        repo.deleteByShortcode(shortCode);
    return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
}
}
