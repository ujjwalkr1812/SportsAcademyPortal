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
public class AddStudent extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
    
    private static final String HOST = "jdbc:derby://localhost:1527/SportsAcademy";
    private static final String USERNAME = "mydb";
    private static final String PASSWORD = "admin";
    private static boolean invalid = true;
    private String admin;
    
    public AddStudent() {
        initComponents();
        this.setLocationRelativeTo(null);
        hidden.setVisible(false);
        clearData();
        adminname.setText("Error in loading your name!!!");
        invalid = true;
    }
    public AddStudent(String adminName) {
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
                String query = "SELECT * FROM student";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    model.addRow(new Object[]{rs.getString("regno"), rs.getString("name"), rs.getInt("age"), rs.getString("contact"), rs.getString("address"), rs.getString("adhar")});
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void Clear() {
        getData();
        
        name.setText(null);
        regno.setText(null);
        age.setText(null);
        contact.setText(null);
        address.setText(null);
        adhar.setText(null);
        hidden.setText(null);
        
        nameerror.setText("*");
        nameerror.setForeground(Color.red);
        regnoerror.setText("*");
        regnoerror.setForeground(Color.red);
        ageerror.setText("*");
        ageerror.setForeground(Color.red);
        contacterror.setText("*");
        contacterror.setForeground(Color.red);
        addresserror.setText("*");
        addresserror.setForeground(Color.red);
        adharerror.setText("* 12-digit");
        adharerror.setForeground(Color.red);
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
        if((name.getText()).equals("")) {
            nameerror.setText("* Required");
            nameerror.setForeground(Color.red);
            x = false;
        } else {
            nameerror.setText("* Correct");
            nameerror.setForeground(Color.green);
        } 
        if((age.getText()).equals("")) {
            ageerror.setText("* Required");
            ageerror.setForeground(Color.red);
            x = false;
        } else if(Integer.parseInt(age.getText())<5 || Integer.parseInt(age.getText())>100) {
            ageerror.setText("* Invalid");
            ageerror.setForeground(Color.red);
            age.setText("Age must be 5 to 100...");
            x = false;
        } else {
            ageerror.setText("* Correct");
            ageerror.setForeground(Color.green);
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
        if(!adhar.getText().equals("")) {
            boolean numeric = true;
            Long num = 0L;
            try {
                num = Long.parseLong(adhar.getText());
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if(!numeric || num<100000000000L || num>999999999999L) {
                adharerror.setText("* 12-digit");
                adharerror.setForeground(Color.red);
                x = false;
            } else {
                adharerror.setText("* Correct");
                adharerror.setForeground(Color.green);
            }
        } else {
            adharerror.setText("* 12-digit");
            adharerror.setForeground(Color.red);
            x = false;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        nameerror = new javax.swing.JLabel();
        regnoerror = new javax.swing.JLabel();
        ageerror = new javax.swing.JLabel();
        addresserror = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        adhar = new javax.swing.JTextField();
        contacterror = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        regno = new javax.swing.JTextField();
        adharerror = new javax.swing.JLabel();
        hidden = new javax.swing.JLabel();
        adminname = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        addUpdateTrainer = new javax.swing.JButton();
        updateStudentPerformance = new javax.swing.JButton();
        address = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 245, 245));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(">>||ENTER STUDENT DETAILS");

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name");

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Address");

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Age");

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Contact");

        submit.setText("Submit");
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitMouseEntered(evt);
            }
        });
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        nameerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        nameerror.setForeground(new java.awt.Color(255, 0, 51));
        nameerror.setText("*");

        regnoerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        regnoerror.setForeground(new java.awt.Color(255, 0, 51));
        regnoerror.setText("*");

        ageerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ageerror.setForeground(new java.awt.Color(255, 0, 51));
        ageerror.setText("*");

        addresserror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        addresserror.setForeground(new java.awt.Color(255, 0, 51));
        addresserror.setText("*");

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Aadhaar");

        contacterror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        contacterror.setForeground(new java.awt.Color(255, 0, 51));
        contacterror.setText("*");

        update.setText("Update");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

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
                {null, null, null, null, null, null}
            },
            new String [] {
                "RegNo", "Name", "Age", "Contact", "Address", "Aadhar"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        delete.setText("Delete Selected Entry");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Reg. No.");

        adharerror.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        adharerror.setForeground(new java.awt.Color(0, 102, 102));
        adharerror.setText("12-digit");

        adminname.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        adminname.setForeground(new java.awt.Color(102, 0, 0));
        adminname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminname.setText("Hi, Admin!                                              ");

        logout.setText("LogOut");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        addUpdateTrainer.setText("Add/Update Trainer");
        addUpdateTrainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUpdateTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateTrainerActionPerformed(evt);
            }
        });

        updateStudentPerformance.setText("Update Student Performance");
        updateStudentPerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateStudentPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentPerformanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(283, 283, 283)
                                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(regno, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(regnoerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(nameerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ageerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(adhar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(addresserror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(contacterror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(adharerror, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addUpdateTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateStudentPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adminname, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hidden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateStudentPerformance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addUpdateTrainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(regno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(regnoerror))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(nameerror))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageerror))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contacterror)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addresserror)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adhar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(adharerror))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submit)
                            .addComponent(reset))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(update)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(hidden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if(!invalid && Validated() && !(hidden.getText().equals(""))) {
            try {
                Connection conn = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = conn.createStatement();
                String query = "UPDATE Student SET regno='"+regno.getText()+"',name='"+name.getText()+"',age="+age.getText()+",contact='"+contact.getText()+"',address='"+address.getText()+"',adhar='"+adhar.getText()+"' WHERE regno='"+hidden.getText()+"'";
                stmt.execute(query);
                String RNO = regno.getText();
                JOptionPane.showMessageDialog(null, "Form data updated Successfully for:\nOld Registration Number - "+hidden.getText()+"\nNew Registration Number - "+RNO);
                Clear();
            }
            catch(SQLIntegrityConstraintViolationException e) {
                try {
                    Connection conn = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                    Statement stmt = conn.createStatement();
                    String query1 = "ALTER TABLE performance DROP CONSTRAINT fk_student";
                    stmt.execute(query1);
                    String query2 = "UPDATE performance SET regno='"+regno.getText()+"' WHERE regno='"+hidden.getText()+"'";
                    stmt.execute(query2);
                    String query3 = "UPDATE Student SET regno='"+regno.getText()+"',name='"+name.getText()+"',age="+age.getText()+",contact='"+contact.getText()+"',address='"+address.getText()+"',adhar='"+adhar.getText()+"' WHERE regno='"+hidden.getText()+"'";
                    stmt.execute(query3);
                    String query4 = "ALTER TABLE performance ADD CONSTRAINT fk_student FOREIGN KEY(regno) REFERENCES student(regno)";
                    stmt.execute(query4);
                    String RNO = regno.getText();
                    JOptionPane.showMessageDialog(null, "Form data updated Successfully for:\nOld Registration Number - "+hidden.getText()+"\nNew Registration Number - "+RNO);
                    Clear();
                } catch(SQLException x) {
                    JOptionPane.showMessageDialog(null, "Exeption occured while updating recrod with foreign key change between student table and performance table.\n"+x);
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid details...\n\t\tOR\nTrying to update entry which does not exists...");
        }
    }//GEN-LAST:event_updateActionPerformed

    
    
    
    
    
    
    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
        Validated();
    }//GEN-LAST:event_updateMouseEntered

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
                String query = "INSERT INTO Student(regno,name,age,contact,address,adhar) VALUES('"+regno.getText()+"','"+name.getText()+"',"+age.getText()+",'"+contact.getText()+"','"+address.getText()+"','"+adhar.getText()+"')";
                stmt.execute(query);
                hidden.setText(regno.getText());
                JOptionPane.showMessageDialog(null, "Form data submitted Successfully adding new entry with:\nRegistration No:"+hidden.getText());
                Clear();
            }
            catch(SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Cannot sumbit two records with same Registration Number.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Exeption occured.\n"+e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid details...");
        }
    }//GEN-LAST:event_submitActionPerformed

    
    
    private void submitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseEntered
        // TODO add your handling code here:
        Validated();
    }//GEN-LAST:event_submitMouseEntered

    
    
    
    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int rowIndex = table1.getSelectedRow();
        regno.setText(model.getValueAt(rowIndex, 0).toString());
            hidden.setText(model.getValueAt(rowIndex, 0).toString());
        name.setText(model.getValueAt(rowIndex, 1).toString());
        age.setText(model.getValueAt(rowIndex, 2).toString());
        contact.setText(model.getValueAt(rowIndex, 3).toString());
        address.setText(model.getValueAt(rowIndex, 4).toString());
        adhar.setText(model.getValueAt(rowIndex, 5).toString());
    }//GEN-LAST:event_table1MouseClicked

    
    
    
    
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete the selected record...");
        try {
            if(x==0 && !(hidden.getText().equals(""))) {
                try{
                    Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                    Statement stmt = con.createStatement();
                    String query = "DELETE FROM Student WHERE regno='"+hidden.getText()+"'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null, "Selected row deleted Successfully...\nDeleted Registration Number - "+hidden.getText());
                    Clear();
                }
                catch(SQLIntegrityConstraintViolationException e) {
                    try {
                        Connection conn = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                        Statement stmt = conn.createStatement();
                        String query1 = "ALTER TABLE performance DROP CONSTRAINT fk_student";
                        stmt.execute(query1);
                        String query2 = "DELETE FROM performance WHERE regno='"+hidden.getText()+"'";
                        stmt.execute(query2);
                        String query3 = "DELETE FROM Student WHERE regno='"+hidden.getText()+"'";
                        stmt.execute(query3);
                        String query4 = "ALTER TABLE performance ADD CONSTRAINT fk_student FOREIGN KEY(regno) REFERENCES student(regno)";
                        stmt.execute(query4);
                        String RNO = regno.getText();
                        JOptionPane.showMessageDialog(null, "Form data deleted Successfully for:\nDeleted Registration Number - "+hidden.getText());
                        Clear();
                    } catch(SQLException error) {
                        JOptionPane.showMessageDialog(null, "Exeption occured while updating recrod with foreign key change between student table and performance table.\n"+error);
                    }
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

    
    
    
    
    
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        LandingPage loggedout = new LandingPage("admin");
        Clear();
        this.dispose();
        loggedout.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    
    
    
    
    private void addUpdateTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateTrainerActionPerformed
        // TODO add your handling code here:
        AddTrainer trainer = new AddTrainer(admin);
        Clear();
        this.dispose();
        trainer.setVisible(true);
    }//GEN-LAST:event_addUpdateTrainerActionPerformed

    
    
    
    
    private void updateStudentPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentPerformanceActionPerformed
        // TODO add your handling code here:
        StudentPerformance studentperformance = new StudentPerformance(admin);
        Clear();
        this.dispose();
        studentperformance.setVisible(true);
    }//GEN-LAST:event_updateStudentPerformanceActionPerformed

   
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
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUpdateTrainer;
    private javax.swing.JTextField address;
    private javax.swing.JLabel addresserror;
    private javax.swing.JTextField adhar;
    private javax.swing.JLabel adharerror;
    private javax.swing.JLabel adminname;
    private javax.swing.JTextField age;
    private javax.swing.JLabel ageerror;
    private javax.swing.JTextField contact;
    private javax.swing.JLabel contacterror;
    private javax.swing.JButton delete;
    private javax.swing.JLabel hidden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameerror;
    private javax.swing.JTextField regno;
    private javax.swing.JLabel regnoerror;
    private javax.swing.JButton reset;
    private javax.swing.JButton submit;
    private javax.swing.JTable table1;
    private javax.swing.JButton update;
    private javax.swing.JButton updateStudentPerformance;
    // End of variables declaration//GEN-END:variables
}
