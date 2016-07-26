package scene;

import util.Vector2d;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiarash on 7/16/16.
 */
public abstract class SceneNode {

    SceneManager sm;

    // relative to parent
    protected Vector2d position, scale;
    protected double rotation;
    protected Vector2d velocity;

    protected List<SceneNode> children;

    public SceneNode() {
        position = new Vector2d();
        rotation = 0.0;
        scale = new Vector2d(1.0, 1.0);
        velocity = new Vector2d();

        children = new ArrayList<>();
    }

    public void attachChild(SceneNode node) {
        node.sm = sm;
        children.add(node);
        sm.nodes.add(node);
    }

    public void detachChild(SceneNode node) {
        children.remove(node);
        sm.nodes.remove(node);
        sm.transformMap.remove(node);
        // TODO: remove children from nodes array and transformMap
    }

    public abstract void drawSelf(Graphics2D g);

    public void recursiveUpdateTransform(AffineTransform reference) {
        AffineTransform transform = (AffineTransform) reference.clone();
        transform.translate(position.getX(), position.getY());
        // TODO: rotate around the center
        transform.rotate(rotation, 0.0, 0.0);
        transform.scale(scale.getX(), scale.getY());

        sm.transformMap.put(this, transform);
        children.forEach(child -> child.recursiveUpdateTransform(transform));
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

    public void move(Vector2d v) {
        position = position.add(v);
    }

    public void rotate(double theta) {
        rotation += theta;
    }

}
