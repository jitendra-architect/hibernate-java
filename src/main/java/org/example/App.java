package org.example;

import org.example.entity.Address;
import org.example.entity.Certificate;
import org.example.entity.Student;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Create and save entity
            Student student1 = new Student();
            student1.setName("Varsha");
            student1.setCity("Bangalore");

            Certificate certificate1 = new Certificate();
            certificate1.setCourse("Java");
            certificate1.setDuration("3 Months");
            student1.setCert(certificate1);

            Student student2 = new Student();
            student2.setName("Jitendra");
            student2.setCity("Mumbai");

            Certificate certificate2 = new Certificate();
            certificate2.setCourse("Node");
            certificate2.setDuration("3 Months");

            student2.setCert(certificate2);

//            Address address = new Address();
//            address.setCity("Delhi");
//            address.setStreet("Kinjer");
//            address.setAddedDate(new Date());
//            address.setOpen(true);
//            address.setLat(110.22);

//            Student student1 = session.get(Student.class, 1);
//            System.out.println("Done....");
//            System.out.println(student1.toString());


            session.save(student1);
            session.save(student2);
            //session.save(address);

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Fuck of man");
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
