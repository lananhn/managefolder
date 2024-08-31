package com.example.managefolder.modal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "folder")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String path;
}
