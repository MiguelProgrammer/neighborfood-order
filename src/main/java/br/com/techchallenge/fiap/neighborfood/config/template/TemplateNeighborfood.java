/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.config.template;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class TemplateNeighborfood {

    @Value("${ngfood.module.main}")
    private String moduleNeighborfood;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> menu(){

        try {
            return restTemplate.getForEntity(moduleNeighborfood, String.class);
        } catch (Exception e){
            log.error("Error -> {}", e);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}
