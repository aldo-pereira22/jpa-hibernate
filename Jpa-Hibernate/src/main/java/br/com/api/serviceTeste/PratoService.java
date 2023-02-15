package br.com.api.serviceTeste;

import br.com.api.entity.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato prato = new Prato();
        prato.setNome("Risoto de frutos do mar");
        prato.setDescricao("Risoto com diversos  frutos do mar");
        prato.setDisponivel(true);
        prato.setValor(BigDecimal.valueOf(88.50));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Teste");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(prato);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
