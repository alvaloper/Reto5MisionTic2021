/**
 * 
 * @CONTROLADOR Autor
 * Creación del componente que responde la interacción entre los eventos y los objetos 
 * de la tabla Autor
 * 
 */
package leolibros.controlador;

import leolibros.modelo.Autor;
import leolibros.modelo.AutorDAO;
import leolibros.vista.Autorvista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @Author Luis Jose Espinoza Alvarado ing.espinozalj at gmail.com
 *
 */
public class AutorControlador implements ActionListener {

    AutorDAO dao = new AutorDAO();
    Autor p = new Autor();
    Autorvista vista = new Autorvista();
    DefaultTableModel modelo = new DefaultTableModel();

    public AutorControlador(Autorvista v) {
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnDelete.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);

    }

    //Creación de las acciones de los botones Listar, Agregar, Modificar, Eliminar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnListar) {
            limpiarTabla();
            listar(vista.tabla);
            nuevo();
        }
        if (e.getSource() == vista.btnAgregar) {
            add();
            listar(vista.tabla);
            nuevo();
        }
        if (e.getSource() == vista.btnEditar) {
            int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe Seleccionar un Autor de la lista!");
            } else {
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nom = (String) vista.tabla.getValueAt(fila, 1);
                vista.txtId.setText("" + id);
                vista.txtNom.setText(nom);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            Actualizar();
            listar(vista.tabla);
            nuevo();

        }
        if (e.getSource() == vista.btnDelete) {
            delete();
            listar(vista.tabla);
            nuevo();
        }


    }

    //Limpieza de los campos de texto de la vista autor
    void nuevo() {
        vista.txtId.setText("");
        vista.txtNom.setText("");
        vista.txtNom.requestFocus();
    }

    /**
     * 
     * @Method delete
     * Permite eliminar Autores de la tabla Autor
     * 
     */
    public void delete() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe Seleccionar una Fila...!!!");
        } else {
            int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            dao.Delete(id);
            System.out.println("El Reusltado es" + id);
            JOptionPane.showMessageDialog(vista, "Autor Eliminado...!!!");
        }
        limpiarTabla();
    }

     /**
     * 
     * @Method add
     * Permite agregar Autores de la tabla Autor
     * 
     */
    public void add() {
        String nom = vista.txtNom.getText();
        p.setNom(nom);
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Autor Agregado con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
    }

     /**
     * 
     * @Method Actualizar
     * Permite Modificar Autores de la tabla Autor
     * 
     */
    public void Actualizar() {
        if (vista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "No se Identifica el ID del Autor debe selecionar la opcion Editar");
        } else {
            int id = Integer.parseInt(vista.txtId.getText());
            String nom = vista.txtNom.getText();
            p.setId(id);
            p.setNom(nom);

            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Autor Actualizado con Exito.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }
        }
        limpiarTabla();
    }

     /**
     * 
     * @Method listar
     * Permite listar Autores de la tabla Autor
     * 
     */
    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Autor> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNom();

            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

     /**
     * 
     * @Method centrarCeldas
     * Permite centrar en vista los resultados de los Autores de la tabla Autor
     * 
     */
    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

     /**
     * 
     * @Method limpiarTabla
     * Permite actualizar el Grid de Autores de la tabla Autor
     * 
     */
    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
