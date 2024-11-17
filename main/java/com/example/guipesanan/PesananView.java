package com.example.guipesanan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PesananView {
    private JFrame frame;
    private JLabel title, nama, alamat, telp, totalNum;
    private JTextField txtNama, txtAlamat, txtNoTelp;
    private JCheckBox cbSteak, cbSpaghetti, cbPizza;
    private JButton submit;
    private JTextArea historyData;

    public PesananView() {
        // Create the main frame
        frame = new JFrame("GUI Pesanan Makanan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 700);
        frame.setLayout(new BorderLayout());

        title = new JLabel("APLIKASI PEMESANAN");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));

        // Customer data panel
        JPanel pnlCustomer = new JPanel(new GridLayout(3, 2));
        pnlCustomer.setBorder(BorderFactory.createTitledBorder("Data Customer"));

        nama = new JLabel("Nama:");
        txtNama = new JTextField();

        alamat = new JLabel("Alamat:");
        txtAlamat = new JTextField();

        telp = new JLabel("No Telp");
        txtNoTelp = new JTextField();

        pnlCustomer.add(nama);
        pnlCustomer.add(txtNama);
        pnlCustomer.add(alamat);
        pnlCustomer.add(txtAlamat);
        pnlCustomer.add(telp);
        pnlCustomer.add(txtNoTelp);

        // Menu selection panel
        JPanel pnlMenu = new JPanel(new GridLayout(3, 1));
        pnlMenu.setBorder(BorderFactory.createTitledBorder("Pilih Menu"));

        cbSteak = new JCheckBox("Steak");
        pnlMenu.add(cbSteak);

        cbSpaghetti = new JCheckBox("Spaghetti");
        pnlMenu.add(cbSpaghetti);

        cbPizza = new JCheckBox("Pizza");
        pnlMenu.add(cbPizza);

        // Input panel (Customer data + Menu)
        JPanel pnlInput = new JPanel();
        pnlInput.setLayout(new GridLayout(1, 2));
        pnlInput.add(pnlCustomer);
        pnlInput.add(pnlMenu);
        mainPanel.add(pnlInput);
        mainPanel.add(Box.createVerticalStrut(10));

        // Submit panel
        JPanel pnlSubmitOuter = new JPanel(new GridLayout(1, 2));
        pnlSubmitOuter.add(new JLabel());

        JPanel pnlSubmit = new JPanel();
        pnlSubmit.setLayout(new BoxLayout(pnlSubmit, BoxLayout.Y_AXIS));

        JPanel pnlSubmitTop = new JPanel(new GridLayout(1,2));
        JPanel pnlSubmitMid = new JPanel(new GridLayout(1,1));
        JPanel pnlSubmitBot = new JPanel(new GridLayout(1,3));


        pnlSubmitTop.add(new JLabel("TOTAL BAYAR"));
        pnlSubmit.add(pnlSubmitTop);


        totalNum = new JLabel("0");
        totalNum.setHorizontalAlignment(SwingConstants.RIGHT);
        totalNum.setFont(new Font("Arial", Font.BOLD, 16));
        totalNum.setForeground(Color.YELLOW);
        totalNum.setOpaque(true);
        totalNum.setBackground(Color.BLACK);
        pnlSubmitMid.add(totalNum);
        pnlSubmit.add(pnlSubmitMid);
        pnlSubmit.add(Box.createVerticalStrut(10));


        submit = new JButton("TAMBAH");
        pnlSubmitBot.add(new JLabel());
        pnlSubmitBot.add(new JLabel());
        pnlSubmitBot.add(submit);
        pnlSubmit.add(pnlSubmitBot);

        pnlSubmitOuter.add(pnlSubmit);
        mainPanel.add(pnlSubmitOuter);

        mainPanel.add(Box.createVerticalStrut(10));

        // Data panel
        JPanel pnlData = new JPanel();
        pnlData.setLayout(new GridLayout(1,1));
        pnlData.setBorder(BorderFactory.createTitledBorder("Data Penjualan"));

        historyData = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(historyData);
        scrollPane.setMinimumSize(new Dimension(630, 400));
        scrollPane.setPreferredSize(scrollPane.getMinimumSize());
        pnlData.add(scrollPane);

        mainPanel.add(pnlData);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setResizable(true);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public void show() {
        frame.setVisible(true);
    }
    
    //getters

    public JButton getSubmit() {
        return submit;
    }

    public JCheckBox getcbPizza() {
        return cbPizza;
    }

    public JCheckBox getcbSpaghetti() {
        return cbSpaghetti;
    }

    public JCheckBox getcbSteak() {
        return cbSteak;
    }

    public JLabel getTotalNum() {
        return totalNum;
    }

    public JTextField getTxtAlamat() {
        return txtAlamat;
    }

    public JTextField getTxtNama() {
        return txtNama;
    }

    public JTextField getTxtNoTelp() {
        return txtNoTelp;
    }

    public JTextArea getHistoryData() {
        return historyData;
    }

    //add event listener

    public void addCbEventListener(ActionListener a){
        cbPizza.addActionListener(a);
        cbSpaghetti.addActionListener(a);
        cbSteak.addActionListener(a);
    }

    public  void addSubmitEventListener(ActionListener a){
        submit.addActionListener(a);
    }
}
