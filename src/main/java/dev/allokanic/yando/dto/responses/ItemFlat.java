package dev.allokanic.yando.dto.responses;

import dev.allokanic.yando.dto.FileType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemFlat {
    private String id;
    private String url;
    private String date;
    private String parentId;
    private FileType type;
    private int size;
}
