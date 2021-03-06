package scene.object;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import logic.collision.CollisionShape;
import pipeline.Model;
import pipeline.Texture;
import scene.Scene;

public class StaticEntity extends VisibleObject {
	
	public CollisionShape collision = null;
	public Vector3f position = null;
	public Vector3f rotation = null;
	public float scale = 1f;

	public StaticEntity(Model model, Texture texture, Matrix4f matrix, boolean dontRender) {
		super(model, texture, matrix, dontRender);
	}
	
	public StaticEntity(Model model, String texture) {
		super(model, texture);
	}

	public StaticEntity() {
		super(null, null, null, true);
	}
	
	public void updateMatrix() {
		Matrix4f m = getMatrix();
		m.identity();
		m.translate(position);
		m.rotate(rotation);
		m.scale(scale);
		if (collision != null)
			collision.update(position, rotation, scale);
	}

	public CollisionShape getCollision() {
		return collision;
	}

	public void update(Scene scene) {
		updateMatrix();
	}
}
