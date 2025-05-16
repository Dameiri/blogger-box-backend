package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    //récupérer tous les posts d'une catégorie
    List<Post> getAllByCategoryId(UUID categoryId);

    //récupérer tous les posts
    List<Post> getAll();

    //récupérer un post par son ID
    Post getById(UUID id);

    //créer un nouveau post
    Post create(String title, String content, UUID categoryId);

    //mettre à jour un post
    Post update(UUID id, String title, String content);

    //supprimer un post par son ID
    boolean deleteById(UUID id);

    Post patchDescription(UUID id, String description);
}
