package nz.students.forsdi.chinchilla.service;

import nz.students.forsdi.chinchilla.entity.Post;

import java.util.List;

public interface PostService {
    public List<Post> getPosts();

    public void savePost(Post thePost);

    public Post getPost(int id);

    public void deletePost(int id);
}
