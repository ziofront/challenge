package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.PlaceFindHistory;
import com.ziofront.challenge.vo.Top10History;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSearchHistoryRepository {

    private static Logger LOG = LoggerFactory.getLogger(TestSearchHistoryRepository.class);

    @Autowired
    private PlaceFindHistoryRepository searchHistoryRepository;

    @Autowired
    private Top10HistoryRepository top10HistoryRepository;

    @Test
    public void test1_findAll() {
        List<PlaceFindHistory> list = searchHistoryRepository.findAll();

        LOG.debug("list={}", list);

        assertTrue(list == null || list.size() <= 0);
    }

    @Test
    public void test2_save() {
        PlaceFindHistory history = searchHistoryRepository.save(PlaceFindHistory.builder().keyword("하나은행").memberSeq(1).build());


        searchHistoryRepository.save(PlaceFindHistory.builder().keyword("하나은행").memberSeq(1).build());
        searchHistoryRepository.save(PlaceFindHistory.builder().keyword("하나은행").memberSeq(2).build());
        searchHistoryRepository.save(PlaceFindHistory.builder().keyword("하나은행").memberSeq(3).build());

        searchHistoryRepository.save(PlaceFindHistory.builder().keyword("카카오프렌즈").memberSeq(1).build());
        searchHistoryRepository.save(PlaceFindHistory.builder().keyword("카카오프렌즈").memberSeq(1).build());

        LOG.debug("history={}", history);

        assertTrue(history != null);
    }


    @Test
    public void test3_findAll() {
        List<PlaceFindHistory> list = searchHistoryRepository.findAll();

        LOG.debug("list={}", list);

        assertTrue(list != null && list.size() > 0);
    }


    @Test
    public void test5_findTop10Count() {

        List<Top10History> list = top10HistoryRepository.findPlaceFindHistoryCount();

        list.forEach(i -> LOG.debug("{} : {}", i.getKeyword(), i.getCnt()));

        LOG.debug("list={}", list);

        assertTrue(list != null && list.size() > 0);
    }
}
