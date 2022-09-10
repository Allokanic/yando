package dev.allokanic.yando.structures;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Item {
    private String id;
    private String url;
    private String time;
    private String parentId;
    private String type;
    private int size;
    ArrayList<Item> children;
}
