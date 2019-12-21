package nz.students.forsdi.chinchilla.rest;

import nz.students.forsdi.chinchilla.entity.Post;
import nz.students.forsdi.chinchilla.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostRestController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getUsers() {
        return postService.getPosts();
    }
}
