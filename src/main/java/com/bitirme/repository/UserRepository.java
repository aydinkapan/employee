package com.bitirme.repository;

import com.bitirme.dto.response.UserResponseDto;
import com.bitirme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = """
                select new com.bitirme.dto.response.UserResponseDto(
                    u.firstName,
                    u.lastName,
                    u.email,
                    u.identityNo,
                    u.salary,
                    u.startDate,
                    u.title,
                    u.role,
                    u.level,
                    u.department,
                    u.birthDate,
                    uci.address,
                    uci.city,
                    uci.country,
                    uci.postCode,
                    uci.phoneNumber,
                    u.userId)
                
                FROM User u
                INNER JOIN UserContactInfo uci 
                    on u.userId=uci.user.userId
""")
    List<UserResponseDto>findAllUsers();


    @Query(value = """
            select new com.bitirme.dto.response.UserResponseDto(
                    u.firstName,
                    u.lastName,
                    u.email,
                    u.identityNo,
                    u.salary,
                    u.startDate,
                    u.title,
                    u.role,
                    u.level,
                    u.department,
                    u.birthDate,
                    uci.address,
                    uci.city,
                    uci.country,
                    uci.postCode,
                    uci.phoneNumber,
                    u.userId)
            FROM User u
            INNER JOIN UserContactInfo uci
            on u.userId=uci.user.userId
            where u.userId=:userId
""")
    UserResponseDto findUserById(@PathVariable("userId")Long userId);

}
