package com.bitirme.service;

import com.bitirme.dto.request.UserRequestDto;
import com.bitirme.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto saveUser(UserRequestDto userRequestDto);

    List<UserResponseDto> findAllUsers();

    UserResponseDto findUserByUserId(Long userId);

    void deleteUser(Long id);

    UserResponseDto updateUser(UserRequestDto userRequestDto, Long id);

}

