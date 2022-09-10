package dev.allokanic.yando.controllers;

import dev.allokanic.yando.structures.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
* Question about errors
*
 */

@Controller
public class DataController {



    @PostMapping("/imports")
    public ResponseEntity<Object> importData(@RequestBody ArrayList<Item> items, @RequestBody String updateTime) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFile(@PathVariable("id") String id, @RequestBody String date) {

    }

    @GetMapping("/nodes/{id}")
    public ResponseEntity<Object> getItem(@PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
