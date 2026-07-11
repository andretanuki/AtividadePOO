import java.util.Objects;

public class Cliente{
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente (String  nome, String cpf, String telefone, String email) throws NomeInvalidoException, CpfInvalidoException, TelefoneInvalidoException, EmailInvalidoException {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
    }

    // getters
    public String getNome() {
    return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    
    // setters
    public void setNome(String nome) throws NomeInvalidoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new NomeInvalidoException("Nome inválido");
        }
        this.nome = nome;
    }
    
    public void setCpf(String cpf) throws CpfInvalidoException {
        if (cpf == null) {
            throw new CpfInvalidoException("CPF nulo é inválido.");
        }
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            throw new CpfInvalidoException("CPF inválido.");
        }
        validarDigitosCpf(cpf);
        this.cpf = cpf;
    }
    
    public void setTelefone(String telefone) throws TelefoneInvalidoException {
        if (telefone == null) {
            throw new TelefoneInvalidoException("Telefone nulo é inválido.");
        }
        telefone = telefone.replaceAll("\\D", "");

        if (telefone.length() != 11) {
            throw new TelefoneInvalidoException("Telefone inválido.");
		}
		this.telefone = telefone;
    }
    public void setEmail(String email) throws EmailInvalidoException {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new EmailInvalidoException("Email inválido");
        }
        this.email = email;
    }

    private void validarDigitosCpf(String cpf) throws CpfInvalidoException {
        int soma1 = 0;
        int peso1 = 10;
        for (int i = 0; i < 9; i++) {
            int num = Character.getNumericValue(cpf.charAt(i));
            soma1 += (num * peso1);
            peso1--;
        }
        int resto1 = soma1 % 11;
        int digito1 = (resto1 < 2) ? 0 : (11 - resto1);

        int soma2 = 0;
        int peso2 = 11;
        for (int i = 0; i < 10; i++) {
            int num = Character.getNumericValue(cpf.charAt(i));
            soma2 += (num * peso2);
            peso2--;
        }
        int resto2 = soma2 % 11;
        int digito2 = (resto2 < 2) ? 0 : (11 - resto2);

        int digitoInformado1 = Character.getNumericValue(cpf.charAt(9));
        int digitoInformado2 = Character.getNumericValue(cpf.charAt(10));

        if (digito1 != digitoInformado1 || digito2 != digitoInformado2) {
            throw new CpfInvalidoException("Os dígitos verificadores do CPF Não batem.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return Objects.equals(other.cpf, this.cpf);
    }
    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
    @Override
    public String toString() {
        return "=== Dados do Cliente ===\n" +
            "Nome:     " + nome + "\n" +
            "CPF:      " + cpf + "\n" +
            "Telefone: " + telefone + "\n" +
            "E-mail:   " + email + "\n" +
            "========================";
    }
}
