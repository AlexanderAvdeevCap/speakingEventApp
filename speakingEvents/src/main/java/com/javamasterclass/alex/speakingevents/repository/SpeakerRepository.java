package com.javamasterclass.alex.speakingevents.repository;

import com.javamasterclass.alex.speakingevents.model.Speaker;
import org.springframework.data.repository.CrudRepository;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
}
