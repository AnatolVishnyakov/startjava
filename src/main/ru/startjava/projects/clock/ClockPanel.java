package ru.startjava.projects.clock;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

class ClockPanel extends GraphicsCore {
    @Override
    protected void showGraphics(Graphics graphics) {
        /*
            {рисование циферблата}
            for i:=1 to 12 do
            begin
              xt:=115 + round(100*sin(6.28*30*i/360));
              yt:=115 - round(100*cos(6.28*30*i/360));
        //      MoveTo(xt, yt);
              str(i,s);
              TextOut(xt,yt,s);
            end;
        * */
        for (int i = 1; i <= 12; i++) {
            final int xt = (int) (115 + abs(100 * sin(6.28 * 30 * i / 360)));
            final int yt = (int) (115 - abs(100 * cos(6.28 * 30 * i / 360)));
            final String hour = String.valueOf(i);

            final JLabel label = new JLabel(hour) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
//                    g.drawString(hour, xt, yt);
                    setBounds(xt, yt, 115, 115);
                }
            };
            this.add(label);
        }
    }

    public static void main(String[] args) {
        run();
    }
}