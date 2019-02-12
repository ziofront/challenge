package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.PlaceFindHistory;
import com.ziofront.challenge.vo.Top10History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiho
 */
@Repository
public interface Top10HistoryRepository extends CrudRepository<PlaceFindHistory, Long> {

    /*
        TODO 쿼리를 안쓰고 할 수 있는 방법이.. 있겠지...
     */
    @Query(nativeQuery = true, value =
            "SELECT " +
                    " v.keyword as keyword, COUNT(v.keyword) as cnt"
                    + " FROM " +
                    "PLACE_SEARCH_HISTORY v "
                    + " GROUP BY " +
                    "v.keyword "
                    + " ORDER BY cnt DESC, keyword "
                    + " LIMIT 10"
    )
    List<Top10History> findPlaceFindHistoryCount();

}
