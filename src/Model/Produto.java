package Model;

/**
 *
 * @author Eduardo
 */
public class Produto {
    private int cod_Item_Estoque;
    private String nome;
    private String descricao;
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_Item_Estoque() {
        return cod_Item_Estoque;
    }

    public void setCod_Item_Estoque(int cod_Item_Estoque) {
        this.cod_Item_Estoque = cod_Item_Estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
