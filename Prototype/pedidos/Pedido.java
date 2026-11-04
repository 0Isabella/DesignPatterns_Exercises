package pedidos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido implements Prototype<Pedido>, Serializable {
    private static long proximoId = 1;

    private long id;
    private String cliente;
    private String enderecoEntrega;
    private List<ItemPedido> itens = new ArrayList<>();
    private LocalDate criadoEm;

    public Pedido(String cliente, String enderecoEntrega) {
        this.id = proximoId++;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.criadoEm = LocalDate.now();
    }

    private Pedido(Pedido origem) {
        this(origem.cliente, origem.enderecoEntrega);
        for (ItemPedido item : origem.itens) {
            this.itens.add(new ItemPedido(item)); // cópia profunda
        }
    }

    @Override
    public Pedido clonar() {
        return new Pedido(this);
    }

    public Pedido clonarPorSerializacao() {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            try (ObjectOutputStream saida = new ObjectOutputStream(bytes)) {
                saida.writeObject(this);
            }
            Pedido lido;
            try (ObjectInputStream entrada =
                    new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
                lido = (Pedido) entrada.readObject();
            }
            
            Pedido copia = new Pedido(lido.cliente, lido.enderecoEntrega);
            copia.itens.addAll(lido.itens);
            return copia;
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Falha ao copiar o pedido por serialização", e);
        }
    }

    public BigDecimal valorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.subtotal());
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public long getId() { return id; }
    public String getCliente() { return cliente; }
    public String getEnderecoEntrega() { return enderecoEntrega; }
    public LocalDate getCriadoEm() { return criadoEm; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itens); }

    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setEnderecoEntrega(String enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }
}
