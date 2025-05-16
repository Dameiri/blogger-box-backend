package com.dauphine.blogger_box_backend.controllers;

import com.dauphine.blogger_box_backend.dto.CreationCategoryRequest;
import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.ElementRequest;
import com.dauphine.blogger_box_backend.model.Post;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @PostMapping("/elements")
    public String create(@RequestBody ElementRequest body) {
        // TODO later, implement persistence layer
        // INSERT INTO ... (title, description) VALUES (${title}, ${description});
        return "Create new element with title '%s' and description '%s'"
                .formatted(body.getTitle(), body.getDescription());
    }
    @PutMapping("/elements/{id}")/*pour mettre à jour*/
    public String update(@PathVariable Integer id, @RequestBody ElementRequest body) {
        // TODO later, implement persistence layer
        // UPDATE ... SET title = ${title}, description = ${description} WHERE id = ${id};
        return "Update element '%s' with title '%s' and description '%s'"
                .formatted(id, body.getTitle(), body.getDescription());
    }
    @PatchMapping("/elements/{id}/description")
    public String patch(@PathVariable Integer id, @RequestBody String description) {
        // TODO later, implement persistence layer
        // UPDATE ... SET description = ${description} WHERE id = ${id};
        return "Patch element '%s' with description '%s'".formatted(id, description);
    }
    @DeleteMapping("/elements/{id}")
    public String delete(@PathVariable Integer id) {
        //dELETE ... WHERE id = ${id}
        return "Delete element '%s'".formatted(id);
    }

    private final List<Category> temporaryCategories;

    public CategoryController() {
        this.temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Category(UUID.randomUUID(), "my first category"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "my second category"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "my third category"));
    }

    // GET /v1/categories
    @GetMapping
    public List<Category> retrieveAllCategories() {
        return temporaryCategories;
    }
    // GET /v1/categories/{id}
    @GetMapping("/{id}")
    public Category retrieveCategoryById(@PathVariable UUID id) {
        return temporaryCategories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
// DELETE /v1/categories/{id}
@DeleteMapping("/{id}")
public boolean deleteCategory(@PathVariable UUID id) {
    return temporaryCategories.removeIf(c -> c.getId().equals(id));
}

/*Result
  {
    "id": "fce5a5e8-7bbb-400c-a7eb-9a22f5c77e11",
    "name": "my first category"
  },
  {
    "id": "ea170447-a665-4b1b-a8e4-e085bcc3f75e",
    "name": "my second category"
  },
  {
    "id": "b0af3b2e-935e-4de6-ae06-7b3929e53aa6",
    "name": "my third category"
    */


}
