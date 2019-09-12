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
public class UsuarioFachada {

    @PersistenceContext(unitName = "ListaCompartilhada-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<ejb.Usuario> getListUsuarios() {
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }

    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM USUARIO");
        return (Integer) query.getSingleResult();
    }

    public void cadastrarUsuario(Usuario usuario) {  // Cadastra o cliente 
        usuario.setCodigo(getMaxId() + 1);
        em.persist(usuario);
    }

    public void salvarUsuario(Usuario usuario) {
        em.merge(usuario);
        em.flush();
    }

    public void removerUsuario(Integer codigo) {
        em.remove(em.find(Usuario.class, codigo));
    }
    
    public Usuario getUsuarioByCodigo(int codigo) {
        Query query = em.createNamedQuery("Usuario.findByCodigo");
        query.setParameter("codigo", codigo);
        return (Usuario) query.getSingleResult();
    }
}
