package com.ziofront.challenge.web.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPagination {

    private static Logger LOG = LoggerFactory.getLogger(TestPagination.class);

    @Test
    public void test1() {
        Pagination pagination1 = Pagination.builder().currentPage(4).totalCount(2630).pageSize(15).paginationSize(6).build();

        Pagination pagination2 = Pagination.builder().currentPage(3).totalCount(23).pageSize(10).paginationSize(5).build();

        LOG.debug("pagination1={}", pagination1);
        LOG.debug("pagination2={}", pagination2);
    }

}
