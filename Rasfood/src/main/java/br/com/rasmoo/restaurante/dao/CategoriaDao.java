package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager entityManager;
    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    public void cadastrar(Categoria categoria) {
        entityManager.persist(categoria);
        System.out.println("Prato salvo é:" + categoria);
    }
}
