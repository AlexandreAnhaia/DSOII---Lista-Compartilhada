/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alexandre
 */
@Stateless
@LocalBean
public class ProdutoFachada {

    @PersistenceContext(unitName = "ListaCompartilhada-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<ejb.Produto> getListaProdutos() {
        Query query = em.createNamedQuery("Produto.findAll");
        return query.getResultList();
    }

    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM PRODUTO");
        return (Integer) query.getSingleResult();
    }

    public void cadastrarProduto(Produto produto) {  // Cadastra o cliente 
        produto.setCodigo(getMaxId() + 1);
        em.persist(produto);
    }

    public void salvarProduto(Produto produto) {
        em.merge(produto);
        em.flush();
    }

    public void removerProduto(Integer codigo) {
        em.remove(em.find(Produto.class, codigo));
    }

    public Produto getProdutoByCodigo(int codigo) {
        Query query = em.createNamedQuery("Produto.findByCodigo");
        query.setParameter("codigo", codigo);
        return (Produto) query.getSingleResult();
    }

    public int getMaxIdProduto() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM LISTARELPRODUTO");
        return (Integer) query.getSingleResult();
    }
}
