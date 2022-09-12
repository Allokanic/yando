package dev.allokanic.yando.dto.responses;

import dev.allokanic.yando.dto.FileType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Item {
    private String id;
    private String url;
    private String date;
    private String parentId;
    private FileType type;
    private int size;
    private List<Item> children;
}
