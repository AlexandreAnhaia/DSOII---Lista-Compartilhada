/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ejb.Listarelproduto;
import ejb.ListarelprodutoFachada;
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
public class ListarelprodutoMBean {

    @EJB
    private ListarelprodutoFachada listarelprodutoFachada;
    private Listarelproduto listarelproduto;
    public ArrayList<Produto> produtos;
    private Produto produto ;
    private Integer codigoListaAtual;

    public ListarelprodutoFachada getListarelprodutoFachada() {
        return listarelprodutoFachada;
    }

    public void setListarelprodutoFachada(ListarelprodutoFachada listarelprodutoFachada) {
        this.listarelprodutoFachada = listarelprodutoFachada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * Creates a new instance of ListarelprodutoMBean
     */
    public ListarelprodutoMBean() {
    }

    public Listarelproduto getListarelproduto() {
        return listarelproduto;
    }

    public void setListarelproduto(Listarelproduto listarelproduto) {
        this.listarelproduto = listarelproduto;
    }

    public List<Listarelproduto> getListaClientes() {
        return listarelprodutoFachada.getListaRel();
    }

    public void getProdutos(Integer codigo) {
        listarelprodutoFachada.getProdutos(codigo);
    }

    public void cadastrarItem() {
        listarelprodutoFachada.cadastrarItem(listarelproduto);
        listarelproduto = new Listarelproduto();
    }
    
    public void setCodigoListaAtual() {
        codigoListaAtual = listarelprodutoFachada.getMaxId();
    }

    public Integer getCodigoListaAtual() {
        return codigoListaAtual;
    }

    public void setCodigoListaAtual(Integer codigoListaAtual) {
        this.codigoListaAtual = codigoListaAtual;
    }
    
    public String salvarItem() {
        listarelprodutoFachada.salvarItens(this.produtos);
        return "menuPrincipal";
    }
    
    
}
