package com.ziofront.challenge.service;

import com.ziofront.challenge.repository.PlaceFindHistoryRepository;
import com.ziofront.challenge.repository.Top10HistoryRepository;
import com.ziofront.challenge.vo.PlaceFindHistory;
import com.ziofront.challenge.vo.Top10History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiho
 */
@Service
public class PlaceFindHIstoryService {

    @Autowired
    private PlaceFindHistoryRepository placeFindHistoryRepository;

    @Autowired
    private Top10HistoryRepository top10HistoryRepository;

    /**
     * @param placeFindHistory
     */
    public PlaceFindHistory saveHistory(PlaceFindHistory placeFindHistory) {
        return placeFindHistoryRepository.save(placeFindHistory);
    }

    /**
     * @return
     */
    public List<Top10History> findTop10History() {
        return top10HistoryRepository.findPlaceFindHistoryCount();
    }

}
