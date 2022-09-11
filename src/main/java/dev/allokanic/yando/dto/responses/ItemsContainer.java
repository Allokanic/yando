package dev.allokanic.yando.dto.responses;

import lombok.Data;

import java.util.List;

@Data
public class ItemsContainer {
    private List<ItemFlat> items;
}
