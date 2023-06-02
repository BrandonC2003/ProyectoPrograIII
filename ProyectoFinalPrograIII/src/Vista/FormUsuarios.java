/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import webservicebar.Usuarios;
import webservicebar.WebServiceBar_Service;
import webservicebar.WebServiceBar;


/**
 *
 * @author brand
 */
public class FormUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form FormUsuarios
     */
    WebServiceBar_Service servicio;
    WebServiceBar cliente;
    DefaultTableModel model;
    public FormUsuarios() {
        initComponents();
        rbtVendedor.setSelected(true);
        servicio = new WebServiceBar_Service();
        cliente = servicio.getWebServiceBarPort();
        model = new DefaultTableModel();
    }
    private void limpiar(){
        txfUsuario.setText("");
        txfNombre.setText("");
        txfApellido.setText("");
        passClave.setText("");
        txfTelefono.setText("");
        chbActivo.isSelected();
        rbtAdministrador.setSelected(true);
    }
    private String obtenerNivel(){
        if(rbtAdministrador.isSelected()){
            return "Administrador";
        }
        else if(rbtVendedor.isSelected()){
            return "Vendedor";
        }else{
            return "Inventariador";
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        txfUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        txfApellido = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txfTelefono = new javax.swing.JTextField();
        chbActivo = new javax.swing.JCheckBox();
        rbtVendedor = new javax.swing.JRadioButton();
        rbtAdministrador = new javax.swing.JRadioButton();
        rbtInventariador = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInformacion = new javax.swing.JTable();
        passClave = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(0, 0, 0));

        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario");

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido");

        lblClave.setForeground(new java.awt.Color(255, 255, 255));
        lblClave.setText("Clave");

        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Telefono");

        chbActivo.setBackground(new java.awt.Color(0, 0, 0));
        chbActivo.setForeground(new java.awt.Color(255, 255, 255));
        chbActivo.setText("Activo");

        rbtVendedor.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(rbtVendedor);
        rbtVendedor.setForeground(new java.awt.Color(255, 255, 255));
        rbtVendedor.setText("Vendedor");

        rbtAdministrador.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(rbtAdministrador);
        rbtAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        rbtAdministrador.setText("Administrador");

        rbtInventariador.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(rbtInventariador);
        rbtInventariador.setForeground(new java.awt.Color(255, 255, 255));
        rbtInventariador.setText("Inventariador");

        btnGuardar.setBackground(new java.awt.Color(102, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(102, 255, 255));
        btnEditar.setText("Editar");

        tblInformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblInformacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido)
                            .addComponent(lblClave)
                            .addComponent(lblTelefono)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfNombre)
                            .addComponent(txfApellido)
                            .addComponent(txfTelefono)
                            .addComponent(txfUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passClave))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtAdministrador)
                                    .addComponent(rbtVendedor)
                                    .addComponent(rbtInventariador)))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbActivo))
                        .addGap(49, 145, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(passClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(chbActivo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(rbtAdministrador)
                        .addGap(18, 18, 18)
                        .addComponent(rbtVendedor)
                        .addGap(18, 18, 18)
                        .addComponent(rbtInventariador))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Usuarios usuario = new Usuarios();
        
        usuario.setNombreUsuario(txfUsuario.getText());
        usuario.setNombre(txfNombre.getText());
        usuario.setApellido(txfApellido.getText());
        usuario.setClave(passClave.getPassword().toString());
        usuario.setTelefono(txfTelefono.getText());
        usuario.setEstado(chbActivo.isSelected() ? 1 : 0);
        usuario.setNivel(obtenerNivel());
        
        boolean resultado = cliente.agregarUsuario(usuario.getNombreUsuario(), usuario.getNombre(), usuario.getApellido(), usuario.getClave(),usuario.getTelefono() , usuario.getEstado(), usuario.getNivel());
        
        if(resultado){
            JOptionPane.showMessageDialog(this, "Usuario insertado exitosamente");
            limpiar();
        }else{
            JOptionPane.showMessageDialog(this, "Ocurrio un error al intentar insertar el usuario");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox chbActivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField passClave;
    private javax.swing.JRadioButton rbtAdministrador;
    private javax.swing.JRadioButton rbtInventariador;
    private javax.swing.JRadioButton rbtVendedor;
    private javax.swing.JTable tblInformacion;
    private javax.swing.JTextField txfApellido;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfTelefono;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
