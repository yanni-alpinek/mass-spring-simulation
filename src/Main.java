import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double startX = 0.5;
        double masa = 1.0;
        double k = 10.0;

        Kulka kulka = new Kulka(masa, startX, 0.0);
        Sprezyna sprezyna = new Sprezyna(k, 1.0, kulka);
        Polaczenie polaczenie = new Polaczenie(startX, sprezyna);
        SymulacjaGUI panel = new SymulacjaGUI(polaczenie);

        Timer timer = new Timer(10, e -> {
            polaczenie.update();
            panel.repaint();
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 2, 5, 5));

        JTextField startXField = new JTextField(String.valueOf(startX));
        JTextField masaField = new JTextField(String.valueOf(masa));
        JTextField kField = new JTextField(String.valueOf(k));
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        controlPanel.add(new JLabel("Start X:"));
        controlPanel.add(startXField);
        controlPanel.add(new JLabel("Masa kulki:"));
        controlPanel.add(masaField);
        controlPanel.add(new JLabel("Sprężyna k:"));
        controlPanel.add(kField);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);

        startButton.addActionListener(e -> {
            try {
                double newX = Double.parseDouble(startXField.getText());
                double newMasa = Double.parseDouble(masaField.getText());
                double newK = Double.parseDouble(kField.getText());

                Kulka newKulka = new Kulka(newMasa, newX, 0.0);
                Sprezyna newSprezyna = new Sprezyna(newK, 1.0, newKulka);

                polaczenie.setSprezyna(newSprezyna);
                polaczenie.setX(newX);

                timer.start();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Niepoprawne wartości!");
            }
        });

        stopButton.addActionListener(e -> timer.stop());

        JFrame frame = new JFrame("Symulacja kulki na sprężynie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
