 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.ClienteDAO;
import DAO.ConvenioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author winicius
 */
public class Convenio {
    private int idConvenio;
    private String razaoSocial;
    private String cnpj;
    private String dtInicio;
    private String dtTermino;
    private String email;
    private float desconto;

    public Convenio(int idConvenio, String razaoSocial, String cnpj, String dtInicio, String dtTermino, String email, float desconto) {
        this.idConvenio = idConvenio;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dtInicio = dtInicio;
        this.dtTermino = dtTermino;
        this.email = email;
        this.desconto = desconto;
    }
 
    public int getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(int idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(String dtTermino) {
        this.dtTermino = dtTermino;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    
    public static Convenio obterConvenio(int codConvenio) throws ClassNotFoundException, SQLException {
        return ConvenioDAO.getInstancia().obterConvenios(codConvenio);
    }
    
       public static List<Convenio> obterConvenios() throws ClassNotFoundException, SQLException {
        return ConvenioDAO.getInstancia().obterConvenio();
    }
      
       

    
}
