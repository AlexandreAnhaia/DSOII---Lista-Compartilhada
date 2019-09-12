/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexandre
 */
@Entity
@Table(name = "LISTARELPRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listarelproduto.findAll", query = "SELECT l FROM Listarelproduto l"),
    @NamedQuery(name = "Listarelproduto.findByCodigo", query = "SELECT l FROM Listarelproduto l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Listarelproduto.findByCodigolista", query = "SELECT l FROM Listarelproduto l WHERE l.codigolista = :codigolista"),
    @NamedQuery(name = "Listarelproduto.findByCodigoproduto", query = "SELECT l FROM Listarelproduto l WHERE l.codigoproduto = :codigoproduto"),
    @NamedQuery(name = "Listarelproduto.findByQuantidade", query = "SELECT l FROM Listarelproduto l WHERE l.quantidade = :quantidade")})
public class Listarelproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "CODIGOLISTA")
    private Integer codigolista;
    @Column(name = "CODIGOPRODUTO")
    private Integer codigoproduto;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    public Listarelproduto() {
    }

    public Listarelproduto(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigolista() {
        return codigolista;
    }

    public void setCodigolista(Integer codigolista) {
        this.codigolista = codigolista;
    }

    public Integer getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(Integer codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listarelproduto)) {
            return false;
        }
        Listarelproduto other = (Listarelproduto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Listarelproduto[ codigo=" + codigo + " ]";
    }
    
}
