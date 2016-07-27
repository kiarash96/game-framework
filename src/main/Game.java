package main;

import scene.SceneManager;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Created by kiarash on 7/16/16.
 */
public class Game {

    JFrame window;
    GamePanel panel;

    public static final int WIDTH = 1280, HEIGHT = 960;
    public static final int FPS = 60;
    public static final double DT = (double) 1000 * 1000 * 1000 / FPS; // in nano seconds

    Image buffer;
    boolean running;

    SceneManager sm;

    Game() {
        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        running = true;
        sm = new SceneManager();
    }

    public void run() throws InterruptedException {
        panel = new GamePanel(WIDTH, HEIGHT);

        window = new JFrame("My Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        this.mainLoop();
    }

    public void mainLoop() throws InterruptedException {
        double timeSinceLastUpdate = 0.0, clock = 0.0;
        while (running) {
            processInput();

            double now = System.nanoTime();
            timeSinceLastUpdate += (clock == 0.0 ? 0.0 : now - clock);
            clock = now;

            while (timeSinceLastUpdate > DT) {
                timeSinceLastUpdate -= DT;

                processInput();
                update(DT / (1000 * 1000 * 1000));
            }

            render();
        }
    }

    private void processInput() {
        while (!panel.getEventQueue().isEmpty()) {
            // TODO: process event
            System.err.println(panel.getEventQueue().poll());
        }
    }

    private void update(double dt) {
        sm.update(dt);
    }

    private void render() {
        Graphics2D g = (Graphics2D) buffer.getGraphics();

        // clear the buffer
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        sm.render(g);

        // draw the buffer on screen
        panel.getGraphics().drawImage(buffer, 0, 0, null);
    }
}
