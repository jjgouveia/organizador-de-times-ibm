package me.jarbasgouveia.organizadordetimes.controller;

import me.jarbasgouveia.organizadordetimes.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<?> listarTimes(){
        return ResponseEntity.status(HttpStatus.OK).body(timeService.listarTimes());
    }
}
