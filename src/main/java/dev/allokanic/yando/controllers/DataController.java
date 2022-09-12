package dev.allokanic.yando.controllers;

import dev.allokanic.yando.dto.requests.ItemsImportRequest;
import dev.allokanic.yando.dto.responses.Item;
import dev.allokanic.yando.dto.responses.ItemFlat;
import dev.allokanic.yando.services.NodesService;
import dev.allokanic.yando.validation.annotation.IsISO8601;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
* Question about errors
*
 */

@RestController
@Validated
public class DataController {

    private final NodesService service;

    public DataController(NodesService service) {
        this.service = service;
    }

    @PostMapping("/imports")
    public void importData(@Valid @RequestBody ItemsImportRequest imports) {
        service.importEntries(imports);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFile(@PathVariable("id") String id, @IsISO8601 @RequestParam String date) {
        service.deleteItem(id, date);
    }

    @GetMapping("/nodes/{id}")
    public Item getItem(@PathVariable("id") String id) {
        return service.getItem(id);
    }

    @GetMapping("/updates")
    public List<ItemFlat> getHistory(@IsISO8601 @RequestParam String date) {
        return service.getLastDayUpdatedItemsList(date);
    }
}