package Model;

public class Pedido implements java.io.Serializable {

    private int id;
    private double precoTotal;
    private Vendedor vendedor;
    private PedidoItem pedidoItem;
    private Cliente cliente;

    //
    public Pedido() {

    }

    public Pedido(int id, double precoTotal, Vendedor vendedor, PedidoItem pedidoItem, Cliente cliente) {
        this.setId(id);
        this.setPrecoTotal(precoTotal);
        this.setVendedor(vendedor);
        this.setPedidoItem(pedidoItem);
        this.setCliente(cliente);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal < 0 ? 0.1 : precoTotal;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setPedidoItem(PedidoItem pedidoItem) {
        this.pedidoItem = pedidoItem;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //
    public int getId() {
        return this.id;
    }

    public double getPrecoTotal() {
        return this.precoTotal;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public PedidoItem getPedidoItem() {
        return this.pedidoItem;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
