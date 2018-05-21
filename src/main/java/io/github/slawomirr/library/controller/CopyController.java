package io.github.slawomirr.library.controller;

import io.github.slawomirr.library.domain.EItemStatus;
import io.github.slawomirr.library.domain.dto.CopyDto;
import io.github.slawomirr.library.mapper.CopyMapper;
import io.github.slawomirr.library.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/copy")
@CrossOrigin(origins = "*")
public class CopyController {

    @Autowired
    private CopyService copyService;

    @Autowired
    private CopyMapper copyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
    public List<CopyDto> getBookCopies() {
        return copyMapper.mapToCopyDtoList(copyService.getAllCopies());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public CopyDto getCopy(@RequestParam Long bookCopyId) throws Exception {
        return copyMapper.mapToCopyDto(copyService.getCopyById(bookCopyId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addCopy", consumes = APPLICATION_JSON_VALUE)
    public void addCopy(@RequestBody CopyDto copyDto) {
        copyMapper.mapToCopyDto(copyService.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopy")
    public void updateCopy(@RequestBody CopyDto copyDto) {
        copyMapper.mapToCopyDto(copyService.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopy")
    public void deleteCopy(@RequestParam Long copyId) {
        copyService.deleteCopy(copyId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatus")
    public void updateStatus(@RequestParam Long bookCopyId, @RequestParam EItemStatus EItemStatus) throws Exception {
        copyService.updateLendStatus(bookCopyId, EItemStatus);
    }

    @RequestMapping(method = RequestMethod.GET, value = "countAvailableCopies")
    public Long countAvailableCopies(@RequestParam String title) {
        return copyService.countAvailableCopies(title);
    }
}
