package com.example.guipesanan;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PesananController {
    private PesananView view;

    public PesananController(PesananView view) {
        this.view = view;
        view.addCbEventListener(a -> updateHarga());
        view.addSubmitEventListener(a -> saveHistory());
    }

    void updateHarga(){
        int total = 0;
        if (view.getcbPizza().isSelected())
            total += 25000;
        if (view.getcbSpaghetti().isSelected())
            total += 15000;
        if (view.getcbSteak().isSelected())
            total += 30000;

        view.getTotalNum().setText(String.valueOf(total));
    }

    void saveHistory(){
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telp = view.getTxtNoTelp().getText();
        int total = 0;

        if (nama.isEmpty() || alamat.isEmpty() || telp.isEmpty()) {
            JOptionPane.showMessageDialog(view.getFrame(), "Ada field yang kosong, Harap isi semua field!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!view.getcbSteak().isSelected() && !view.getcbSpaghetti().isSelected() && !view.getcbPizza().isSelected()) {
            JOptionPane.showMessageDialog(view.getFrame(), "Tidak ada makanan yang dipilih, harap pilih salah satu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder msg = new StringBuilder();
        msg.append("Nama: ").append(nama).append("\n");
        msg.append("Alamat: ").append(alamat).append("\n");
        msg.append("No Telp: ").append(telp).append("\n");
        msg.append("----------------------------------\n");

        msg.append("Pesanan:\n");
        if (view.getcbSteak().isSelected()){
            msg.append("\tSteak (30000)\n");
            total += 30000;
        }
        if (view.getcbSpaghetti().isSelected()){
            msg.append("\tSpaghetti (15000)\n");
            total += 15000;
        }
        if (view.getcbPizza().isSelected()){
            msg.append("\tPizza (25000)\n");
            total += 25000;
        }
        msg.append("----------------------------------\n");

        msg.append("Total Bayar:\n");
        msg.append("\tRp. ").append(String.valueOf(total)).append("\n\n\n");

        view.getHistoryData().append(msg.toString());

        view.getTxtAlamat().setText("");
        view.getTxtNama().setText("");
        view.getTxtNoTelp().setText("");
        view.getcbPizza().setSelected(false);
        view.getcbSteak().setSelected(false);
        view.getcbSpaghetti().setSelected(false);
        updateHarga();
    }
}
