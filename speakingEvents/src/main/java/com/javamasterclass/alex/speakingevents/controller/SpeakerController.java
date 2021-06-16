package com.javamasterclass.alex.speakingevents.controller;

import com.javamasterclass.alex.speakingevents.model.Speaker;
import com.javamasterclass.alex.speakingevents.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpeakerController {

    private final SpeakerService service;

    public SpeakerController(SpeakerService service) {
        this.service = service;
    }

    @GetMapping("/speakers")
    @ResponseBody
    public Iterable<Speaker> read(){
        return service.read();
    }

    @PostMapping("/speakers")
    public ResponseEntity<String> create(@RequestBody Speaker speaker){
        return service.create(speaker);
    }

    @PutMapping("/speakers/{id}")
    public ResponseEntity<String> put(@PathVariable Long id, @RequestBody Speaker speaker){
        return service.put(id, speaker);
    }

    @DeleteMapping("/speakers/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
