package HomeworkPart2.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Entity
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    //one author->Manya Books
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Books> books=new HashSet<>();
}
