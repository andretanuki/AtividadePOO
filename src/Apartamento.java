public class Apartamento extends Imovel{
    private int andar;
    private int numeroApt;
    private double vlrCondominio;
    private double iptu;

    public Apartamento(){
    }

    public Apartamento(Endereco endereco, double valor, double area, int andar, int numeroApt, double vlrCondominio, double iptu) throws ValorImovelInvalidoException {
        super(endereco, valor, area);
        setAndar(andar);
        setNumeroApt(numeroApt);
        setVlrCondominio(vlrCondominio);
        setIptu(iptu);
    }

    // Getters
    public int getAndar() {
        return andar;
    }
    public int getNumeroApt() {
        return numeroApt;
    }
    public double getVlrCondominio() {
        return vlrCondominio;
    }
    public double getIptu() {
        return iptu;
    }

    // Setters
    public void setAndar(int andar) {
        this.andar = andar;
    }
    public void setNumeroApt(int numeroApt) {
        this.numeroApt = numeroApt;
    }
    public void setVlrCondominio(double vlrCondominio) {
        this.vlrCondominio = vlrCondominio;
    }
    public void setIptu(double iptu) {
        this.iptu = iptu;
    }

    @Override
    public double calcularValorFinal() {
        return getValor() + this.vlrCondominio + this.iptu;
    }
    @Override
    public String toString() {
        return super.toString() + "Apartamento\n" +
               "Andar:    " + andar + "\n" +
               "Nº Apt:   " + numeroApt + "\n" +
               "Condom.:  " + vlrCondominio + "\n" +
               "IPTU:     " + iptu + "\n" +
               "Valor Final:" + calcularValorFinal() + "\n" +
               "========================";
    }
}
