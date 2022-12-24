package com.bitirme.mapper;

import com.bitirme.dto.request.PermissionRequestDto;
import com.bitirme.dto.response.PermissionResponseDto;
import com.bitirme.entity.Permission;
import com.bitirme.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {

    public Permission createPermission(PermissionRequestDto permissionRequestDto) {
        return Permission.builder().user(User.builder().userId(permissionRequestDto.getUserId()).build())
                .permissionType(permissionRequestDto.getPermissionType())
                .totalDay(permissionRequestDto.getTotalDay())
                .permissionStartDate(permissionRequestDto.getPermissionStartDate())
                .permissionEndDate(permissionRequestDto.getPermissionEndDate())
                .permissionDefinition(permissionRequestDto.getPermissionDefinition())
                .permissionReturnDate(permissionRequestDto.getPermissionReturnDate())
                .build();
    }

    public PermissionResponseDto createDto(Permission permission) {
        PermissionResponseDto permissionResponseDto = new PermissionResponseDto();
        permissionResponseDto.setUserId(permission.getUser().getUserId());
        permissionResponseDto.setPermissionType(permission.getPermissionType());
        permissionResponseDto.setTotalDay(permission.getTotalDay());
        permissionResponseDto.setPermissionStartDate(permission.getPermissionStartDate());
        permissionResponseDto.setPermissionEndDate(permission.getPermissionEndDate());
        permissionResponseDto.setPermissionDefinition(permission.getPermissionDefinition());
        permissionResponseDto.setPermissionReturnDate(permission.getPermissionReturnDate());
        return permissionResponseDto;
    }
}
