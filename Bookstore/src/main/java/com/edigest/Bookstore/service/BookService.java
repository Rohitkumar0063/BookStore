package com.edigest.Bookstore.service;


import com.edigest.Bookstore.DTO.DTO;
import com.edigest.Bookstore.entity.Book;
import com.edigest.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    final private Map<String, Book> books= new HashMap<>();
    //1.Gte All Books
    public List<Book> getAllBooks(){
        return new ArrayList<>(books.values());
    }

    public Book addBookFromDTO( DTO dto){
        Book book = new Book();
        //DTO dto=new DTO();
        //dto.setPrice( price);
        //dto.setBookName(bookName);
        //dto.setAuthor(author);
        book.setBookAuthor(dto.getAuthor());
        book.setBookName(dto.getBookName());
        book.setGenre(dto.getGenre());
        book.setPrice(dto.getPrice());
        book.setId(dto.getId());
        String id = dto.getId();
        books.put(id, book);
        System.out.println("YOur Book has been uploaded:");
        return  bookRepository.save(book);
    }



    public List<Book> searchForType( String genre){
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter genre to browse: ");
        //String browseBook=sc.nextLine();
        //return new ArrayList<>()
        List<Book> filteredBooks= new ArrayList<>();

        for (Book book:books.values())
            if (book.getGenre().toLowerCase().contains(genre)){
                filteredBooks.add(book);
            }
        return filteredBooks;
    }


    public Book getByBookId(String id){
        return books.get(id);
    }

}
