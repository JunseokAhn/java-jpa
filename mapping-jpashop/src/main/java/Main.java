import domain.Order;
import domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();
        ET.begin();

        try {
            Order order = new Order();
            order.addOrderItem((new OrderItem()));



            ET.commit();
        } catch (Exception e) {
            e.printStackTrace();
            ET.rollback();
        } finally {
            EM.close();
        }
        EMF.close();

    }
}
