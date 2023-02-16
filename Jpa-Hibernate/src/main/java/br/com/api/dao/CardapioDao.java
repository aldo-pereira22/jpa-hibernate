package br.com.api.dao;

import br.com.api.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {
    public EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada: "+ cardapio);
    }

    public Cardapio consultar(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void exlcuir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
