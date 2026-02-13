package HomeworkPart2.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate publishDate;

    private Double price;

    //Many Books->one author;
    @ManyToOne
    @JoinColumn(name="author_id")
    @ToString.Exclude
    private Author author;
}
