/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat.Fundos;

import java.util.Objects;

/**
 *
 * @author 
 */
public class Material {
    private int Id;
    private String Descricao;
    private float Stock;

    public Material() {
    }

    
    public Material(String Descricao, float Stock) {
        this.Id = -1;
        this.Descricao = Descricao;
        this.Stock = Stock;
    }

    public int getId() {
        return Id;
    }
    public String getDescricao() {
        return Descricao;
    }
    public float getStock() {
        return Stock;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    public void setStock(float Stock) {
        this.Stock = Stock;
    }
    
    @Override
    public String toString() {
        return Descricao;
    }

    public Object[] getRowData() {
        Object[] ret = {Id,Descricao,Stock};
        return ret;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.Id;
        hash = 89 * hash + Objects.hashCode(this.Descricao);
        hash = 89 * hash + Float.floatToIntBits(this.Stock);
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
        final Material other = (Material) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        return Float.floatToIntBits(this.Stock) == Float.floatToIntBits(other.Stock);
    }
    
    
    
    
    
    
    
}
