package com.ziofront.challenge.client;

import com.ziofront.challenge.client.vo.Book;
import com.ziofront.challenge.client.vo.BookResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface BookClient {
    @RequestLine("GET /{isbn}")
    public BookResource findByIsbn(@Param("isbn") String isbn);

    @RequestLine("GET")
    public List<BookResource> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    public void create(Book book);
}