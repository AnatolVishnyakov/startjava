package ru.startjava.projects.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class GraphicsCore extends JPanel implements ActionListener {
    private final int delay = 10;
    private final int width = 1_000;
    private final int height = 700;
    private Timer animationTimer; // timer controlling frame rate

    GraphicsCore() {
        setPreferredSize(new Dimension(width, height));

        this.animationTimer = new Timer(delay, this);
        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* Fill in background */
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        showGraphics(g);
    }

    protected abstract void showGraphics(Graphics graphics);

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void start() {
        animationTimer.start();
    }

    public void stop() {
        animationTimer.stop();
    }

    static void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Solar System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ClockPanel panel = new ClockPanel();

                frame.add(panel);       // Add panel to frame
                frame.pack();           // Set component sizes and layout
                frame.setVisible(true); // Display the resulting frame
            }
        });
    }
}