package br.com.api.vo;

public class ItensPrincipaisVo {
    private Long quantidade;
    private String nome;

    public ItensPrincipaisVo( String nome,Long quantidade) {
        this.quantidade = quantidade;
        this.nome = nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ItensPrincipaisVo{" +
                "quantidade=" + quantidade +
                ", nome='" + nome + '\'' +
                '}';
    }
}
