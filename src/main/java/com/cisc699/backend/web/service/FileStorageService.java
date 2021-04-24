package com.cisc699.backend.web.service;

import com.cisc699.backend.web.model.SourceFile;
import com.cisc699.backend.repository.SourceFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService {
    @Autowired
    SourceFileRepository fileRepository;

    public SourceFile store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        SourceFile FileToDB = new SourceFile(fileName, file.getContentType());
        return fileRepository.save(FileToDB);
    }
}
