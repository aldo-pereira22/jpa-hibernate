package br.com.api.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("Teste");
    public static EntityManager getEntityManager(){
        return entityManager.createEntityManager();
    }
}
