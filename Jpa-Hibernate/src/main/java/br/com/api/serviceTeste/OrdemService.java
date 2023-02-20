package br.com.api.serviceTeste;

import br.com.api.dao.CardapioDao;
import br.com.api.dao.ClienteDao;
import br.com.api.dao.EnderecoDao;
import br.com.api.dao.OrdemDao;
import br.com.api.entity.Cliente;
import br.com.api.entity.Endereco;
import br.com.api.entity.Ordem;
import br.com.api.entity.OrdensCardapio;
import br.com.api.util.CarrregaDadosUtil;
import br.com.api.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CarrregaDadosUtil.cadastarCategorias(entityManager);
        CarrregaDadosUtil.cadastrarProdutosCardapio(entityManager);
        CarrregaDadosUtil.cadastrarClientes(entityManager);
        CarrregaDadosUtil.cadastrarOrdensClientes(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        System.out.println("\n\n\n\n\n\n\n\n\n"+clienteDao.consultarTodos());
//        System.out.println(""+enderecoDao.consultarClientesUsandoCriteria("SP", "Sao Paulo", null));
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
