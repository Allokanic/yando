package dev.allokanic.yando.mapper;

import dev.allokanic.yando.dto.requests.ItemImport;
import dev.allokanic.yando.dto.responses.Item;
import dev.allokanic.yando.dto.responses.ItemFlat;
import dev.allokanic.yando.entity.Entry;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

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
                .setSize(entry.getSize())
                .setDate(entry.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")));
    }

    public ItemFlat convertEntryToFlatItem(Entry entry) {
        return new ItemFlat()
                .setId(entry.getId())
                .setUrl(entry.getUrl())
                .setType(entry.getType())
                .setParentId(entry.getParentId())
                .setSize(entry.getSize())
                .setDate(entry.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
    }
}
