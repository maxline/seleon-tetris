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

```java
public class CustomPanel extends JPanel {
     protected void paintComponent(Graphics g) {
            super.paintComponent(g); // рисуем панель
            // Рисуем все что душе угодно
     }
}
```

0. Рефакторинг (todo и убрать sout-ы)
0. Сделать вечный цикл, а не только 20 фигур. и порефакторить метод go.
0. добавить game over.
1. добавить кнопки начать новую игру, выход, пауза.
2. убрать нижнюю всегда заполненную строку
3. исправить проваливание фигуры вниз при нажатии стрелки вниз.
4. сделать показ очков
5. добавить цвета
6. добавить показ, какая фигура следующая появится.
7. добавить уровни, и ускорение на каждом уровне.
8. юнит тесты
9. переписать на javafx, spring
10. сохранение результатов игры в файл.
11. многопоточность?