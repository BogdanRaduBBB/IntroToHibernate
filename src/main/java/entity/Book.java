package entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "book")
@Table(name = "CARTI")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "autor")
    private String author;

    public Book(String author) {
        this.author = author;
    }
}
