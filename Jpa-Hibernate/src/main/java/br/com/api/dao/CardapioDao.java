package br.com.api.dao;

import br.com.api.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioDao {
    public EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada: "+ cardapio);
    }

    public Cardapio consultarPorId(final Integer id){

        return this.entityManager.find(Cardapio.class, id);
    }

    public Cardapio consultarPorNome(final  String filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = upper(:nome)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome",filtro).getSingleResult();
        }catch (Exception e){
            throw null;
        }

    }
    public List<Cardapio> consultarTodos(){
        try{
            String sql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
        }catch (Exception e){
            throw null;
        }


    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }
    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        try{
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor",filtro).getResultList();
        }catch (Exception e){
            throw null;
        }
    }
    public void exlcuir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
