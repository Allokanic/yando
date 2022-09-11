package dev.allokanic.yando.mapper;

import dev.allokanic.yando.dto.requests.ItemImport;
import dev.allokanic.yando.entity.Entry;
import org.springframework.stereotype.Component;

@Component
public class EntryMapper {
    public Entry convertImportItemToEntry(ItemImport item) {
        return new Entry()
                .setId(item.getId())
                .setSize(item.getSize())
                .setParentId(item.getParentId())
                .setType(item.getType())
                .setUrl(item.getUrl());
    }
}
