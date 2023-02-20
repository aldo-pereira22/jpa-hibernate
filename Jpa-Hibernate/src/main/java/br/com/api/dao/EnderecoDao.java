package br.com.api.dao;

import br.com.api.entity.Cliente;
import br.com.api.entity.Endereco;
import br.com.api.vo.ClienteVo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class EnderecoDao {
    private EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public List<Endereco> consultarTodos() {
        String jpql = "SELECT e FROM Endereco e";
        return this.entityManager.createQuery(jpql, Endereco.class).getResultList();
    }

    public List<ClienteVo> consultarClientes(final String estado, final String cidade, final String rua) {
        String jpql = "SELECT new br.com.api.vo.ClienteVo (e.cliente.cpf, e.cliente.nome) " +
                "FROM Endereco e WHERE 1=1 ";

        if (Objects.nonNull(estado)) {
            jpql = jpql.concat(" AND UPPER(e.estado) = UPPER(:estado)");
        }
        if (Objects.nonNull(cidade)) {
            jpql = jpql.concat(" AND UPPER(e.cidade) = UPPER(:cidade)");
        }
        if (Objects.nonNull(rua)) {
            jpql = jpql.concat(" AND UPPER(e.rua) = UPPER(:rua)");
        }
        TypedQuery typedQuery = this.entityManager.createQuery(jpql, ClienteVo.class);
        if (Objects.nonNull(estado)) {
            typedQuery.setParameter("estado", estado);
        }
        if (Objects.nonNull(cidade)) {
            typedQuery.setParameter("cidade", cidade);
        }
        if (Objects.nonNull(rua)) {
            typedQuery.setParameter("rua", rua);
        }
        return typedQuery.getResultList();
    }

    public List<ClienteVo> consultarClientesUsandoCriteria(final String estado, final String cidade, final String rua) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ClienteVo> criteriaQuery = builder.createQuery(ClienteVo.class);
        Root<Endereco> enderecoRoot = criteriaQuery.from(Endereco.class);
        criteriaQuery.multiselect(enderecoRoot.get("cliente").get("cpf"), enderecoRoot.get("cliente").get("nome"));

        Predicate predicate = builder.and();
        if (Objects.nonNull(estado)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(enderecoRoot.get("estado")), estado.toUpperCase()));
        }
        if (Objects.nonNull(cidade)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(enderecoRoot.get("cidade")), cidade.toUpperCase()));
        }
        if (Objects.nonNull(rua)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(enderecoRoot.get("rua")), rua.toUpperCase()));
        }
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

//        public List<Endereco> consultarTodos() {
//            String jpql = "SELECT e FROM Endereco e";
//            return this.entityManager.createQuery(jpql,Endereco.class).getResultList();
//        }
}
