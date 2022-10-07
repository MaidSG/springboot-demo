package com.wy.springbootdemo.controller;


import com.wy.springbootdemo.entity.Unit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UnitController {
    private List<Unit> unitList = new ArrayList<>();

    @PostMapping("/unit")
    public ResponseEntity<List<Unit>> addBook(@RequestBody Unit unit) {
        unitList.add(unit);
        return ResponseEntity.ok(unitList);
    }

    @DeleteMapping("/unit/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id) {
        unitList.remove(id);
        return ResponseEntity.ok(unitList);
    }

    @GetMapping("/unit")
    public ResponseEntity getBookByName(@RequestParam("desc") String desc) {
        List<Unit> results = unitList.stream().filter(unit -> unit.getDescription().equals(desc)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }

}
