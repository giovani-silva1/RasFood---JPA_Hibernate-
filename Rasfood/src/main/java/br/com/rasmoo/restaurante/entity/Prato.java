package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/******
 * Ciclo de Vida da Entidade
 *
 * Transient -> Ainda enquanto não foi persistido não gerando o ID , não é gerenciada pela JPA
 *
 * (persist) -> Ja é gerenciado pela JPA ( Transient mudado para MANAGED)
 *
 *
 * Close / Clear -> Entidade passa de Managed para Detached.
 *
 */
@Entity
@Table(name = "pratos")
public class Prato {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    private String descricao;

    private Boolean disponivel;

    private BigDecimal valor;


    @Column(name = "data_de_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Prato() {
    }

    public Prato(Integer id, String nome, String descricao, Boolean disponivel, BigDecimal valor, LocalDateTime dataRegistro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prato prato = (Prato) o;
        return Objects.equals(id, prato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", disponivel=" + disponivel +
                ", valor=" + valor +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
