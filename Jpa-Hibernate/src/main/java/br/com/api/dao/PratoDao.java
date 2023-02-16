package br.com.api.dao;

import br.com.api.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {
    public EntityManager entityManager;

    public PratoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Prato prato){
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: "+ prato);
    }

    public Prato consultar(final Integer id){
        return this.entityManager.find(Prato.class, id);
    }

    public void atualizar(final Prato prato){
        this.entityManager.merge(prato);
    }

    public void exlcuir(final Prato prato){
        this.entityManager.remove(prato);
    }
}
