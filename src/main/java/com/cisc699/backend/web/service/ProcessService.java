package com.cisc699.backend.web.service;

import com.cisc699.backend.repository.MovieRepository;
import com.cisc699.backend.web.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ProcessService {
    @Autowired
    MovieRepository movieRepository;

    public void importMovieData(MultipartFile file) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            br.lines().forEach(line -> movieRepository.save(new Movie(line)));
        }
    }
}
