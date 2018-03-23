package io.github.slawomirr.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private long id;
    private String firstName;
    private String lastName;
    private Date memberSince;
}
