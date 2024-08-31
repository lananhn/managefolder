package com.example.managefolder.repository;

import com.example.managefolder.modal.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
    @Query(nativeQuery = true, value = "select * from file f " +
            "where f.ID_FOLDER = ?1 ")
    List<File> getAllFileChild(Integer idFolder);
}
