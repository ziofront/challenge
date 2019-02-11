package com.ziofront.challenge.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private int totalCount;
    private int pageableCount;
    private List<Item> placeList;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String id;
        private String name;
        private String x;
        private String y;
        private String url;
        private String phone;
        private String address1;
        private String address2;
        private String categoryName;
        private String mapUrl;
    }


}
