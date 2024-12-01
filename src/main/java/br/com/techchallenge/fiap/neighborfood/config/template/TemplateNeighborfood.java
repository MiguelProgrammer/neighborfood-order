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

    @Value("${ngfood.module.main.menu}")
    private String moduleNeighborfood;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> menu(){

        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(moduleNeighborfood, String.class);
            return forEntity;
        } catch (Exception e){
            log.error("Error -> {}", e);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}
