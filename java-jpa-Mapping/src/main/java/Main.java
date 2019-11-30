import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TR = EM.getTransaction();
        TR.begin();

        try {
            TR.commit();
        }catch(Exception e){
            TR.rollback();
        }finally{
            EM.close();
        }
        EMF.close();

    }
}
