import java.util.Objects;

public class Cliente{
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente (String  nome, String cpf, String telefone, String email) {
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
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: nome inválido");
        }
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("Erro: CPF inválido");
        }
        cpf = cpf.replaceAll("\\D", "");

	    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
	        throw new IllegalArgumentException("Erro: CPF inválido.");
	    }
	    this.cpf = cpf;
    }
    public void setTelefone(String telefone) {
        if (telefone == null) {
	        throw new IllegalArgumentException("Telefone inválido.");
	    }
		telefone = telefone.replaceAll("\\D", "");
		
        if (telefone.length() != 11) {
			throw new IllegalArgumentException("Telefone inválido");
		}
		this.telefone = telefone;
    }
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Erro: email inválido");
        }
        this.email = email;
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