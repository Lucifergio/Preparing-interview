package homework5.serviceDao;

import homework5.entity.Student;
import homework5.config.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    public Student findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    public void save(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }

    public List<Student> findAll() {
        List<Student> students = (List<Student>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }
}
