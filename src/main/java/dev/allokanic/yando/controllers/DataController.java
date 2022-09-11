package dev.allokanic.yando.controllers;

import dev.allokanic.yando.dto.requests.ItemsImportRequest;
import dev.allokanic.yando.dto.responses.Item;
import dev.allokanic.yando.services.NodesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public HttpStatus deleteFile(@PathVariable("id") String id, @RequestParam String date) {
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/nodes/{id}")
    public Item getItem(@PathVariable("id") String id) {
        return service.getItem(id);
    }
}
