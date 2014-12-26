/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author nelson
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

    public Funcionario() {
    }

    public Funcionario(int Nif, String Nome, String Telefone, String Email, String Rua, String Localidade, String Cp, Date DtNascimento, String EstadoCivil) {
        this.Id = -1;
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Localidade = Localidade;
        this.Cp = Cp;
        this.DtNascimento = DtNascimento;
        this.EstadoCivil = EstadoCivil;
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
        return Nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.Id;
        hash = 17 * hash + this.Nif;
        hash = 17 * hash + Objects.hashCode(this.Nome);
        hash = 17 * hash + Objects.hashCode(this.Telefone);
        hash = 17 * hash + Objects.hashCode(this.Email);
        hash = 17 * hash + Objects.hashCode(this.Rua);
        hash = 17 * hash + Objects.hashCode(this.Localidade);
        hash = 17 * hash + Objects.hashCode(this.Cp);
        hash = 17 * hash + Objects.hashCode(this.DtNascimento);
        hash = 17 * hash + Objects.hashCode(this.EstadoCivil);
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
        return true;
    }


    @Override
    protected Object clone() {
        return new Funcionario(this.Nif,this.Nome,this.Telefone,this.Email,this.Rua,this.Localidade,this.Cp,this.DtNascimento,this.EstadoCivil);
    }




}
