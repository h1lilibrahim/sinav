package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResimGalerisi {

    private JFrame pencere;
    private JLabel resimAlani;
    private JLabel aciklamaAlani;
    private JButton oncekiButon;
    private JButton sonrakiButon;

    private String[] resimYollari = {
            "resim/resim1.jpg",
            "resim/resim2.jpg",
            "resim/resim3.jpg"
    };

    private String[] resimAciklamalari = {
            "Resim 1 Açıklaması",
            "Resim 2 Açıklaması",
            "esim 3 Açıklaması"
    };

    private int mevcutIndeks = 0;

    public ResimGalerisi() {
        // Pencere ayarları
        pencere = new JFrame("Resim Galerisi");
        pencere.setSize(800, 600);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setLayout(new BorderLayout());

        // Kuzey paneli: Butonlar
        JPanel kuzeyPaneli = new JPanel();
        oncekiButon = new JButton("Önceki");
        sonrakiButon = new JButton("Sonraki");

        kuzeyPaneli.add(oncekiButon);
        kuzeyPaneli.add(sonrakiButon);
        pencere.add(kuzeyPaneli, BorderLayout.NORTH);

        // Merkez paneli: Resim alanı
        resimAlani = new JLabel();
        resimAlani.setHorizontalAlignment(SwingConstants.CENTER);
        pencere.add(resimAlani, BorderLayout.CENTER);

        // Güney paneli: Açıklama alanı
        aciklamaAlani = new JLabel("", SwingConstants.CENTER);
        pencere.add(aciklamaAlani, BorderLayout.SOUTH);

        // Butonlara tıklama olayları
        oncekiButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oncekiResmiGoster();
            }
        });

        sonrakiButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sonrakiResmiGoster();
            }
        });

        // İlk resmi yükle
        galeriyiGuncelle();

        // Pencereyi göster
        pencere.setVisible(true);
    }

    private void oncekiResmiGoster() {
        mevcutIndeks--;
        if (mevcutIndeks < 0) {
            mevcutIndeks = resimYollari.length - 1;
        }
        galeriyiGuncelle();
    }

    private void sonrakiResmiGoster() {
        mevcutIndeks++;
        if (mevcutIndeks >= resimYollari.length) {
            mevcutIndeks = 0;
        }
        galeriyiGuncelle();
    }

    private void galeriyiGuncelle() {
        ImageIcon ikon = new ImageIcon(resimYollari[mevcutIndeks]);
        resimAlani.setIcon(ikon);
        aciklamaAlani.setText(resimAciklamalari[mevcutIndeks]);
    }


}
