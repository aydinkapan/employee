package com.bitirme.dto.response;

import com.bitirme.enums.PermissionType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PermissionResponseDto {

    private Long userId;

    private PermissionType permissionType;

    private Long totalDay;

    private String permissionStartDate;

    private String permissionEndDate;

    private String permissionDefinition;

    private String permissionReturnDate;

    private Long permissionId;
}
