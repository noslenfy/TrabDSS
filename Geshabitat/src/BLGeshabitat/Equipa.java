/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author nelson
 */
public class Equipa {
    private int Id;
    private String Nome;
    private List<Integer> voluntarios;
    private int Funcionario_Id;

    public Equipa() {
    }

    public Equipa(String Nome, List<Integer> voluntarios, int Funcionario_Id) {
        this.Nome = Nome;
        this.voluntarios = voluntarios;
        this.Funcionario_Id = Funcionario_Id;
    }

    public Equipa(String Nome, int Funcionario_Id) {
        this.Nome = Nome;
        this.Funcionario_Id = Funcionario_Id;
    }
    
    

    public int getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public List<Integer> getVoluntarios() {
        return voluntarios;
    }

    public int getFuncionario_Id() {
        return Funcionario_Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setVoluntarios(List<Integer> voluntarios) {
        this.voluntarios = voluntarios;
    }

    public void setFuncionario_Id(int Funcionario_Id) {
        this.Funcionario_Id = Funcionario_Id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Id;
        hash = 97 * hash + Objects.hashCode(this.Nome);
        hash = 97 * hash + Objects.hashCode(this.voluntarios);
        hash = 97 * hash + this.Funcionario_Id;
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
        final Equipa other = (Equipa) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.voluntarios, other.voluntarios)) {
            return false;
        }
        if (this.Funcionario_Id != other.Funcionario_Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipa{" + "Id=" + Id + ", Nome=" + Nome + ", voluntarios=" + voluntarios + ", Funcionario_Id=" + Funcionario_Id + '}';
    }
    
    
    
    
}
