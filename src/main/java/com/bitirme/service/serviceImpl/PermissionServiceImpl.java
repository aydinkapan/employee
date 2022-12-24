package com.bitirme.service.serviceImpl;

import com.bitirme.dto.request.PermissionRequestDto;
import com.bitirme.dto.response.PermissionResponseDto;
import com.bitirme.entity.Permission;
import com.bitirme.exception.CustomerNotFoundException;
import com.bitirme.mapper.PermissionMapper;
import com.bitirme.repository.PermissionRepository;
import com.bitirme.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;
    private final PermissionRepository permissionRepository;

    @Override
    public PermissionResponseDto savePermission(PermissionRequestDto permissionRequestDto) {
        Permission permission = permissionMapper.createPermission(permissionRequestDto);
        return permissionMapper.createDto(permissionRepository.save(permission));
    }

    @Override
    public List<PermissionResponseDto> findAllPermissions() {
        return permissionRepository.findAllPermissions();
    }

    @Override
    public PermissionResponseDto findPermissionById(Long permissionId) {
        return permissionRepository.findPermissionsById(permissionId);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionRepository.deleteById(permissionId);
    }

    @Override
    public PermissionResponseDto updatePermission(PermissionRequestDto permissionRequestDto, Long id) {
        Optional<Permission> permissionOptional = permissionRepository.findById(id);
        permissionOptional.ifPresent(permission -> {
            permission.setPermissionType(permissionRequestDto.getPermissionType());
            permission.setTotalDay(permissionRequestDto.getTotalDay());
            permission.setPermissionStartDate(permissionRequestDto.getPermissionStartDate());
            permission.setPermissionEndDate(permissionRequestDto.getPermissionEndDate());
            permission.setPermissionDefinition(permissionRequestDto.getPermissionDefinition());
            permission.setPermissionReturnDate(permission.getPermissionReturnDate());
            permissionRepository.save(permission);
        });
        return permissionOptional.map(permissionMapper::createDto)
                .orElseThrow(() -> new CustomerNotFoundException("Permission Not Found!"));
    }

}
