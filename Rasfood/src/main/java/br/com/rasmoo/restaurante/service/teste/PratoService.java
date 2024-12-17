package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDao;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Prato risoto = new Prato();
        risoto.setNome("Risoto de Frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula , polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));


        Prato salmao = new Prato();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));


        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();

        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        pratoDao.cadastrar(salmao);
        entityManager.persist(risoto);
        entityManager.flush();
        entityManager.persist(salmao);// passando de transient para managed
        entityManager.flush();
        System.out.println("O prato consultado foi:" + pratoDao.consultar(2));

        pratoDao.remover(salmao);
        System.out.println("O prato consultado foi depois de excluido:" + pratoDao.consultar(2));
        entityManager.clear();

        risoto.setValor(BigDecimal.valueOf(10000));
        pratoDao.alterar(risoto);
        System.out.println("O prato consultado foi:" + pratoDao.consultar(1));
        entityManager.getTransaction().commit();
        entityManager.close(); // passando para detached


    }
}
