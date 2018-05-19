package io.github.slawomirr.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LENDINGS")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COPY_ID")
    private Copy copy;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member memberId;

    @NotNull
    @Column(name = "LEND_DATE")
    private LocalDate lendDate;

    @NotNull
    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    public Lending(Copy copy, Member memberId, LocalDate lendDate, LocalDate returnDate) {
        this.copy = copy;
        this.memberId = memberId;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
    }
}
