package com.dauphine.blogger_box_backend.repository;

import com.dauphine.blogger_box_backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByCategory_Id(UUID categoryId);
}
