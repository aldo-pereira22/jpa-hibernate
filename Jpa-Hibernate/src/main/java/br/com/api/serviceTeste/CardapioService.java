package br.com.api.serviceTeste;

import br.com.api.dao.CardapioDao;
import br.com.api.dao.CategoriaDao;
import br.com.api.entity.Categoria;
import br.com.api.util.CarrregaDadosUtil;
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
        EntityManager entityManager1 = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CarrregaDadosUtil.cadastarCategorias(entityManager);
        CarrregaDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao caardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de Produtos por valor: "+ caardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));
        entityManager.close();
    }
}
