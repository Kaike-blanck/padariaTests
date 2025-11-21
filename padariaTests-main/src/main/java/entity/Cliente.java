package entity;

import jakarta.persistence.Entity;


@Entity
public class Cliente extends Pessoa {

    private String cpf;
    private String telefone;
    private int totPontosAcumulados;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public Cliente(int id, String nome, String cpf, String telefone, int totPontosAcumulados ) {
        super(id, nome);
        if(nome.isBlank()){
            throw new ClienteInvalidoException("Há campos obrigatórios não preenchidos!");
        }

        if( cpf.length() != 11){
            throw new ClienteInvalidoException("CPF digitado é inválido, favor validar!");
        }

        if(telefone.length() != 11){
            throw new ClienteInvalidoException("Número digitado é inválido, favor validar!");
        }
        if(totPontosAcumulados > 0){

            System.out.println("Pontos do cliente: " + (this.totPontosAcumulados + totPontosAcumulados));
        }
        if(totPontosAcumulados <= 0){
            System.out.println("Cliente não possui nenhum ponto salvo");

        }

        this.cpf = cpf;
        this.telefone = telefone;
        this.totPontosAcumulados = totPontosAcumulados;
        this.senha = nome.substring(0,3) + cpf.substring(0,3);
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", telefone=" + telefone + ", totPontosAcumulados=" + totPontosAcumulados + '}';
    }

    public Cliente() {
        
    }
    
    public boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
}
    public boolean validarNome(String nome) {
    return nome.matches("[a-zA-ZÀ-ÿ\\s]{6,}");
}
    public boolean validarTelefone(String telefone) {
    return telefone.matches("\\d{11}");
}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTotPontosAcumulados(int totPontosAcumulados) {
        this.totPontosAcumulados = totPontosAcumulados;
    }
    
    
    public String getTelefone() {
        return telefone;
    }

    public int getTotPontosAcumulados() {
        return totPontosAcumulados;
    }

}
