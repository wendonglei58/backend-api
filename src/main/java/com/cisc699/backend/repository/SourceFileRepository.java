package com.cisc699.backend.repository;

import com.cisc699.backend.web.model.SourceFile;
import org.springframework.data.repository.CrudRepository;

public interface SourceFileRepository extends CrudRepository<SourceFile, Long>{
    //@Query("SELECT * From files where ")
}
