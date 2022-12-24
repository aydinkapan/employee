package com.bitirme.entity;

import com.bitirme.enums.UserDepartment;
import com.bitirme.enums.UserLevel;
import com.bitirme.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;


    //    @Column
//    @NotNull
//    protected String password;
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "uci_id")
    private UserContactInfo userContactInfo;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "perm_id")
    private Permission permission;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "spend_id")
    private Spending spending;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    protected String email;


    @Column(name = "identity_no")
    private Long identityNo;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "title")
    private String title;

    @Column(name = "role")
    @Enumerated
    private UserRole role;

    @Column(name = "level")
    @Enumerated
    private UserLevel level;

    @Column(name = "department")
    @Enumerated
    private UserDepartment department;

    @Column(name = "birth_date")
    private String birthDate;

}


