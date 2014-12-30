/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGeshabitat;

import javax.swing.JInternalFrame;

/**
 *
 * @author nelson
 */
public class SidePanel extends javax.swing.JPanel{
    private JInternalFrame jIntFrame;

    public SidePanel() {
        jIntFrame=null;
    }

    
    public SidePanel(JInternalFrame jIntFrame) {
        this.jIntFrame = jIntFrame;
    }
    
    public void setInternalFrame(JInternalFrame jIntFrame) {
        this.jIntFrame = jIntFrame;
    }

    public JInternalFrame getjIntFrame() {
        return jIntFrame;
    }
    

    
}
