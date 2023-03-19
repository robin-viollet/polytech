package ads.lab6;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        final int width = 800;
        final int height = 800;

        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 1; i <= width; ++i){
            values.add(i);
        }

        Collections.shuffle(values);

        JFrame root = new JFrame("Sorting algorithms");
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                for (int i = 0; i < values.size(); ++i){
                    int value = values.get(i);
                    g.drawLine(i, height - value, i, height);
                }
            }
        };

        Dimension dimension = new Dimension(width, height);

        root.setPreferredSize(dimension);
        root.setContentPane(panel);
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setResizable(false);

        root.pack();
        root.setVisible(true);

        values.sort((integer, t1) -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            int comparison = Comparator.<Integer>naturalOrder().compare(integer, t1);
            panel.repaint();
            return comparison;
        });
    }
}
