package br.com.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "ordens_cardapio",
//            joinColumns = @JoinColumn(name = "ordens_id"),
//            inverseJoinColumns = @JoinColumn(name = "cardapio_id")
//    )
    private List<OrdensCardapio> ordensCardapioList = new ArrayList<>();

    @ManyToOne
    private Cliente cliente;

    public Ordem() {
    }
    public void addOrdensCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapioList.add(ordensCardapio);
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

    public List<OrdensCardapio> getOrdensCardapioList() {
        return ordensCardapioList;
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

    public void setOrdensCardapioList(List<OrdensCardapio> ordensCardapioList) {
        this.ordensCardapioList = ordensCardapioList;
    }

    public Ordem(Integer id, BigDecimal valorTotal, LocalDate dataCriacao, List<OrdensCardapio> ordensCardapioList, Cliente cliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
        this.ordensCardapioList = ordensCardapioList;
        this.cliente = cliente;
    }


}
