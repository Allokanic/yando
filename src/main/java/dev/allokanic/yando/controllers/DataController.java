package dev.allokanic.yando.controllers;

import dev.allokanic.yando.dto.requests.ItemsImportRequest;
import dev.allokanic.yando.dto.responses.Item;
import dev.allokanic.yando.dto.responses.ItemFlat;
import dev.allokanic.yando.services.NodesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Question about errors
*
 */

@RestController
public class DataController {

    private final NodesService service;

    public DataController(NodesService service) {
        this.service = service;
    }

    @PostMapping("/imports")
    public void importData(@RequestBody ItemsImportRequest imports) {
        service.importEntries(imports);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFile(@PathVariable("id") String id, @RequestParam String date) {
        service.deleteItem(id, date);
    }

    @GetMapping("/nodes/{id}")
    public Item getItem(@PathVariable("id") String id) {
        return service.getItem(id);
    }

    @GetMapping("/updates")
    public List<ItemFlat> getHistory(@RequestParam String date) {
        return service.getLastDayUpdatedItemsList(date);
    }
}