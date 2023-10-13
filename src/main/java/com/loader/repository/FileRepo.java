package com.loader.repository;

import com.loader.model.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends CrudRepository<File, Long> {
}
