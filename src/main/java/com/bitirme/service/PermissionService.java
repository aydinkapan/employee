package com.bitirme.service;

import com.bitirme.dto.request.PermissionRequestDto;
import com.bitirme.dto.response.PermissionResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PermissionService {

    PermissionResponseDto savePermission(PermissionRequestDto permissionRequestDto);

    List<PermissionResponseDto> findAllPermissions();

    PermissionResponseDto findPermissionById(Long permissionId);


    void deletePermission(@PathVariable Long permissionId);

    PermissionResponseDto updatePermission(PermissionRequestDto permissionRequestDto, Long id);

}

