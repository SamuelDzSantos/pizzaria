package pizzaria.models.pedido;


public class Pedido {

    private int id;
    private int idCliente;
    private String nomeCliente;
    private int status;
    private double valor_total;
    private String nomeStatus;
    private int qtdItens;
//    private List<Pizza> pizzas;

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }
                
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valor_total;
    }

    public void setValorTotal(double valorTotal) {
        this.valor_total = valorTotal;
    }

//    public List<Pizza> getPizzas() {
//        return pizzas;
//    }
//
//    public void setPizzas(List<Pizza> pizzas) {
//        this.pizzas = pizzas;
//    }
    
}

