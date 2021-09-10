/**
 * 
 * @CONTROLADOR Edicion
 * Creación del componente que responde la interacción entre los eventos y los objetos 
 * de la tabla Edicion
 * 
 */
package leolibros.controlador;

import leolibros.modelo.Edicion;
import leolibros.modelo.EdicionDAO;
import leolibros.vista.Edicionvista;
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
public class EdicionControlador implements ActionListener {

    EdicionDAO dao = new EdicionDAO();
    Edicion p = new Edicion();
    Edicionvista vista = new Edicionvista();
    DefaultTableModel modelo = new DefaultTableModel();

    public EdicionControlador(Edicionvista v) {
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
                String annio = (String) vista.tabla.getValueAt(fila, 1);
                String idioma = (String) vista.tabla.getValueAt(fila, 2);
                String copias = (String) vista.tabla.getValueAt(fila, 3);
                vista.txtId.setText("" + id);
                vista.txtAnnio.setText(annio);
                vista.txtIdioma.setText(idioma);
                vista.txtCopias.setText(copias);
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
        vista.txtAnnio.setText("");
        vista.txtIdioma.setText("");
        vista.txtCopias.setText("");
        vista.txtAnnio.requestFocus();
    }

     /**
     * 
     * @Method delete
     * Permite eliminar Ediciones de la tabla edicion
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
            JOptionPane.showMessageDialog(vista, "Edicion Eliminada.!!!");
        }
        limpiarTabla();
    }

     /**
     * 
     * @Method add
     * Permite agregar Ediciones a la tabla Edicion
     * 
     */
    public void add() {
        int isbn = Integer.parseInt(vista.txtId.getText());
        String annio = vista.txtAnnio.getText();
        String idioma = vista.txtIdioma.getText();
        String copias = vista.txtCopias.getText();
        p.setId(isbn);
        p.setAnnio(annio);
        p.setIdioma(idioma);
        p.setCopias(copias);
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Edicion Agregada con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
    }

     /**
     * 
     * @Method Actualizar
     * Permite Modificar Ediciones de la tabla edicion
     * 
     */
    public void Actualizar() {
        if (vista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "No se Identifica el ID del Autor debe selecionar la opcion Editar");
        } else {
        int isbn = Integer.parseInt(vista.txtId.getText());
        String annio = vista.txtAnnio.getText();
        String idioma = vista.txtIdioma.getText();
        String copias = vista.txtCopias.getText();
        p.setId(isbn);
        p.setAnnio(annio);
        p.setIdioma(idioma);
        p.setCopias(copias);

            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Edicion Actualizada con Exito.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }
        }
        limpiarTabla();
    }

    /**
     * 
     * @Method listar
     * Permite listar Ediciones de la tabla edicion
     * 
     */
    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Edicion> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getAnnio();
            objeto[2] = lista.get(i).getIdioma();
            objeto[3] = lista.get(i).getCopias();

            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

     /**
     * 
     * @Method centrarCeldas
     * Permite centrar en vista los resultados de las Ediciones de la tabla edicion
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
     * Permite actualizar el Grid de Ediciones de la tabla edicion
     * 
     */
    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
