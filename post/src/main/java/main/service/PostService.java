package main.service;

import main.dto.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {

    PostDto save(PostDto postDto);

    PostDto getById(UUID id);

    List<PostDto> getAll();

    void delete(UUID id);

    PostDto update(UUID id, PostDto postDto);

}
