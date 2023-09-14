/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jelo;

import domain.Jelo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import so.jelo.SOVratiSvaJela;

/**
 *
 * @author PC
 */
public class GetAllJeloTest {
    @Test
    public void GetAllJeloTest() {
        try {
            
               SOVratiSvaJela so = new SOVratiSvaJela();
               so.templateExecute(new Jelo());
               ArrayList<Jelo> jela =  so.getLista();
            
            
            Assert.assertNotSame(0, jela.size());// test je uspesan onda kada ima elemenata u bazi, dok kada nema nece biti uspesan
            // ovde je moze zarad slike da se stavi 3 da bi test vratio error
        } catch (Exception ex) {
        }
    }
}
