public class Contrato{
    private Cliente cliente;
    private Imovel imovel;
    private String tipoContrato;
    private double valorAcordado;

    public Contrato(Cliente cliente, Imovel imovel, String tipoContrato, double valorAcordado) {
        this.cliente = cliente;
        this.imovel = imovel;
        this.tipoContrato = tipoContrato;
        this.valorAcordado = valorAcordado;
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
}