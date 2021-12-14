package com.example.my.spring.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReportCreatingService {

    public void create(){
        log.info("Some file created");
    }
}
