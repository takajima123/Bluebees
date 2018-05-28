/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airasysad;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author takajima
 */
public class WorkersRecord extends javax.swing.JFrame {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
            //Date Picker SYSTEM -------
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    JLabel l = new JLabel("", JLabel.CENTER);
    String day = "";
    JDialog d;
    JButton[] button = new JButton[49];
    /**
     * Creates new form WorkersRecord
     */
    public WorkersRecord() {
        initComponents();
        conn = database.sqliteConnect.connectorDB();
        TheTable();
        Records();
        recordbtn.setEnabled(false);
logs.setEnabled(false);
logs.setVisible(false);
jScrollPane2.setVisible(false);
jScrollPane2.setEnabled(false);
SalaryPaid.setVisible(false);
SalaryPaid.setEnabled(false);
jScrollPane4.setVisible(false);
jScrollPane4.setEnabled(false);
paid.setVisible(false);
paid.setEnabled(false);
Details.setVisible(false);
Details.setEnabled(false);
        CurrentDate();
        Paid();
        groupButton();
    }
    
//      String sqlQuery = " SELECT DISTINCT Date,COUNT(Date) AS count,sum(RMD) AS RMD ,Ingredients from RM group by ingredients";      
//            pst = conn.prepareStatement(sqlQuery);
//            rs = pst.executeQuery(); 
    public void TheTable() {
        try {
            String sqlQuery = " SELECT firstname,Count(Regular) AS 'Regular',Count(Holiday) AS 'Holiday ' from Attendance group by Firstname ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            WRecords.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }
    public void Records(){
        try{
        String sqlQuery = "Select FirstName,Date,Tin as 'TimeIn', Tout as 'TimeOut'from Attendance ";
        pst = conn.prepareStatement(sqlQuery);
        rs = pst.executeQuery();
        logs.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){}
        finally{try{rs.close();pst.close();}catch(Exception e){}}
    }
    
          public void CurrentDate() {
DecimalFormat mFormat= new DecimalFormat("00");
mFormat.format(Double.valueOf(year));
        Calendar cal = new GregorianCalendar();
        int mm = cal.get(Calendar.MONTH);
        int yyyy = cal.get(Calendar.YEAR);
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        From.setText("" + dd + '-' + mFormat.format(Double.valueOf(mm + 1)) + '-' + yyyy);
        To.setText("" + dd + '-' + mFormat.format(Double.valueOf(mm + 1)) + '-' + yyyy);
    }
              public void Paid(){
        try{
        String sqlQuery = "Select Name,TotalPay As 'Pay',Date from Pay ";
        pst = conn.prepareStatement(sqlQuery);
        rs = pst.executeQuery();
        SalaryPaid.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){}
        finally{try{rs.close();pst.close();}catch(Exception e){}}
    }
              
    public void toExcel(JTable table, File file) {
        try {
            TableModel model = WRecords.getModel();
            try (FileWriter excel = new FileWriter(file)) {

                for (int i = 0; i < model.getColumnCount(); i++) {
                    excel.write(model.getColumnName(i) + ",");
                }

                excel.write("\n");

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        //  System.out.println(model.getValueAt(i, j).toString());
                        excel.write(model.getValueAt(i, j).toString() + ",");
                    }
                    excel.write("\n");
                }
            }

        } catch (IOException e) {
        }
    }
        public void toExcel1(JTable table, File file) {
        try {
            TableModel model = logs.getModel();
            try (FileWriter excel = new FileWriter(file)) {

                for (int i = 0; i < model.getColumnCount(); i++) {
                    excel.write(model.getColumnName(i) + ",");
                }

                excel.write("\n");

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        //  System.out.println(model.getValueAt(i, j).toString());
                        excel.write(model.getValueAt(i, j).toString() + ",");
                    }
                    excel.write("\n");
                }
            }

        } catch (IOException e) {
        }
    }
            public void toExcel2(JTable table, File file) {
        try {
            TableModel model = SalaryPaid.getModel();
            try (FileWriter excel = new FileWriter(file)) {

                for (int i = 0; i < model.getColumnCount(); i++) {
                    excel.write(model.getColumnName(i) + ",");
                }

                excel.write("\n");

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        //  System.out.println(model.getValueAt(i, j).toString());
                        excel.write(model.getValueAt(i, j).toString() + ",");
                    }
                    excel.write("\n");
                }
            }

        } catch (IOException e) {
        }
    }
            
     private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(rbtn1);
        bg1.add(rbtn2);
        bg1.add(rbtn3);

    }           
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WorkerPanel = new javax.swing.JPanel();
        WorkerLabel = new javax.swing.JLabel();
        WorkerLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SalaryWorker = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        WRecords = new javax.swing.JTable();
        PanelBackground = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbtn3 = new javax.swing.JRadioButton();
        rbtn2 = new javax.swing.JRadioButton();
        rbtn1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        Details = new javax.swing.JLabel();
        paid = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        HPresent = new javax.swing.JTextField();
        WorkersName = new javax.swing.JTextField();
        WTotal = new javax.swing.JTextField();
        Salary = new javax.swing.JTextField();
        Rpresent = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        logs = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        SalaryPaid = new javax.swing.JTable();
        logsbtn = new javax.swing.JLabel();
        recordbtn = new javax.swing.JLabel();
        Dto = new javax.swing.JButton();
        To = new javax.swing.JLabel();
        From = new javax.swing.JLabel();
        Dfrom = new javax.swing.JButton();
        RecordBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WorkerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WorkerLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkerLabel.setText("Worker's Salary  :");
        WorkerPanel.add(WorkerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        WorkerLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkerLabel2.setText("Worker's Day Present");
        WorkerPanel.add(WorkerLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        SalaryWorker.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalaryWorker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Pay", "DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(SalaryWorker);
        if (SalaryWorker.getColumnModel().getColumnCount() > 0) {
            SalaryWorker.getColumnModel().getColumn(0).setResizable(false);
            SalaryWorker.getColumnModel().getColumn(0).setPreferredWidth(20);
            SalaryWorker.getColumnModel().getColumn(1).setResizable(false);
            SalaryWorker.getColumnModel().getColumn(1).setPreferredWidth(20);
            SalaryWorker.getColumnModel().getColumn(2).setResizable(false);
        }

        WorkerPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 490, 240));

        WRecords.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        WRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                WRecordsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(WRecords);

        WorkerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 490, 240));

        PanelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/vintage_paper.jpg"))); // NOI18N
        WorkerPanel.add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 520, 600));

        getContentPane().add(WorkerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 580));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 160, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbtn3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbtn3.setText("Salary Pay");
        jPanel1.add(rbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        rbtn2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbtn2.setText("Log's Details");
        jPanel1.add(rbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        rbtn1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbtn1.setText("Worker's Day Present");
        jPanel1.add(rbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/vintage_paper.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 180, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 170, 90));

        Details.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Details.setText("Logs Details");
        getContentPane().add(Details, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 30));

        paid.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        paid.setText("Salary Pay ");
        getContentPane().add(paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, 30));

        save.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 80, -1));

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 90, -1));

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Delete Worker's Salary");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 180, -1));

        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setText("Import to Worker Salary");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 420, 180, -1));

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setText("Home");
        jButton4.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton4.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton4.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 70, 50));

        HPresent.setEditable(false);
        HPresent.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(HPresent, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 160, 30));

        WorkersName.setEditable(false);
        WorkersName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(WorkersName, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 160, 30));

        WTotal.setEditable(false);
        WTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(WTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 160, 30));

        Salary.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Salary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SalaryKeyPressed(evt);
            }
        });
        getContentPane().add(Salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 160, 30));

        Rpresent.setEditable(false);
        Rpresent.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(Rpresent, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 160, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText(" Holiday Present :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 150, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Regular Day Present :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 160, 60));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Salary :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 50, 50));

        Total.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Total.setText("  Total :");
        getContentPane().add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 70, 70));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("  Worker's Name :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 130, 60));

        logs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(logs);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 47, 490, 240));

        SalaryPaid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(SalaryPaid);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 490, 240));

        logsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1424521102_7.png"))); // NOI18N
        logsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logsbtnMouseReleased(evt);
            }
        });
        getContentPane().add(logsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        recordbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1424521094_8.png"))); // NOI18N
        recordbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                recordbtnMouseReleased(evt);
            }
        });
        getContentPane().add(recordbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        Dto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Dto.setText("Past Date");
        Dto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DtoActionPerformed(evt);
            }
        });
        getContentPane().add(Dto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 120, 30));

        To.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(To, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 160, 30));

        From.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(From, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 160, 30));

        Dfrom.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Dfrom.setText("Latest Date");
        Dfrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DfromActionPerformed(evt);
            }
        });
        getContentPane().add(Dfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 120, 30));

        RecordBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/vintage_paper.jpg"))); // NOI18N
        getContentPane().add(RecordBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DtoActionPerformed
//        JPanel p = new JPanel();
//        final JFrame f = new JFrame();
//        f.getContentPane().add(p);
//        f.pack();
//        f.setVisible(false);
//        p.setVisible(false);
//        To.setText(new DatePicker(f).setPickedDate());
//
//        try {
//            //String sqlQuery = "SELECT * FROM sales WHERE date BETWEEN '" + Dto.getText() + "'  AND '" + Dfrom.getText() + "' group by product  ";
//            String sqlQuery = "SELECT  firstname,count(regular) AS 'Regular',count(holiday) as 'Holiday' from attendance WHERE date BETWEEN  '" + To.getText().toString() + "' AND '" + From.getText().toString() + "' group by Firstname";
//            pst = conn.prepareStatement(sqlQuery);
//            rs = pst.executeQuery();
//            Record.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        } finally {
//            try {
//                rs.close();
//                pst.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
        
  try{
    if(WRecords.isEnabled()){
                JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        To.setText(new DatePicker(f).setPickedDate());

        try {
            //String sqlQuery = "SELECT * FROM sales WHERE date BETWEEN '" + Dto.getText() + "'  AND '" + Dfrom.getText() + "' group by product  ";
            String sqlQuery = "SELECT  firstname,count(regular) AS 'Regular',count(holiday) as 'Holiday' from attendance WHERE date BETWEEN  '" + To.getText().toString() + "' AND '" + From.getText().toString() + "'group by Firstname ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            WRecords.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    else if(logs.isEnabled()){
                        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        To.setText(new DatePicker(f).setPickedDate());

        try {
            //String sqlQuery = "SELECT * FROM sales WHERE date BETWEEN '" + Dto.getText() + "'  AND '" + Dfrom.getText() + "' group by product  ";
            String sqlQuery = "SELECT  FirstName,Date,Tin as 'TimeIn', Tout as 'TimeOut'from Attendance WHERE date BETWEEN  '" + To.getText().toString() + "' AND '" + From.getText().toString() + "'";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            logs.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
catch(Exception e){}
 finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }}      
        
    }//GEN-LAST:event_DtoActionPerformed

    private void DfromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DfromActionPerformed
//        JPanel p = new JPanel();
//        final JFrame f = new JFrame();
//        f.getContentPane().add(p);
//        f.pack();
//        f.setVisible(false);
//        p.setVisible(false);
//        From.setText(new DatePicker(f).setPickedDate());
//
//        try {
//            //String sqlQuery = "SELECT * FROM sales WHERE date BETWEEN '" + Dto.getText() + "'  AND '" + Dfrom.getText() + "' group by product  ";
//            String sqlQuery = "SELECT  firstname,count(regular) AS 'Regular',count(holiday) as 'Holiday' from attendance WHERE date BETWEEN  '" + To.getText().toString() + "' AND '" + From.getText().toString() + "' group by Firstname";
//            pst = conn.prepareStatement(sqlQuery);
//            rs = pst.executeQuery();
//            Record.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        } finally {
//            try {
//                rs.close();
//                pst.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
try{
    if(WRecords.isEnabled()){
                JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        From.setText(new DatePicker(f).setPickedDate());

        try {
            //String sqlQuery = "SELECT * FROM sales WHERE date BETWEEN '" + Dto.getText() + "'  AND '" + Dfrom.getText() + "' group by product  ";
            String sqlQuery = "SELECT  firstname,count(regular) AS 'Regular',count(holiday) as 'Holiday' from attendance WHERE date BETWEEN  '" + To.getText().toString() + "' AND '" + From.getText().toString() + "' group by Firstname";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            WRecords.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    else if(logs.isEnabled()){
                        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        From.setText(new DatePicker(f).setPickedDate());

        try {
            //String sqlQuery = "SELECT * FROM sales WHERE date BETWEEN '" + Dto.getText() + "'  AND '" + Dfrom.getText() + "' group by product  ";
            String sqlQuery = "SELECT  FirstName,Date,Tin as 'TimeIn', Tout as 'TimeOut'from Attendance WHERE date BETWEEN  '" + To.getText().toString() + "' AND '" + From.getText().toString() + "' group by Firstname";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            logs.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
catch(Exception e){}
 finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }}
    }//GEN-LAST:event_DfromActionPerformed

    private void logsbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsbtnMouseReleased
recordbtn.setEnabled(true);
logsbtn.setEnabled(false);

WorkerLabel.setVisible(false);
WorkerLabel.setEnabled(false);
WorkerLabel2.setVisible(false);
WorkerLabel2.setEnabled(false);
WorkerPanel.setVisible(false);
WRecords.setVisible(false);
WRecords.setEnabled(false);
jScrollPane1.setEnabled(false);
jScrollPane1.setVisible(false);
SalaryWorker.setEnabled(false);
SalaryWorker.setVisible(false);
jScrollPane3.setEnabled(false);
jScrollPane3.setVisible(false);

logs.setEnabled(true);
logs.setVisible(true);
jScrollPane2.setVisible(true);
jScrollPane2.setEnabled(true);
SalaryPaid.setVisible(true);
SalaryPaid.setEnabled(true);
jScrollPane4.setVisible(true);
jScrollPane4.setEnabled(true);
paid.setVisible(true);
paid.setEnabled(true);
Details.setVisible(true);
Details.setEnabled(true);
    }//GEN-LAST:event_logsbtnMouseReleased

    private void recordbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordbtnMouseReleased
recordbtn.setEnabled(false);
logsbtn.setEnabled(true);

WorkerLabel.setVisible(true);
WorkerLabel.setEnabled(true);
WorkerLabel2.setVisible(true);
WorkerLabel2.setEnabled(true);
WorkerPanel.setVisible(true);
WRecords.setVisible(true);
WRecords.setEnabled(true);
jScrollPane1.setEnabled(true);
jScrollPane1.setVisible(true);
SalaryWorker.setEnabled(true);
SalaryWorker.setVisible(true);
jScrollPane3.setEnabled(true);
jScrollPane3.setVisible(true);

logs.setEnabled(false);
logs.setVisible(false);
jScrollPane2.setVisible(false);
jScrollPane2.setEnabled(false);
SalaryPaid.setVisible(false);
SalaryPaid.setEnabled(false);
jScrollPane4.setVisible(false);
jScrollPane4.setEnabled(false);
paid.setVisible(false);
paid.setEnabled(false);
Details.setVisible(false);
Details.setEnabled(false);
    }//GEN-LAST:event_recordbtnMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Login open = new Login();
        open.setVisible(true);
        open.Clear.setVisible(false);
        open.Login.setVisible(false);
        open.User.setVisible(false);
        open.Pass.setVisible(false);
        open.loginlabel1.setVisible(false);
        open.LoginLabel2.setVisible(false);
        open.loginPanel.setVisible(false);
        open.Logo.setVisible(false);

        open.Clear.setEnabled(false);
        open.Login.setEnabled(false);
        open.User.setEnabled(false);
        open.Pass.setEnabled(false);
        open.loginlabel1.setEnabled(false);
        open.LoginLabel2.setEnabled(false);
        open.loginPanel.setEnabled(false);
        open.Logo.setEnabled(false);

                   //inside
        open.Selection.setEnabled(true);
        open.Sales.setEnabled(true);
        open.Input.setEnabled(true);
        open.Worker.setEnabled(true);
        open.Record.setEnabled(true);
        open.MenuEdit.setEnabled(true);
        open.Logout.setEnabled(true);

        open.Selection.setVisible(true);
        open.Sales.setVisible(true);
        open.Input.setVisible(true);
        open.Worker.setVisible(true);
        open.Record.setVisible(true);
        open.MenuEdit.setVisible(true);
        open.Logout.setVisible(true);

//inside end
        try {
            rs.close();
            pst.close();
        } catch (Exception e) {

        }
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
try{
        String Dto = To.getText();
        String Fto = From.getText();
        Object[] row = new Object[3];
        DefaultTableModel model2 = (DefaultTableModel) SalaryWorker.getModel();
        {
        if(!!WorkersName.getText().isEmpty()  ){
            JOptionPane.showMessageDialog(null, "Select Employee from the Table ");
                }
        else if(!!Salary.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter Salary");
        }
         else
            {
            row[0] = WorkersName.getText();
            row[1] = WTotal.getText();
            row[2] = "From"+Fto+"-"+"To"+Dto;
           // row[2] = 
            model2.addRow(row);
        JOptionPane.showMessageDialog(null, "Added to list");
        //CLEAR-----
        WorkersName.setText("");
        HPresent.setText("");
        Rpresent.setText("");
        Salary.setText("");
        Total.setText("");
                }
        }
}
catch(Exception e){}
finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void WRecordsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WRecordsMouseReleased
//String sqlQuery = " SELECT firstname,Count(Regular) AS 'Regular',Count(Holiday) AS 'Holiday ' "
//        + "from Attendance group by Firstname ";
        try
        {
            
            int row = WRecords.getSelectedRow();
            String clickedRow = (WRecords.getModel().getValueAt(row,0).toString());
            String sqlQuery = " SELECT firstname,LastName from Attendance where firstname='"+clickedRow+"' group by Firstname  ";
          //String sqlQuery = "select * from Workers where id = '" + clickedRow + "'";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();

            if(rs.next())
            {
                String FirstName   = rs.getString("FirstName");
                String LastName  = rs.getString("LastName");
                WorkersName.setText(FirstName+" "+LastName );
                String Holiday = WRecords.getModel().getValueAt(row, 1).toString();
                HPresent.setText(Holiday);
                String Regular = WRecords.getModel().getValueAt(row, 2).toString();
                Rpresent.setText(Regular);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_WRecordsMouseReleased

    private void SalaryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalaryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                double R = Double.parseDouble(Rpresent.getText());
                double H = Double.parseDouble(HPresent.getText());
                double S = Double.parseDouble(Salary.getText());
                double HT = (S*2)*H;
                double RT = S * R;
                double T = HT+RT;
                String Atotal = String.valueOf(T);
                WTotal.setText(Atotal);
                System.out.println(HT+""+RT);
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, a);
            }
        }
    }//GEN-LAST:event_SalaryKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    DefaultTableModel model = (DefaultTableModel) SalaryWorker.getModel();
    int[] rows = SalaryWorker.getSelectedRows();
      try{
         if(SalaryWorker.getSelectionModel().isSelectionEmpty()){
             JOptionPane.showMessageDialog(null, "No Item To Be Deleted From List");
         }
         else{
                for (int i = 0; i < rows.length; i++) {
                model.removeRow(rows[i] - i);
                }
         }
      }
      catch(Exception e){}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       WorkersName.setText("");
       HPresent.setText("");
       Rpresent.setText("");
       Salary.setText("");
       WTotal.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
 try{
     
 
        for (int x = 0; x < SalaryWorker.getRowCount(); x++) {
        try {
        String sqlQuery = "insert into Pay (name , totalPay ,  Date ) values ('" + SalaryWorker.getValueAt(x, 0).toString() + "','" + SalaryWorker.getValueAt(x, 1).toString() + "','" + SalaryWorker.getValueAt(x, 2).toString() + "')";
        pst = conn.prepareStatement(sqlQuery);
        pst.execute();   
                //                        Clear Tabe 
                        SalaryWorker.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Name", "Pay", "DATE"
                            }
                        ) {
                            boolean[] canEdit = new boolean [] {
                                false, false, false
                            };

                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                            }
                        });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
//        JOptionPane.showMessageDialog(null, "Saved to Sales");
        }
}
catch(Exception e){
 }
finally {
        try {
            
        rs.close();
        pst.close();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
        }
  

 
 
    }//GEN-LAST:event_saveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try{
        if(!rbtn1.isSelected() && !rbtn2.isSelected() && !rbtn3.isSelected()){
            JOptionPane.showMessageDialog(null, "Select File to be exported");
        }
        else if(rbtn1.isSelected()){
            File desktop = new File(System.getProperty("user.home"), "Desktop");
            String Present1 = "'"+WorkerLabel2.getText()+"' Date '" + From.getText().toString() + "' to '" + To.getText().toString() + "'.csv";
            File file1 = new File(desktop, Present1);
            toExcel(WRecords, file1);
            JOptionPane.showMessageDialog(null, "File Saved");
            

        }
        else if(rbtn2.isSelected()){
            File desktop = new File(System.getProperty("user.home"), "Desktop");
            String Logs = "'"+Details.getText()+"' Date '" + From.getText().toString() + "' to '" + To.getText().toString() + "'.csv";
            File file1 = new File(desktop, Logs);
            toExcel1(logs, file1);
            JOptionPane.showMessageDialog(null, "File Saved");
        }
        else if(rbtn3.isSelected()){
            File desktop = new File(System.getProperty("user.home"), "Desktop");
            String Paid = "'"+paid.getText()+"' Date '" + From.getText().toString() + "' to '" + To.getText().toString() + "'.csv";
            File file2 = new File(desktop, Paid);
            toExcel2(SalaryPaid, file2);
            JOptionPane.showMessageDialog(null, "File Saved");
        }
    }
    catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(WorkersRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkersRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkersRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkersRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkersRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Details;
    private javax.swing.JButton Dfrom;
    private javax.swing.JButton Dto;
    private javax.swing.JLabel From;
    private javax.swing.JTextField HPresent;
    private javax.swing.JLabel PanelBackground;
    private javax.swing.JLabel RecordBg;
    private javax.swing.JTextField Rpresent;
    private javax.swing.JTextField Salary;
    private javax.swing.JTable SalaryPaid;
    private javax.swing.JTable SalaryWorker;
    private javax.swing.JLabel To;
    private javax.swing.JLabel Total;
    private javax.swing.JTable WRecords;
    private javax.swing.JTextField WTotal;
    private javax.swing.JLabel WorkerLabel;
    private javax.swing.JLabel WorkerLabel2;
    private javax.swing.JPanel WorkerPanel;
    private javax.swing.JTextField WorkersName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable logs;
    private javax.swing.JLabel logsbtn;
    private javax.swing.JLabel paid;
    private javax.swing.JRadioButton rbtn1;
    private javax.swing.JRadioButton rbtn2;
    private javax.swing.JRadioButton rbtn3;
    private javax.swing.JLabel recordbtn;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
