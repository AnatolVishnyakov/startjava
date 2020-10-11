package ru.startjava.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class GraphicsCore extends JPanel implements ActionListener, MouseListener {
    private final int delay = 500;
    private final int width = 293;
    private final int height = 402;
    private Timer animationTimer;
    protected boolean isMouseClicked;
    protected int mousePosX;
    protected int mousePosY;

    protected GraphicsCore() {
        setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            isMouseClicked = true;
            mousePosX = e.getX();
            mousePosY = e.getY();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
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