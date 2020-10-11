package ru.startjava.projects.calculator;

import ru.startjava.projects.GraphicsCore;

import java.awt.*;

public class CalculatorApp extends GraphicsCore {
    private int x = 0;
    private int y = 0;

    private Point getCursorLocation() {
        return MouseInfo.getPointerInfo()
                .getLocation();
    }

    private int getCursorCoordinateX() {
        return getCursorLocation().x;
    }

    private int getCursorCoordinateY() {
        return getCursorLocation().y;
    }

    @Override
    protected void showGraphics(Graphics graphics) {
        // Макет калькулятора
        graphics.setColor(Color.BLACK);

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        char[] operations = new char[]{'+', '-', '*', '/'};

        int widthScreen = this.getWidth();

        int posX = 10;
        int posY = 140;

        int posXTeXt = 40;
        int posYText = 175;

        int widthSquare = 50;

        int posXX = 225;
        int posYY = 140;

        int posYT = 175;
        for (int j = 0; j < operations.length; j++) {
            graphics.drawRect(posXX, posYY, 60, 60);
            graphics.drawString(String.valueOf(operations[j]), 255, posYT);
            posYY += 65;
            posYT += 65;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (posX + widthSquare > widthScreen - 100) {
                posX = 10;
                posY += 65;

                posXTeXt = 30;
                posYText += 65;
            }
            if (isMouseClicked) {
//                System.out.println("Key pressed: " + numbers[i]);
//                System.out.println("PosX: " + posX + " / PosX: " + (posX + 60) + " PosY: " + posY + " / PosY: " + (posY + 60));
                if ((mousePosX >= posX && mousePosX <= posX + 60) && (mousePosY >= posY && mousePosY <= posY + 60)) {
                    System.out.println("Click key: " + numbers[i]);
                isMouseClicked = false;
                }
            }
            graphics.drawRect(posX, posY, 60, 60);
            graphics.drawString(String.valueOf(numbers[i]), posXTeXt, posYText);
            posX += 65;
            posXTeXt += 65;
        }

        int XRes = 75;
        int YRes = 335;
        graphics.drawRect(XRes, YRes, 125, 60);
        graphics.drawString("=", 135, 370);

        graphics.drawRect(10, 50, widthScreen - 25, 50);
    }

    public static void main(String[] args) {
        final CalculatorApp calculatorApp = new CalculatorApp();
        run(calculatorApp, "Calculator");
    }
}
