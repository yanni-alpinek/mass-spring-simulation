import javax.swing.*;
import java.awt.*;

public class SymulacjaGUI extends JPanel {

    private Polaczenie polaczenie;

    public SymulacjaGUI(Polaczenie polaczenie) {
        this.polaczenie = polaczenie;
        setPreferredSize(new Dimension(700, 700));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x0 = getWidth() / 2;
        int y0 = 50;

        g.setColor(Color.BLACK);
        g.fillOval(x0 - 5, y0 - 5, 10, 10);

        int kulkaX = x0;
        int kulkaY = (int) (y0 + polaczenie.getNewX() * 100);

        g.setColor(Color.BLUE);
        g.drawLine(x0, y0, kulkaX, kulkaY);

        g.setColor(Color.RED);
        g.fillOval(kulkaX - 10, kulkaY - 10, 20, 20);
    }

}
