package com.javamasterclass.alex.speakingevents.service;

import com.javamasterclass.alex.speakingevents.model.Speaker;
import com.javamasterclass.alex.speakingevents.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpeakerService {
    private final SpeakerRepository speakerRepository;

    public SpeakerService(SpeakerRepository speaker) {
        this.speakerRepository = speaker;
    }
    public Iterable<Speaker> read(){
        return speakerRepository.findAll();
    }
    public ResponseEntity<String> create(Speaker speaker) {
        speakerRepository.save(speaker);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<String> put(Long id, Speaker speaker){
        if (!speakerRepository.existsById(id)) return new ResponseEntity<>("The entry does not exist.", HttpStatus.BAD_REQUEST);
        if (speaker.fieldIsNull())  return ResponseEntity.badRequest().body(" Not all fields are provided.");
        Optional<?> existingSpeaker = speakerRepository.findById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return new ResponseEntity<>("The entry has been successfully updated.",HttpStatus.OK);
    }

    public ResponseEntity<String> delete(Long id){
        if(speakerRepository.existsById(id)) {
            speakerRepository.deleteById(id);
            return new ResponseEntity<>("The entry has been successfully deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("The entry does not exist.", HttpStatus.BAD_REQUEST);
        }
    }
}

