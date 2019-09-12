/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ejb.Usuario;
import ejb.UsuarioFachada;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@RequestScoped
public class UsuarioMBean {

    @EJB
    private UsuarioFachada usuarioFachada;
    private Usuario usuario = new Usuario();
    private Integer codigo = 0;
    private String senha = "";

    /**
     * Creates a new instance of UsuarioMBean
     */
    public UsuarioMBean() {
    }

    public List<Usuario> getListaUsuarios() {
        return usuarioFachada.getListUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String cadastrarUsuario() {          // Chama o método do bean de sessão
        usuarioFachada.cadastrarUsuario(usuario);
        usuario = new Usuario();
        return "index";
    }

    public String salvarUsuario() {
        usuarioFachada.salvarUsuario(this.usuario);
        return "index";
    }

    public String verificaUsuario() {
        Integer codigo1 = (Integer) this.codigo;
        Usuario usuario = usuarioFachada.getUsuarioByCodigo(codigo1);
        if (usuario.getSenha().equals(this.senha)) {
            return "menuPrincipal";
        }
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Código ou Senha Incorretos", null);
//        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Falha", "Usuario ou senha Incorretos"));
        return null;
    }

    public String removerUsuario(Integer codigo) {
        usuarioFachada.removerUsuario(codigo);
        return "index";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        int codigo1 = (Integer) codigo;
        this.codigo = codigo1;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String exibeTelaCadastro() {
        return "cadastraUsuario";
    }

}
