package dev.allokanic.yando.dto.requests;

import dev.allokanic.yando.dto.FileType;
import lombok.Data;

@Data
public class ItemImport {
    private String id;
    private String url;
    private String parentId;
    private FileType type;
    private int size;
}
