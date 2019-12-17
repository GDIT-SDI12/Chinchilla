package nz.students.forsdi.chinchilla;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest {
    @Test
    public void testConnection() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            assertTrue(session.isConnected());
        } finally {
            session.close();
            factory.close();
        }
    }
}
