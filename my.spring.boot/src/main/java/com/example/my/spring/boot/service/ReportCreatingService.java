package com.example.my.spring.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Slf4j
public class ReportCreatingService {

    public void create(File file){
        log.info("Some file created\n" +
                "Path: "+file.getAbsolutePath());
    }
}
