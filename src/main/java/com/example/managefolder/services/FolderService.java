package com.example.managefolder.services;

import com.example.managefolder.modal.File;
import com.example.managefolder.modal.Folder;
import com.example.managefolder.repository.FileRepository;
import com.example.managefolder.repository.FolderRepository;
import com.example.managefolder.services.repsonse.ContentFolderDTO;
import com.example.managefolder.services.request.FolderDTO;
import com.example.managefolder.services.request.ListToDeleteDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FolderService {
    private final FolderRepository folderRepository;
    private final FileRepository fileRepository;
    public List<Folder> getAllFolder() {
        return folderRepository.findAll();
    }
    public ContentFolderDTO getDetailById(Integer id) {
        ContentFolderDTO contentFolderDTO = new ContentFolderDTO();
        Optional<Folder> folder = folderRepository.findById(id);
        if (folder.isPresent()) {
            List<Folder> listFoldersChild = folderRepository.getAllFolderChild(folder.get().getPath());
            listFoldersChild.remove(folder.get());
            List<File> listFilesChild = fileRepository.getAllFileChild(id);

            contentFolderDTO.setId(folder.get().getId());
            contentFolderDTO.setName(folder.get().getName());
            contentFolderDTO.setFoldersChild(listFoldersChild);
            contentFolderDTO.setFilesChild(listFilesChild);
        }

        return contentFolderDTO;
    }

    public String changeFolderName(Integer id, FolderDTO dto) {
        Optional<Folder> folder = folderRepository.findById(id);
        if(folder.isPresent()) {
            folder.get().setName(dto.getName());
            folderRepository.save(folder.get());
        }
        return "change folder name";
    }

    public String delete(ListToDeleteDTO dto) {
        if (dto.getIds().isEmpty()) return null;
        dto.getIds().forEach(id -> {
            Optional<Folder> folderPatent = folderRepository.findById(id);
            if (folderPatent.isPresent()) {
                List<Folder> foldersChild = folderRepository.getAllFolderChild(folderPatent.get().getPath());
                List<File> filesChild = fileRepository.getAllFileChild(id);
                if (!foldersChild.isEmpty()) folderRepository.deleteAll(foldersChild);
                if (!filesChild.isEmpty()) fileRepository.deleteAll(filesChild);
            } else {
                Optional<File> file = fileRepository.findById(id);
                file.ifPresent(fileRepository::delete);
            }
        });

        return "delete folder and file";
    }
}
