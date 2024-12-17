package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de Frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula , polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));


        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));


        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
        entityManager.persist(risoto);
        entityManager.flush();
        entityManager.persist(salmao);// passando de transient para managed
        entityManager.flush();
        System.out.println("O prato consultado foi:" + cardapioDao.consultar(2));

        cardapioDao.remover(salmao);
        System.out.println("O prato consultado foi depois de excluido:" + cardapioDao.consultar(2));
        entityManager.clear();

        risoto.setValor(BigDecimal.valueOf(10000));
        cardapioDao.alterar(risoto);
        System.out.println("O prato consultado foi:" + cardapioDao.consultar(1));
        entityManager.getTransaction().commit();
        entityManager.close(); // passando para detached


    }
}
