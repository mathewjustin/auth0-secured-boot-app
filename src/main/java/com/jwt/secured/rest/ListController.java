package com.jwt.secured.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwt.secured.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListController {

    @Autowired
    @Qualifier("names-list")
    public List<String>names;

    @GetMapping("/names")
    public List<String>getNames(@RequestParam(value = "lim",defaultValue = "10")String limit) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        String content = authentication.getPrincipal().toString();
        User current =
        objectMapper.readValue(content,User.class);


        int maxSize = Integer.parseInt(limit);
        maxSize=maxSize<0?10:maxSize;

        return names.stream()
                .limit(maxSize)
                .collect(Collectors.toList());
    }


    @GetMapping("/")
    public List<String>defaultpage(@RequestParam(value = "lim",defaultValue = "10")String limit) throws IOException {

            return getNames("10");

    }




}
