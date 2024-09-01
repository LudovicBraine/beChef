package com.salty.bechef.mapper;

import com.salty.bechef.entities.Book;
import com.salty.bechef.entities.Page;
import com.salty.bechef.entities.dto.BookDTO;
import com.salty.bechef.entities.dto.PageDTO;
import com.salty.bechef.entities.dto.PageLightDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel =  "spring", uses = {BookMapper.class, UserMapper.class})
public interface PageMapper {

    @Mapping(target="id", source="page.id")
    @Mapping(target="title", source="page.title")
    @Mapping(target="image", source="page.image")
    @Mapping(target="content", source="page.content")
    @Mapping(target="createdAt", source="page.createdAt")
    @Mapping(target="lastModifiedBy", source="page.lastModifiedBy")
    @Mapping(target="modifyAt", source="page.modifyAt")
    @Mapping(target="display", source="page.display")
    @Mapping(target="user", source="page.user.id")
    @Mapping(target="book", source="page.book.id")
    PageDTO pageToPageDTO(Page page);

    @InheritInverseConfiguration
    Page pageDtoToPage(PageDTO pageDTO);

    List<PageDTO> listPageToListPageDTO(List<Page> pageList);

    List<Page> listPageDTOToListPage(List<PageDTO> pageDTOList);
}
