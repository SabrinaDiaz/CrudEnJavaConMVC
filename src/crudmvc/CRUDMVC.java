/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.CtrlProducto;
import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.frmProducto;

public class CRUDMVC {

    public static void main(String[] args) {
        // TODO code application logic here
        Producto mod = new Producto();
        ConsultaProducto modC = new ConsultaProducto();
        frmProducto frm = new frmProducto();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
