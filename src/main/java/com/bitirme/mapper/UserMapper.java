package com.bitirme.mapper;

import com.bitirme.dto.request.UserRequestDto;
import com.bitirme.dto.response.UserResponseDto;
import com.bitirme.entity.User;
import com.bitirme.entity.UserContactInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {


    public User createUser(UserRequestDto userRequestDto) {
        User user = new User();
        UserContactInfo userContactInfo = new UserContactInfo();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setIdentityNo(userRequestDto.getIdentityNo());
        user.setSalary(userRequestDto.getSalary());
        user.setStartDate(userRequestDto.getStartDate());
        user.setTitle(userRequestDto.getTitle());
        user.setRole(userRequestDto.getRole());
        user.setLevel(userRequestDto.getLevel());
        user.setDepartment(userRequestDto.getDepartment());
        user.setBirthDate(userRequestDto.getBirthDate());
        userContactInfo.setAddress(userRequestDto.getAddress());
        userContactInfo.setCity(userRequestDto.getCity());
        userContactInfo.setCountry(userRequestDto.getCountry());
        userContactInfo.setPostCode(userRequestDto.getPostCode());
        userContactInfo.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setUserContactInfo(userContactInfo);
        userContactInfo.setUser(user);
        return user;

    }

    public UserResponseDto createDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setIdentityNo(user.getIdentityNo());
        userResponseDto.setSalary(user.getSalary());
        userResponseDto.setStartDate(user.getStartDate());
        userResponseDto.setTitle(user.getTitle());
        userResponseDto.setRole(user.getRole());
        userResponseDto.setLevel(user.getLevel());
        userResponseDto.setDepartment(user.getDepartment());
        userResponseDto.setBirthDate(user.getBirthDate());
        userResponseDto.setAddress(user.getUserContactInfo().getAddress());
        userResponseDto.setCity(user.getUserContactInfo().getCity());
        userResponseDto.setCountry(user.getUserContactInfo().getCountry());
        userResponseDto.setPostCode(user.getUserContactInfo().getPostCode());
        userResponseDto.setPhoneNumber(user.getUserContactInfo().getPhoneNumber());
        return userResponseDto;

    }

}
