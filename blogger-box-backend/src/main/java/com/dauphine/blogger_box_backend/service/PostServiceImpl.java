package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;
import com.dauphine.blogger_box_backend.repository.PostRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    /*
    private final List<Category> temporaryCategories;
    private final List<Post> temporaryPosts;*/
    private final CategoryService categoryService;
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository, CategoryService categoryService) {
        this.postRepository = postRepository;
        this.categoryService = categoryService;
        /*
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
            ));*/

    }


    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        /*
        List<Post> filteredPosts = new ArrayList<>();
        for (Post post : temporaryPosts) {
            if (post.getCategory() != null && post.getCategory().getId().equals(categoryId)) {
                filteredPosts.add(post);
            }
        }

        return filteredPosts;*/
        return this.postRepository.findAllByCategory_Id(categoryId);
    }

    @Override
    public List<Post> getAll() {
        //les ordonner
        return this.postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }

    @Override
    public Post getById(UUID id) {
        /*
        return temporaryPosts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);

         */
        return this.postRepository.findById(id).orElse(null);
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
    if(post == null) {
        return null;}
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return this.postRepository.save(post);

    }





    @Override
    public void deleteById(UUID id) {
          this.postRepository.deleteById(id);

    }



    @Override
    public Post create(String title, String content,UUID categoryId) {
        Post post = new Post(UUID.randomUUID(), title, content, LocalDateTime.now(),categoryService.getById(categoryId));

        return this.postRepository.save(post);
    }
}
