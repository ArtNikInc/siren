package main.api;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import main.dto.PostDto;
import main.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    @GetMapping("/")
    public List<PostDto> getAllPosts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PostDto getPost(@NonNull @PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public PostDto savePost(@NonNull @RequestBody PostDto postDto) {
        return service.save(postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@NonNull @PathVariable UUID id) {
        service.delete(id);
    }

}
