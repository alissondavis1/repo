/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Categoriasocio;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexandre
 */
public class DaoCategoriaSocioTest {
    
    DaoCategoriaSocio d;
    public DaoCategoriaSocioTest() {
    }
   
    @Before
    public void setUp() {
        d = new DaoCategoriaSocio();
    }
   
    
    /**
     * Test of BuscarCategoriaPorNome method, of class DaoCategoriaSocio.
     */
    @Test
    public void testBuscarCategoriaPorNome() {
        System.out.println("BuscarCategoriaPorNome");
        String nome = "Socio Fundador";
        DaoCategoriaSocio instance = new DaoCategoriaSocio();
        Categoriasocio expResult = null;
        Categoriasocio result = instance.BuscarCategoriaPorNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarCategoriaPorNomeLike method, of class DaoCategoriaSocio.
     */
    @Test
    public void testBuscarCategoriaPorNomeLike() {
        System.out.println("BuscarCategoriaPorNomeLike");
        String nome = "socio";
        DaoCategoriaSocio instance = new DaoCategoriaSocio();
        List expResult = null;
        List result = instance.BuscarCategoriaPorNomeLike(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarTodasCategorias method, of class DaoCategoriaSocio.
     */
    @Test
    public void testBuscarTodasCategorias() {
        System.out.println("BuscarTodasCategorias");
        DaoCategoriaSocio instance = new DaoCategoriaSocio();
        List expResult = null;
        List result = instance.BuscarTodasCategorias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarCategoriaSocioPorId method, of class DaoCategoriaSocio.
     */
    @Test
    public void testBuscarCategoriaSocioPorId() {
        System.out.println("BuscarCategoriaSocioPorId");
        int id = 0;
        DaoCategoriaSocio instance = new DaoCategoriaSocio();
        Categoriasocio expResult = null;
        Categoriasocio result = instance.BuscarCategoriaSocioPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}