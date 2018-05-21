package io.github.slawomirr.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COPIES")
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @NotNull
    @Column(name = "STATUS")
    private EItemStatus eItemStatus;

    @OneToMany(
            targetEntity = Lending.class,
            mappedBy = "copy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Lending> lendings = new ArrayList<>();

    public Copy(EItemStatus eItemStatus) {
        this.eItemStatus = eItemStatus;
    }

    public Copy(Book book, EItemStatus eItemStatus) {
        this.book = book;
        this.eItemStatus = eItemStatus;
    }

    public Copy(Long id, Book book, EItemStatus eItemStatus) {
        this.id = id;
        this.book = book;
        this.eItemStatus = eItemStatus;
    }
}
