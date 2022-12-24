package com.bitirme.repository;

import com.bitirme.dto.response.PermissionResponseDto;
import com.bitirme.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {


    @Query("""
                        select new com.bitirme.dto.response.PermissionResponseDto(
                            p.user.userId,
                            p.permissionType,
                            p.totalDay,
                            p.permissionStartDate,
                            p.permissionEndDate,
                            p.permissionDefinition,
                            p.permissionReturnDate,
                            p.permId
                        )
                        From Permission p
            """)
    List<PermissionResponseDto> findAllPermissions();

    @Query("""
                        select new com.bitirme.dto.response.PermissionResponseDto(
                            p.user.userId,
                            p.permissionType,
                            p.totalDay,
                            p.permissionStartDate,
                            p.permissionEndDate,
                            p.permissionDefinition,
                            p.permissionReturnDate,
                            p.permId
                        )
                        From Permission p
                        where p.permId=:permissionId
            """)
    PermissionResponseDto findPermissionsById(@PathVariable("permissionId") Long permissionId);
}
