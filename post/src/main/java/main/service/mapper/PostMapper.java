package main.service.mapper;

import main.dao.entity.Post;
import main.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {

    PostDto toDto(Post post);
}
