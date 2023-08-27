package main.service.impl;

import lombok.RequiredArgsConstructor;
import main.dao.entity.Post;
import main.dao.repository.PostRepository;
import main.dto.PostDto;
import main.exception.EntityNotFoundException;
import main.service.PostService;
import main.service.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final PostMapper mapper;

    @Override
    public PostDto save(PostDto postDto) {
        Date date = new Date();
        Post post = Post.builder()
                .body(postDto.getBody())
                .title(postDto.getTitle())
                .subTitle(postDto.getSubTitle())
                .createdAt(date)
                .publishedAt(date)
                .build();
        return mapper.toDto(repository.save(post));
    }

    @Override
    public PostDto getById(UUID id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Post.class, id)));
    }

    @Override
    public List<PostDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public PostDto update(UUID id, PostDto postDto) {
        Post post = Post.builder()
                .id(id)
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .subTitle(postDto.getSubTitle())
                .createdAt(postDto.getCreatedAt())
                .publishedAt(postDto.getPublishedAt())
                .build();
        return mapper.toDto(repository.save(post));
    }

}
