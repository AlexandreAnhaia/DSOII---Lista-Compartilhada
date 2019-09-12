/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ejb.Produto;
import ejb.ProdutoFachada;
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
public class ProdutoMBean {

    @EJB
    private ProdutoFachada produtoFachada;
    private Produto produto = new Produto();

    /**
     * Creates a new instance of ProdutoMBean
     */
    public ProdutoMBean() {
    }

    public List<Produto> getListaProdutos() {
        return produtoFachada.getListaProdutos();
    }

    public ProdutoFachada getProdutoFachada() {
        return produtoFachada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String cadastrarProduto() {
        produtoFachada.cadastrarProduto(produto);
        produto = new Produto();
        return "menuPrincipal";
    }

    public String salvarProduto() {
        produtoFachada.salvarProduto(this.produto);
        return "menuPrincipal";
    }

    public String removerProduto(Integer codigo) {
        produtoFachada.removerProduto(codigo);
        return "menuPrincipal";
    }

}
