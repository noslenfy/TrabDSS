/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat.Projectos;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 
 */
public class RegistoMaterial {
    private Date data;
    private String material;
    private float quantidade;
    private String fase;

    public RegistoMaterial(Date data, String material, float quantidade, String fase) {
        this.data = data;
        this.material = material;
        this.quantidade = quantidade;
        this.fase = fase;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return "RegistoMaterial{" + "data=" + data + ", material=" + material + ", quantidade=" + quantidade + ", fase=" + fase + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.data);
        hash = 89 * hash + Objects.hashCode(this.material);
        hash = 89 * hash + Float.floatToIntBits(this.quantidade);
        hash = 89 * hash + Objects.hashCode(this.fase);
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
        final RegistoMaterial other = (RegistoMaterial) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (Float.floatToIntBits(this.quantidade) != Float.floatToIntBits(other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.fase, other.fase)) {
            return false;
        }
        return true;
    }
    
    public Object[] getRow() {
        return new Object[] {this.getData(),this.getMaterial(),this.getQuantidade(),this.getFase()};
    }
    
    
}
