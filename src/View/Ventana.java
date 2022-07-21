package View;

import Model.ArchivoHistorial;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import Model.ArchivoLibros;
import Model.DeclararCola;
import Model.Libro;
import Model.Nodo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.time.format.DateTimeFormatter;

/** @author Jose Ignacio */

public class Ventana extends javax.swing.JFrame {

    Libro lib = null;
    ArchivoLibros arch = new ArchivoLibros();
    TableRowSorter<TableModel> sortear;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Ventana() throws IOException {
        initComponents();

        ArchivoLibros arch = new ArchivoLibros();
        Libro lib = null;
        File archivo;

        this.setLocationRelativeTo(null);
        ColorSelectd(indlibros);
        this.estiloTabla();
        this.estiloTabla2();
        arch.setRutaArchivo("Libros.txt");

        archivo = new File(arch.getRutaArchivo());
        BufferedWriter escribir;
        if (archivo.exists()) {
            escribir = new BufferedWriter(new FileWriter(archivo, true));
        } else {
            escribir = new BufferedWriter(new FileWriter(archivo));
        }
        escribir.close();

        LlenarTabla();
        AddtablaHistorial();

        ArchivoHistorial hist = new ArchivoHistorial();
        Nodo nod = null;
        File archivo2;

        hist.setRutaArchivo("Historial.txt");

        archivo2 = new File(hist.getRutaArchivo());
        BufferedWriter escribir1;
        if (archivo2.exists()) {
            escribir1 = new BufferedWriter(new FileWriter(archivo2, true));
        } else {
            escribir1 = new BufferedWriter(new FileWriter(archivo2));
        }
        escribir1.close();

    }

    public void LlenarTabla() throws IOException {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        int cont = 0;
        String linea = null;
        FileReader fichero = new FileReader("Libros.txt");
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "\t");
            String isbn = campo.nextToken().trim();
            String nom = campo.nextToken().trim();
            String aut = campo.nextToken().trim();
            String cat = campo.nextToken().trim();
            String edi = campo.nextToken().trim();
            String pub = campo.nextToken().trim();
            String cant = campo.nextToken().trim();
            lib = new Libro();
            lib.setIsbn(isbn);
            lib.setNombre(nom);
            lib.setAutor(aut);
            lib.setCategoria(cat);
            lib.setEditorial(edi);
            lib.setPublicacion(Integer.parseInt(pub));
            lib.setCantidad(Integer.parseInt(cant));

            cont++;
            addtotable(lib.getIsbn(), lib.getNombre(), lib.getAutor(), lib.getCategoria(), lib.getEditorial(), lib.getPublicacion(), lib.getCantidad());
        }
        leer.close();

        txtarte.setText(String.valueOf(arch.contCategoria("Libros.txt", "Arte")));
        txthistoria.setText(String.valueOf(arch.contCategoria("Libros.txt", "Historia")));
        txttecnologia.setText(String.valueOf(arch.contCategoria("Libros.txt", "Tecnología")));
        txtentretinimiento.setText(String.valueOf(arch.contCategoria("Libros.txt","Entretenimiento")));
        int arte = Integer.parseInt(txtarte.getText());
        int historia = Integer.parseInt(txthistoria.getText());
        int entretenimiento  = Integer.parseInt(txtentretinimiento.getText());
        int tecnologia = Integer.parseInt(txttecnologia.getText());
        int contador = arte + historia + entretenimiento + tecnologia;
        txtcontador.setText(String.valueOf(contador));
    }


    public void addtotable(String isbn, String nombre, String autor, String categoria, String editorial, int pub, int cant) {

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        Object[] fila = new Object[7];
        fila[0] = isbn;
        fila[1] = nombre;
        fila[2] = autor;
        fila[3] = categoria;
        fila[4] = editorial;
        fila[5] = pub;
        fila[6] = cant; 
        model.addRow(fila);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlback = new javax.swing.JPanel();
        btnsalir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLibros = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        btnPrestar = new javax.swing.JLabel();
        indlibros = new javax.swing.JPanel();
        indagregar = new javax.swing.JPanel();
        indprestar = new javax.swing.JPanel();
        indhistorial = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        pnlLibros = new javax.swing.JPanel();
        cbfiltrar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtcontador = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtarte = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txthistoria = new javax.swing.JLabel();
        txtentretinimiento = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txttecnologia = new javax.swing.JLabel();
        calcularmayor = new javax.swing.JButton();
        pnlAgregar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtisbn = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtautor = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        cbcategoria = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txteditorial = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtano = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        pnlPrestar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtisbnbuscar = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtnombrebuscar = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtautorbuscar = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtidpersona = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        btnprestar = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtnombrepersona = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        btnbuscar = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        cboperacion = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        txtcantidaprestar = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        pnlHistorial = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtfiltro = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaprestamos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlback.setBackground(new java.awt.Color(53, 58, 86));
        pnlback.setForeground(new java.awt.Color(250, 251, 252));
        pnlback.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(159, 159, 227));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsalirMouseClicked(evt);
            }
        });
        pnlback.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 421, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        pnlback.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 69, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BIBLIOTECA ");
        pnlback.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 125, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MUNICIPAL");
        pnlback.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 120, 20));

        btnLibros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLibros.setForeground(new java.awt.Color(204, 204, 204));
        btnLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/books.png"))); // NOI18N
        btnLibros.setText("LIBROS");
        btnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLibrosMouseClicked(evt);
            }
        });
        pnlback.add(btnLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, -1));

        btnHistorial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(204, 204, 204));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/record.png"))); // NOI18N
        btnHistorial.setText("HISTORIAL");
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialMouseClicked(evt);
            }
        });
        pnlback.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 204, 204));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add book.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        pnlback.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        btnPrestar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrestar.setForeground(new java.awt.Color(204, 204, 204));
        btnPrestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Prestar.png"))); // NOI18N
        btnPrestar.setText("PRESTAR");
        btnPrestar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrestar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrestarMouseClicked(evt);
            }
        });
        pnlback.add(btnPrestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        indlibros.setBackground(new java.awt.Color(53, 58, 86));

        javax.swing.GroupLayout indlibrosLayout = new javax.swing.GroupLayout(indlibros);
        indlibros.setLayout(indlibrosLayout);
        indlibrosLayout.setHorizontalGroup(
            indlibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        indlibrosLayout.setVerticalGroup(
            indlibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        pnlback.add(indlibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 10, -1));

        indagregar.setBackground(new java.awt.Color(53, 58, 86));

        javax.swing.GroupLayout indagregarLayout = new javax.swing.GroupLayout(indagregar);
        indagregar.setLayout(indagregarLayout);
        indagregarLayout.setHorizontalGroup(
            indagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        indagregarLayout.setVerticalGroup(
            indagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        pnlback.add(indagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 10, -1));

        indprestar.setBackground(new java.awt.Color(53, 58, 86));

        javax.swing.GroupLayout indprestarLayout = new javax.swing.GroupLayout(indprestar);
        indprestar.setLayout(indprestarLayout);
        indprestarLayout.setHorizontalGroup(
            indprestarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        indprestarLayout.setVerticalGroup(
            indprestarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        pnlback.add(indprestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 10, -1));

        indhistorial.setBackground(new java.awt.Color(53, 58, 86));

        javax.swing.GroupLayout indhistorialLayout = new javax.swing.GroupLayout(indhistorial);
        indhistorial.setLayout(indhistorialLayout);
        indhistorialLayout.setHorizontalGroup(
            indhistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        indhistorialLayout.setVerticalGroup(
            indhistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        pnlback.add(indhistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 10, -1));

        pnlPrincipal.add(pnlback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        pnlOpciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlOpciones.setLayout(new java.awt.CardLayout());

        pnlLibros.setBackground(new java.awt.Color(255, 255, 255));
        pnlLibros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbfiltrar.setBackground(new java.awt.Color(204, 204, 204));
        cbfiltrar.setForeground(new java.awt.Color(0, 0, 0));
        cbfiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar.", "Historia", "Arte", "Tecnología y Entretenimiento" }));
        cbfiltrar.setAutoscrolls(true);
        cbfiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbfiltrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbfiltrarItemStateChanged(evt);
            }
        });
        pnlLibros.add(cbfiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 160, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(53, 58, 86));
        jLabel5.setText("LIBROS");
        pnlLibros.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 18, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "NOMBRE", "AUTOR", "CATEGORIA", "EDITORIAL", "AÑO", "CANTIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setFocusable(false);
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        pnlLibros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 652, 290));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(53, 58, 86));
        jLabel11.setText("Total:");
        pnlLibros.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        txtcontador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcontador.setForeground(new java.awt.Color(232, 57, 95));
        txtcontador.setText("0");
        pnlLibros.add(txtcontador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 36, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(53, 58, 86));
        jLabel17.setText("Arte");
        pnlLibros.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        txtarte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtarte.setForeground(new java.awt.Color(232, 57, 95));
        txtarte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtarte.setText("0");
        pnlLibros.add(txtarte, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 36, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(53, 58, 86));
        jLabel19.setText("Entretenimiento");
        pnlLibros.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(53, 58, 86));
        jLabel20.setText("Historia");
        pnlLibros.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        txthistoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txthistoria.setForeground(new java.awt.Color(232, 57, 95));
        txthistoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txthistoria.setText("0");
        pnlLibros.add(txthistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 36, -1));

        txtentretinimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtentretinimiento.setForeground(new java.awt.Color(232, 57, 95));
        txtentretinimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtentretinimiento.setText("0");
        pnlLibros.add(txtentretinimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 36, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(53, 58, 86));
        jLabel28.setText("Tecnología ");
        pnlLibros.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        txttecnologia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txttecnologia.setForeground(new java.awt.Color(232, 57, 95));
        txttecnologia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttecnologia.setText("0");
        pnlLibros.add(txttecnologia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 36, -1));

        calcularmayor.setText("Categoria con mayor libros");
        calcularmayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularmayorActionPerformed(evt);
            }
        });
        pnlLibros.add(calcularmayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, -1));

        pnlOpciones.add(pnlLibros, "card2");

        pnlAgregar.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("AGREGAR");
        pnlAgregar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 18, -1, -1));

        txtisbn.setBackground(new java.awt.Color(255, 255, 255));
        txtisbn.setBorder(null);
        txtisbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtisbnKeyTyped(evt);
            }
        });
        pnlAgregar.add(txtisbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 130, 20));

        jSeparator1.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlAgregar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, 10));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(53, 58, 86));
        jLabel9.setText("ISBN:");
        pnlAgregar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnagregarMouseClicked(evt);
            }
        });
        pnlAgregar.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 50, 50));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(53, 58, 86));
        jLabel10.setText("NOMBRE:");
        pnlAgregar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setBorder(null);
        pnlAgregar.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 130, 20));

        jSeparator2.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlAgregar.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 130, 10));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(53, 58, 86));
        jLabel12.setText("CATEGORIA:");
        pnlAgregar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txtautor.setBackground(new java.awt.Color(255, 255, 255));
        txtautor.setBorder(null);
        pnlAgregar.add(txtautor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 130, 20));

        jSeparator3.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlAgregar.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, 10));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(53, 58, 86));
        jLabel13.setText("AUTOR:");
        pnlAgregar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        cbcategoria.setBackground(new java.awt.Color(255, 255, 255));
        cbcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione.", "Historia", "Arte", "Tecnología", "Entretenimiento" }));
        pnlAgregar.add(cbcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 160, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(53, 58, 86));
        jLabel14.setText("EDITORIAL:");
        pnlAgregar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        txteditorial.setBackground(new java.awt.Color(255, 255, 255));
        txteditorial.setBorder(null);
        pnlAgregar.add(txteditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 130, 20));

        jSeparator4.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlAgregar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 130, 10));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(53, 58, 86));
        jLabel15.setText("AÑO:");
        pnlAgregar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        txtano.setBackground(new java.awt.Color(255, 255, 255));
        txtano.setBorder(null);
        pnlAgregar.add(txtano, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 130, 20));

        jSeparator5.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlAgregar.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 130, 10));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(53, 58, 86));
        jLabel25.setText("CANTIDAD:");
        pnlAgregar.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        txtcantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtcantidad.setBorder(null);
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        pnlAgregar.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 130, 20));

        jSeparator15.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlAgregar.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 130, 10));

        pnlOpciones.add(pnlAgregar, "card3");

        pnlPrestar.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrestar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(53, 58, 86));
        jLabel7.setText("PRESTAR");
        pnlPrestar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 18, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(53, 58, 86));
        jLabel16.setText("ISBN:");
        pnlPrestar.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        txtisbnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtisbnbuscar.setBorder(null);
        txtisbnbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtisbnbuscarKeyTyped(evt);
            }
        });
        pnlPrestar.add(txtisbnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 130, 20));

        jSeparator6.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlPrestar.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, 10));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(53, 58, 86));
        jLabel18.setText("NOMBRE:");
        pnlPrestar.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        txtnombrebuscar.setEditable(false);
        txtnombrebuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtnombrebuscar.setBorder(null);
        pnlPrestar.add(txtnombrebuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, 20));

        jSeparator7.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlPrestar.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, 10));

        txtautorbuscar.setEditable(false);
        txtautorbuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtautorbuscar.setBorder(null);
        pnlPrestar.add(txtautorbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 130, 20));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(53, 58, 86));
        jLabel21.setText("AUTOR:");
        pnlPrestar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jSeparator8.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlPrestar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 130, 10));

        txtidpersona.setBackground(new java.awt.Color(255, 255, 255));
        txtidpersona.setBorder(null);
        pnlPrestar.add(txtidpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 130, 20));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(53, 58, 86));
        jLabel22.setText("IDENTIFICACÍON:");
        pnlPrestar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jSeparator9.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlPrestar.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 130, 10));

        btnprestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregar.png"))); // NOI18N
        btnprestar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnprestar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnprestarMouseClicked(evt);
            }
        });
        pnlPrestar.add(btnprestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 50, 50));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(53, 58, 86));
        jLabel24.setText("NOMBRE:");
        pnlPrestar.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        txtnombrepersona.setBackground(new java.awt.Color(255, 255, 255));
        txtnombrepersona.setBorder(null);
        pnlPrestar.add(txtnombrepersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 130, 20));

        jSeparator10.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlPrestar.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 130, 10));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(53, 58, 86));
        jLabel26.setText("DATOS DE LA PERSONA:");
        pnlPrestar.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));
        pnlPrestar.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, -1));

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/findbook.png"))); // NOI18N
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscarMouseClicked(evt);
            }
        });
        pnlPrestar.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 60, 50));

        txtfecha.setEditable(false);
        txtfecha.setBackground(new java.awt.Color(255, 255, 255));
        txtfecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfecha.setBorder(null);
        pnlPrestar.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 130, 20));

        jSeparator13.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlPrestar.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 130, 10));

        cboperacion.setBackground(new java.awt.Color(204, 204, 204));
        cboperacion.setForeground(new java.awt.Color(0, 0, 0));
        cboperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operacion.", "Prestamo", "Devolución" }));
        cboperacion.setAutoscrolls(true);
        cboperacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboperacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboperacionItemStateChanged(evt);
            }
        });
        pnlPrestar.add(cboperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 160, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(53, 58, 86));
        jLabel27.setText("CANTIDAD:");
        pnlPrestar.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        txtcantidaprestar.setEditable(false);
        txtcantidaprestar.setBackground(new java.awt.Color(255, 255, 255));
        txtcantidaprestar.setBorder(null);
        pnlPrestar.add(txtcantidaprestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 130, 20));

        jSeparator16.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlPrestar.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 130, 10));

        pnlOpciones.add(pnlPrestar, "card4");

        pnlHistorial.setBackground(new java.awt.Color(255, 255, 255));
        pnlHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(53, 58, 86));
        jLabel8.setText("HISTORIAL");
        pnlHistorial.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 25, -1, -1));

        txtfiltro.setBackground(new java.awt.Color(255, 255, 255));
        txtfiltro.setToolTipText("BUSCAR POR ISBN");
        txtfiltro.setBorder(null);
        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfiltroKeyTyped(evt);
            }
        });
        pnlHistorial.add(txtfiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 130, 20));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(53, 58, 86));
        jLabel23.setText("ISBN:");
        pnlHistorial.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jSeparator14.setBackground(new java.awt.Color(53, 58, 86));
        jSeparator14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlHistorial.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 130, 10));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tablaprestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "NOMBRE", "ID", "CLIENTE", "OPERACION", "FECHA", "CANTIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaprestamos.setFocusable(false);
        tablaprestamos.setRowHeight(25);
        tablaprestamos.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tablaprestamos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablaprestamos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaprestamos);

        pnlHistorial.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 79, 652, 290));

        pnlOpciones.add(pnlHistorial, "card5");

        pnlPrincipal.add(pnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 740, 470));

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnsalirMouseClicked

    private void btnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLibrosMouseClicked
        GoLibros();
    }//GEN-LAST:event_btnLibrosMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        ColorSelectd(indagregar);
        PanelSelectd(pnlAgregar);
        resetColor(new JPanel[]{indlibros, indprestar, indhistorial});
        resetPanel(new JPanel[]{pnlLibros, pnlHistorial, pnlPrestar});
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnPrestarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrestarMouseClicked
        ColorSelectd(indprestar);
        PanelSelectd(pnlPrestar);
        resetColor(new JPanel[]{indlibros, indagregar, indhistorial});
        resetPanel(new JPanel[]{pnlLibros, pnlHistorial, pnlAgregar});

        txtfecha.setText(dtf.format(LocalDateTime.now()));
    }//GEN-LAST:event_btnPrestarMouseClicked

    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked
        ColorSelectd(indhistorial);
        PanelSelectd(pnlHistorial);
        resetColor(new JPanel[]{indlibros, indprestar, indagregar});
        resetPanel(new JPanel[]{pnlLibros, pnlAgregar, pnlPrestar});

        try {
            AddtablaHistorial();
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_btnHistorialMouseClicked

    private void btnagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarMouseClicked
        try {
            Libro lib = new Libro();
            String isbn = txtisbn.getText();
            lib.setIsbn(isbn);
            String nom = txtnombre.getText();
            lib.setNombre(nom);
            String Aut = txtautor.getText();
            lib.setAutor(Aut);
            String cat = cbcategoria.getSelectedItem().toString();
            lib.setCategoria(cat);
            String edi = txteditorial.getText();
            lib.setEditorial(edi);
            int ano = Integer.parseInt(txtano.getText());
            lib.setPublicacion(ano);
            int cant = Integer.parseInt(txtcantidad.getText());
            lib.setCantidad(cant);

            if (cat.equals("Seleccione.")) {
                JOptionPane.showMessageDialog(rootPane, "SELECCIONE UNA CATEGORIA");
            } else {

                if (ano < 0 || ano > 2022) {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE UN AÑO DE PUBLICACIÓN VALIDO");
                } else {

                    try {
                        arch.guardarArchivo(lib);
                        LlenarTabla();
                    } catch (IOException ex) {

                    }

                    LimpiarCampos();
                    JOptionPane.showMessageDialog(rootPane, "¡LIBRO AGREGADO CON EXITO!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE TODOS LOS DATOS DEL LIBRO");
        }

    }//GEN-LAST:event_btnagregarMouseClicked

    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        try {

            String ibsn = txtisbnbuscar.getText();
            buscarLibro(arch.getRutaArchivo(), ibsn);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE EL ISBN DEL LIBRO");
        }
    }//GEN-LAST:event_btnbuscarMouseClicked

    private void cbfiltrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbfiltrarItemStateChanged
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        String query = cbfiltrar.getSelectedItem().toString();

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tabla.setRowSorter(tr);

        if (!"Filtrar.".equals(query)) {
            tr.setRowFilter(RowFilter.regexFilter(query));

        } else {

            tabla.setRowSorter(tr);
        }
    }//GEN-LAST:event_cbfiltrarItemStateChanged


    private void btnprestarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprestarMouseClicked

        try {
            ArchivoHistorial hist = new ArchivoHistorial();
            Nodo no = new Nodo();
            DeclararCola cola = new DeclararCola();

            String isbn = txtisbnbuscar.getText();
            no.setIsbn(isbn);
            String libro = txtnombrebuscar.getText();
            no.setNombrelibro(libro);
            int id = Integer.parseInt(txtidpersona.getText());
            no.setId(id);
            String nombre = txtnombrepersona.getText();
            no.setNombreuser(nombre);
            String operacion = cboperacion.getSelectedItem().toString();
            no.setOperacion(operacion);
            String fecha = txtfecha.getText();
            no.setFecha(fecha);
            int cant = Integer.parseInt(txtcantidaprestar.getText());
            no.setCantidad(cant);
                    

            if (!operacion.equals("Operacion.")) {

                if (operacion.equals("Prestamo")) {

                    cola.agregar(no.getIsbn(), no.getNombrelibro(), no.getNombreuser(), no.getId(), no.getOperacion(), no.getFecha(), no.getCantidad()-1);
                    hist.guardarArchivo(isbn, libro, nombre, id, operacion, fecha, cant-1);
                    LimpiarCamps();
                    JOptionPane.showMessageDialog(rootPane, "¡LIBRO PRESTADO CON EXITO!");

                } else if ( operacion.equals("Devolución")) {
                    cola.agregar(no.getIsbn(), no.getNombrelibro(), no.getNombreuser(), no.getId(), no.getOperacion(), no.getFecha(), no.getCantidad()+1);
                    hist.guardarArchivo(isbn, libro, nombre, id, operacion, fecha, cant);
                    LimpiarCamps();
                    JOptionPane.showMessageDialog(rootPane, "¡LIBRO DEVUELTO CON EXITO!");

                } else {

                    JOptionPane.showMessageDialog(rootPane, "¡LIBRO NO DISPONIBLE PARA ESTA OPERACION!");
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "¡SELECCIONE UNA OPERACION!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE TODOS LOS DATOS");
        }

    }//GEN-LAST:event_btnprestarMouseClicked

    private void cboperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboperacionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboperacionItemStateChanged

    private void txtfiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtfiltro.getText().trim().length() == 13) {
            evt.consume();
        }

        DefaultTableModel model = (DefaultTableModel) tablaprestamos.getModel();

        String query = txtfiltro.getText();

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tablaprestamos.setRowSorter(tr);

        if (!"Filtrar.".equals(query)) {
            tr.setRowFilter(RowFilter.regexFilter(query));

        } else {

            tabla.setRowSorter(tr);
        }
    }//GEN-LAST:event_txtfiltroKeyTyped

    private void txtisbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtisbnKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtisbn.getText().trim().length() == 13) {
            evt.consume();
        }
    }//GEN-LAST:event_txtisbnKeyTyped

    private void txtisbnbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtisbnbuscarKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtisbnbuscar.getText().trim().length() == 13) {
            evt.consume();
        }
    }//GEN-LAST:event_txtisbnbuscarKeyTyped

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void calcularmayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularmayorActionPerformed
        int arte = Integer.parseInt(txtarte.getText());
        int historia = Integer.parseInt(txthistoria.getText());
        int entretenimiento  = Integer.parseInt(txtentretinimiento.getText());
        int tecnologia = Integer.parseInt(txttecnologia.getText());
        
       String mensaje = "";
      if (arte > historia && arte > entretenimiento && arte>tecnologia){
      mensaje = "La categoria con mayor numero de libros es: Arte con "+arte+ " Libros";
      }else if (historia > arte && historia > entretenimiento && historia>tecnologia){
      mensaje = "La categoria con mayor numero de libros es: Historia con "+historia+ " Libros";
      }else if (entretenimiento > historia && entretenimiento > arte && entretenimiento>tecnologia){
      mensaje = "La categoria con mayor numero de libros es: Entretenimiento con "+entretenimiento+ " Libros";
      }else if (tecnologia > historia && entretenimiento > entretenimiento && entretenimiento>arte){
      mensaje = "La categoria con mayor numero de libros es: Tecnología con "+tecnologia+ " Libros";
      }else {
      mensaje = "Hay 2 categorias o mas con el mismo numero de libros";
      }
      JOptionPane.showMessageDialog(rootPane, mensaje);
    }//GEN-LAST:event_calcularmayorActionPerformed

    private void GoLibros() {
        ColorSelectd(indlibros);
        PanelSelectd(pnlLibros);
        resetColor(new JPanel[]{indagregar, indprestar, indhistorial});
        resetPanel(new JPanel[]{pnlAgregar, pnlHistorial, pnlPrestar});

        try {
            LlenarTabla();
        } catch (IOException ex) {
        }

    }

    public void AddtablaHistorial() throws IOException {

        try {
            DefaultTableModel model = (DefaultTableModel) tablaprestamos.getModel();
            model.setRowCount(0);
            Nodo no;
            int cont = 0;
            String linea = null;
            FileReader fichero = new FileReader("Historial.txt");
            BufferedReader leer = new BufferedReader(fichero);
            while ((linea = leer.readLine()) != null) {
                StringTokenizer campo = new StringTokenizer(linea, "\t");
                String isbn = campo.nextToken().trim();
                String libro = campo.nextToken().trim();
                String nombre = campo.nextToken().trim();
                String ide = campo.nextToken().trim();
                String op = campo.nextToken().trim();
                String fecha = campo.nextToken().trim();
                String cant = campo.nextToken().trim();
                no = new Nodo();
                no.setIsbn(isbn);
                no.setNombrelibro(libro);
                no.setNombreuser(nombre);
                no.setId(Integer.parseInt(ide));
                no.setOperacion(op);
                no.setFecha(fecha);
                no.setCantidad(Integer.parseInt(cant));
                

                addtotableprestamos(no.getIsbn(), no.getNombrelibro(), no.getId(), no.getNombreuser(), no.getOperacion(), fecha, no.getCantidad());
            }
            leer.close();
        } catch (Exception e) {

        }
    }

    public void addtotableprestamos(String isbn, String libro, int id, String nombre, String op, String fecha, int cant) {

        DefaultTableModel model = (DefaultTableModel) tablaprestamos.getModel();
        Object[] fila = new Object[7];
        fila[0] = isbn;
        fila[1] = libro;
        fila[2] = id;
        fila[3] = nombre;
        fila[4] = op;
        fila[5] = fecha;
        fila[6] = cant;
        model.addRow(fila);
    }

    private void ColorSelectd(JPanel J) {
        J.setBackground(new java.awt.Color(204, 204, 204));
    }

    private void resetColor(JPanel[] indicators) {

        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackground(new java.awt.Color(53, 58, 86));
        }
    }

    private void PanelSelectd(JPanel J) {
        J.setVisible(true);
    }

    private void resetPanel(JPanel[] indicators) {

        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setVisible(false);
        }
    }

    public void estiloTabla() {
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabla.getTableHeader().setOpaque(false);
        tabla.getTableHeader().setBackground(new Color(53, 58, 86));
        tabla.getTableHeader().setForeground(new Color(255, 255, 255));
        tabla.setRowHeight(25);
    }

    public void estiloTabla2() {
        tablaprestamos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaprestamos.getTableHeader().setOpaque(false);
        tablaprestamos.getTableHeader().setBackground(new Color(53, 58, 86));
        tablaprestamos.getTableHeader().setForeground(new Color(255, 255, 255));
        tablaprestamos.setRowHeight(25);
    }

    public void LimpiarCampos() {
        txtisbn.setText("");
        txtnombre.setText("");
        txtautor.setText("");
        txteditorial.setText("");
        txtano.setText("");
        txtcantidad.setText("");
   }

    public void LimpiarCamps() {
        txtisbnbuscar.setText("");
        txtnombrebuscar.setText("");
        txtautorbuscar.setText("");
        txtnombrepersona.setText("");
        txtidpersona.setText("");
        txtcantidaprestar.setText("");
    }

    public void buscarLibro(String rutaArchivo, String code) throws FileNotFoundException, IOException {
        String linea = null;
        Libro lib;
        txtnombrebuscar.setText("");
        txtautorbuscar.setText("");
        txtcantidaprestar.setText("");
        boolean encontrado = false;
        FileReader fichero = new FileReader("Libros.txt");
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "\t");
            String isbn = campo.nextToken().trim();
            String nom = campo.nextToken().trim();
            String aut = campo.nextToken().trim();
            String cat = campo.nextToken().trim();
            String edi = campo.nextToken().trim();
            String pub = campo.nextToken().trim();
            String cant = campo.nextToken().trim();
            lib = new Libro();
            lib.setIsbn(isbn);
            lib.setNombre(nom);
            lib.setAutor(aut);
            lib.setCategoria(cat);
            lib.setEditorial(edi);
            lib.setPublicacion(Integer.parseInt(pub));
            lib.setCantidad(Integer.parseInt(cant));

            if (lib.getIsbn().equals(code)) {
                encontrado = true;
                txtnombrebuscar.setText(lib.getNombre());
                txtautorbuscar.setText(lib.getAutor());
                txtcantidaprestar.setText(String.valueOf(lib.getCantidad()));
            }

        }
        leer.close();

        if (encontrado == true) {
            JOptionPane.showMessageDialog(rootPane, "LIBRO ENCONTRADO");
        } else {
            JOptionPane.showMessageDialog(rootPane, "LIBRO NO ENCONTRADO");
        }
    }
    
    public static void main(String args[]) {
        try {
            
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ventana().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnHistorial;
    private javax.swing.JLabel btnLibros;
    private javax.swing.JLabel btnPrestar;
    private javax.swing.JLabel btnagregar;
    private javax.swing.JLabel btnbuscar;
    private javax.swing.JLabel btnprestar;
    private javax.swing.JLabel btnsalir;
    private javax.swing.JButton calcularmayor;
    private javax.swing.JComboBox<String> cbcategoria;
    private javax.swing.JComboBox<String> cbfiltrar;
    private javax.swing.JComboBox<String> cboperacion;
    private javax.swing.JPanel indagregar;
    private javax.swing.JPanel indhistorial;
    private javax.swing.JPanel indlibros;
    private javax.swing.JPanel indprestar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel pnlAgregar;
    private javax.swing.JPanel pnlHistorial;
    private javax.swing.JPanel pnlLibros;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlPrestar;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlback;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaprestamos;
    private javax.swing.JTextField txtano;
    private javax.swing.JLabel txtarte;
    private javax.swing.JTextField txtautor;
    private javax.swing.JTextField txtautorbuscar;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcantidaprestar;
    private javax.swing.JLabel txtcontador;
    private javax.swing.JTextField txteditorial;
    private javax.swing.JLabel txtentretinimiento;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtfiltro;
    private javax.swing.JLabel txthistoria;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtisbnbuscar;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombrebuscar;
    private javax.swing.JTextField txtnombrepersona;
    private javax.swing.JLabel txttecnologia;
    // End of variables declaration//GEN-END:variables
}
