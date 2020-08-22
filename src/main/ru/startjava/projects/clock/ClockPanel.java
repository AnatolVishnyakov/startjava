package ru.startjava.projects.clock;

import ru.startjava.projects.GraphicsCore;

import java.awt.*;
import java.awt.geom.Line2D;
import java.time.LocalDateTime;

import static java.lang.Math.*;

public class ClockPanel extends GraphicsCore {
    public ClockPanel() {
        super();
    }

    @Override
    protected void showGraphics(Graphics graphics) {
        // Рисование циферблата
        for (int i = 1; i <= 12; i++) {
            final int xt = (int) (115 + round(100 * sin(6.28 * 30 * i / 360)));
            final int yt = (int) (115 - round(100 * cos(6.28 * 30 * i / 360)));
            final String hour = String.valueOf(i);
            graphics.setColor(Color.black);
            graphics.drawString(hour, xt, yt);
        }

        graphics.setColor(Color.black);
        graphics.fillOval(112, 100, 10, 10);

        // Получение текущего времени
        LocalDateTime dateTime = LocalDateTime.now();
        final int hour = dateTime.getHour();
        final int minute = dateTime.getMinute();
        final int second = dateTime.getSecond();

        // Рисование секундной стрелки
        final int xs = (int) (115 + round(90 * sin(6.28 * second / 60)));
        final int ys = (int) (115 - round(90 * cos(6.28 * second / 60)));
        graphics.setColor(Color.red);
        graphics.drawLine(117, 105, xs, ys);

        // Рисование минутной стрелки
        final int xm = (int) (115 + round(85 * sin(6.28 * minute / 60)));
        final int ym = (int) (115 - round(85 * cos(6.28 * minute / 60)));
        final Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(new Line2D.Float(117, 105, xm, ym));

        // Рисование часовой стрелки
        final int xh = (int) (115 + round(40 * sin(6.28 * hour / 12)));
        final int yh = (int) (115 - round(40 * cos(6.28 * hour / 12)));
        graphics.drawLine(117, 105, xh, yh);
    }

    public static void main(String[] args) {
        run(new ClockPanel(), "Clock");
    }
}