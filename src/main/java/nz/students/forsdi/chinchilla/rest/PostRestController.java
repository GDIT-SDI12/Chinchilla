package nz.students.forsdi.chinchilla.rest;

import nz.students.forsdi.chinchilla.entity.Post;
import nz.students.forsdi.chinchilla.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostRestController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable int postId) {
        return postService.getPost(postId);
    }

    @PostMapping("")
    public Post addPost(@RequestBody Post thePost) {
        //set Id to 0 in order to create new post, not update
        thePost.setId(0);
        postService.savePost(thePost);
        return thePost;
    }

    @PutMapping("")
    public Post updatePost(@RequestBody Post thePost) {
        postService.savePost(thePost);
        return thePost;
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
        return "Deleted post id - " + postId;
    }
}
