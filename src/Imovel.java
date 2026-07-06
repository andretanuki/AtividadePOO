public abstract class Imovel implements Calculavel{
    private int cod;
    private Endereco endereco;
    private double valor;
    private double area;
    private StatusImovel status;
    private static int contador = 1;
    
    public Imovel(Endereco endereco, double valor, double area) {
        this.cod = contador++;
        setEndereco(endereco);
        setValor(valor);
        setArea(area);
        this.status = StatusImovel.Disponivel;
    }

    // Getters
    public int getCod() {
        return cod;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public double getValor() {
        return valor;
    }
    public double getArea() {
        return area;
    }
    public StatusImovel getStatus() {
        return status;
    }

    // Setters
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Erro: O valor do imóvel deve ser maior que zero.");
        }
        this.valor = valor;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public void setStatus(StatusImovel status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "=== Dados do Imóvel ===\n" +
            "Código:   " + cod + "\n" +
            "Endereço: " + endereco + "\n" +
            "Valor:    " + valor + "\n" +
            "Área:     " + area + "\n" +
            "Status:   " + status + "\n" +
            "Tipo:     ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Imovel imovel = (Imovel) obj;
        return cod == imovel.cod;
    }
}