/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ejb.Lista;
import ejb.ListaFachada;
import ejb.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@RequestScoped
public class ListaMBean {
    @EJB
    private ListaFachada listaFachada;
    private ArrayList<Produto> produtos;

    /**
     * Creates a new instance of ListaMBean
     */
    public ListaMBean() {
    }
    
    public List<Lista> getLista() {
        return listaFachada.getListas();
    }
    
    
    
}
