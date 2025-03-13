package org.bell.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.bell.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class MyController {

    ObjectMapper mapper = new ObjectMapper();
    Random rand = new Random();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/get")
    public ResponseEntity<String> get() {

        responseTime(1001);
        return new ResponseEntity<>(
                "{" +
                            "\"login\":"+"\"login1\","+
                            "\"status\":"+"\"ok\""+
                        "}",
                HttpStatus.OK
        );

    }

    @PostMapping("/post")
    public ResponseEntity<String> post(@Valid @RequestBody User user) throws JsonProcessingException {

        user.setDate(sdf.format(new Date()));
        responseTime(1001);
        return new ResponseEntity<>(mapper.writeValueAsString(user), HttpStatus.OK);
    }

    private void responseTime(int bound){
        try{
            int time = rand.nextInt(bound)+1000;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
