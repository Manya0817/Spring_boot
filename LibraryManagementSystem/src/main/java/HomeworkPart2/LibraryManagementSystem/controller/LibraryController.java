package HomeworkPart2.LibraryManagementSystem.controller;

import HomeworkPart2.LibraryManagementSystem.entity.Author;
import HomeworkPart2.LibraryManagementSystem.entity.Book;
import HomeworkPart2.LibraryManagementSystem.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author){
        return libraryService.createAuthor(author);
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book,@RequestParam Long author_id){
        return libraryService.createBook(book,author_id);
    }

    @GetMapping("/books")
    List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @GetMapping("/authors")
    List<Author> getAllAuthors(){
        return libraryService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@RequestParam Long id){
        return libraryService.getAuthorById(id);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@RequestParam Long id){
        return libraryService.getBookById(id);
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@RequestParam Long id,@RequestBody Author updated){
        return libraryService.updateAuthor(id,updated);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(Long id,Book updated){
       return libraryService.updateBook(id,updated);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(Long id){
        libraryService.deleteAuthor(id);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(Long id){
        libraryService.deleteBook(id);
    }

    @GetMapping("/books/title")
    public List<Book> findBooksByTitle(String title){
        return libraryService.findBooksByTitle(title);
    }

    @GetMapping("/books/date")
    public List<Book> findAfterDate(LocalDateTime date){
        return libraryService.findAfterDate(date);
    }

    @GetMapping("/authors/name")
    public List<Author> findAuthorByName(String name){
        return libraryService.findAuthorByName(name);
    }

    @GetMapping("/books/author")
    public List<Book> findBooksbyAuthor(Long id){
        return libraryService.findBooksbyAuthor(id);
    }
}
