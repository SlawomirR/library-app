package io.github.slawomirr.library.controller;

import io.github.slawomirr.library.domain.dto.LendingDto;
import io.github.slawomirr.library.mapper.LendingMapper;
import io.github.slawomirr.library.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/lend")
@CrossOrigin(origins = "*")
public class LendingController {

    @Autowired
    private LendingService lendingService;

    @Autowired
    private LendingMapper lendingMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getLendBooks")
    public List<LendingDto> getLendBooks() {
        return lendingMapper.mapToLendingDtoList(lendingService.getAllLend());
    }

    @RequestMapping(method = RequestMethod.POST, value = "lendBook", consumes = APPLICATION_JSON_VALUE)
    public void lendBook(@RequestBody LendingDto lendingDto) {
        lendingMapper.mapToLendingDto(lendingService.saveLend(lendingMapper.mapToLending(lendingDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public void returnBook(@RequestParam Long lendBookId) {
        lendingService.returnBook(lendBookId);
    }
}
