package com.bitirme.entity;

import com.bitirme.enums.PermissionType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "perm_id")
    private Long permId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "permission_type")
    @Enumerated
    private PermissionType permissionType;

    @Column(name = "total_day")
    private Long totalDay;

    @Column(name = "permission_start_date")
    private String permissionStartDate;

    @Column(name = "permission_end_date")
    private String permissionEndDate;

    @Column(name = "permission_definition")
    private String permissionDefinition;

    @Column(name = "permission_return_date")
    private String permissionReturnDate;


}
