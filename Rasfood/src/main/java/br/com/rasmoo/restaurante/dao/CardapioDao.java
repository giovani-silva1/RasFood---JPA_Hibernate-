package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio) {
        entityManager.persist(cardapio);
        System.out.println("Prato salvo é:" + cardapio);
    }

    public Cardapio consultarPorId(Integer id) {
        return entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos(){
        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(sql,Cardapio.class).getResultList();

    }

    public List<Cardapio>consultarPorValor(final BigDecimal filtro){
        String sql = "select c from Cardapio c Where c.valor = :valor";
        return this.entityManager.createQuery(sql,Cardapio.class).setParameter("valor",filtro).getResultList();

    }
    public Cardapio consultarPorNome(final String filtro){
        try {
            String sql = "select c from Cardapio c Where UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(sql,Cardapio.class).setParameter("nome",filtro).getSingleResult();

        }catch (Exception e) {
            return null;
        }

    }

    public void alterar(Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void remover(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
