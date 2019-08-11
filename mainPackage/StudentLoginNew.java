/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class StudentLoginNew extends javax.swing.JFrame {

    /**
     * Creates new form StudentLoginNew
     */
    
    private static final String HOST = "jdbc:derby://localhost:1527/SportsAcademy";
    private static final String USERNAME = "mydb";
    private static final String PASSWORD = "admin";
    private static boolean invalid = true;
    private String student;
    private String RNO;
    
    public StudentLoginNew() {
        initComponents();
        this.setLocationRelativeTo(null);
        clearData();
        studentname.setText("Error!!!");
        invalid = true;
        profilePanel.setVisible(true);
        performancePanel.setVisible(false);
        passwordPanel.setVisible(false);
    }

    public StudentLoginNew(String userName, String studentName) {
        this();
        invalid = false;
        student = studentName;
        RNO = userName;
        studentname.setText("Hi, "+student+"!");
        getData();
    }
        
    private void clearData() {
        DefaultTableModel model1 = (DefaultTableModel) profileTable.getModel();
        model1.setRowCount(0);
        DefaultTableModel model2 = (DefaultTableModel) performanceTable.getModel();
        model2.setRowCount(0);
    }
    
    private void getData() {
        clearData();//Clear the table befor rendering new data
        if(invalid) {
            return;
        } else {
            DefaultTableModel model1 = (DefaultTableModel) profileTable.getModel();
            try{
                Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM student WHERE regno = '"+RNO+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    model1.addRow(new Object[]{"Registration No.", rs.getString("regno")});
                    model1.addRow(new Object[]{"Name", rs.getString("name")});
                    model1.addRow(new Object[]{"Age", rs.getString("age")});
                    model1.addRow(new Object[]{"Contact", rs.getString("contact")});
                    model1.addRow(new Object[]{"Address", rs.getString("address")});
                    model1.addRow(new Object[]{"Aadhaar", rs.getString("adhar")});
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        studentname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        profileToggle = new javax.swing.JLabel();
        performanceToggle = new javax.swing.JLabel();
        passwordToggle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        profileTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        performancePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        performanceTable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        passwordPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        newPass = new javax.swing.JPasswordField();
        confNewPass = new javax.swing.JPasswordField();
        passwordSubmit = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 255));

        jPanel2.setBackground(new java.awt.Color(240, 240, 255));

        studentname.setFont(new java.awt.Font("Verdana", 3, 20)); // NOI18N
        studentname.setForeground(new java.awt.Color(54, 82, 122));
        studentname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentname.setText("Hi, STUDENT!");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("STUDENT'S RECORD");

        logout.setFont(new java.awt.Font("Verdana", 3, 20)); // NOI18N
        logout.setForeground(new java.awt.Color(0, 102, 0));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("LogOut");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(studentname, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(261, 579));

        jPanel8.setBackground(new java.awt.Color(55, 128, 128));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        profileToggle.setBackground(new java.awt.Color(0, 51, 102));
        profileToggle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        profileToggle.setForeground(new java.awt.Color(0, 51, 102));
        profileToggle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileToggle.setText("My Profile");
        profileToggle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileToggleMouseClicked(evt);
            }
        });

        performanceToggle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        performanceToggle.setForeground(new java.awt.Color(0, 51, 102));
        performanceToggle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        performanceToggle.setText("View Trainers");
        performanceToggle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performanceToggleMouseClicked(evt);
            }
        });

        passwordToggle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        passwordToggle.setForeground(new java.awt.Color(0, 51, 102));
        passwordToggle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordToggle.setText("Change Password");
        passwordToggle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordToggleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profileToggle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(performanceToggle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(passwordToggle, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(profileToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(performanceToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(55, 128, 128));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(">>||WELCOME TO STUDENT LOGIN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(194, 232, 194));

        profilePanel.setOpaque(false);

        profileTable.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        profileTable.setForeground(new java.awt.Color(0, 51, 102));
        profileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "FIELD", "INFORMATION"
            }
        ));
        profileTable.setFocusable(false);
        profileTable.setOpaque(false);
        profileTable.setRowHeight(35);
        profileTable.setRowMargin(5);
        profileTable.setShowHorizontalLines(false);
        profileTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(profileTable);
        if (profileTable.getColumnModel().getColumnCount() > 0) {
            profileTable.getColumnModel().getColumn(0).setMinWidth(150);
            profileTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            profileTable.getColumnModel().getColumn(0).setMaxWidth(250);
            profileTable.getColumnModel().getColumn(1).setMinWidth(500);
            profileTable.getColumnModel().getColumn(1).setMaxWidth(1000);
        }

        jPanel10.setBackground(new java.awt.Color(250, 250, 250));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(97, 85, 82));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PROFILE INFORMATION");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        performancePanel.setOpaque(false);

        performanceTable.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        performanceTable.setForeground(new java.awt.Color(0, 51, 102));
        performanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SPORT", "TRAINER", "TRAINER CONTACT", "FEES", "GRADE"
            }
        ));
        performanceTable.setFocusable(false);
        performanceTable.setOpaque(false);
        performanceTable.setRowHeight(35);
        performanceTable.setRowMargin(5);
        performanceTable.setShowVerticalLines(false);
        jScrollPane3.setViewportView(performanceTable);
        if (performanceTable.getColumnModel().getColumnCount() > 0) {
            performanceTable.getColumnModel().getColumn(0).setMinWidth(150);
            performanceTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            performanceTable.getColumnModel().getColumn(1).setMinWidth(200);
            performanceTable.getColumnModel().getColumn(1).setPreferredWidth(250);
            performanceTable.getColumnModel().getColumn(2).setMinWidth(150);
            performanceTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            performanceTable.getColumnModel().getColumn(3).setMinWidth(100);
            performanceTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            performanceTable.getColumnModel().getColumn(4).setMinWidth(50);
            performanceTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jPanel11.setBackground(new java.awt.Color(250, 250, 250));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(97, 85, 82));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TRAINERS' DETAILS");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout performancePanelLayout = new javax.swing.GroupLayout(performancePanel);
        performancePanel.setLayout(performancePanelLayout);
        performancePanelLayout.setHorizontalGroup(
            performancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(performancePanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        performancePanelLayout.setVerticalGroup(
            performancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, performancePanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        passwordPanel.setOpaque(false);

        jPanel12.setBackground(new java.awt.Color(250, 250, 250));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(97, 85, 82));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("UPDATE PASSWORD");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(67, 42, 35));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("New Password :");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(67, 42, 35));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Confirm New Password :");
        jLabel11.setToolTipText("");

        passwordSubmit.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        passwordSubmit.setForeground(new java.awt.Color(56, 32, 32));
        passwordSubmit.setText("Submit");
        passwordSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newPass)
                            .addComponent(confNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                .addGap(219, 219, 219))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPass, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(passwordSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(performancePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(performancePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void profileToggleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileToggleMouseClicked
        // TODO add your handling code here:
        clearData();//Clear the table befor rendering new data
        if(invalid) {
            return;
        } else {
            profilePanel.setVisible(true);
            performancePanel.setVisible(false);
            passwordPanel.setVisible(false);
            DefaultTableModel model1 = (DefaultTableModel) profileTable.getModel();
            try{
                Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM student WHERE regno = '"+RNO+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    model1.addRow(new Object[]{"Registration No.", rs.getString("regno")});
                    model1.addRow(new Object[]{"Name", rs.getString("name")});
                    model1.addRow(new Object[]{"Age", rs.getString("age")});
                    model1.addRow(new Object[]{"Contact", rs.getString("contact")});
                    model1.addRow(new Object[]{"Address", rs.getString("address")});
                    model1.addRow(new Object[]{"Aadhaar", rs.getString("adhar")});
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_profileToggleMouseClicked

    private void performanceToggleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_performanceToggleMouseClicked
        // TODO add your handling code here:
        clearData();//Clear the table befor rendering new data
        if(invalid) {
            return;
        } else {
            profilePanel.setVisible(false);
            performancePanel.setVisible(true);
            passwordPanel.setVisible(false);
            DefaultTableModel model2 = (DefaultTableModel) performanceTable.getModel();
            try{
                Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                Statement stmt = con.createStatement();
                String query1 = "SELECT sport, trainer_name, trainer_contact, fees, grade FROM performance WHERE regno = '"+RNO+"'";
                ResultSet rs1 = stmt.executeQuery(query1);
                while(rs1.next()) {
                    model2.addRow(new Object[]{rs1.getString("sport"), rs1.getString("trainer_name"), rs1.getString("trainer_contact"), rs1.getString("fees"), rs1.getString("grade")});
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_performanceToggleMouseClicked

    private void passwordToggleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordToggleMouseClicked
        // TODO add your handling code here:
        
        clearData();//Clear the table befor rendering new data
        if(invalid) {
            return;
        } else {
            profilePanel.setVisible(false);
            performancePanel.setVisible(false);
            passwordPanel.setVisible(true);
        }
        
    }//GEN-LAST:event_passwordToggleMouseClicked

    private void passwordSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordSubmitActionPerformed
        // TODO add your handling code here:
        if(invalid) {
            return;
        } else {
            String pass1 = newPass.getText().toString();
            String pass2 = confNewPass.getText().toString();
            if(pass1.equals(pass2)) {
                if(pass1.length()>=8 && pass1.length()<=25) {
                    Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,25}$");
                    Matcher m = p.matcher(pass1);
                    if(m.matches()) {
                        try {
                            Connection con = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
                            Statement stmt = con.createStatement();
                            String query1 = "UPDATE student SET password = '"+pass1+"' WHERE regno = '"+RNO+"'";
                            stmt.execute(query1);
                            JOptionPane.showMessageDialog(null, "Password updated successfully.\nLogin again with new password.");
                            this.dispose();
                            LandingPage loggedout = new LandingPage("student");
                            loggedout.setVisible(true);
                        } catch(Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password must contain atleast one lowercase letter, uppercase letter, one digit and one Special character.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password must be 8 to 25 characters long.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "New Password and Confirm New Password must be same.");
            }
        }
    }//GEN-LAST:event_passwordSubmitActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        LandingPage loggedout = new LandingPage("student");
        loggedout.setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(StudentLoginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLoginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLoginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLoginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLoginNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confNewPass;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logout;
    private javax.swing.JPasswordField newPass;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JButton passwordSubmit;
    private javax.swing.JLabel passwordToggle;
    private javax.swing.JPanel performancePanel;
    private javax.swing.JTable performanceTable;
    private javax.swing.JLabel performanceToggle;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JTable profileTable;
    private javax.swing.JLabel profileToggle;
    private javax.swing.JLabel studentname;
    // End of variables declaration//GEN-END:variables
}
