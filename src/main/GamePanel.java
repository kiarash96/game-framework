package main;

import javax.swing.JPanel;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by kiarash on 7/16/16.
 */
public class GamePanel extends JPanel {

    Queue<AWTEvent> eventQueue;

    public GamePanel(int width, int height) {
        super();

        eventQueue = new ConcurrentLinkedQueue<>();
        enableEvents(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK
                | AWTEvent.KEY_EVENT_MASK);

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void processEvent(AWTEvent e) {
        eventQueue.add(e);
    }

    Queue<AWTEvent> getEventQueue() {
        return eventQueue;
    }
}
