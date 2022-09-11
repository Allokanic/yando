package dev.allokanic.yando.dto.responses;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Item {
    private String id;
    private String url;
    private String time;
    private String parentId;
    private String type;
    private int size;
    List<Item> children;
}
