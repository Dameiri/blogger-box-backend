package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll(); // Récupérer toutes les catégories
    Category getById(UUID id); // Récupérer une catégorie par ID
    Category create(String name); // Créer une nouvelle catégorie
    Category updateName(UUID id, String name); // Mettre à jour le nom d'une catégorie
    boolean deleteById(UUID id); // Supprimer une catégorie par ID


}
