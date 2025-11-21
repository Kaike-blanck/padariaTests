package entity;

import java.time.LocalDate;

public class Venda {
    
    private int id;
    private String cpf;
    private String formaPag;
    private double valor;
    private Produto produto;

    public Venda(int id, String cpf, String formaPag, LocalDate data) {
        this.id = id;
        this.cpf = cpf;
        this.formaPag = formaPag;
    }
    
    public Venda( LocalDate data){
        this.id = id;
    }

    public Venda(String cpf, double valor, String formaPag) {
        if(cpf.length() != 11){
            throw new VendaInvalidaException("CPF do Cliente não foi encontrado, favor verificar o campo CPF!");
        }
        this.cpf = cpf;
        this.valor = valor;
        this.formaPag = formaPag;
      
    }

    public boolean validarNome(String nome) {
        return nome.matches("[a-zA-ZÀ-ÿ\\s]{6,}");
    }
 

    public void atualizarEstoque(int qtd){
        
    }
    
    public void acumulaPontos(Cliente cliente, int pontos){
        cliente.setTotPontosAcumulados(pontos);
    }

     public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public double getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        if (cpf.equals(null) || cpf.length() < 11 || cpf.equals("")){
            throw new VendaInvalidaException("Erro! O cliente não pode ser alterado");
        } else {
            this.cpf = cpf;
        }
    }

    public void setFormaPag(String formaPag) {
        if (formaPag.equals("") || formaPag.equals(null)){
            throw new VendaInvalidaException("Erro! O pagamento não pode ser alterado");
        } else {
            this.formaPag = formaPag;
        }
    }

    public void setValor(double valor) {
        if (valor < 0 ){
            throw new VendaInvalidaException("Erro! O valor não pode ser alterado");
        } else {
            this.valor = valor;
        }
    }
    
    public Produto getProduto(){
        return this.produto;
    }
    
    
    public void registrarVenda(Produto produto, int quantidade) {
        
        if (quantidade > produto.getQuantidadeEstoque()){
            throw new VendaInvalidaException("O item selecionado excede a"
                    + " em estoque");
        }
        
        this.valor = produto.getPreco() * quantidade;
        this.produto = produto;
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
    }
}
