package io.github.slawomirr.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LendingDto {

    private Long id;
    private CopyDto copyDtoOut;
    private MemberDto memberDto;
    private Date lendingDate;
    private Date returnDate;
}
