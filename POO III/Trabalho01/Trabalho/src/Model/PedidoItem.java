package Model;

public class PedidoItem implements java.io.Serializable {

    private int id;
    private String nome;
    private float preco;

    //
    public PedidoItem() {

    }

    public PedidoItem(int id, String nome, float preco) {
        this.setId(id);
        this.setNome(nome);
        this.setPreco(preco);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    //
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public float getPreco() {
        return this.preco;
    }

    //
    @Override
    public String toString() {
        return this.nome + " (" + this.preco + ")";
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
