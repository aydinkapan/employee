package com.bitirme.service.serviceImpl;

import com.bitirme.dto.request.UserRequestDto;
import com.bitirme.dto.response.UserResponseDto;
import com.bitirme.entity.User;
import com.bitirme.exception.CustomerNotFoundException;
import com.bitirme.mapper.UserMapper;
import com.bitirme.repository.UserRepository;
import com.bitirme.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        User user = userMapper.createUser(userRequestDto);
        return userMapper.createDto(userRepository.save(user));
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public UserResponseDto findUserByUserId(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(user -> {
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
            user.getUserContactInfo().setAddress(userRequestDto.getAddress());
            user.getUserContactInfo().setCity(userRequestDto.getCity());
            user.getUserContactInfo().setCountry(userRequestDto.getCountry());
            user.getUserContactInfo().setPostCode(userRequestDto.getPostCode());
            user.getUserContactInfo().setPhoneNumber(userRequestDto.getPhoneNumber());
            userRepository.save(user);
        });
        return userOptional.map(userMapper::createDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
    }
}

