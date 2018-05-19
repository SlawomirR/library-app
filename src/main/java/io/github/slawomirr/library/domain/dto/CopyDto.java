package io.github.slawomirr.library.domain.dto;

import io.github.slawomirr.library.domain.EItemStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {

    private Long id;
    private Long bookId;
    @Setter
    private EItemStatus eItemStatus;
}
