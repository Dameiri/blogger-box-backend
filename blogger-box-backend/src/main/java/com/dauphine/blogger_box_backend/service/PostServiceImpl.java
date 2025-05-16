package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final List<Category> temporaryCategories;
    private final List<Post> temporaryPosts;
    private final CategoryService categoryService;


    public PostServiceImpl(CategoryService categoryService) {
            this.temporaryPosts = new ArrayList<>();
        this.temporaryCategories = new ArrayList<>();
            this.temporaryPosts.add(new Post(
                    UUID.randomUUID(),
                    "First Post",
                    "Content of First Post",
                    LocalDate.now() ,
                    new Category(UUID.randomUUID(),"category premium")
            ));

            this.temporaryPosts.add(new Post(
                    UUID.randomUUID(),
                    "Second Post",
                    "Content of Second Post",
                    LocalDate.now() ,
                    new Category(UUID.randomUUID(),"category premium")
            ));

            this.temporaryPosts.add(new Post(
                    UUID.randomUUID(),
                    "Third Post",
                    "Content of Third Post",
                    LocalDate.now() ,
                    new Category(UUID.randomUUID(),"category premium")
            ));
        this.categoryService = categoryService;
    }


    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        List<Post> filteredPosts = new ArrayList<>();
        for (Post post : temporaryPosts) {
            if (post.getCategory() != null && post.getCategory().getId().equals(categoryId)) {
                filteredPosts.add(post);
            }
        }
        return filteredPosts;
    }

    @Override
    public List<Post> getAll() {
        return temporaryPosts;
    }

    @Override
    public Post getById(UUID id) {
        return temporaryPosts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
/*
    @Override
    public Post create(String title, String content, UUID categoryId) {
        // --------- C’est ici que tu tapes temporaryCategories. pour accéder à la liste ---------
        Category category = temporaryCategories.stream()
                .filter(c -> c.getId().equals(categoryId))
                .findFirst()
                .orElse(null);

        Post post = new Post(
                UUID.randomUUID(),
                title,
                content,
                LocalDate.now(),
                category
        );
        temporaryPosts.add(post);
        return post;
    }
*/


@Override
    public Post update(UUID id, String title, String content){
        Post post = this.getById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }

    @Override
    public boolean deleteById(UUID id) {
        return temporaryPosts.removeIf(post -> post.getId().equals(id));
    }



    @Override
    public Post patchDescription(UUID id, String description) {
        return  null;
    }
    @Override
    public Post create(String title, String content,UUID categoryId) {
        Post post = new Post(UUID.randomUUID(), title, content, LocalDate.now(),categoryService.getById(categoryId));
        this.temporaryPosts.add(post);
        return post;
    }
}
