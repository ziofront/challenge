package com.ziofront.challenge.client.vo.kakaomap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
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

        @SerializedName("total_count")
        private int totalCount;

        @SerializedName("pageable_count")
        private int pageableCount;

        @SerializedName("is_end")
        private boolean isEnd;

        @SerializedName("same_name")
        private SameName sameName;

        @Data
        public static class SameName {

            private List<String> region;
            private String keyword;

            @SerializedName("selected_region")
            private String selectedRegion;
        }
    }

    @Data
    public static class Document {

        private String id;

        @SerializedName("place_name")
        private String placeName;

        @SerializedName("category_name")
        private String categoryName;

        @SerializedName("category_group_code")
        private String categoryGroupCode;

        @SerializedName("category_group_name")
        private String categoryGroupName;

        private String phone;

        @SerializedName("address_name")
        private String addressName;

        @SerializedName("road_address_name")
        private String roadAddressName;
        private String x;
        private String y;

        @SerializedName("placeUrl")
        private String placeUrl;
        private String distance;
    }

}
