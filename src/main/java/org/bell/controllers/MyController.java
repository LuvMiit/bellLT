package org.bell.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bell.pojo.GetResponse;
import org.bell.pojo.PostRequest;
import org.bell.pojo.PostResponse;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class MyController {

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/get")
    public String get() throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(new GetResponse()));
        return mapper.writeValueAsString(new GetResponse());

    }

    @PostMapping("/post")
    public String post(@RequestBody PostRequest json) throws JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return mapper.writeValueAsString(new PostResponse(json.getLogin(), json.getPassword(), sdf.format(new Date())));
    }
}
