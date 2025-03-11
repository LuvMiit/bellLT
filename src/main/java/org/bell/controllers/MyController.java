package org.bell.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bell.pojo.GetResponse;
import org.bell.pojo.PostRequest;
import org.bell.pojo.PostResponse;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class MyController {

    ObjectMapper mapper = new ObjectMapper();
    Random rand = new Random();
    @GetMapping("/get")
    public String get() throws JsonProcessingException {

        responseTime(1001);
        return mapper.writeValueAsString(new GetResponse());

    }

    @PostMapping("/post")
    public String post(@RequestBody PostRequest json) throws JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        responseTime(1001);
        return mapper.writeValueAsString(new PostResponse(json.getLogin(), json.getPassword(), sdf.format(new Date())));
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
