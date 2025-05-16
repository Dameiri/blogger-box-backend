package com.dauphine.blogger_box_backend.controllers;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;
import com.dauphine.blogger_box_backend.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "Posts")
@RestController
@RequestMapping("/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @ApiOperation(value = "Create a new post", notes = "This endpoint creates a new post with the specified title and description.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Post created successfully"),
            @ApiResponse(code = 400, message = "Bad request")
    })

    @PostMapping("/")
    public Post createPost(@RequestParam String title,
                           @RequestParam String content,
                           @RequestParam UUID categoryId) {
        return postService.create(title, content, categoryId);
    }
    // POST /v1/posts


    @ApiOperation(value = "Update an existing post", notes = "This endpoint updates the post with the given ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Post updated successfully"),
            @ApiResponse(code = 404, message = "Post not found")
    })
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id,
               @RequestParam String title,
               @RequestParam String content){
        //mettre à jour le post dans la liste ou base de données
       return  postService.update(id, title, content);
    }

    @ApiOperation(value = "Update description of a post", notes = "This endpoint updates only the description of the post with the given ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Description updated successfully"),
            @ApiResponse(code = 404, message = "Post not found")
    })
    /*
    @PatchMapping("/{id}/description")
    public String patch(@PathVariable UUID id, @RequestBody String description) {
        // Mettre à jour la description du post
        Post patchedPost = postService.patchDescription(id, description);
        if (patchedPost != null) {
            return "Updated description of post '%s' with new description '%s'".formatted(id, patchedPost.getContent());
        } else {
            return "Post with ID '%s' not found".formatted(id);
        }
    }

    @ApiOperation(value = "Delete a post", notes = "This endpoint deletes the post with the given ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Post deleted successfully"),
            @ApiResponse(code = 404, message = "Post not found")
    })*/
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        // Implémentation de la persistance (supprimer le post de la liste ou base de données)
        postService.deleteById(id);
    }
    /*simulation avant de se connecter a la base de donnees*/

    @GetMapping
    public List<Post> getAllCategories() {
        return this.postService.getAll();
    }


    @GetMapping("{id}")
    public Post getCategoryById(@PathVariable UUID id) {
        return this.postService.getById(id);
    }

}


