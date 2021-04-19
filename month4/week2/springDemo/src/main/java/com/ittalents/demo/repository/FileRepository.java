package com.ittalents.demo.repository;

import com.ittalents.demo.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {
}
