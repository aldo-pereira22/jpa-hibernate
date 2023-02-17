package br.com.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "data_de_criacao")
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToMany
    @JoinTable(
            name = "ordens_cardapio",
            joinColumns = @JoinColumn(name = "ordens_id"),
            inverseJoinColumns = @JoinColumn(name = "cardapio_id")
    )
    private List<Cardapio> cardapioList;

    @ManyToOne
    private Cliente cliente;

    public Ordem() {
    }

    public Ordem( Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
