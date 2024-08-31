package com.example.managefolder.services.repsonse;

import com.example.managefolder.modal.File;
import com.example.managefolder.modal.Folder;
import lombok.Data;

import java.util.List;

@Data
public class ContentFolderDTO {
    private Integer id;
    private String name;
    private List<Folder> foldersChild;
    private List<File> filesChild;
}
