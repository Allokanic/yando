package dev.allokanic.yando.services;

import dev.allokanic.yando.dto.FileType;
import dev.allokanic.yando.dto.requests.ItemsImportRequest;
import dev.allokanic.yando.dto.responses.Item;
import dev.allokanic.yando.dto.responses.ItemFlat;
import dev.allokanic.yando.entity.Entry;
import dev.allokanic.yando.exception.EntryNotFoundException;
import dev.allokanic.yando.mapper.EntryMapper;
import dev.allokanic.yando.repository.EntriesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
        for (var item : imports.getItems().stream().filter(a -> a.getType() == FileType.FILE).toList()) {
            modifySizeAndDateOfPredecessors(item.getParentId(), item.getSize(), date);
        }
    }

    void modifySizeAndDateOfPredecessors(String parentId, int additionSize, LocalDateTime date) {
        while (parentId != null) {
            Entry parent = entriesRepository.findById(parentId).get();
            parent.setSize(parent.getSize() + additionSize);
            parent.setTime(date);
            entriesRepository.save(parent);
            parentId = parent.getParentId();
        }
    }


    public Item getItem(String id) {
        Entry entry = entriesRepository.findById(id).orElseThrow(() -> new EntryNotFoundException(id));
        return assembleItem(entry);
    }

    private Item assembleItem(Entry entry) {
        Item root = mapper.convertEntryToItem(entry);
        if (entry.getType() != FileType.FILE) {
            root.setChildren(new ArrayList<>());
            List<Entry> children = entriesRepository.findAllByParentId(root.getId());
            children.forEach(c -> root.getChildren().add(assembleItem(c)));
        }
        return root;
    }

    public void deleteItem(String id, String updateDate) {
        LocalDateTime date = LocalDateTime.parse(updateDate, DateTimeFormatter.ISO_DATE_TIME);
        Entry root = entriesRepository.findById(id).orElseThrow(() -> new EntryNotFoundException(id));
        if (root.getType() == FileType.FOLDER) {
            for (Entry c : entriesRepository.findAllByParentId(id)) {
                deleteInDepth(c);
            }
        }
        int sizeToSubtract = root.getSize();
        String parentId = root.getParentId();
        entriesRepository.delete(root);

        modifySizeAndDateOfPredecessors(parentId, -sizeToSubtract, date);
    }

    private void deleteInDepth(Entry root) {
        if (root.getType() == FileType.FOLDER) {
            for (Entry c : entriesRepository.findAllByParentId(root.getId())) {
                deleteInDepth(c);
            }
        }
        entriesRepository.delete(root);
    }

    public List<ItemFlat> getLastDayUpdatedItemsList(String date) {
        LocalDateTime now = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
        return entriesRepository.findAllByTimeBetween(now.minusDays(1), now)
                .stream()
                .map(mapper::convertEntryToFlatItem)
                .toList();
    }
}
