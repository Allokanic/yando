package dev.allokanic.yando.mapper;

import dev.allokanic.yando.dto.requests.ItemImport;
import dev.allokanic.yando.dto.responses.Item;
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

    public Item convertEntryToItem(Entry entry) {
        return new Item()
                .setId(entry.getId())
                .setUrl(entry.getUrl())
                .setType(entry.getType())
                .setParentId(entry.getParentId())
                .setSize(entry.getSize());
    }
}
