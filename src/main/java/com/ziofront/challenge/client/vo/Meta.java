package com.ziofront.challenge.client.vo;

import lombok.Data;

@Data
public class Meta {
    int total_count;
    int pageable_count;
    boolean is_end;
    SameName same_name;
}
