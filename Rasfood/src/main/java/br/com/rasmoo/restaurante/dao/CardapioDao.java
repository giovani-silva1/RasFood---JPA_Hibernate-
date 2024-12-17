package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio) {
        entityManager.persist(cardapio);
        System.out.println("Prato salvo é:" + cardapio);
    }

    public Cardapio consultar(Integer id) {
        return entityManager.find(Cardapio.class, id);
    }


    public void alterar(Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void remover(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
