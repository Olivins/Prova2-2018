package professorangoti.com.interaocomousuario.activities.domain;

public class Value {
    private String produto;
    private String valor;

    public Value() {
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Price{" +
                "produto='" + produto + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}

