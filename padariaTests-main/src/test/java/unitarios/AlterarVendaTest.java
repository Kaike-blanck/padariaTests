/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unitarios;

import entity.Venda;
import entity.VendaInvalidaException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class AlterarVendaTest {
    
    List<Venda> lista = new ArrayList<Venda>();
            
    Venda venda = new Venda("12312312301", 20.50, "Pix");
    
    @Test
    public void deveAlterarInformaçõesDaVenda(){
        
        //act
        venda.setFormaPag("Dinheiro");
        venda.setValor(25.99);
        
        //assert
        Assertions.assertEquals("Dinheiro", venda.getFormaPag());
        Assertions.assertEquals(25.99, venda.getValor());
        System.out.println("Informações da venda alteradas com sucesso");
        
    }
    
    @Test
    public void deveAlterarClienteVenda(){
        
        //act
        venda.setCpf("12345678910");
        
        //assert
        Assertions.assertEquals("12345678910", venda.getCpf());
    }
    
    @Test
    public void deveAlterarFormaPagamentoVenda() {
        
        //act
        venda.setFormaPag("Débito");
        
        //assert
        Assertions.assertEquals("Débito", venda.getFormaPag());
    }
    
    @Test
    public void deveAlterarValorDaVenda() {
        
        //act
        venda.setValor(39.90);
        
        //assert
        Assertions.assertEquals(39.90, venda.getValor());
    }
    
    @Test
    public void deveValidarAlteracaoCpfInvalida() {
        
        //assert e act
        Assertions.assertThrows(VendaInvalidaException.class, () -> {
            venda.setCpf("");
        });
    }
    
    @Test
    public void deveValiudarAlteracaoFormaPagInvalida() {
        
        //assert e act
        Assertions.assertThrows(VendaInvalidaException.class, () -> {
            venda.setFormaPag("");
        });
    }
    
    @Test
    public void deveValidarAlteracaoValorInvalida() {
        
        //assert e act
        Assertions.assertThrows(VendaInvalidaException.class, () -> {
            venda.setValor(-3.50);
        });
    }
}
