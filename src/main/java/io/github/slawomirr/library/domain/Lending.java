package io.github.slawomirr.library.domain;

import io.github.slawomirr.library.utils.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LENDINGS")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "COPY_ID")
    private Copy copy;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private LibraryMember libraryMember;

    @NotNull
    @Column(name = "LENDING_DATE")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate lendingDate;

    @Column(name = "RETURN_DATE")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate returnDate;

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Lending(Copy copy, LibraryMember libraryMember, LocalDate lendingDate) {
        this.copy = copy;
        this.libraryMember = libraryMember;
        this.lendingDate = lendingDate;
    }
}
