package Model;

public class PedidoItem implements java.io.Serializable {

    private int id;
    private String descricao;
    private float preco;

    //
    public PedidoItem() {

    }

    public PedidoItem(int id, String descricao, float preco) {
        this.setId(id);
        this.setDescricao(descricao);
        this.setPreco(preco);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty() ? "NOME PADRÃO" : descricao.toUpperCase();
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    //
    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public float getPreco() {
        return this.preco;
    }

    //
    @Override
    public String toString() {
        return this.descricao + " (" + this.preco + ")";
    }

    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoItem other = (PedidoItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
