package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Prato prato) {
        entityManager.persist(prato);
        System.out.println("Prato salvo é:" + prato);
    }

    public Prato consultar(Integer id) {
        return entityManager.find(Prato.class, id);
    }


    public void alterar(Prato prato) {
        this.entityManager.merge(prato);
    }

    public void remover(Prato prato){
        this.entityManager.remove(prato);
    }
}
