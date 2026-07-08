public class Terreno extends Imovel{
    private TipoTerreno tipo;

    public Terreno(){

    }
    public Terreno(Endereco endereco, double valor, double area, TipoTerreno tipo) {
        super(endereco, valor, area);
        setTipo(tipo);
    }

    // Getter
    public TipoTerreno getTipo() {
        return tipo;
    }

    // Setter
    public void setTipo(TipoTerreno tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcularValorFinal() {
        return getValor() * 1.08;
    }
    @Override
    public String toString() {
        return super.toString() + "Terreno\n" +
               "Tipo:     " + this.tipo + "\n" +
               "Valor Final:" + calcularValorFinal() + "\n" +
               "========================";
    }
}
