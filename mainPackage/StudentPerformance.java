/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class StudentPerformance extends javax.swing.JFrame {

    /**
     * Creates new form StudentPerformance
     */
    
    private static final String HOST = "jdbc:derby://localhost:1527/SportsAcademy";
    private static final String USERNAME = "mydb";
    private static final String PASSWORD = "admin";
    private static boolean invalid = true;
    private String admin;
    
    public StudentPerformance() {
        initComponents();
        this.setLocationRelativeTo(null);
        hidden.setVisible(false);
        hidden2.setVisible(false);
        clearData();
        adminname.setText("Error in loading your name!!!");
        invalid = true;
    }

    public StudentPerformance(String adminName) {
        this();
        invalid = false;
        admin = adminName;
        adminname.setText("Hi, "+admin+"!");
        getData();
    }
    
    private void clearData() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
    }
    
    private void getData() {
        clearData();//Clear the table befor rendering new data
        if(invalid) {
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            try{
                Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM performance";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    model.addRow(new Object[]{rs.getString("regno"), rs.getString("sport"), rs.getString("trainer_name"), rs.getString("trainer_contact"), rs.getInt("fees"), rs.getString("grade")});
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void Clear() {
        getData();
        
        regno.setText(null);
        sport.setSelectedItem(null);
        trainerList.removeAllItems();
        trainerContact.setText(null);
        feesSport.setText(null);
        hidden.setText(null);
        hidden2.setText(null);
        
        regnoerror.setText("*");
        regnoerror.setForeground(Color.red);
        sporterror.setText("*");
        sporterror.setForeground(Color.red);
        trainernameerror.setText("*");
        trainernameerror.setForeground(Color.red);
        trainercontacterror.setText("*");
        trainercontacterror.setForeground(Color.red);
        feessporterror.setText("*");
        feessporterror.setForeground(Color.red);
    }
    
    private boolean Validated() {
        boolean x = true;
        if((regno.getText()).equals("")) {
            regnoerror.setText("* Required");
            regnoerror.setForeground(Color.red);
            x = false;
        } else {
            regnoerror.setText("* Correct");
            regnoerror.setForeground(Color.green);
        }
        
        if(sport.getSelectedItem()==null || (sport.getSelectedItem().toString()).equals("")) {
            sporterror.setText("* Required");
            sporterror.setForeground(Color.red);
            x = false;
        } else {
            sporterror.setText("* Correct");
            sporterror.setForeground(Color.green);
        }
        
        if(trainerList.getSelectedItem()==null || (trainerList.getSelectedItem().toString()).equals("")) {
            trainernameerror.setText("* Required");
            trainernameerror.setForeground(Color.red);
            x = false;
        } else {
            trainernameerror.setText("* Correct");
            trainernameerror.setForeground(Color.green);
        }
        
        if(!trainerContact.getText().equals("")) {
            boolean numeric = true;
            Long num = 0L;
            try {
                num = Long.parseLong(trainerContact.getText());
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if(!numeric) {
                trainercontacterror.setText("* Digit Only");
                trainercontacterror.setForeground(Color.red);
                x = false;
            } else if(num<1000000000L || num>9999999999L) {
                trainercontacterror.setText("* 10-digit");
                trainercontacterror.setForeground(Color.red);
                x = false;
            } else {
                trainercontacterror.setText("* Correct");
                trainercontacterror.setForeground(Color.green);
            }
        } else {
            trainercontacterror.setText("* Required");
            trainercontacterror.setForeground(Color.red);
            x = false;
        }
        
        if(!feesSport.getText().equals("")) {
            boolean numeric = true;
            int num = 0;
            try {
                num = Integer.parseInt(feesSport.getText());
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if(!numeric) {
                feessporterror.setText("* Digit Only");
                feessporterror.setForeground(Color.red);
                x = false;
            } else if(num<1000) {
                feessporterror.setText("*min Rs1000");
                feessporterror.setForeground(Color.red);
                x = false;
            }  else if(num>100000) {
                feessporterror.setText("*max Rs1Lakh");
                feessporterror.setForeground(Color.red);
                x = false;
            } else {
                feessporterror.setText("* Correct");
                feessporterror.setForeground(Color.green);
            }
        } else {
            feessporterror.setText("* Required");
            feessporterror.setForeground(Color.red);
        }
        
        return x;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        adminname = new javax.swing.JLabel();
        addUpdateStudent = new javax.swing.JButton();
        addUpdateTrainer = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        regno = new javax.swing.JTextField();
        feesSport = new javax.swing.JTextField();
        sporterror = new javax.swing.JLabel();
        regnoerror = new javax.swing.JLabel();
        trainercontacterror = new javax.swing.JLabel();
        feessporterror = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        update = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        hidden = new javax.swing.JLabel();
        trainerList = new javax.swing.JComboBox<>();
        trainernameerror = new javax.swing.JLabel();
        sport = new javax.swing.JComboBox<>();
        hidden2 = new javax.swing.JLabel();
        trainerContact = new javax.swing.JLabel();

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TrainerId");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "RegNo", "Sport", "Trainer", "Contact", "Fees", "Grade"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(">>||ENTER STUDENT ENROLLMENT DETAILS");

        adminname.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        adminname.setForeground(new java.awt.Color(102, 0, 0));
        adminname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminname.setText("Hi, Admin!                                               ");

        addUpdateStudent.setText("Add/Update Student");
        addUpdateStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateStudentActionPerformed(evt);
            }
        });

        addUpdateTrainer.setText("Add/Update Trainer");
        addUpdateTrainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUpdateTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateTrainerActionPerformed(evt);
            }
        });

        logout.setText("LogOut");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Reg. No.");

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Sport");

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Trainer");

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Contact");

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fees");

        sporterror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        sporterror.setForeground(new java.awt.Color(255, 0, 51));
        sporterror.setText("*");

        regnoerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        regnoerror.setForeground(new java.awt.Color(255, 0, 51));
        regnoerror.setText("*");

        trainercontacterror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        trainercontacterror.setForeground(new java.awt.Color(255, 0, 51));
        trainercontacterror.setText("*");

        feessporterror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        feessporterror.setForeground(new java.awt.Color(255, 0, 51));
        feessporterror.setText("*");

        reset.setText("Reset");
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        delete.setText("Delete Selected Record");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        trainerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerListActionPerformed(evt);
            }
        });

        trainernameerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        trainernameerror.setForeground(new java.awt.Color(255, 0, 51));
        trainernameerror.setText("*");

        sport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cricket", "Football", "TableTennis", "Chess", "Tennis", "Hockey" }));
        sport.setSelectedIndex(-1);
        sport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportActionPerformed(evt);
            }
        });

        trainerContact.setBackground(new java.awt.Color(255, 255, 255));
        trainerContact.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addUpdateTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(feesSport, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(feessporterror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(regno, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(regnoerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(trainerList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sport, 0, 241, Short.MAX_VALUE)
                                            .addComponent(trainerContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(trainercontacterror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sporterror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(trainernameerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hidden2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hidden, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUpdateTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(regno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regnoerror))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(sporterror))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(sport, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(trainerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trainernameerror))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(trainercontacterror)
                            .addComponent(trainerContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(feesSport, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(feessporterror))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset)
                            .addComponent(submit))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update)
                            .addComponent(delete))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hidden, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hidden2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_resetActionPerformed

    
    
    private void sportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportActionPerformed
        // TODO add your handling code here:
        try {
            String selected_sport = sport.getSelectedItem().toString();
            trainerList.removeAllItems();
            if(selected_sport.length()>0) {
                try{
                    Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                    Statement stmt = con.createStatement();
                    String query = "SELECT trainerid, name, contact FROM trainer WHERE sport = '"+selected_sport+"'";
                    stmt.execute(query);
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()) {
                        trainerList.addItem(rs.getString("trainerid")+"-"+rs.getString("name"));
                    }

                    query = "SELECT fees FROM fee WHERE sport = '"+selected_sport+"'";
                    stmt.execute(query);
                    rs = stmt.executeQuery(query);
                    while(rs.next()) {
                        feesSport.setText(rs.getString("fees"));
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details...");
            }
        } catch(NullPointerException e) {
            trainerList.removeAll();
        }
    }//GEN-LAST:event_sportActionPerformed

    
    
    
    private void trainerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerListActionPerformed
        // TODO add your handling code here:
        try {
            String selected_trainer = trainerList.getSelectedItem().toString();
            if(selected_trainer.length()>0) {
                try{
                    Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                    Statement stmt = con.createStatement();
                    String query = "SELECT contact FROM trainer WHERE trainerid = '"+selected_trainer.split("-")[0]+"'";
                    stmt.execute(query);
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()) {
                        trainerContact.setText(rs.getString("contact"));
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details...");
            }
        } catch(NullPointerException e) {
            trainerList.removeAll();
        }
    }//GEN-LAST:event_trainerListActionPerformed

    
    
    
    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int rowIndex = table1.getSelectedRow();
        regno.setText(model.getValueAt(rowIndex, 0).toString());
            hidden.setText(model.getValueAt(rowIndex, 0).toString());
        sport.setSelectedItem(model.getValueAt(rowIndex, 1).toString());
            hidden2.setText(model.getValueAt(rowIndex, 1).toString());
        trainerList.setSelectedItem(model.getValueAt(rowIndex, 2).toString());
        trainerContact.setText(model.getValueAt(rowIndex, 3).toString());
        feesSport.setText(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_table1MouseClicked

    
    
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        if(!invalid && Validated()) {
            try{
                Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = con.createStatement();
                String query = "INSERT INTO performance(regno,sport,trainer_name,trainer_contact,fees) VALUES('"+regno.getText()+"','"+sport.getSelectedItem().toString()+"','"+trainerList.getSelectedItem().toString()+"','"+trainerContact.getText()+"',"+Integer.parseInt(feesSport.getText())+")";
                stmt.execute(query);
                hidden.setText(regno.getText());
                hidden2.setText(sport.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Form data submitted Successfully adding new entry for:\nRegistration No:"+hidden.getText()+"\nSport:"+hidden.getText());
                Clear();
            }
            catch(SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Cannot sumbit two records with same Registration No and Sport.\n\t\tOR\nNo such student exists....");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid details...\nAnd(OR) Enter using right path...");
        }
    }//GEN-LAST:event_submitActionPerformed

    
    
    
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if(!invalid && Validated() && !(hidden.getText().equals("")) && !(hidden2.getText().equals(""))) {
            try {
                Connection conn = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = conn.createStatement();
                System.out.println("RegNo: "+regno.getText());
                System.out.println("Sport: "+sport.getSelectedItem().toString());
                System.out.println("Trainer: "+trainerList.getSelectedItem().toString());
                System.out.println("Contact: "+trainerContact.getText());
                System.out.println("Fees: "+Integer.parseInt(feesSport.getText()));
                System.out.println("Hidden: "+hidden.getText());
                System.out.println("Hidden2: "+hidden2.getText());
                
                String query = "UPDATE performance SET regno='"+regno.getText()+"',sport='"+sport.getSelectedItem().toString()+"',trainer_name='"+trainerList.getSelectedItem().toString()+"',trainer_contact='"+trainerContact.getText()+"',fees="+Integer.parseInt(feesSport.getText())+" WHERE regno='"+hidden.getText()+"' AND sport = '"+hidden2.getText()+"'";
                stmt.execute(query);
                String RNO = regno.getText();
                String SPORT = sport.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null, "Form data updated Successfully for:\nOld RegNo - "+hidden.getText()+"\nNew RegNo - "+RNO+"\nOld SPORT - "+hidden2.getText()+"\nNew SPORT - "+SPORT);
                Clear();
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid details...\n\t\tOR\nTrying to update entry which does not exists...");
        }
    }//GEN-LAST:event_updateActionPerformed

    
    
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete the selected record...");
        try {
            if(x==0 && !(hidden.getText().equals("")) && !(hidden2.getText().equals(""))) {
                try{
                    Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                    Statement stmt = con.createStatement();
                    String query = "DELETE FROM performance WHERE regno='"+hidden.getText()+"' AND sport = '"+hidden2.getText()+"'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null, "Selected row deleted Successfully...\nDeleted RNO - "+hidden.getText()+"\nDeleted SPORT - "+hidden2.getText());
                    Clear();
                    
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
                }
            } else if(x==0 && (hidden.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Trying to delete entry which does not exists...");
            } else {
                JOptionPane.showMessageDialog(null, "No record was deleted.");
            }
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No record was deleted.\nPlease select the record to be deleted.");
        }
    }//GEN-LAST:event_deleteActionPerformed

    
    
    
    private void addUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateStudentActionPerformed
        // TODO add your handling code here:
        AddStudent student = new AddStudent(admin);
        Clear();
        this.dispose();
        student.setVisible(true);
    }//GEN-LAST:event_addUpdateStudentActionPerformed

    
    
    
    private void addUpdateTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateTrainerActionPerformed
        // TODO add your handling code here:
        AddTrainer trainer = new AddTrainer(admin);
        Clear();
        this.dispose();
        trainer.setVisible(true);
    }//GEN-LAST:event_addUpdateTrainerActionPerformed

    
    
    
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        LandingPage loggedout = new LandingPage("admin");
        Clear();
        this.dispose();
        loggedout.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(StudentPerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPerformance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUpdateStudent;
    private javax.swing.JButton addUpdateTrainer;
    private javax.swing.JLabel adminname;
    private javax.swing.JButton delete;
    private javax.swing.JTextField feesSport;
    private javax.swing.JLabel feessporterror;
    private javax.swing.JLabel hidden;
    private javax.swing.JLabel hidden2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTextField regno;
    private javax.swing.JLabel regnoerror;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<String> sport;
    private javax.swing.JLabel sporterror;
    private javax.swing.JButton submit;
    private javax.swing.JTable table1;
    private javax.swing.JLabel trainerContact;
    private javax.swing.JComboBox<String> trainerList;
    private javax.swing.JLabel trainercontacterror;
    private javax.swing.JLabel trainernameerror;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
