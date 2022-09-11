package dev.allokanic.yando.dto.requests;

import lombok.Data;

import java.util.List;

@Data
public class ItemsImportRequest {
    private List<ItemImport> items;
    private String updateDate;
}
