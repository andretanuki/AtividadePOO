import java.util.Objects;

public abstract class Imovel implements Calculavel{
    private int cod;
    private Endereco endereco;
    private double valor;
    private double area;
    private StatusImovel status;
    private static int contador = 1;

    public Imovel(){
    }
    
    public Imovel(Endereco endereco, double valor, double area) throws ValorImovelInvalidoException, AreaInvalidaException {
        setEndereco(endereco);
        setValor(valor);
        setArea(area);
        this.status = StatusImovel.Disponivel;
        this.cod = contador++;
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
    public void setValor(double valor) throws ValorImovelInvalidoException {
        if (valor <= 0) {
            throw new ValorImovelInvalidoException("O valor do imóvel deve ser maior que zero.");
        }
        this.valor = valor;
    }
    public void setArea(double area) throws AreaInvalidaException {
        if (area <= 0) throw new AreaInvalidaException();
        this.area = area;
    }
    public void setStatus(StatusImovel status) {
        this.status = status;
    }

    public void setCod(int cod) {
        this.cod = cod;
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
    public int hashCode(){
        return Objects.hash(cod);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Imovel)) return false;

        Imovel imovel = (Imovel) obj;
        return cod == imovel.cod;
    }
}
