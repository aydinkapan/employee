package com.bitirme.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequestDto {
    private String username;
    @ToString.Exclude
    private String password;
}

