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
import java.util.regex.*;

/**
 *
 * @author acer
 */
public class AddTrainer extends javax.swing.JFrame {

    /**
     * Creates new form AddTrainer
     */
    
    private static final String HOST = "jdbc:derby://localhost:1527/SportsAcademy";
    private static final String USERNAME = "mydb";
    private static final String PASSWORD = "admin";
    private static boolean invalid = true;
    private String admin;
    
    public AddTrainer() {
        initComponents();
        this.setLocationRelativeTo(null);
        hidden.setVisible(false);
        clearData();
        adminname.setText("Error in loading your name!!!");
        invalid = true;
    }

    public AddTrainer(String adminName) {
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
                String query = "SELECT * FROM trainer";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    model.addRow(new Object[]{rs.getString("trainerid"), rs.getString("name"), rs.getString("contact"), rs.getString("address"), rs.getString("email"), rs.getString("sport")});
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void Clear() {
        getData();
        
        trainerid.setText(null);
        name.setText(null);
        contact.setText(null);
        address.setText(null);
        email.setText(null);
        sport.setSelectedItem(null);
        hidden.setText(null);
        
        traineriderror.setText("*");
        traineriderror.setForeground(Color.red);
        nameerror.setText("*");
        nameerror.setForeground(Color.red);
        contacterror.setText("*");
        contacterror.setForeground(Color.red);
        addresserror.setText("*");
        addresserror.setForeground(Color.red);
        emailerror.setText("*");
        emailerror.setForeground(Color.red);
        sporterror.setText("*");
        sporterror.setForeground(Color.red);
    }
    
    private boolean Validated() {
        boolean x = true;
        if((trainerid.getText()).equals("")) {
            traineriderror.setText("* Required");
            traineriderror.setForeground(Color.red);
            x = false;
        } else {
            traineriderror.setText("* Correct");
            traineriderror.setForeground(Color.green);
        } 
        if((name.getText()).equals("")) {
            nameerror.setText("* Required");
            nameerror.setForeground(Color.red);
            x = false;
        } else {
            nameerror.setText("* Correct");
            nameerror.setForeground(Color.green);
        }
        if(!contact.getText().equals("")) {
            boolean numeric = true;
            Long num = 0L;
            try {
                num = Long.parseLong(contact.getText());
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if(!numeric) {
                contacterror.setText("* Digit Only");
                contacterror.setForeground(Color.red);
                x = false;
            } else if(num<1000000000L || num>9999999999L) {
                contacterror.setText("* 10-digit");
                contacterror.setForeground(Color.red);
                x = false;
            } else {
                contacterror.setText("* Correct");
                contacterror.setForeground(Color.green);
            }
        } else {
            contacterror.setText("* Required");
            contacterror.setForeground(Color.red);
            x = false;
        }
        if((address.getText()).equals("")) {
            addresserror.setText("* Required");
            addresserror.setForeground(Color.red);
            x = false;
        } else {
            addresserror.setText("* Correct");
            addresserror.setForeground(Color.green);
        }
        if((email.getText()).equals("")) {
            emailerror.setText("* Required");
            emailerror.setForeground(Color.red);
            x = false;
        } else {
            boolean valid_email = Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[_A-Za-z0-9-]{2,})$", email.getText());
            if(!valid_email) {
                emailerror.setText("* Wrong Email");
                emailerror.setForeground(Color.red);
                x = false;
            } else {
                emailerror.setText("* Correct");
                emailerror.setForeground(Color.green);
            }
        }
        if(sport.getSelectedItem()==null || (sport.getSelectedItem().toString()).equals("")) {
            sporterror.setText("* Required");
            sporterror.setForeground(Color.red);
            x = false;
        } else {
            sporterror.setText("* Correct");
            sporterror.setForeground(Color.green);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        trainerid = new javax.swing.JTextField();
        traineriderror = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        contacterror = new javax.swing.JLabel();
        nameerror = new javax.swing.JLabel();
        emailerror = new javax.swing.JLabel();
        addresserror = new javax.swing.JLabel();
        sporterror = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        adminname = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        updateStudentPerformance = new javax.swing.JButton();
        addUpdateStudent = new javax.swing.JButton();
        hidden = new javax.swing.JLabel();
        sport = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 245, 245));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(">>||ENTER TRAINER DETAILS");

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
                "TrainerId", "Name", "Contact", "Address", "Email", "Sport"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TrainerId");

        traineriderror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        traineriderror.setForeground(new java.awt.Color(255, 0, 51));
        traineriderror.setText("*");

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Name");

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contact");

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Address");

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("E-mail");

        jLabel10.setBackground(new java.awt.Color(0, 102, 102));
        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Sport");

        contacterror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        contacterror.setForeground(new java.awt.Color(255, 0, 51));
        contacterror.setText("*");

        nameerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        nameerror.setForeground(new java.awt.Color(255, 0, 51));
        nameerror.setText("*");

        emailerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        emailerror.setForeground(new java.awt.Color(255, 0, 51));
        emailerror.setText("*");

        addresserror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        addresserror.setForeground(new java.awt.Color(255, 0, 51));
        addresserror.setText("*");

        sporterror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        sporterror.setForeground(new java.awt.Color(255, 0, 51));
        sporterror.setText("*");

        reset.setText("Reset");
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete Selected Entry");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        adminname.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        adminname.setForeground(new java.awt.Color(102, 0, 0));
        adminname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminname.setText("Hi, Admin!                                       ");

        logout.setText("LogOut");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        updateStudentPerformance.setText("Update Student Performance");
        updateStudentPerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateStudentPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentPerformanceActionPerformed(evt);
            }
        });

        addUpdateStudent.setText("Add/Update Student");
        addUpdateStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateStudentActionPerformed(evt);
            }
        });

        sport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cricket", "Football", "TableTennis", "Chess", "Tennis", "Hockey" }));
        sport.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateStudentPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminname, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(sport, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(20, 20, 20)
                                                .addComponent(sporterror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(emailerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(addresserror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(contacterror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(nameerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(trainerid, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(traineriderror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hidden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateStudentPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(trainerid, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(traineriderror))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameerror))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contacterror))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(addresserror)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailerror))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(sporterror)
                            .addComponent(sport, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset)
                            .addComponent(submit))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update)
                            .addComponent(delete)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(hidden, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_resetActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        if(!invalid && Validated()) {
            try{
                Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = con.createStatement();
                String query = "INSERT INTO trainer(trainerid,name,contact,address,email,sport) VALUES('"+trainerid.getText()+"','"+name.getText()+"','"+contact.getText()+"','"+address.getText()+"','"+email.getText()+"','"+sport.getSelectedItem().toString()+"')";
                stmt.execute(query);
                hidden.setText(trainerid.getText());
                JOptionPane.showMessageDialog(null, "Form data submitted Successfully adding new entry with:\nTrainer ID:"+hidden.getText());
                Clear();
            }
            catch(SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Cannot sumbit two records with same Trainer ID.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid details...");
        }
    }//GEN-LAST:event_submitActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if(!invalid && Validated() && !(hidden.getText().equals(""))) {
            try {
                Connection conn = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = conn.createStatement();
                String query1 = "UPDATE performance SET trainer_name ='"+trainerid.getText()+"-"+name.getText()+"', trainer_contact = '"+contact.getText()+"' WHERE trainer_name LIKE '"+(hidden.getText().toString()+"%")+"'";
                stmt.execute(query1);
                String query2 = "UPDATE trainer SET trainerid='"+trainerid.getText()+"',name='"+name.getText()+"',contact='"+contact.getText()+"',address='"+address.getText()+"',email='"+email.getText()+"',sport='"+sport.getSelectedItem().toString()+"' WHERE trainerid='"+hidden.getText()+"'";
                stmt.execute(query2);
                String TID = trainerid.getText();
                JOptionPane.showMessageDialog(null, "Form data updated Successfully for:\nOld Trainer ID - "+hidden.getText()+"\nNew Trainer ID - "+TID);
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
            if(x==0 && !(hidden.getText().equals(""))) {
                try{
                    Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                    Statement stmt = con.createStatement();
                    String query1 = "SELECT regno FROM performance WHERE trainer_name like '"+(hidden.getText().toString()+"%")+"'";
                    ResultSet rs = stmt.executeQuery(query1);
                    while(rs.next()) {
                        JOptionPane.showMessageDialog(null, "Selected row cannot be deleted until new Trainer is assigned to the students under this trainer.");
                        Clear();
                        return;
                    }
                    String query2 = "DELETE FROM trainer WHERE trainerid='"+hidden.getText()+"'";
                    stmt.execute(query2);
                    JOptionPane.showMessageDialog(null, "Selected row deleted Successfully...\nDeleted Trainer ID - "+hidden.getText());
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

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int rowIndex = table1.getSelectedRow();
        trainerid.setText(model.getValueAt(rowIndex, 0).toString());
            hidden.setText(model.getValueAt(rowIndex, 0).toString());
        name.setText(model.getValueAt(rowIndex, 1).toString());
        contact.setText(model.getValueAt(rowIndex, 2).toString());
        address.setText(model.getValueAt(rowIndex, 3).toString());
        email.setText(model.getValueAt(rowIndex, 4).toString());
        sport.setSelectedItem(model.getValueAt(rowIndex, 5).toString());
    }//GEN-LAST:event_table1MouseClicked

    private void addUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateStudentActionPerformed
        // TODO add your handling code here:
        AddStudent student = new AddStudent(admin);
        Clear();
        this.dispose();
        student.setVisible(true);
    }//GEN-LAST:event_addUpdateStudentActionPerformed

    private void updateStudentPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentPerformanceActionPerformed
        // TODO add your handling code here:
        StudentPerformance studentperformance = new StudentPerformance(admin);
        Clear();
        this.dispose();
        studentperformance.setVisible(true);
    }//GEN-LAST:event_updateStudentPerformanceActionPerformed

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
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTrainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUpdateStudent;
    private javax.swing.JTextField address;
    private javax.swing.JLabel addresserror;
    private javax.swing.JLabel adminname;
    private javax.swing.JTextField contact;
    private javax.swing.JLabel contacterror;
    private javax.swing.JButton delete;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailerror;
    private javax.swing.JLabel hidden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameerror;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<String> sport;
    private javax.swing.JLabel sporterror;
    private javax.swing.JButton submit;
    private javax.swing.JTable table1;
    private javax.swing.JTextField trainerid;
    private javax.swing.JLabel traineriderror;
    private javax.swing.JButton update;
    private javax.swing.JButton updateStudentPerformance;
    // End of variables declaration//GEN-END:variables
}
