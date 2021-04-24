package com.cisc699.backend.web.controllers;

import com.cisc699.backend.web.message.ResponseMessage;
import com.cisc699.backend.web.service.FileStorageService;
import com.cisc699.backend.web.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

@Controller
@CrossOrigin("http://localhost:3000")
public class FileController {

    @Autowired
    private FileStorageService storageService;

    @Autowired
    private ProcessService processService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);
            String fileName = file.getOriginalFilename();
            message = "Uploaded the file successfully: " + fileName;

            if (fileName.toLowerCase().contains("movie")) {
                processService.importMovieData(file);
            }

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            e.printStackTrace();
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

}