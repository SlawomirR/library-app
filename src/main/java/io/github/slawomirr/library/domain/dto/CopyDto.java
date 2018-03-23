package io.github.slawomirr.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {

    private Long id;
    private Long bookId;
    private String status;
}
