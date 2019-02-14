package com.ziofront.challenge.vo;


import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author jiho
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEMBER_BASE")
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SEQ")
    private long seq;

    @Column(name = "MEMBER_NAME", nullable = false)
    private String name;

    @Column(name = "LOGIN_ID", nullable = false, unique = true)
    private String loginId;

    @Column(name = "LOGIN_PASSWORD", nullable = false)
    @ToString.Exclude
    private String loginPassword;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private List<MemberRole> roles;

}
