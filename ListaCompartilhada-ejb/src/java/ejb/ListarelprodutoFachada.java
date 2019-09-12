/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
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
public class ListarelprodutoFachada {

    @PersistenceContext(unitName = "ListaCompartilhada-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM LISTARELPRODUTO");
        return (Integer) query.getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<ejb.Listarelproduto> getListaRel() {
        Query query = em.createNamedQuery("Listarelproduto.findAll");
        return query.getResultList();
    }

    public List<Integer> getProdutos(Integer codigo) {
        Query query = em.createNamedQuery("Listarelproduto.findByCodigolista");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }

    public void cadastrarItem(Listarelproduto listarelproduto) {  // Cadastra o cliente 
        listarelproduto.setCodigo(getMaxId() + 1);
        em.persist(listarelproduto);
    }

    public void salvarItens(ArrayList<Produto> produtos) {
        for (Produto produto : produtos) {
            produto.setCodigo(getMaxId() + 1);
            em.persist(produto);
        }
    }
}
