package me.jarbasgouveia.organizadordetimes.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jarbasgouveia.organizadordetimes.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/times")
@Tag(name = "Time Controller", description = "Controller para gerenciamento dos times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @Operation(summary = "Lista todos os times", description = "Lista todos os times criados de acordo com as regras de negócio")
    @ApiResponse(responseCode = "200")
    @GetMapping
    public ResponseEntity<?> listarTimes(){
        return ResponseEntity.status(HttpStatus.OK).body(timeService.listarTimes());
    }
}
