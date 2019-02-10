package com.ziofront.challenge.service;

import com.ziofront.challenge.repository.PlaceFindHistoryRepository;
import com.ziofront.challenge.vo.PlaceFindHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceFindHIstoryService {

    @Autowired
    private PlaceFindHistoryRepository placeFindHistoryRepository;

    /**
     * 
     * @param placeFindHistory
     */
    public void saveHistory(PlaceFindHistory placeFindHistory) {
        placeFindHistoryRepository.save(placeFindHistory);
    }

}
