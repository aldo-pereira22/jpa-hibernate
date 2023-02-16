package br.com.api.dao;

import br.com.api.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public Categoria consultarPorId(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List
    public List<Categoria> consultarTodos() {
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql,Categoria.class).getResultList();
    }
    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria){
        this.entityManager.remove(categoria);
    }
}