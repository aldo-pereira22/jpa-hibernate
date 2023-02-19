package br.com.api.serviceTeste;

import br.com.api.dao.CardapioDao;
import br.com.api.dao.ClienteDao;
import br.com.api.dao.OrdemDao;
import br.com.api.entity.Cliente;
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

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao= new OrdemDao(entityManager);


        Cliente Aldo = new Cliente("11111", "Aldo", "11111112222");
        Ordem ordem = new Ordem(Aldo);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1),2));
        clienteDao.cadastrar(Aldo);
        ordemDao.cadastrar(ordem);
        System.out.println(ordem.getOrdensCardapioList());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
