package com.example.managefolder.repository;

import com.example.managefolder.modal.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Integer> {
    @Query(nativeQuery = true, value = "select * from folder f " +
            "where f.PATH like '?1%' ")
    List<Folder> getAllFolderChild(String path);
}
