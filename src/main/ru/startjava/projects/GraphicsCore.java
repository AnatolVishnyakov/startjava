package ru.startjava.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GraphicsCore extends JPanel implements ActionListener {
    private final int delay = 500;
    private final int width = 240;
    private final int height = 230;
    private Timer animationTimer;

    protected GraphicsCore() {
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

        System.out.println(this.getHeight());
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

    protected static void run(JPanel panel, String title) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame(title);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);       // Add panel to frame
                frame.pack();           // Set component sizes and layout
                frame.setVisible(true); // Display the resulting frame
            }
        });
    }
}