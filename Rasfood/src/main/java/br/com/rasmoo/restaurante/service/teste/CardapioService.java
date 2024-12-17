package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager,cadastrarCategoria(entityManager));

    }

    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }
    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria){

        Cardapio risoto = new Cardapio("Risoto de Frutos do mar","Risoto acompanhado de lula , polvo e mariscos",true,BigDecimal.valueOf(88.50),categoria);
        Cardapio salmao = new Cardapio("Salmao ao molho de maracuja","Salmao grelhado ao molho de maracuja",true,BigDecimal.valueOf(60.00),categoria);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
        entityManager.persist(risoto);
        entityManager.flush();
        entityManager.persist(salmao);// passando de transient para managed
        entityManager.flush();
        risoto.setValor(BigDecimal.valueOf(10000));
        cardapioDao.alterar(risoto);
        System.out.println("O prato consultado foi:" + cardapioDao.consultar(1));
        System.out.println("O prato consultado foi:" + cardapioDao.consultar(1));
        entityManager.close(); // passando para detached
    }
}
