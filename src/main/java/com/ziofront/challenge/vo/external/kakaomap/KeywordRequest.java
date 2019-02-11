package com.ziofront.challenge.vo.external.kakaomap;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KeywordRequest {

    private String query;

    @SerializedName("category_group_code")
    private String categoryGroupCode;

    private String x;
    private String y;
    private int radius;
    private String rect;
    private int page;
    private int size;

}
