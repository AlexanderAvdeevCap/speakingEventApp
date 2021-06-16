package com.javamasterclass.alex.speakingevents.controller;

import com.javamasterclass.alex.speakingevents.model.Session;
import com.javamasterclass.alex.speakingevents.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SessionController {

    private final SessionService service;

    public SessionController(SessionService service) {
        this.service = service;
    }

    @GetMapping("/sessions")
    @ResponseBody
    public Iterable<Session> read(){
        return service.read();
    }

    @PostMapping("/sessions")
    public ResponseEntity<String> create(@RequestBody Session session){
        return service.create(session);
    }

    @PutMapping("/sessions/{id}")
    public ResponseEntity<String> put(@PathVariable Long id, @RequestBody Session session){
        return service.put(id, session);
    }

    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
