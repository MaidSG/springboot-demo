package com.wy.springbootdemo.controller;

import com.wy.springbootdemo.entity.Unit;
import com.wy.springbootdemo.exception.BitMapException;
import com.wy.springbootdemo.until.BitMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class BitMapController {

    @Autowired
    private static final BitMap bitMap = new BitMap();

    @PostMapping("/bit-num")
    public ResponseEntity<String> addNum(@RequestBody Unit unit) {
        System.out.println(unit);
        String str_num = unit.getId();
        if (str_num == null || "".equals(str_num)){
            throw new BitMapException();
        }
        int number = Integer.parseInt(str_num);
        bitMap.add(number);
        boolean contains = bitMap.contains(number);
        return ResponseEntity.ok(contains?"now , bit map contains : " + number:"add faild" );
    }

    @DeleteMapping("/bit-num/{num}")
    public ResponseEntity<String> delete(@PathVariable("num") int num) {
        bitMap.delete(num);
        return ResponseEntity.ok(num + " delete complete");
    }

    @GetMapping("/bit-num/{num}")
    public ResponseEntity contains(@PathVariable("num") int num) {
        boolean contains = bitMap.contains(num);
        return ResponseEntity.ok("the " + num + " contains: " + contains);
    }


}
