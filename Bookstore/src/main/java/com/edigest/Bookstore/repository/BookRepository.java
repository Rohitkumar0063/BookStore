package com.edigest.Bookstore.repository;

import com.edigest.Bookstore.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    // You can define custom queries here later if needed
}
