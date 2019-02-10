package com.ziofront.challenge.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PLACE_SEARCH_HISTORY")
public class PlaceFindHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "SEARCH_SEQ")
    private long seq;

    @Column(name = "MEMBER_SEQ")
    private long memberSeq;

    @Column(name = "KEYWORD")
    private String keyword;

}
