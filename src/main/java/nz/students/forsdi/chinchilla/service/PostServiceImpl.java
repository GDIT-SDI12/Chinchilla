package nz.students.forsdi.chinchilla.service;

import nz.students.forsdi.chinchilla.dao.PostDAO;
import nz.students.forsdi.chinchilla.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDAO postDAO;

    @Override
    public List<Post> getPosts() {
        return postDAO.getPosts();
    }

    @Override
    public void savePost(Post thePost) {
        postDAO.savePost(thePost);
    }

    @Override
    public Post getPost(int id) {
        return postDAO.getPost(id);
    }

    @Override
    public void deletePost(int id) {
        postDAO.deletePost(id);
    }
}
