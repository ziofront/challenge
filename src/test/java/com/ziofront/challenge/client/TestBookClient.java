package com.ziofront.challenge.client;

import com.ziofront.challenge.client.BookClient;
import com.ziofront.challenge.client.vo.Book;
import com.ziofront.challenge.client.vo.BookResource;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class TestBookClient {

    private BookClient bookClient;

    @Before
    public void init() {
        bookClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BookClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BookClient.class, "http://localhost:8080/test.json");

    }

    @Test
    public void givenBookClient_shouldRunSuccessfully() throws Exception {
        List<Book> books = bookClient.findAll().stream()
                .map(BookResource::getBook)
                .collect(Collectors.toList());

        assertTrue(books.size() >= 2);
    }


//    @Test
//    public void givenBookClient_shouldFindOneBook() throws Exception {
//        Book book = bookClient.findByIsbn("0451524934").getBook();
//        assertThat(book.getAuthor(), containsString("Orwell"));
//    }
//
//    @Test
//    public void givenBookClient_shouldPostBook() throws Exception {
//        String isbn = UUID.randomUUID().toString();
//        Book book = new Book(isbn, "Me", "It's me!", null, null);
//        bookClient.create(book);
//        book = bookClient.findByIsbn(isbn).getBook();
//
//        assertThat(book.getAuthor(), is("Me"));
//    }
}
