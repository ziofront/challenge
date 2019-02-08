package com.ziofront.challenge.client.vo.kakaomap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class KeywordResponse {

    private Meta meta;
    private List<Document> documents;


    @Data
    public static class Meta {

        private int total_count;
        private int pageable_count;
        private boolean is_end;
        private SameName same_name;

        @Data
        public static class SameName {

            List<String> region;
            String keyword;
            String selected_region;
        }
    }

    @Data
    public static class Document {
        private String id;
        private String place_name;
        private String category_name;
        private String category_group_code;
        private String category_group_name;
        private String phone;
        private String address_name;
        private String road_address_name;
        private String x;
        private String y;
        private String place_url;
        private String distance;
    }

}
