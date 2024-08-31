package com.example.managefolder.controller;

import com.example.managefolder.modal.Folder;
import com.example.managefolder.services.FolderService;
import com.example.managefolder.services.repsonse.ContentFolderDTO;
import com.example.managefolder.services.request.FolderDTO;
import com.example.managefolder.services.request.ListToDeleteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/folder")
public class FolderController {
    private final FolderService folderService;

    @GetMapping("/")
    public ResponseEntity<List<Folder>> getAllFolder() {
        return ResponseEntity.ok(folderService.getAllFolder());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentFolderDTO> getDetailById(@PathVariable Integer id) {
        return ResponseEntity.ok(folderService.getDetailById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeFolderName(@PathVariable Integer id, @RequestBody FolderDTO dto) {
        return ResponseEntity.ok(folderService.changeFolderName(id, dto));
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody ListToDeleteDTO dto) {
        return ResponseEntity.ok(folderService.delete(dto));
    }
}
