package com.dauphine.blogger_box_backend.controllers;
import com.dauphine.blogger_box_backend.model.ElementRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    /*expose three endpoint

- GET /hello-world
- GET /hello?name={...}
- GET /hello/{name}

     */
    @GetMapping("HelloWorld")
    public String heloWorld(){
        return "Hello World";
    }
    @GetMapping("Hello")
    public String helloByName(@RequestParam String name){
        return "Hello"+name;
    }
    @GetMapping("Hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello "+name;
    }

/*
    @PostMapping("/elements")
    public String create(@RequestBody ElementRequest body) {
        // TODO later, implement persistence layer
        // INSERT INTO ... (title, description) VALUES (${title}, ${description});
        return "Create new element with title '%s' and description '%s'"
                .formatted(body.getTitle(), body.getDescription());
    }



    @PutMapping("/elements/{id}")/*pour mettre à jour
    public String update(@PathVariable Integer id, @RequestBody ElementRequest body) {
        // TODO later, implement persistence layer
        // UPDATE ... SET title = ${title}, description = ${description} WHERE id = ${id};
        return "Update element '%s' with title '%s' and description '%s'"
                .formatted(id, body.getTitle(), body.getDescription());
    }
    @PatchMapping("/elements/{id}/description")/*PATCH request method is used to make a partial changes in an existing resource
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

 */



}
