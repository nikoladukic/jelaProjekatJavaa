/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jelo;

import domain.Jelo;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import so.jelo.SOKreirajJelo;
import so.jelo.SOVratiSvaJela;

/**
 *
 * @author PC
 */
public class AddNewJeloTest {
    
    @Test
    public void AddNewJeloTest() {
        try {
               SOVratiSvaJela so = new SOVratiSvaJela();
               so.templateExecute(new Jelo());
               ArrayList<Jelo> jelaBefore =  so.getLista();
               
                (new SOKreirajJelo()).templateExecute(new Jelo(12L, "Karadjordjeva", 900, "Tradicinallno srpsko jelo"));
                
               SOVratiSvaJela so2 = new SOVratiSvaJela();
               so2.templateExecute(new Jelo());
               ArrayList<Jelo> jelaAfter =  so2.getLista();
               
                int beforeInsert = jelaBefore.size();
                int afterInsert = jelaAfter.size();
            
            
            Assert.assertSame(beforeInsert, afterInsert-1);// svaki put mora da se mejnja jelo da bi test bio uspesan
            
        } catch (Exception ex) {
        }
    }
}
