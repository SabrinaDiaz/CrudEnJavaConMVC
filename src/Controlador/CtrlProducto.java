package Controlador;

import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlProducto implements ActionListener{

    private Producto modelo;
    private ConsultaProducto modeloConsulta;
    private frmProducto formulario;

    public CtrlProducto(Producto modelo, ConsultaProducto modeloConsulta, frmProducto formulario) {
        this.modelo = modelo;
        this.modeloConsulta = modeloConsulta;
        this.formulario = formulario;
        //botones
        this.formulario.btnGuardar.addActionListener(this);
        this.formulario.btnModificar.addActionListener(this);
        this.formulario.btnEliminar.addActionListener(this);
        this.formulario.btnLimpiar.addActionListener(this);
        this.formulario.btnGuardar.addActionListener(this);
    }

    public void iniciar() {
        formulario.setTitle("Productos");
        formulario.setLocationRelativeTo(null);
        formulario.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formulario.btnGuardar) {
            modelo.setCodigo(formulario.txtCodigo.getText());
            modelo.setNombre(formulario.txtNombre.getText());
            modelo.setPrecio( Double.parseDouble(formulario.txtPrecio.getText()));
            modelo.setCantidad( Integer.parseInt(formulario.txtCantidad.getText()));

            if (modeloConsulta.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
   
        if (e.getSource() == formulario.btnModificar) {
            modelo.setId(Integer.parseInt(formulario.txtId.getText()));
            modelo.setCodigo(formulario.txtCodigo.getText());
            modelo.setNombre(formulario.txtNombre.getText());
            modelo.setPrecio(Double.parseDouble(formulario.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(formulario.txtCantidad.getText()));

            if (modeloConsulta.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar registro");
                limpiar();
            }
        }

        if (e.getSource() == formulario.btnEliminar) {
            modelo.setId(Integer.parseInt(formulario.txtId.getText()));

            if (modeloConsulta.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro");
                limpiar();
            }
        }
        if (e.getSource() == formulario.btnBuscar) {
            modelo.setCodigo(formulario.txtCodigo.getText());

            if (modeloConsulta.buscar(modelo)) {
                formulario.txtId.setText(String.valueOf(modelo.getId()));
                formulario.txtCodigo.setText(modelo.getCodigo());
                formulario.txtNombre.setText(modelo.getNombre());
                formulario.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                formulario.txtCantidad.setText(String.valueOf(modelo.getCantidad()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        if (e.getSource() == formulario.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {

        formulario.txtId.setText(null);
        formulario.txtCodigo.setText(null);
        formulario.txtNombre.setText(null);
        formulario.txtPrecio.setText(null);
        formulario.txtCantidad.setText(null);
    }
}
