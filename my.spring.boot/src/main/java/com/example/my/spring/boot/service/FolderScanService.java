package com.example.my.spring.boot.service;

import com.example.my.spring.boot.dto.SrcFolderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class FolderScanService {

    @Value("${report.folder.src}")
    private String folderPath;

    public SrcFolderInfo scan() {
        log.info("Scan folder: " + folderPath);
        // TODO
        File file = new File(folderPath);
        SrcFolderInfo result = new SrcFolderInfo(Arrays.asList(file.list()));
        return result;
    }
}
