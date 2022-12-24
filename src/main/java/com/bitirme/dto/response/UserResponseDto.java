package com.bitirme.dto.response;

import com.bitirme.enums.UserDepartment;
import com.bitirme.enums.UserLevel;
import com.bitirme.enums.UserRole;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    private Long identityNo;

    private Long salary;

    private String startDate;

    private String title;

    private UserRole role;

    private UserLevel level;

    private UserDepartment department;

    private String birthDate;

    private String address;

    private String city;

    private String country;

    private String postCode;

    private Long phoneNumber;

    private Long userId;
}
