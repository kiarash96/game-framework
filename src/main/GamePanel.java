package main;

import javax.swing.JPanel;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by kiarash on 7/16/16.
 */
public class GamePanel extends JPanel {
    public static final int WIDTH = 1280, HEIGHT = 960;
    public static final int FPS = 60;

    Image buffer;
    Queue<AWTEvent> eventQueue;
    boolean running;

    public GamePanel() {
        super();

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        running = true;

        eventQueue = new ConcurrentLinkedQueue<>();
        enableEvents(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK
                    | AWTEvent.KEY_EVENT_MASK);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void processEvent(AWTEvent e) {
        eventQueue.add(e);
    }

    public void mainLoop() {
        while (running) {
            processInput();
            update();
            render();
        }
    }

    private void processInput() {
        while (!eventQueue.isEmpty()) {
            // TODO: process event
            System.err.println(eventQueue.poll());
        }
    }

    private void update() {
        // TODO
    }

    private void render() {
        // TODO
    }
}
