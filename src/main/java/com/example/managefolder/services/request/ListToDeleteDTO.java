package com.example.managefolder.services.request;

import lombok.Data;

import java.util.List;

@Data
public class ListToDeleteDTO {
    List<Integer> ids;
}
