package br.com.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @EmbeddedId
    private ClienteId clienteId;

    private String nome;

    @Embedded
    private Contato contato;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();


    public Cliente(String cpf, String email, String nome) {
        this.clienteId = new ClienteId(email, cpf );
        this.nome = nome;
    }

    public Cliente() {

    }

    public void addEndereco(Endereco endereco) {
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }




    public String getCpf() {
        return this.clienteId.getCpf();
    }

    public void setCpf(String cpf) {
        this.clienteId.setCpf(cpf);
    }

    public void setEmail(String email) {
        this.clienteId.setEmail(email);
    }
    public String getEmail(){
        return clienteId.getEmail();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf=" + clienteId.getCpf() +
                ", email=" + clienteId.getEmail() +
                ", nome='" + nome + '\'' +
                ", contato=" + contato +
                ", enderecoList=" + enderecoList +
                '}';
    }
}
