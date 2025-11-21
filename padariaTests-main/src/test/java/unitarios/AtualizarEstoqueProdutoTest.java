/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unitarios;

import org.junit.jupiter.api.Test;
import entity.Produto;
import entity.Venda;
import entity.VendaInvalidaException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
/**
 *
 * @author user
 */
public class AtualizarEstoqueProdutoTest {
    
    Produto produto = new Produto(1, "Pão francês", 4.99, "Pães", 10);
    Venda venda = new Venda("11122233344", 0.0, "Pix");
    
    int quantidadeDoProduto = 4;
    
    @Test
    public void deveAtualizarEstoqueProduto() {
        
        venda.registrarVenda(produto, quantidadeDoProduto);
        
        Assertions.assertEquals(6, produto.getQuantidadeEstoque());
    }
    
    @Test
    public void deveValidarQuantidadeEmEstoqueInsuficiente(){
        
        quantidadeDoProduto = 50;
        
        Assertions.assertThrows(VendaInvalidaException.class, () -> {
            venda.registrarVenda(produto, quantidadeDoProduto);
        });
        
    }
}
