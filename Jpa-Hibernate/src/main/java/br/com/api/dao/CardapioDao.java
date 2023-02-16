package br.com.api.dao;

import br.com.api.entity.Cardapio;

import javax.persistence.EntityManager;
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

    public List<Cardapio> consultarTodos(){
        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(sql, Cardapio.class).getResultList();

    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void exlcuir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}