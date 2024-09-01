package com.salty.bechef.controller;

import com.salty.bechef.entities.Page;
import com.salty.bechef.entities.dto.PageDTO;
import com.salty.bechef.mapper.PageMapper;
import com.salty.bechef.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/page")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;
    private final PageMapper pageMapper;

    /*
    @GetMapping("/{id}/pages")
    public ResponseEntity<List<PageDTO>> findAllPageByBookId(@PathVariable Long id) {
        List<Page> pages = this.pageService.getPagesByBookId(id);
        List<PageDTO> pageDTOS = this.pageMapper.listPageToListPageDTO(pages);
        return new ResponseEntity<>(pageDTOS, HttpStatus.OK);
    }

    @GetMapping("/{bookId}/page/{pageId}")
    public ResponseEntity<PageDTO>findPageById(@PathVariable Long bookId, @PathVariable Long pageId) {
        Page page = this.pageService.getPageByBookId(bookId, pageId);
        PageDTO pageDTO = this.pageMapper.pageToPageDTO(page);
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<PageDTO> addPage(@PathVariable Long bookId, @RequestBody PageDTO page) {
        Page pageSaved = this.pageService.addPage(bookId ,page);
        PageDTO pageDTO = this.pageMapper.pageToPageDTO(pageSaved);
        //        PageLightDTO pageLightDTO = this.pageMapper.pageToPageLightDTO(pageSaved);
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleById(@PathVariable("id") Long id){
        this.pageService.deletePage(id);
        return ResponseEntity.ok().build();
    } */
}
