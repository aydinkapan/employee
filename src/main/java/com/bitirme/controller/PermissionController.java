package com.bitirme.controller;

import com.bitirme.dto.request.PermissionRequestDto;
import com.bitirme.dto.response.PermissionResponseDto;
import com.bitirme.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/permission")
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping
    ResponseEntity<PermissionResponseDto> createPermission(@RequestBody PermissionRequestDto permissionRequestDto) {

        return ResponseEntity.ok(permissionService.savePermission(permissionRequestDto));
    }

    @GetMapping
    List<PermissionResponseDto> getAllPermissions() {
        return permissionService.findAllPermissions();
    }

    @GetMapping("/{permissionId}")
    PermissionResponseDto getPermissionById(@PathVariable Long permissionId) {
        return permissionService.findPermissionById(permissionId);
    }

    @DeleteMapping("/{permissionId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePermission(@PathVariable Long permissionId) {
        permissionService.deletePermission(permissionId);
    }

    @PutMapping("/{permissionId}")
    ResponseEntity<PermissionResponseDto> updatePermission(@RequestBody PermissionRequestDto permissionRequestDto, @PathVariable Long permissionId) {
        return ResponseEntity.ok(permissionService.updatePermission(permissionRequestDto, permissionId));

    }
}

