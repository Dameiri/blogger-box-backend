package com.dauphine.blogger_box_backend.controllers;
import com.dauphine.blogger_box_backend.model.ElementRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(
        name = "Hello world API",
        description = "My first hello world endpoints"
)
public class HelloWorldController {

    /*expose three endpoint
- GET /hello-world
- GET /hello?name={...}
- GET /hello/{name}

     */
    @GetMapping("HelloWorld")
    @Operation(
            summary = "Hello for everyone"
    )
    public String heloWorld(){
        return "Hello World";
    }
    @GetMapping("Hello")
    @Operation(
            summary = "Just a hello "
    )
    public String helloByName(@RequestParam String name){
        return "Hello"+name;
    }
    @GetMapping("Hello/{name}")
    @Operation(
            summary = "Hello by name endpoint",
            description = "Returns 'Hello {name}' by path variable"
    )
    public String hello(
            @Parameter(description = "Name to greet")
            @PathVariable String name
    ) {
        return "Hello " + name;
    }

    @PostMapping("/elements")
    public String create(@RequestBody ElementRequest body) {
        // INSERT INTO ... (title, description) VALUES (${title}, ${description});
        return "Create new element with title '%s' and description '%s'"
                .formatted(body.getTitle(), body.getDescription());
    }



    @PutMapping("/elements/{id}")/*pour mettre à jour*/
    public String update(@PathVariable Integer id, @RequestBody ElementRequest body) {
        // UPDATE ... SET title = ${title}, description = ${description} WHERE id = ${id};
        return "Update element '%s' with title '%s' and description '%s'"
                .formatted(id, body.getTitle(), body.getDescription());
    }
    @PatchMapping("/elements/{id}/description")/*PATCH request method is used to make a partial changes in an existing resource*/
    public String patch(@PathVariable Integer id, @RequestBody String description) {
        // UPDATE ... SET description = ${description} WHERE id = ${id};
        return "Patch element '%s' with description '%s'".formatted(id, description);
    }
    @DeleteMapping("/elements/{id}")
    public String delete(@PathVariable Integer id) {
        //dELETE ... WHERE id = ${id}
        return "Delete element '%s'".formatted(id);
    }





}
