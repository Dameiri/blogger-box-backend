package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final List<Category> temporaryCategories = new ArrayList<>();

    // Initialiser des catégories fictives
    public CategoryServiceImpl() {
        temporaryCategories.add(new Category(UUID.randomUUID(), "My first category"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "My second category"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "My third category"));
    }

    @Override
    public List<Category> getAll() {
        // Retourner toutes les catégories
        return temporaryCategories;
    }

    @Override
    public Category getById(UUID id) {
        // Chercher une catégorie par son ID
        return temporaryCategories.stream()
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .orElse(null); // Retourne null si la catégorie n'est pas trouvée
    }

    @Override
    public Category create(String name) {
        // Créer une nouvelle catégorie
        Category category = new Category(UUID.randomUUID(), name);
        temporaryCategories.add(category);
        return category;
    }


    @Override
    public Category updateName(UUID id, String newName) {
        // Recherche la catégorie dans la liste en filtrant par ID
        Category category = temporaryCategories.stream()
                .filter(c -> id.equals(c.getId())) // Vérifie si l'ID correspond
                .findFirst() // Récupère la première catégorie qui correspond
                .orElse(null); // Si aucune catégorie n'est trouvée, renvoie null

        // Si la catégorie existe, on met à jour son nom
        if (category != null) {
            category.setName(newName);
        }

        return category; // Retourne la catégorie mise à jour (ou null si non trouvée)
    }

    @Override
    public boolean deleteById(UUID id) {
        //supprimer une catégorie par son ID
        Category category = getById(id);
        if (category != null) {
            temporaryCategories.remove(category);
            return true;
        }
        return false; // Retourne false si la catégorie n'existe pas
    }
}
