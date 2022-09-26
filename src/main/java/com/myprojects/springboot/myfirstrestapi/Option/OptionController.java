package com.myprojects.springboot.myfirstrestapi.Option;

import jakarta.persistence.GeneratedValue;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/options")
public class OptionController {

    @Autowired
    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping
    public ResponseEntity retrieveAllOptions(){
        return new ResponseEntity(optionService.getAllOptions(), HttpStatus.ACCEPTED);
    }
}
