package com.myprojects.ebankingbackend.dtos;


import lombok.Data;


@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
}