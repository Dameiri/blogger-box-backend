package com.dauphine.blogger_box_backend.controllers;

import com.dauphine.blogger_box_backend.model.Post;
import com.dauphine.blogger_box_backend.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "Posts")
@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value = "Get all posts", notes = "Returns all posts ordered by creation date descending.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of posts returned")
    })
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @ApiOperation(value = "Search posts", notes = "Search posts by title or content containing the given value (case-insensitive).")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Filtered list of posts returned")
    })
    @GetMapping(params = "value")
    public List<Post> searchPostsByValue(
            @Parameter(description = "Search term", example = "adoption")
            @RequestParam("value") String value
    ) {
        return postService.searchByValue(value);
    }

    @ApiOperation(value = "Get post by ID", notes = "Returns the post with the given UUID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Post found"),
            @ApiResponse(code = 404, message = "Post not found")
    })
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable UUID id) {
        return postService.getById(id);
    }

    @ApiOperation(value = "Create a new post", notes = "Creates a post with title, content and categoryId")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Post created successfully"),
            @ApiResponse(code = 400, message = "Invalid input")
    })
    @PostMapping
    public Post createPost(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam UUID categoryId
    ) {
        return postService.create(title, content, categoryId);
    }

    @ApiOperation(value = "Update an existing post", notes = "Updates title and content of the post with the given ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Post updated successfully"),
            @ApiResponse(code = 404, message = "Post not found")
    })
    @PutMapping("/{id}")
    public Post updatePost(
            @PathVariable UUID id,
            @RequestParam String title,
            @RequestParam String content
    ) {
        return postService.update(id, title, content);
    }

    @ApiOperation(value = "Delete a post", notes = "Deletes the post with the given ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Post deleted successfully"),
            @ApiResponse(code = 404, message = "Post not found")
    })
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable UUID id) {
        postService.deleteById(id);
    }
}