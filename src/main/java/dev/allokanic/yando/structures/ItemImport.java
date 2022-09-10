package dev.allokanic.yando.structures;

import lombok.Data;

@Data
public class ItemImport {
    private String id;
    private String url;
    private String parentId;
    private String type;
    private int size;
}
