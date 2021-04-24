package com.cisc699.backend.repository;

import com.cisc699.backend.web.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>  {
}
