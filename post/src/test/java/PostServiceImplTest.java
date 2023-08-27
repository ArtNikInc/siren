import main.dao.entity.Post;
import main.dao.repository.PostRepository;
import main.dto.PostDto;
import main.exception.EntityNotFoundException;
import main.service.PostService;
import main.service.impl.PostServiceImpl;
import main.service.mapper.PostMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    private static final PostMapper MAPPER = Mappers.getMapper(PostMapper.class);
    private static final Post POST = Post.builder()
            .id(UUID.randomUUID())
            .body("text")
            .title("title")
            .subTitle("subTitle")
            .createdAt(new Date())
            .publishedAt(new Date())
            .build();

    @Mock
    private PostRepository repository;

    @Captor
    private ArgumentCaptor<Post> postArgumentCaptor;

    private PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl(repository, MAPPER);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(POST);
        postService.save(MAPPER.toDto(POST));
        verify(repository).save(postArgumentCaptor.capture());
        Assertions.assertEquals(POST.getTitle(), postArgumentCaptor.getValue().getTitle());
        Assertions.assertEquals(POST.getBody(), postArgumentCaptor.getValue().getBody());
    }

    @Test
    void getById() {
        when(repository.findById(POST.getId())).thenReturn(Optional.of(POST));
        checkPost(postService.getById(POST.getId()), POST);
    }

    @Test
    void getById_ThrowException() {
        when(repository.findById(POST.getId())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> postService.getById(POST.getId()));
    }

    @Test
    void getAll() {
        postService.getAll();
        verify(repository).findAll();
    }

    @Test
    void delete() {
        postService.delete(POST.getId());
        verify(repository).deleteById(POST.getId());
    }

    @Test
    void update() {
        when(repository.save(any())).thenReturn(POST);
        postService.update(POST.getId(), MAPPER.toDto(POST));
        verify(repository).save(postArgumentCaptor.capture());
        Assertions.assertEquals(POST.getId(), postArgumentCaptor.getValue().getId());
    }

    private void checkPost(PostDto postDto, Post post) {
        Assertions.assertEquals(postDto.getId(), post.getId());
        Assertions.assertEquals(postDto.getSubTitle(), post.getSubTitle());
        Assertions.assertEquals(postDto.getBody(), post.getBody());
        Assertions.assertEquals(postDto.getTitle(), post.getTitle());
    }

}
