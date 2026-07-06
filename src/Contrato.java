public class Contrato{
    private Cliente cliente;
    private Imovel imovel;
    private String tipoContrato;
    private double valorAcordado;

    public Contrato(Cliente cliente, Imovel imovel, String tipoContrato, double valorAcordado) throws ValorImovelInvalidoException {
        this.cliente = cliente;
        this.imovel = imovel;
        this.tipoContrato = tipoContrato;
        this.setValorAcordado(valorAcordado);
    }

    public Contrato(Cliente cliente, Imovel imovel, String tipoContrato) {
        this.cliente = cliente;
        this.imovel = imovel;
        this.tipoContrato = tipoContrato;
        this.valorAcordado = imovel.calculaValorFinal();
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }
    public Imovel getImovel() {
        return imovel;
    }
    public String getTipoContrato() {
        return tipoContrato;
    }
    public double getValorAcordado() {
        return valorAcordado;
    }

    public String emitirContrato() {
        return "=== CONTRATO DE " + tipoContrato.toUpperCase() + " ===\n" +
               "Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")\n" +
               "Código do Imóvel:  " + imovel.getCod() + "\n" +
               "Valor Acordado: R$ " + valorAcordado + "\n" +
               "==========================";
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public void setTipoContrato(String tipoContrato) {

        this.tipoContrato = tipoContrato;
    }

    public void setValorAcordado(double valorAcordado) throws ValorImovelInvalidoException {
        if(valorAcordado < 0) throw new ValorImovelInvalidoException();
        this.valorAcordado = valorAcordado;
    }
}
