package com.jwt.secured.configs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@ComponentScan("com.jwt.*")
public class Configs {

    @Bean("names-list")
    public List<String>namesList() throws IOException {
        InputStream is = TypeReference.class.getResourceAsStream("/json/names.json");

        ObjectMapper objeMapper=new ObjectMapper();
        List<Object> objects = objeMapper.readValue(IOUtils.toString (is,"UTF-8"),
                new TypeReference<List<String>>() {
                });

        return objects.stream()
                .map(e->e.toString())
                .collect(Collectors.toList());
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
