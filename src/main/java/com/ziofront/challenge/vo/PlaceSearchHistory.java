package com.ziofront.challenge.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PLACE_SEARCH_HISTORY")
public class PlaceSearchHistory {

    private long seq;

    private long memberSeq;

    private String keyword;

}
