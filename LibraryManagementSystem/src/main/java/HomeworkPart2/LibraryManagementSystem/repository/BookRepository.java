package HomeworkPart2.LibraryManagementSystem.repository;

import HomeworkPart2.LibraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitleContainingIgnoreCase(String name);

    List<Book> findByPublishDateAfter(LocalDateTime date);

    List<Book> findByAuthorId(Long authorId);
}
