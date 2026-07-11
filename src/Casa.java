public class Casa extends Imovel{
    private int nrQuartos;
    private boolean garagem;
    private double iptu;

    public Casa(){

    }

    public Casa(Endereco endereco, double valor, double area, int nrQuartos, boolean garagem, double iptu) throws ValorImovelInvalidoException {
        super(endereco, valor, area);
        setNrQuartos(nrQuartos);
        setGaragem(garagem);
        setIptu(iptu);
    }

    // Getters
    public int getNrQuartos() {
        return nrQuartos;
    }
    public double getIptu() {
        return iptu;
    }
    public boolean isGaragem() {
        return garagem;
    }

    // Setters
    public void setNrQuartos(int nrQuartos) {
        this.nrQuartos = nrQuartos;
    }
    public void setGaragem(boolean garagem) {
        this.garagem = garagem;
    }
    public void setIptu(double iptu) {
        this.iptu = iptu;
    }

    @Override
    public double calcularValorFinal() {
        return getValor() + this.iptu;
    }
    @Override
    public String toString() {
        String temGaragem = this.garagem ? "Sim" : "Não";
        return super.toString() + "Casa\n" +
               "Quartos:  " + nrQuartos + "\n" +
               "Garagem:  " + temGaragem + "\n" +
               "IPTU:     " + iptu + "\n" +
               "Valor Final:" + calcularValorFinal() + "\n" +
               "========================";
    }
}
