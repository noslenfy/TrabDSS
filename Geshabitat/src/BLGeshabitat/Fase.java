/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import java.util.Objects;

/**
 *
 * @author nelson
 */
public class Fase {
    private int Id;
    private String Descricao;
    private int Projecto_Id;

    public Fase() {
    }

    
    public Fase(String Descricao, int Projecto_Id) {
        this.Descricao = Descricao;
        this.Projecto_Id = Projecto_Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getProjecto_Id() {
        return Projecto_Id;
    }

    public void setProjecto_Id(int Projecto_Id) {
        this.Projecto_Id = Projecto_Id;
    }
    
    

    @Override
    public String toString() {
        return Descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.Descricao);
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
        final Fase other = (Fase) obj;
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        return true;
    }
    
    
}
