/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat.Utilizadores;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author 
 */
public class Funcionario {
    private int Id;
    private int Nif;
    private String Nome;
    private String Telefone;
    private String Email;
    private String Rua;
    private String Localidade;
    private String Cp;
    private Date DtNascimento;
    private String EstadoCivil;
    
    private String Username;
    private boolean CFamilias;
    private boolean CFundos;
    private boolean CConstrucao;
    

    public Funcionario() {
    }


    public Funcionario(int Nif, String Nome, String Telefone, String Email, String Rua, String Localidade, String Cp, Date DtNascimento, String EstadoCivil, String Username, boolean CFamilias, boolean CFundos, boolean CConstrucao) {
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Localidade = Localidade;
        this.Cp = Cp;
        this.DtNascimento = DtNascimento;
        this.EstadoCivil = EstadoCivil;
        this.Username = Username;
        this.CFamilias = CFamilias;
        this.CFundos = CFundos;
        this.CConstrucao = CConstrucao;
    }


    
    public int getId() {
        return Id;
    }
    public int getNif() {
        return Nif;
    }
    public String getNome() {
        return Nome;
    }
    public String getTelefone() {
        return Telefone;
    }
    public String getEmail() {
        return Email;
    }
    public String getRua() {
        return Rua;
    }
    public String getLocalidade() {
        return Localidade;
    }
    public String getCp() {
        return Cp;
    }
    public Date getDtNascimento() {
        return DtNascimento;
    }
    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public void setNif(int Nif) {
        this.Nif = Nif;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setRua(String Rua) {
        this.Rua = Rua;
    }
    public void setLocalidade(String Localidade) {
        this.Localidade = Localidade;
    }
    public void setCp(String Cp) {
        this.Cp = Cp;
    }
    public void setDtNascimento(Date DtNascimento) {
        this.DtNascimento = DtNascimento;
    }
    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    @Override
    public String toString() {
        return Username;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public boolean isCFamilias() {
        return CFamilias;
    }

    public void setCFamilias(boolean CFamilias) {
        this.CFamilias = CFamilias;
    }

    public boolean isCFundos() {
        return CFundos;
    }

    public void setCFundos(boolean CFundos) {
        this.CFundos = CFundos;
    }

    public boolean isCConstrucao() {
        return CConstrucao;
    }

    public void setCConstrucao(boolean CConstrucao) {
        this.CConstrucao = CConstrucao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.Id;
        hash = 83 * hash + this.Nif;
        hash = 83 * hash + Objects.hashCode(this.Nome);
        hash = 83 * hash + Objects.hashCode(this.Telefone);
        hash = 83 * hash + Objects.hashCode(this.Email);
        hash = 83 * hash + Objects.hashCode(this.Rua);
        hash = 83 * hash + Objects.hashCode(this.Localidade);
        hash = 83 * hash + Objects.hashCode(this.Cp);
        hash = 83 * hash + Objects.hashCode(this.DtNascimento);
        hash = 83 * hash + Objects.hashCode(this.EstadoCivil);
        hash = 83 * hash + Objects.hashCode(this.Username);
        hash = 83 * hash + (this.CFamilias ? 1 : 0);
        hash = 83 * hash + (this.CFundos ? 1 : 0);
        hash = 83 * hash + (this.CConstrucao ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.Nif != other.Nif) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Telefone, other.Telefone)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Rua, other.Rua)) {
            return false;
        }
        if (!Objects.equals(this.Localidade, other.Localidade)) {
            return false;
        }
        if (!Objects.equals(this.Cp, other.Cp)) {
            return false;
        }
        if (!Objects.equals(this.DtNascimento, other.DtNascimento)) {
            return false;
        }
        if (!Objects.equals(this.EstadoCivil, other.EstadoCivil)) {
            return false;
        }
        if (!Objects.equals(this.Username, other.Username)) {
            return false;
        }
        if (this.CFamilias != other.CFamilias) {
            return false;
        }
        if (this.CFundos != other.CFundos) {
            return false;
        }
        if (this.CConstrucao != other.CConstrucao) {
            return false;
        }
        return true;
    }



    public Object[] getRowData() {
        Object[] ret = {Id,Nome,Localidade,Telefone,Email,Username};
        return ret;
    }

}
