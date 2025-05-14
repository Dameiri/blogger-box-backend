package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;
import com.dauphine.blogger_box_backend.service.CategoryService;
import com.dauphine.blogger_box_backend.service.PostService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> temporaryPosts;
    private final CategoryService categoryService; // Pour vérifier si la catégorie existe

    public PostServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.temporaryPosts = new ArrayList<>();
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

    @Override
    public Post create(String title, String content) {
     /*   Category category = categoryService.getById(categoryId);

        if (category == null) {
            return null;
        }

        Post post = new Post();
        post.setId(UUID.randomUUID());
        post.setTitle(title);
        post.setContent(content);
        post.setDate(new Timestamp(System.currentTimeMillis()));
        post.setCategory(category);

        temporaryPosts.add(post);

      */
        return null;
    }




    public Post update(UUID id, String title, String content) {
        // Chercher le post dans la liste en mémoire
        Post post = temporaryPosts.stream()
                .filter(p -> p.getId().equals(id))  // Chercher le post avec le bon ID
                .findFirst()  // Prendre le premier post trouvé
                .orElse(null);  // Si aucun post n'est trouvé, retourner null

        if (post != null) {
            // Si le post existe, mettre à jour le titre et le contenu
            post.setTitle(title);
            post.setContent(content);
            return post;  // Retourner le post mis à jour
        }
        // Si le post n'existe pas, retourner null
        return null;
    }

    @Override
    public boolean deleteById(UUID id) {
        return temporaryPosts.removeIf(post -> post.getId().equals(id));
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public Post patchDescription(UUID id, String description) {
        return  null;
    }
}
