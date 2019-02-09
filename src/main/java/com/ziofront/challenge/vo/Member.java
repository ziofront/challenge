package com.ziofront.challenge.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER_BASE")
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
    private String loginPassword;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private List<MemberRole> roles;

}
