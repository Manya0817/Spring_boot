package HomeworkPart2.LibraryManagementSystem.service;

import HomeworkPart2.LibraryManagementSystem.entity.Author;
import HomeworkPart2.LibraryManagementSystem.entity.Book;
import HomeworkPart2.LibraryManagementSystem.repository.AuthorRepository;
import HomeworkPart2.LibraryManagementSystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LibraryService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    //Creation

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Book createBook(Book book,Long author_id){
        Author author=authorRepository.findById(author_id).orElseThrow();
        book.setAuthor(author);
        authorRepository.save(author);
        return book;
    }

    //Get

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long author_id){
        Author author=authorRepository.findById(author_id).orElseThrow();
        return author;
    }

    public Book getBookById(Long id){
        Book book=bookRepository.findById(id).orElseThrow();
        return book;
    }

    public Author updateAuthor(Long id,Author updated){
        Author author=authorRepository.findById(id).orElseThrow();
        author.setName(updated.getName());
        author.setEmail(updated.getEmail());
        authorRepository.save(author);
        return author;
    }

    public Book updateBook(Long id,Book updated){
        Book book=getBookById(id);
        book.setTitle(updated.getTitle());
        book.setPrice(updated.getPrice());
        book.setPublishDate(updated.getPublishDate());
        bookRepository.save(book);
        return book;
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> findBooksByTitle(String title){
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findAfterDate(LocalDateTime date){
        return bookRepository.findByPublishDateAfter(date);
    }

    public List<Author> findAuthorByName(String name){
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Book> findBooksbyAuthor(Long id){
        return bookRepository.findByAuthorId(id);
    }
}
