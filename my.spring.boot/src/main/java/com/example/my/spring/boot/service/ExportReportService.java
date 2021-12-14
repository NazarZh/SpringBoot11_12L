package com.example.my.spring.boot.service;

import com.example.my.spring.boot.dto.ReportData;
import com.example.my.spring.boot.dto.SrcFolderInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExportReportService {

    private final FolderScanService folderScanService;
    private final FolderProcessingService folderProcessingService;
    private final ReportCreatingService reportCreatingService;

    @Value("${report.folder.dest}")
    private String desPath;

    public void export(){

        log.info("Start export");
        SrcFolderInfo folderInfo = folderScanService.scan();
        ReportData process = folderProcessingService.process(folderInfo);

        reportCreatingService.create(createAndExportReport(process));

    }

    private File createAndExportReport(ReportData data){
        log.info("Export file {} to {}", data, desPath);

        try (FileWriter fileWriter = new FileWriter(desPath+"/result.txt")){

            fileWriter.write("Max length: "+data.getMaxLengthFile()+"\n");
            fileWriter.write("Folder's size: "+data.getFolderSize());
            return new File(desPath+"/result.txt");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
