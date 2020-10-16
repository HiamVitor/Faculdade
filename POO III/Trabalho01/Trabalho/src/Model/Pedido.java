package Model;

public class Pedido implements java.io.Serializable {

    private int id;
    private int credito;
    private boolean semiPresencial;
    private PedidoItem pedidoItem;
    private Cliente cliente;

    //
    public Pedido() {

    }

    public Pedido(int id, int credito, boolean semiPresencial, PedidoItem pedidoItem, Cliente cliente) {
        this.setId(id);
        this.setCredito(credito);
        this.setSemiPresencial(semiPresencial);
        this.setPedidoItem(pedidoItem);
        this.setCliente(cliente);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setCredito(int credito) {
        this.credito = (credito != 2) && (credito != 4) ? 2 : credito;
    }

    public void setSemiPresencial(boolean semiPresencial) {
        this.semiPresencial = semiPresencial;
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

    public int getCredito() {
        return this.credito;
    }

    public boolean isSemiPresencial() {
        return this.semiPresencial;
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
