package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.PlaceFindHistory;
import com.ziofront.challenge.vo.Top10History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Top10HistoryRepository extends CrudRepository<PlaceFindHistory, Long> {

    @Query(nativeQuery = true, value =
            "SELECT " +
                    " v.keyword as keyword, COUNT(v.keyword) as cnt"
            + " FROM " +
                    "PLACE_SEARCH_HISTORY v "
            + " GROUP BY " +
                    "v.keyword "
    )
    public List<Top10History> findPlaceFindHistoryCount();

}
