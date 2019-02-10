package com.ziofront.challenge.service;

import com.ziofront.challenge.vo.Place;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface PlaceFindService {

    /**
     *
     * @param keyword
     * @param pageable
     * @return
     * @throws IOException
     */
    public Place findByKeyword(String keyword, Pageable pageable) throws IOException;

}
