package scene;

import util.Vector2d;

import java.util.List;

/**
 * Created by kiarash on 7/16/16.
 */
public abstract class SceneNode {

    private SceneManager sm;

    // relative to parent
    protected Vector2d position, scale;
    protected double rotation;
    protected Vector2d velocity;

    protected List<SceneNode> children;

    SceneNode() {
        position = new Vector2d();
        rotation = 0.0;
        scale = new Vector2d();
        velocity = new Vector2d();
    }

    public void attachChild(SceneNode node) {
        node.sm = sm;
        children.add(node);
        sm.nodes.add(node);
    }

    public void detachChild(SceneNode node) {
        children.remove(node);
        sm.nodes.remove(node);
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Vector2d getScale() {
        return scale;
    }

    public void setScale(Vector2d scale) {
        this.scale = scale;
    }

    public Vector2d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
    }

}
