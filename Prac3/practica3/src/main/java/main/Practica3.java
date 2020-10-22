package main;

import javax.swing.JOptionPane;

public class Practica3 extends javax.swing.JFrame {

    private final int[][] matriz = new int[10][10]; 
    private int minimo;
    private int maximo;
    private int corte;
    private int rangeMajor;
    private int rangeMinor;
    
    public Practica3() {
        initComponents();
        actualizarDatos();
        rangeMajor=5;
        rangeMinor=1;
        
        updateTicks();
        barra.setPaintTicks(true);
        barra.setPaintLabels(true);
    }

    private void rellenarMatriz(int min, int max){
        for(int i=0;i<10;i++){
            for(int a=0;a<10;a++){
                matriz[i][a] = (int)((Math.random()*(max-min))+min);
            }
        }
    }
    
    private void mostrarDatos(){
        ventanaMatriz.setText(matrizToString());
        campoMinimo.setText(minimo+"");
        campoMaximo.setText(maximo+"");
        valorBarra.setText(barra.getValue()+"");       
    }
    
    private void actualizarDatos(){
        if(!campoMinimo.getText().equals("") && !campoMaximo.getText().equals("")){
            if(!campoMinimo.getText().equals("-")&& !campoMaximo.getText().equals("-")){
                try{
                int min = Integer.parseInt(campoMinimo.getText());
                int max = Integer.parseInt(campoMaximo.getText());

                if(min>max){
                    JOptionPane.showMessageDialog(this,"El número minimo no puede se mayor que el maximo"
                                                        ,"Alert",JOptionPane.ERROR_MESSAGE);
                }else if(max-min>10000){
                    JOptionPane.showMessageDialog(this,"El rango de valores no puede superior a 10000 para\nevitar problemas de rendimiento"
                                                        ,"Alert",JOptionPane.ERROR_MESSAGE);
                }else{
                    minimo=min;
                    maximo=max;
                    barra.setMinimum(minimo);
                    barra.setMaximum(maximo);                   
                    barra.setValue(minimo);
                    rellenarMatriz(minimo, maximo+1);
                }    
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(this,"Introducir solo números","Alert",JOptionPane.ERROR_MESSAGE);
                }
                mostrarDatos();
            }
        }
    }
   
    private String matrizToString(){
        StringBuilder result = new StringBuilder();
        StringBuilder max = new StringBuilder();
        if(maximo>(-1*minimo)){
            max.append(maximo);
        }else{
            max.append(minimo);
        }
        
        for(int i=0;i<10;i++){
            for(int a=0;a<10;a++){
                result.append("   |   ").append(normalizarNumero(matriz[i][a],max));
            }
            result.append("   |\n");
        }
        return result.toString();
    }
      
    private String normalizarNumero(int num, StringBuilder max){
        StringBuilder numero = new StringBuilder();
        if(num>corte){
            if(num<0){
                StringBuilder numeroAux = new StringBuilder();
                numeroAux.append(num);
                numero.append(" -");
                for(int i=numeroAux.length();i<max.length();i++){
                    numero.insert(2,"0");
                }
                numero.append((num*-1));
            }else{
                numero.append(num);      
                for(int i=numero.length();i<max.length();i++){
                    numero.insert(0,"0");
                }
            }
        }else{
            for(int i=0;i<max.length();i++){              
                numero.append("- ");
            }
        }    
        return numero.toString();
    }
    
    private void updateTicks(){
        barra.setLabelTable(null);
        if((maximo-minimo)>=200){
            
            int diezTicks = (int)((maximo-minimo)/10);
            int majorTicks = diezTicks-diezTicks%5;
            
            barra.setMajorTickSpacing(majorTicks);
            barra.setMinorTickSpacing(majorTicks/5);
        }else if((maximo-minimo)>20){
            barra.setMajorTickSpacing(rangeMajor*2);
            barra.setMinorTickSpacing(rangeMinor*2);
        }else{
            barra.setMajorTickSpacing(rangeMinor);
            barra.setMinorTickSpacing(rangeMinor);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiquetaMinimo = new javax.swing.JLabel();
        etiquetaMaximo = new javax.swing.JLabel();
        campoMinimo = new javax.swing.JTextField();
        campoMaximo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        barra = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventanaMatriz = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        valorBarra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración de la Matriz"));

        etiquetaMinimo.setText("Introducir valor mínimo:");

        etiquetaMaximo.setText("Introducir valor máximo:");

        campoMinimo.setText("0");
        campoMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMinimoKeyReleased(evt);
            }
        });

        campoMaximo.setText("100");
        campoMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMaximoKeyReleased(evt);
            }
        });

        jLabel1.setText("Seleccionar valor de filtrado de matriz :");

        barra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraStateChanged(evt);
            }
        });

        jLabel3.setText("Rango de valores de la matriz:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(etiquetaMinimo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaMaximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaMinimo)
                    .addComponent(campoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaMaximo)
                    .addComponent(campoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Visualización Matriz")));

        ventanaMatriz.setEditable(false);
        ventanaMatriz.setColumns(20);
        ventanaMatriz.setRows(5);
        jScrollPane1.setViewportView(ventanaMatriz);

        jLabel2.setText("Valor de filtrado actual:");

        valorBarra.setEditable(false);
        valorBarra.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(valorBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoMinimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMinimoKeyReleased
        actualizarDatos();
        updateTicks();
    }//GEN-LAST:event_campoMinimoKeyReleased

    private void campoMaximoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMaximoKeyReleased
        actualizarDatos();
        updateTicks();
    }//GEN-LAST:event_campoMaximoKeyReleased

    private void barraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
        corte=barra.getValue();
        mostrarDatos();
        
    }//GEN-LAST:event_barraStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Practica3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider barra;
    private javax.swing.JTextField campoMaximo;
    private javax.swing.JTextField campoMinimo;
    private javax.swing.JLabel etiquetaMaximo;
    private javax.swing.JLabel etiquetaMinimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField valorBarra;
    private javax.swing.JTextArea ventanaMatriz;
    // End of variables declaration//GEN-END:variables
}
