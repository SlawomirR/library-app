package io.github.slawomirr.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEMBERS")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "FIRSTNAME")
    private String firstName;

    @NotNull
    @Column(name = "LASTNAME")
    private String lastName;

    @NotNull
    @Column(name = "MEMBER_SINCE")
    private LocalDate memberSince;

    @OneToMany(
            targetEntity = Lending.class,
            mappedBy = "memberId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Lending> lendings = new ArrayList<>();

    public Member(String firstName, String lastName, LocalDate memberSince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberSince = memberSince;
    }

    public Member(Long id, String firstName, String lastName, LocalDate memberSince) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberSince = memberSince;
    }
}
