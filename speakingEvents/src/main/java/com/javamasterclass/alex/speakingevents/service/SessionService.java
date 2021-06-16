package com.javamasterclass.alex.speakingevents.service;

import com.javamasterclass.alex.speakingevents.model.Session;
import com.javamasterclass.alex.speakingevents.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository session) {
        this.sessionRepository = session;
    }

    public Iterable<Session> read(){
        return sessionRepository.findAll();
    }

    public ResponseEntity<String> create(Session session) {
        sessionRepository.save(session);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<String> put(Long id, Session session){
        if (!sessionRepository.existsById(id)) return new ResponseEntity<>("The entry does not exist.", HttpStatus.BAD_REQUEST);
        if (session.fieldIsNull())  return ResponseEntity.badRequest().body(" Not all fields are provided.");
        Optional<?> existingSession = sessionRepository.findById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return new ResponseEntity<>("The entry has been successfully updated.",HttpStatus.OK);
    }

    public ResponseEntity<String> delete(Long id){
        if(sessionRepository.existsById(id)) {
            sessionRepository.deleteById(id);
            return new ResponseEntity<>("The entry has been successfully deleted.",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("The entry does not exist.", HttpStatus.BAD_REQUEST);
        }
    }
}
