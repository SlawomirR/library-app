package io.github.slawomirr.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LendingDto {

    private Long id;
    private Long copyId;
    private Long memberId;
    private LocalDate lendDate;
    private LocalDate returnDate;
}
