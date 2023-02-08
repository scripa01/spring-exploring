package com.example.springexploring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class SpringExploringApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringExploringApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper(){
    return new ModelMapper();
  }
}
