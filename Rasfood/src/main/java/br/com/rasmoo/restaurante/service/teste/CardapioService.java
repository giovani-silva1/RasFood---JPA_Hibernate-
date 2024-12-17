package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager,cadastrarCategoria(entityManager));

    }

    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        Categoria sobremesa = new Categoria("Sobremesas");
        Categoria bebida = new Categoria("Bebidas");
        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(pratoPrincipal);
        categoriaDao.cadastrar(sobremesa);
        categoriaDao.cadastrar(bebida);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }
    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria){

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        List<Categoria> categoriasEncontradas = categoriaDao.listarTodos();
        Cardapio risoto = new Cardapio("Risoto de Frutos do mar","Risoto acompanhado de lula , polvo e mariscos",true,BigDecimal.valueOf(88.50),categoriasEncontradas.get(0));
        Cardapio salmao = new Cardapio("Salmao ao molho de maracuja","Salmao grelhado ao molho de maracuja",true,BigDecimal.valueOf(60.00),categoriasEncontradas.get(0));
        Cardapio refrigerante = new Cardapio("Coca cola","Coca cola Original",true,BigDecimal.valueOf(10.00),categoriasEncontradas.get(2));
        Cardapio refrigerante2 = new Cardapio("Fanta","Fanta",true,BigDecimal.valueOf(08.00),categoriasEncontradas.get(2));
        Cardapio cerveja = new Cardapio("Cerveja Brahma","Cerveja Brahma",true,BigDecimal.valueOf(12.00),categoriasEncontradas.get(2));
        Cardapio pudim = new Cardapio("Pudim","Pudim",true,BigDecimal.valueOf(22.00),categoriasEncontradas.get(1));
        Cardapio sorvete = new Cardapio("Sorvete de Creme","Sorvete de Creme",true,BigDecimal.valueOf(15.00),categoriasEncontradas.get(1));
        Cardapio cordeiro = new Cardapio("Cordeiro","Cordeiro",true,BigDecimal.valueOf(80.00),categoriasEncontradas.get(0));
        Cardapio strogonoff = new Cardapio("Strogonoff ","Strogonoff",true,BigDecimal.valueOf(40.00),categoriasEncontradas.get(0));
        Cardapio caipirinha = new Cardapio("caipirinha","caipirinha",true,BigDecimal.valueOf(20.00),categoriasEncontradas.get(2));
        Cardapio agua = new Cardapio("Agua","Agua",true,BigDecimal.valueOf(15.00),categoriasEncontradas.get(2));


        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
        cardapioDao.cadastrar(refrigerante);
        cardapioDao.cadastrar(refrigerante2);
        cardapioDao.cadastrar(cerveja);
        cardapioDao.cadastrar(pudim);
        cardapioDao.cadastrar(sorvete);
        cardapioDao.cadastrar(cordeiro);
        cardapioDao.cadastrar(strogonoff);
        cardapioDao.cadastrar(caipirinha);
        cardapioDao.cadastrar(agua);
        entityManager.persist(risoto);
        entityManager.flush();
        entityManager.persist(salmao);// passando de transient para managed
        entityManager.flush();
        entityManager.persist(refrigerante);
        entityManager.flush();
        entityManager.persist(refrigerante2);
        entityManager.flush();
        entityManager.persist(cerveja);
        entityManager.flush();
        entityManager.persist(pudim);
        entityManager.persist(sorvete);
        entityManager.flush();
        entityManager.persist(cordeiro);
        entityManager.flush();
        entityManager.persist(strogonoff);

        entityManager.persist(caipirinha);
        entityManager.persist(agua);

        cardapioDao.consultarTodos().forEach(elemento -> System.out.println("Os pratos que temos é:" + elemento));

        cardapioDao.consultarPorValor(BigDecimal.valueOf(15.00)).forEach(elemento -> System.out.println("Os pratos que temos de 15,00:" + elemento));

        System.out.println("Pesquisando pelo nome Coca cola");

        System.out.println(cardapioDao.consultarPorNome("coca Cola") );

        entityManager.close(); // passando para detached

    }
}
