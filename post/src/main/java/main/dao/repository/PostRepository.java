package main.dao.repository;

import lombok.NonNull;
import main.dao.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    Optional<Post> findById(@NonNull UUID id);

    List<Post> findAll();
}
