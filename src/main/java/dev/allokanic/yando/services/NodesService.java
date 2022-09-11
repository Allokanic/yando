package dev.allokanic.yando.services;

import dev.allokanic.yando.dto.requests.ItemsImportRequest;
import dev.allokanic.yando.entity.Entry;
import dev.allokanic.yando.mapper.EntryMapper;
import dev.allokanic.yando.repository.EntriesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NodesService {
    private final EntriesRepository entriesRepository;
    private final EntryMapper mapper;

    public NodesService(EntriesRepository entriesRepository, EntryMapper mapper) {
        this.entriesRepository = entriesRepository;
        this.mapper = mapper;
    }

    public void importEntries(ItemsImportRequest imports) {
        LocalDateTime date = LocalDateTime.parse(imports.getUpdateDate(), DateTimeFormatter.ISO_DATE_TIME);
        for (var item : imports.getItems()) {
            Entry entry = mapper.convertImportItemToEntry(item);
            entry.setTime(date);
            entriesRepository.save(entry);
        }
    }
}
