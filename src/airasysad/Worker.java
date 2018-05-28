/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airasysad;

import com.sun.glass.events.MouseEvent;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.accessibility.AccessibleAction;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.Timing;

/**
 *
 * @author takajima
 */
public class Worker extends javax.swing.JFrame {
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst1 = null;
    ResultSet rs1 = null;
    /**
     * Creates new form Worker
     */
    public Worker() {
        initComponents();
        CurrentDate();
        conn = database.sqliteConnect.connectorDB();
        WorkerName();
        

//        Check.setText("Check");
//        Check.setEnabled(true);
//        TimeIn.setText("");
//        TimeOut.setText("");
//        Password.setText("");
        
//Selection Panel
        SelectionPanel.setVisible(true);
        SelectionBg.setVisible(true);
        Regularbtn.setVisible(true);
        Holidaybtn.setVisible(true);
        
        SelectionPanel.setEnabled(true);
        SelectionBg.setEnabled(true);
        Regularbtn.setEnabled(true);
        Holidaybtn.setEnabled(true);
//Selection Panel End
       
//HolidayPanel
        HolidaPassLabel.setVisible(false);
        HolidayAttendance.setVisible(false);
        HolidayBg.setVisible(false);
        HolidayCheck.setVisible(false);
        HolidayLastName.setVisible(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setVisible(false);
        HolidayName.setVisible(false);
        HolidayNameLabel.setVisible(false);
        HolidayPanel.setVisible(false);
        HolidayTimeIn.setVisible(false);
        HolidayTimeOut.setVisible(false);
        HolidayTimeinLabel.setVisible(false);
        HolidayTimeoutLabel.setVisible(false);
        Holidaypassword.setVisible(false);
        
        HolidaPassLabel.setEnabled(false);
        HolidayAttendance.setEnabled(false);
        HolidayBg.setEnabled(false);
        HolidayCheck.setEnabled(false);
        HolidayLastName.setEnabled(false);
        HolidayLogin.setEnabled(false);
        HolidayLogout.setEnabled(false);
        HolidayName.setEnabled(false);
        HolidayNameLabel.setEnabled(false);
        HolidayPanel.setEnabled(false);
        HolidayTimeIn.setEnabled(false);
        HolidayTimeOut.setEnabled(false);
        HolidayTimeinLabel.setEnabled(false);
        HolidayTimeoutLabel.setEnabled(false);
        Holidaypassword.setEnabled(false);
//HolidayPanel
        
//RegularPanel  
        TimeOut.setVisible(false);
        TimeIn.setVisible(false);
        Password.setVisible(false);
        TimeoutLabel.setVisible(false);
        TimeInLabel.setVisible(false);
        Login.setVisible(false);
        LogOut.setVisible(false);
        Attendance.setVisible(false);
        Check.setVisible(false);
        NameLabel.setVisible(false);
        PasswordLabel.setVisible(false);
        Name.setVisible(false);
        LastName.setVisible(false);
        
        TimeOut.setEnabled(false);
        TimeIn.setEnabled(false);
        Password.setEnabled(false);
        TimeoutLabel.setEnabled(false);
        TimeInLabel.setEnabled(false);
        Login.setEnabled(false);
        LogOut.setEnabled(false);
        Attendance.setEnabled(false);
        Check.setEnabled(false);
        NameLabel.setEnabled(false);
        PasswordLabel.setEnabled(false);
        Name.setEnabled(false);
        LastName.setEnabled(false);
//RegularPanel           
    }

    public void CurrentDate() { // DYNAMIC TIME AND DATE --------

    Thread clock = new Thread(){
        public void run(){
            for(;;){
            Calendar cal = new GregorianCalendar();
            int S = cal.get(Calendar.SECOND);
            int M = cal.get(Calendar.MINUTE);
            int H = cal.get(Calendar.HOUR);
            Time.setText("" + H + ':' + M + ':' + S);
            
        DecimalFormat mFormat= new DecimalFormat("00");
        mFormat.format(Double.valueOf(year));
        //Calendar cal = new GregorianCalendar();
        int mm = cal.get(Calendar.MONTH);
        int yyyy = cal.get(Calendar.YEAR);
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        Date.setText("" + dd + '-' + mFormat.format(Double.valueOf(mm + 1)) + '-' + yyyy);
            try{
               sleep(1000); 
            } 
            catch(Exception ex){}
        }}
    };  
    clock.start();
    }    //DYNAMIC TIME AND DATE -----------------
    
    private void WorkerName() {
        try {
            String sqlQuery = "SELECT FirstName from Workers";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("FirstName");
                if (cat != null) {
                    Name.addItem(cat);
                    HolidayName.addItem(cat);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
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

        SelectionPanel = new javax.swing.JPanel();
        Regularbtn = new javax.swing.JButton();
        Holidaybtn = new javax.swing.JButton();
        SelectionBg = new javax.swing.JLabel();
        HolidayPanel = new javax.swing.JPanel();
        HolidaPassLabel = new javax.swing.JLabel();
        HolidayAttendance = new javax.swing.JButton();
        HolidayName = new javax.swing.JComboBox();
        HolidayTimeOut = new javax.swing.JTextField();
        HolidayCheck = new javax.swing.JButton();
        HolidayTimeoutLabel = new javax.swing.JLabel();
        HolidayTimeinLabel = new javax.swing.JLabel();
        Holidaypassword = new javax.swing.JPasswordField();
        HolidayTimeIn = new javax.swing.JTextField();
        HolidayLogout = new javax.swing.JButton();
        HolidayNameLabel = new javax.swing.JLabel();
        HolidayLogin = new javax.swing.JButton();
        HolidayBg = new javax.swing.JLabel();
        HolidayLastName = new javax.swing.JLabel();
        TimeOut = new javax.swing.JTextField();
        TimeIn = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        TimeoutLabel = new javax.swing.JLabel();
        TimeInLabel = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        Attendance = new javax.swing.JButton();
        Check = new javax.swing.JButton();
        NameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        Name = new javax.swing.JComboBox();
        Time = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        LastName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Regularbtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Regularbtn.setText("Regular");
        Regularbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegularbtnActionPerformed(evt);
            }
        });
        SelectionPanel.add(Regularbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 230, 100));

        Holidaybtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Holidaybtn.setText("Holiday");
        Holidaybtn.setMaximumSize(new java.awt.Dimension(100, 100));
        Holidaybtn.setMinimumSize(new java.awt.Dimension(100, 100));
        Holidaybtn.setPreferredSize(new java.awt.Dimension(100, 100));
        Holidaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HolidaybtnActionPerformed(evt);
            }
        });
        SelectionPanel.add(Holidaybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 230, 100));
        Holidaybtn.getAccessibleContext().setAccessibleDescription("");

        SelectionBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/vintage_paper.jpg"))); // NOI18N
        SelectionPanel.add(SelectionBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 710, 540));

        getContentPane().add(SelectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 700, 300));

        HolidayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HolidaPassLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HolidaPassLabel.setText("Password :");
        HolidayPanel.add(HolidaPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        HolidayAttendance.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        HolidayAttendance.setText("Attendance Done");
        HolidayAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HolidayAttendanceActionPerformed(evt);
            }
        });
        HolidayPanel.add(HolidayAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 50));

        HolidayName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        HolidayName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        HolidayName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                HolidayNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        HolidayName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HolidayNameMouseReleased(evt);
            }
        });
        HolidayPanel.add(HolidayName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 170, 40));

        HolidayTimeOut.setEditable(false);
        HolidayTimeOut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HolidayPanel.add(HolidayTimeOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 170, 40));

        HolidayCheck.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        HolidayCheck.setText("Check");
        HolidayCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HolidayCheckActionPerformed(evt);
            }
        });
        HolidayPanel.add(HolidayCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 50));

        HolidayTimeoutLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HolidayTimeoutLabel.setText("Time Out:");
        HolidayPanel.add(HolidayTimeoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 90, 40));

        HolidayTimeinLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HolidayTimeinLabel.setText("Time In:");
        HolidayPanel.add(HolidayTimeinLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 80, 40));

        Holidaypassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HolidaypasswordKeyPressed(evt);
            }
        });
        HolidayPanel.add(Holidaypassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, 40));

        HolidayTimeIn.setEditable(false);
        HolidayTimeIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HolidayPanel.add(HolidayTimeIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 170, 40));

        HolidayLogout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        HolidayLogout.setText("Logout");
        HolidayLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HolidayLogoutActionPerformed(evt);
            }
        });
        HolidayPanel.add(HolidayLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 50));

        HolidayNameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HolidayNameLabel.setText("Name :");
        HolidayPanel.add(HolidayNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 20));

        HolidayLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        HolidayLogin.setText("Login");
        HolidayLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HolidayLoginActionPerformed(evt);
            }
        });
        HolidayPanel.add(HolidayLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 50));

        HolidayBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/vintage_paper.jpg"))); // NOI18N
        HolidayPanel.add(HolidayBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -180, 720, 420));

        HolidayLastName.setText("jLabel5");
        HolidayPanel.add(HolidayLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        getContentPane().add(HolidayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 680, 240));

        TimeOut.setEditable(false);
        TimeOut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(TimeOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 170, 40));

        TimeIn.setEditable(false);
        TimeIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(TimeIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 170, 40));

        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordKeyPressed(evt);
            }
        });
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 170, 40));

        TimeoutLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TimeoutLabel.setText("Time Out:");
        getContentPane().add(TimeoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 90, 40));

        TimeInLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TimeInLabel.setText("Time In:");
        getContentPane().add(TimeInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 80, 40));

        Login.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 50));

        LogOut.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LogOut.setText("Logout");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        getContentPane().add(LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 50));

        Attendance.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Attendance.setText("Attendance Done");
        Attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceActionPerformed(evt);
            }
        });
        getContentPane().add(Attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 50));

        Check.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Check.setText("Check");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });
        getContentPane().add(Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 50));

        NameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NameLabel.setText("Name :");
        getContentPane().add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 60, 20));

        PasswordLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PasswordLabel.setText("Password :");
        getContentPane().add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        Name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        Name.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                NamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NameMouseReleased(evt);
            }
        });
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 170, 40));

        Time.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Time.setText("00:00:00");
        getContentPane().add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 190, 50));

        Date.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Date.setText("00-00-000");
        getContentPane().add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 210, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/vintage_paper.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        LastName.setText("jLabel5");
        getContentPane().add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed

//    try{
//    String TimeI = String.valueOf(TimeIn.getText());
//    String TimeO = String.valueOf(TimeOut.getText());
//    String SDate = Date.getText();
//    if(Password.getText().isEmpty()){
//        JOptionPane.showMessageDialog(null, "Enter Password");
//    }
//    else  if(TimeIn.getText().isEmpty()){
//        Check.setText("Log In");
//        String sqlQuery = "insert into Attendance (FirstName , LastName ,  Date , Tin , Tout ) values  ('" + Name.getSelectedItem().toString() + "','" + LastName.getText() + "','" + Date.getText() + "','" + Time.getText() + "','" + TimeOut.getText() + "')";
//        pst = conn.prepareStatement(sqlQuery);
//        pst.execute();   
//        TimeIn.setText(Time.getText());
//        System.out.println("Noinserte");
//    }
//    else if (TimeOut.getText().isEmpty()){
//        Check.setText("Log Out");
//        String sqlQuery = "update attendance set Firstname='" + Name.getSelectedItem().toString() + "',LastName='" + LastName.getText() + "',Tout='" + Time.getText() + "' WHERE Date ='" + SDate + "' and Firstname='" + Name.getSelectedItem().toString() + "'";
//        pst = conn.prepareStatement(sqlQuery);
//        pst.execute();   
//        System.out.println("Iserted");
//    }
//    else if (TimeO != "" || TimeO != null){
//        Check.setText("Attendance done");
//        Check.setEnabled(false);
//        
//    }
//
//}
//catch(Exception e){}
//    finally{
//    try{
//
//        rs.close();
//        pst.close();
//    }catch(Exception e){}}




        String sqlQuery = "select * from workers where firstname=? and password=?";
        try{
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Name.getSelectedItem().toString());
            pst.setString(2, Password.getText());
            rs = pst.executeQuery();
            if(Name.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "No Name Selected");
            }    
            else if(Password.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Password not inserted");
            }
            if(rs.next()){
                        String TimeO = String.valueOf(TimeOut.getText());
                        if(TimeIn.getText().isEmpty()){
                           System.out.println("Noinserte");
                           Check.setEnabled(false);
                           Check.setVisible(false);
                           Login.setVisible(true);
                           Login.setEnabled(true);
                        }
                        else if (TimeOut.getText().isEmpty()){
                           System.out.println("Iserted");
                           Check.setEnabled(false);
                           Check.setVisible(false);
                           LogOut.setVisible(true);
                           LogOut.setEnabled(true);
                        }
                        else if (TimeO != "" || TimeO != null){
                           Check.setEnabled(false);
                           Check.setVisible(false);
                           Attendance.setVisible(true);
                           Attendance.setEnabled(false);

                        }
            }

            else 
            {
                JOptionPane.showMessageDialog(null,"Please Fill in the Required Data / \n Incorrect Password Inserted");
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
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

    }//GEN-LAST:event_CheckActionPerformed

    private void NamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_NamePopupMenuWillBecomeInvisible
        String Selected = (String) Name.getSelectedItem();
    try{    
        try {
            String sqlQuery = "Select FirstName,LastName from Workers where Firstname=?";
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Last = rs.getString("LastName");
                LastName.setText(Last);
            }}catch (Exception e) {}
        try{
            String sqlQuery = "select * from attendance where firstname='"+Selected+"' and Regular='"+Date.getText()+"' ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            String Qdate = rs.getString("Regular");
          //System.out.println(Qdate);
            if (rs.next()){
                String login = rs.getString("Tin");
                TimeIn.setText(login);
                String logout = rs.getString("Tout");
                TimeOut.setText(logout);
              System.out.println(Qdate +login +logout);
            }}catch(Exception e){}
    }
        finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
        
//                try{
//            String sqlQuery = "select * from attendance where firstname='"+Selected+"' and date='"+Date.getText()+"' ";
//            pst = conn.prepareStatement(sqlQuery);
//            rs = pst.executeQuery();
//            String Qdate = rs.getString("Date");
//          //System.out.println(Qdate);
//            if (rs.next()){
//                String login = rs.getString("Tin");
//                TimeIn.setText(login);
//                String logout = rs.getString("Tout");
//                TimeOut.setText(logout);
//              //System.out.println(Qdate +"inside");
//            }
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null,e);
//        }
//       finally
//        {
//            try
//            {
//                rs.close();
//                pst.close();
//            }
//            catch(Exception e)
//            {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }       
//        
        
    }//GEN-LAST:event_NamePopupMenuWillBecomeInvisible

    private void NameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseReleased
        Check.setText("Check");
        TimeIn.setText("");
        TimeOut.setText("");
        Password.setText("");
        Check.setEnabled(true);
        Check.setVisible(true);
        Login.setEnabled(false);
        Login.setVisible(false);
        LogOut.setEnabled(false);
        LogOut.setVisible(false);
        Attendance.setEnabled(false);
        Attendance.setVisible(false);
    }//GEN-LAST:event_NameMouseReleased

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    try{
    if(TimeIn.getText().isEmpty()){
        Check.setText("Log In");
        String sqlQuery = "insert into Attendance (FirstName , LastName ,  Regular , Tin , Tout,date ) values  ('" + Name.getSelectedItem().toString() + "','" + LastName.getText() + "','" + Date.getText() + "','" + Time.getText() + "','" + TimeOut.getText() + "','" + Date.getText() + "')";
        pst = conn.prepareStatement(sqlQuery);
        pst.execute();   
        TimeIn.setText(Time.getText());
        System.out.println("Noinserte");
        Check.setEnabled(true);
        Check.setVisible(true);
        Login.setEnabled(false);
        Login.setVisible(false);
        LogOut.setEnabled(false);
        LogOut.setVisible(false);
        Attendance.setEnabled(false);
        Attendance.setVisible(false);
        Check.setEnabled(true);
        TimeIn.setText("");
        TimeOut.setText("");
        Password.setText("");
        Check.setText("Check");
    }}
    catch(Exception e){}
    finally{
    try{
        rs.close();
        pst.close();
    }catch(Exception e){}}

    }//GEN-LAST:event_LoginActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
    try{
    String SDate = Date.getText();

    if (TimeOut.getText().isEmpty()){
        Check.setText("Log Out");
        String sqlQuery = "update attendance set Firstname='" + Name.getSelectedItem().toString() + "',LastName='" + LastName.getText() + "',Tout='" + Time.getText() + "' WHERE Regular ='" + SDate + "' and Firstname='" + Name.getSelectedItem().toString() + "'";
        pst = conn.prepareStatement(sqlQuery);
        pst.execute();   
        System.out.println("Iserted");
        Check.setEnabled(true);
        Check.setVisible(true);
        Login.setEnabled(false);
        Login.setVisible(false);
        LogOut.setEnabled(false);
        LogOut.setVisible(false);
        Attendance.setEnabled(false);
        Attendance.setVisible(false);
        TimeIn.setText("");
        TimeOut.setText("");
        Password.setText("");
        Check.setText("Check");
    }


}
catch(Exception e){}
    finally{
    try{

        rs.close();
        pst.close();
    }catch(Exception e){}}

    }//GEN-LAST:event_LogOutActionPerformed

    private void AttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AttendanceActionPerformed

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if(Check.isEnabled()){
        String sqlQuery = "select * from workers where firstname=? and password=?";
        try{
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Name.getSelectedItem().toString());
            pst.setString(2, Password.getText());
            rs = pst.executeQuery();
            if(Name.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "No Name Selected");
            }    
            else if(Password.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Password not inserted");
            }
            if(rs.next()){
                        String TimeO = String.valueOf(TimeOut.getText());
                        if(TimeIn.getText().isEmpty()){
                           System.out.println("Noinserte");
                           Check.setEnabled(false);
                           Check.setVisible(false);
                           Login.setVisible(true);
                           Login.setEnabled(true);
                        }
                        else if (TimeOut.getText().isEmpty()){
                           System.out.println("Iserted");
                           Check.setEnabled(false);
                           Check.setVisible(false);
                           LogOut.setVisible(true);
                           LogOut.setEnabled(true);
                        }
                        else if (TimeO != "" || TimeO != null){
                           Check.setEnabled(false);
                           Check.setVisible(false);
                           Attendance.setVisible(true);
                           Attendance.setEnabled(false);

                        }
            }

            else 
            {
                JOptionPane.showMessageDialog(null,"Please Fill in the Required Data / \n Incorrect Password Inserted");
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
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

        }
        else if(Login.isEnabled()){
                            try{
                if(TimeIn.getText().isEmpty()){
                    String sqlQuery = "insert into Attendance (FirstName , LastName ,  Regular , Tin , Tout ,date ) values  ('" + Name.getSelectedItem().toString() + "','" + LastName.getText() + "','" + Date.getText() + "','" + Time.getText() + "','" + TimeOut.getText() + "','" + Date.getText() + "')";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();   
                    TimeIn.setText(Time.getText());
                    System.out.println("Noinserte");
                        TimeIn.setText("");
                        TimeOut.setText("");
                        Password.setText("");
                        Check.setText("Check");
                        Check.setEnabled(true);
                        Check.setVisible(true);
                        Login.setEnabled(false);
                        Login.setVisible(false);
                        LogOut.setEnabled(false);
                        LogOut.setVisible(false);
                        Attendance.setEnabled(false);
                        Attendance.setVisible(false);
                        Name.setSelectedItem("");
                }}
                catch(Exception e){}
                finally{
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e){}}

        }
        else if(LogOut.isEnabled()){
                        try{
             String SDate = Date.getText();

             if (TimeOut.getText().isEmpty()){
                 String sqlQuery = "update attendance set Firstname='" + Name.getSelectedItem().toString() + "',LastName='" + LastName.getText() + "',Tout='" + Time.getText() + "' WHERE Regular ='" + SDate + "' and Firstname='" + Name.getSelectedItem().toString() + "'";
                 pst = conn.prepareStatement(sqlQuery);
                 pst.execute();   
                 System.out.println("Iserted");
                    Check.setText("Check");
                    TimeIn.setText("");
                    TimeOut.setText("");
                    Password.setText("");
                    Check.setEnabled(true);
                    Check.setVisible(true);
                    Login.setEnabled(false);
                    Login.setVisible(false);
                    LogOut.setEnabled(false);
                    LogOut.setVisible(false);
                    Attendance.setEnabled(false);
                    Attendance.setVisible(false);
                    Name.setSelectedItem("");
             }


         }
         catch(Exception e){}
             finally{
             try{

                 rs.close();
                 pst.close();
             }catch(Exception e){}}

        }
        else if(Attendance.isVisible()){
        TimeIn.setText("");
        TimeOut.setText("");
        Password.setText("");
        Check.setText("Check");
        Check.setEnabled(true);
        Check.setVisible(true);
        Login.setEnabled(false);
        Login.setVisible(false);
        LogOut.setEnabled(false);
        LogOut.setVisible(false);
        Attendance.setEnabled(false);
        Attendance.setVisible(false);
        Name.setSelectedItem("");
        }
        }
    }//GEN-LAST:event_PasswordKeyPressed

    private void RegularbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegularbtnActionPerformed
//Selection Panel
        SelectionPanel.setVisible(false);
        SelectionBg.setVisible(false);
        Regularbtn.setVisible(false);
        Holidaybtn.setVisible(false);
        
        SelectionPanel.setEnabled(false);
        SelectionBg.setEnabled(false);
        Regularbtn.setEnabled(false);
        Holidaybtn.setEnabled(false);
//Selection Panel End
       
//HolidayPanel
        HolidaPassLabel.setVisible(false);
        HolidayAttendance.setVisible(false);
        HolidayBg.setVisible(false);
        HolidayCheck.setVisible(false);
        HolidayLastName.setVisible(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setVisible(false);
        HolidayName.setVisible(false);
        HolidayNameLabel.setVisible(false);
        HolidayPanel.setVisible(false);
        HolidayTimeIn.setVisible(false);
        HolidayTimeOut.setVisible(false);
        HolidayTimeinLabel.setVisible(false);
        HolidayTimeoutLabel.setVisible(false);
        Holidaypassword.setVisible(false);
        
        HolidaPassLabel.setEnabled(false);
        HolidayAttendance.setEnabled(false);
        HolidayBg.setEnabled(false);
        HolidayCheck.setEnabled(false);
        HolidayLastName.setEnabled(false);
        HolidayLogin.setEnabled(false);
        HolidayLogout.setEnabled(false);
        HolidayName.setEnabled(false);
        HolidayNameLabel.setEnabled(false);
        HolidayPanel.setEnabled(false);
        HolidayTimeIn.setEnabled(false);
        HolidayTimeOut.setEnabled(false);
        HolidayTimeinLabel.setEnabled(false);
        HolidayTimeoutLabel.setEnabled(false);
        Holidaypassword.setEnabled(false);
//HolidayPanel
        
//RegularPanel  
        TimeOut.setVisible(true);
        TimeIn.setVisible(true);
        Password.setVisible(true);
        TimeoutLabel.setVisible(true);
        TimeInLabel.setVisible(true);
        Login.setVisible(false);
        LogOut.setVisible(false);
        Attendance.setVisible(false);
        Check.setVisible(true);
        NameLabel.setVisible(true);
        PasswordLabel.setVisible(true);
        Name.setVisible(true);
        LastName.setVisible(false);
        
        TimeOut.setEnabled(true);
        TimeIn.setEnabled(true);
        Password.setEnabled(true);
        TimeoutLabel.setEnabled(true);
        TimeInLabel.setEnabled(true);
        Login.setEnabled(false);
        LogOut.setEnabled(false);
        Attendance.setEnabled(false);
        Check.setEnabled(true);
        NameLabel.setEnabled(true);
        PasswordLabel.setEnabled(true);
        Name.setEnabled(true);
        LastName.setEnabled(true);
//RegularPanel     
    }//GEN-LAST:event_RegularbtnActionPerformed

    private void HolidayAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HolidayAttendanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HolidayAttendanceActionPerformed

    private void HolidayNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_HolidayNamePopupMenuWillBecomeInvisible
        String Selected = (String) HolidayName.getSelectedItem();
    try{    
        try {
            String sqlQuery = "Select FirstName,LastName from Workers where Firstname=?";
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Last = rs.getString("LastName");
                HolidayLastName.setText(Last);
            }}catch (Exception e) {}
        try{
            String sqlQuery = "select * from attendance where firstname='"+Selected+"' and Holiday='"+Date.getText()+"' ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            String Qdate = rs.getString("Holiday");
          //System.out.println(Qdate);
            if (rs.next()){
                String login = rs.getString("Tin");
                HolidayTimeIn.setText(login);
                String logout = rs.getString("Tout");
                HolidayTimeOut.setText(logout);
              System.out.println(Qdate +login +logout);
            }}catch(Exception e){}
    }
        finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_HolidayNamePopupMenuWillBecomeInvisible

    private void HolidayNameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HolidayNameMouseReleased
//HolidayPanel
        HolidayTimeIn.setText("");
        HolidayTimeOut.setText("");
        Holidaypassword.setText("");
        HolidayCheck.setEnabled(true);
        HolidayCheck.setVisible(true);
        HolidayAttendance.setEnabled(false);
        HolidayAttendance.setVisible(false);
        HolidayLogin.setVisible(false);
        HolidayLogin.setEnabled(false);
        HolidayLogout.setVisible(false);
        HolidayLogout.setEnabled(false);

//HolidayPanel
    }//GEN-LAST:event_HolidayNameMouseReleased

    private void HolidayCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HolidayCheckActionPerformed
        String sqlQuery = "select * from workers where firstname=? and password=?";
        try{
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, HolidayName.getSelectedItem().toString());
            pst.setString(2, Holidaypassword.getText());
            rs = pst.executeQuery();
            if(HolidayName.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "No Name Selected");
            }    
            else if(Holidaypassword.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Password not inserted");
            }
            if(rs.next()){
                        String TimeO = String.valueOf(HolidayTimeOut.getText());
                        if(HolidayTimeIn.getText().isEmpty()){
                           System.out.println("Noinserte");
                           HolidayCheck.setEnabled(false);
                           HolidayCheck.setVisible(false);
                           HolidayLogin.setVisible(true);
                           HolidayLogin.setEnabled(true);
                        }
                        else if (HolidayTimeOut.getText().isEmpty()){
                           System.out.println("Iserted");
                           HolidayCheck.setEnabled(false);
                           HolidayCheck.setVisible(false);
                           HolidayLogout.setVisible(true);
                           HolidayLogout.setEnabled(true);
                        }
                        else if (TimeO != "" || TimeO != null){
                           HolidayCheck.setEnabled(false);
                           HolidayCheck.setVisible(false);
                           HolidayAttendance.setVisible(true);
                           HolidayAttendance.setEnabled(false);

                        }
            }

            else 
            {
                JOptionPane.showMessageDialog(null,"Please Fill in the Required Data / \n Incorrect Password Inserted");
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
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

    }//GEN-LAST:event_HolidayCheckActionPerformed

    private void HolidaypasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HolidaypasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if(HolidayCheck.isEnabled()){
        String sqlQuery = "select * from workers where firstname=? and password=?";
        try{
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, HolidayName.getSelectedItem().toString());
            pst.setString(2, Holidaypassword.getText());
            rs = pst.executeQuery();
            if(HolidayName.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "No Name Selected");
            }    
            else if(Holidaypassword.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Password not inserted");
            }
            if(rs.next()){
                        String TimeO = String.valueOf(HolidayTimeIn.getText());
                        if(HolidayTimeIn.getText().isEmpty()){
                           System.out.println("Holiday key login");
                           HolidayCheck.setEnabled(false);
                           HolidayCheck.setVisible(false);
                           HolidayLogin.setVisible(true);
                           HolidayLogin.setEnabled(true);
                        }
                        else if (HolidayTimeOut.getText().isEmpty()){
                           System.out.println("Holiday key logout");
                           HolidayCheck.setEnabled(false);
                           HolidayCheck.setVisible(false);
                           HolidayLogout.setVisible(true);
                           HolidayLogout.setEnabled(true);
                        }
                        else if (TimeO != "" || TimeO != null){
                           HolidayCheck.setEnabled(false);
                           HolidayCheck.setVisible(false);
                           HolidayAttendance.setVisible(true);
                           HolidayAttendance.setEnabled(false);

                        }
            }

            else 
            {
                JOptionPane.showMessageDialog(null,"Please Fill in the Required Data / \n Incorrect Password Inserted");
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
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

        }
        else if(HolidayLogin.isEnabled()){
                            try{
                if(HolidayTimeIn.getText().isEmpty()){
                    HolidayCheck.setText("Log In");
                    String sqlQuery = "insert into Attendance (FirstName , LastName ,  Holiday , Tin , Tout, date ) values  ('" + HolidayName.getSelectedItem().toString() + "','" + HolidayLastName.getText() + "','" + Date.getText() + "','" + Time.getText() + "','" + HolidayTimeOut.getText() + "','" + Date.getText() + "')";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();   
                    HolidayTimeIn.setText(Time.getText());
                    System.out.println("Noinserte");
        HolidayTimeIn.setText("");
        HolidayTimeOut.setText("");
        Holidaypassword.setText("");
        HolidayCheck.setText("Check");
        HolidayCheck.setEnabled(true);
        HolidayCheck.setVisible(true);
        HolidayLogin.setEnabled(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setEnabled(false);
        HolidayLogout.setVisible(false);
        HolidayAttendance.setEnabled(false);
        HolidayAttendance.setVisible(false);
        HolidayName.setSelectedItem("");
                }}
                catch(Exception e){}
                finally{
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e){}}

        }
        else if(HolidayLogout.isEnabled()){
                        try{
             String SDate = Date.getText();

             if (HolidayTimeOut.getText().isEmpty()){
                 String sqlQuery = "update attendance set Firstname='" + HolidayName.getSelectedItem().toString() + "',LastName='" + HolidayLastName.getText() + "',Tout='" + Time.getText() + "' WHERE Holiday ='" + SDate + "' and Firstname='" + HolidayName.getSelectedItem().toString() + "'";
                 pst = conn.prepareStatement(sqlQuery);
                 pst.execute();   
                 System.out.println("Iserted");
        HolidayTimeIn.setText("");
        HolidayTimeOut.setText("");
        Holidaypassword.setText("");
        HolidayCheck.setText("Check");
        HolidayCheck.setEnabled(true);
        HolidayCheck.setVisible(true);
        HolidayLogin.setEnabled(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setEnabled(false);
        HolidayLogout.setVisible(false);
        HolidayAttendance.setEnabled(false);
        HolidayAttendance.setVisible(false);
        HolidayName.setSelectedItem("");
             }


         }
         catch(Exception e){}
             finally{
             try{

                 rs.close();
                 pst.close();
             }catch(Exception e){}}

        }
        else if(HolidayAttendance.isVisible()){
        HolidayTimeIn.setText("");
        HolidayTimeOut.setText("");
        Holidaypassword.setText("");
        HolidayCheck.setText("Check");
        HolidayCheck.setEnabled(true);
        HolidayCheck.setVisible(true);
        HolidayLogin.setEnabled(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setEnabled(false);
        HolidayLogout.setVisible(false);
        HolidayAttendance.setEnabled(false);
        HolidayAttendance.setVisible(false);
        HolidayName.setSelectedItem("");
        }
        }
    }//GEN-LAST:event_HolidaypasswordKeyPressed

    private void HolidayLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HolidayLogoutActionPerformed
    try{
    String SDate = Date.getText();

    if (HolidayTimeOut.getText().isEmpty()){
        String sqlQuery = "update attendance set Firstname='" + HolidayName.getSelectedItem().toString() + "',LastName='" + HolidayLastName.getText() + "',Tout='" + Time.getText() + "' WHERE Holiday ='" + SDate + "' and Firstname='" + HolidayName.getSelectedItem().toString() + "'";
        pst = conn.prepareStatement(sqlQuery);
        pst.execute();   
        System.out.println("HolidayTimeout");
        HolidayCheck.setEnabled(true);
        HolidayCheck.setVisible(true);
        HolidayLogin.setEnabled(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setEnabled(false);
        HolidayLogout.setVisible(false);
        HolidayAttendance.setEnabled(false);
        HolidayAttendance.setVisible(false);
        HolidayTimeIn.setText("");
        HolidayTimeOut.setText("");
        Holidaypassword.setText("");
        HolidayCheck.setText("Check");
    }


}
catch(Exception e){}
    finally{
    try{

        rs.close();
        pst.close();
    }catch(Exception e){}}

    }//GEN-LAST:event_HolidayLogoutActionPerformed

    private void HolidayLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HolidayLoginActionPerformed
    try{
    if(HolidayTimeIn.getText().isEmpty()){
        String sqlQuery = "insert into Attendance (FirstName , LastName ,  Holiday , Tin , Tout,date ) values  ('" + HolidayName.getSelectedItem().toString() + "','" + HolidayLastName.getText() + "','" + Date.getText() + "','" + Time.getText() + "','" + HolidayTimeOut.getText() + "','" + Date.getText() + "')";
        pst = conn.prepareStatement(sqlQuery);
        pst.execute();   
        HolidayTimeIn.setText(Time.getText());
        System.out.println("HOlidayTimeiN");
        HolidayCheck.setEnabled(true);
        HolidayCheck.setVisible(true);
        HolidayLogin.setEnabled(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setEnabled(false);
        HolidayLogout.setVisible(false);
        HolidayAttendance.setEnabled(false);
        HolidayAttendance.setVisible(false);
        HolidayTimeIn.setText("");
        HolidayTimeOut.setText("");
        Holidaypassword.setText("");
        HolidayCheck.setText("Check");
    }}
    catch(Exception e){}
    finally{
    try{
        rs.close();
        pst.close();
    }catch(Exception e){}}
    }//GEN-LAST:event_HolidayLoginActionPerformed

    private void HolidaybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HolidaybtnActionPerformed
//Selection Panel
        SelectionPanel.setVisible(false);
        SelectionBg.setVisible(false);
        Regularbtn.setVisible(false);
        Holidaybtn.setVisible(false);
        
        SelectionPanel.setEnabled(false);
        SelectionBg.setEnabled(false);
        Regularbtn.setEnabled(false);
        Holidaybtn.setEnabled(false);
//Selection Panel End
       
//HolidayPanel
        HolidaPassLabel.setVisible(true);
        HolidayAttendance.setVisible(false);
        HolidayBg.setVisible(true);
        HolidayCheck.setVisible(true);
        HolidayLastName.setVisible(false);
        HolidayLogin.setVisible(false);
        HolidayLogout.setVisible(false);
        HolidayName.setVisible(true);
        HolidayNameLabel.setVisible(true);
        HolidayPanel.setVisible(true);
        HolidayTimeIn.setVisible(true);
        HolidayTimeOut.setVisible(true);
        HolidayTimeinLabel.setVisible(true);
        HolidayTimeoutLabel.setVisible(true);
        Holidaypassword.setVisible(true);
        
        HolidaPassLabel.setEnabled(true);
        HolidayAttendance.setEnabled(false);
        HolidayBg.setEnabled(true);
        HolidayCheck.setEnabled(true);
        HolidayLastName.setEnabled(true);
        HolidayLogin.setEnabled(false);
        HolidayLogout.setEnabled(false);
        HolidayName.setEnabled(true);
        HolidayNameLabel.setEnabled(true);
        HolidayPanel.setEnabled(true);
        HolidayTimeIn.setEnabled(true);
        HolidayTimeOut.setEnabled(true);
        HolidayTimeinLabel.setEnabled(true);
        HolidayTimeoutLabel.setEnabled(true);
        Holidaypassword.setEnabled(true);
//HolidayPanel
        
//RegularPanel  
        TimeOut.setVisible(false);
        TimeIn.setVisible(false);
        Password.setVisible(false);
        TimeoutLabel.setVisible(false);
        TimeInLabel.setVisible(false);
        Login.setVisible(false);
        LogOut.setVisible(false);
        Attendance.setVisible(false);
        Check.setVisible(false);
        NameLabel.setVisible(false);
        PasswordLabel.setVisible(false);
        Name.setVisible(false);
        LastName.setVisible(false);
        
        TimeOut.setEnabled(false);
        TimeIn.setEnabled(false);
        Password.setEnabled(false);
        TimeoutLabel.setEnabled(false);
        TimeInLabel.setEnabled(false);
        Login.setEnabled(false);
        LogOut.setEnabled(false);
        Attendance.setEnabled(false);
        Check.setEnabled(false);
        NameLabel.setEnabled(false);
        PasswordLabel.setEnabled(false);
        Name.setEnabled(false);
        LastName.setEnabled(false);
//RegularPanel           
    }//GEN-LAST:event_HolidaybtnActionPerformed

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
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Worker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attendance;
    private javax.swing.JButton Check;
    private javax.swing.JLabel Date;
    private javax.swing.JLabel HolidaPassLabel;
    private javax.swing.JButton HolidayAttendance;
    private javax.swing.JLabel HolidayBg;
    private javax.swing.JButton HolidayCheck;
    private javax.swing.JLabel HolidayLastName;
    private javax.swing.JButton HolidayLogin;
    private javax.swing.JButton HolidayLogout;
    private javax.swing.JComboBox HolidayName;
    private javax.swing.JLabel HolidayNameLabel;
    private javax.swing.JPanel HolidayPanel;
    private javax.swing.JTextField HolidayTimeIn;
    private javax.swing.JTextField HolidayTimeOut;
    private javax.swing.JLabel HolidayTimeinLabel;
    private javax.swing.JLabel HolidayTimeoutLabel;
    private javax.swing.JButton Holidaybtn;
    private javax.swing.JPasswordField Holidaypassword;
    private javax.swing.JLabel LastName;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton Login;
    private javax.swing.JComboBox Name;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton Regularbtn;
    private javax.swing.JLabel SelectionBg;
    private javax.swing.JPanel SelectionPanel;
    private javax.swing.JLabel Time;
    private javax.swing.JTextField TimeIn;
    private javax.swing.JLabel TimeInLabel;
    private javax.swing.JTextField TimeOut;
    private javax.swing.JLabel TimeoutLabel;
    private javax.swing.JLabel background;
    // End of variables declaration//GEN-END:variables
}



