package br.com.api.serviceTeste;

import br.com.api.dao.CardapioDao;
import br.com.api.dao.CategoriaDao;
import br.com.api.entity.Cardapio;
import br.com.api.entity.Categoria;
import br.com.api.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        cadastrarCardapio(entityManager,cadastrarCategoria(entityManager));
    }

    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager );
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);

        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void cadastrarCardapio(EntityManager entityManager, Categoria categoria){
        Cardapio cardapio = new Cardapio();
        cardapio.setNome("Risoto de frutos do mar");
        cardapio.setDescricao("Risoto com diversos  frutos do mar");
        cardapio.setDisponivel(true);
        cardapio.setCategoria(categoria);
        cardapio.setValor(BigDecimal.valueOf(88.50));

        Cardapio cardapio1 = new Cardapio();
        cardapio1.setNome("Salmão ao molho");
        cardapio1.setDescricao("Salmão grelhado ao molho de maracujá");
        cardapio1.setDisponivel(true);
        cardapio1.setCategoria(categoria);
        cardapio1.setValor(BigDecimal.valueOf(39.00));

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(cardapio);
        entityManager.flush();
        cardapioDao.cadastrar(cardapio1);
        entityManager.flush();

//        System.out.println("\n\nPrato do dia consultado foi: "+ cardapioDao.consultarPorId(2));
        System.out.println("\n");
        cardapioDao.consultarTodos().forEach(elemento -> System.out.println("O prato consultado foi: " +elemento +"\n"));

        entityManager.close();
    }
}
