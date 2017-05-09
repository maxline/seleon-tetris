# Simple tetris game
Swing, AWT, MVC

## Swing docs
http://www.skipy.ru/technics/gui_int.html
http://www.skipy.ru/philosophy/visualDesigners.html
http://docs.oracle.com/javase/tutorial/2d/basic2d/index.html
http://docs.oracle.com/javase/tutorial/uiswing/painting/index.html

## Principle of operation
В Swing каждый компонент отрисовывает сам себя в методе paintComponent(Graphics g).
То-есть при вызове метода repaint() вызовется этот метод, в котором сказано только про нарисованную линию - то, что в методе main нигде не сохранится.
Если вы хотите рисовать на компоненте, храните то, что хотите нарисовать в переменной и передавайте в метод paintComponent()

`public class CustomPanel extends JPanel {`
     `protected void paintComponent(Graphics g) {`
            `super.paintComponent(g); // рисуем панель`
            `// Рисуем все что душе угодно`
     `}`
`}`