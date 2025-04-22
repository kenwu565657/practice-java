package com.practice.java.learn.redisson.controller;

import com.practice.java.learn.redisson.service.PraiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PraiseController {
    private final PraiseService praiseService;

    @PostMapping(value = "blog/praise/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addPraise(@RequestBody @Validated Object request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "blog/total/rank", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTotalRank() {
        var rank = praiseService.getPraiseRank();
        return new ResponseEntity<>(rank, HttpStatus.OK);
    }
}
