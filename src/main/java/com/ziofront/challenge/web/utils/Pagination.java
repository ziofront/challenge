package com.ziofront.challenge.web.utils;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ToString
@Getter(AccessLevel.PUBLIC)
public class Pagination {

    private static Logger LOG = LoggerFactory.getLogger(Pagination.class);

    private int paginationSize, currentPage, totalCount, pageSize;

    private int totalPage, totalPagination, currentPagination, beginPageNo, endPageNo, prevPageNo, nextPageNo;

    private boolean isPrev , isNext = false;

    @Builder
    public Pagination(int paginationSize, int currentPage, int totalCount, int pageSize) {
        this.paginationSize = paginationSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;

        init();
    }

    private void init() {
        totalPage = totalCount / pageSize;
        totalPage = (totalCount % pageSize > 0) ? totalPage + 1 : totalPage;

        totalPagination = totalPage / paginationSize;
        totalPagination = (totalPage % paginationSize > 0) ? totalPagination + 1 : totalPagination;

        currentPagination = (pageSize * currentPage) / (paginationSize * pageSize);

        if (((pageSize * currentPage) % (paginationSize * pageSize)) > 0) {
            currentPagination += 1;
        }

        endPageNo = currentPagination * paginationSize;

        beginPageNo = endPageNo - paginationSize + 1;

        if (endPageNo > totalPage) {
            endPageNo = totalPage;
        }

        if(endPageNo < totalPage) {
            isNext = true;
            nextPageNo = endPageNo + 1;
        }

        if(beginPageNo > paginationSize) {
            isPrev = true;
            prevPageNo = beginPageNo - 1;
        }

        LOG.info("this={}", this);
    }
}
