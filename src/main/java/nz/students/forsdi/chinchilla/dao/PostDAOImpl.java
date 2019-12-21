package nz.students.forsdi.chinchilla.dao;

import nz.students.forsdi.chinchilla.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PostDAOImpl implements PostDAO {
    //inject Hibernate's Session Factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Post> getPosts() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Post", Post.class);
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public void savePost(Post thePost) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(thePost);
    }

    @Override
    public Post getPost(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Post.class, id);
    }

    @Override
    public void deletePost(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery =
                currentSession.createQuery("delete from Post where id=:postId");
        theQuery.setParameter("postId", id);
        theQuery.executeUpdate();
    }
}
