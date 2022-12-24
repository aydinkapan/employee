package com.bitirme.dto.request;

import com.bitirme.enums.UserDepartment;
import com.bitirme.enums.UserLevel;
import com.bitirme.enums.UserRole;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private Long userId;

    @NotBlank(message = "Isim bos olamaz!")
    private String firstName;

    @NotBlank(message = "Soyisim bos olamaz")
    private String lastName;

    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: turkcell@mail.com")
    @NotBlank(message = "Email bos olamaz!")
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

}


