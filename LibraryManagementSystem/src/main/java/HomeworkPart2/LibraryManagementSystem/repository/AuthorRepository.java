package HomeworkPart2.LibraryManagementSystem.repository;

import HomeworkPart2.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author,Long> {

    //findAuthorByName
    public List<Author> findByNameContainingIgnoreCase(String name);
}
