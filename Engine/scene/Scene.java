package scene;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;

import opengl.Application;
import particles.ParticleHandler;
import scene.entity.Entity;
import scene.entity.EntityRenderer;
import scene.gui.Gui;
import scene.object.StaticEntity;
import scene.world.World;
import scene.world.terrain.Terrain;

public class Scene {
	protected Gui gui;
	protected Camera camera;
	protected Vector3f lightDirection = new Vector3f(0,1,0);
	
	private List<Entity> entities = new ArrayList<Entity>();
	private List<StaticEntity> objects = new ArrayList<StaticEntity>();
	
	protected boolean isLoading = false;

	public Scene() {
		isLoading = true;
		camera = new Camera();
		gui = new Gui();
		ParticleHandler.init(camera);
	}
	
	public void load() {
	}
	
	public void startTick() {
	}
	
	public void update() {
		if (Application.paused || isLoading()) {
			gui.update();
			return;
		}
		
		for(int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.update(this);
		}
		
		for(int i = 0; i < objects.size(); i++) {
			StaticEntity object = objects.get(i);
			if (object == null) continue;
			object.update(this);
		}
		
		camera.move();
		gui.update();
		ParticleHandler.update(camera);
		
	}
	
	public void cleanUp() {
		for ( StaticEntity entity : objects) {
			entity.destroy();
		}
		for ( Entity entity : entities) {
			EntityRenderer.removeEntity(entity);
			entity.getSource().delete();
		}
		gui.cleanUp();
		ParticleHandler.cleanUp();
	}

	public Camera getCamera() {
		return camera;
	}
	
	// This should return null if these is no heightmap
	public Terrain getTerrain() {
		return null;
	}
	
	public World getWorld() {
		return null;
	}
	
	public Vector3f getLightDirection() {
		return lightDirection;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	public void addObject(StaticEntity entity) {
		objects.add(entity);
	}
	
	public void removeObject(StaticEntity entity) {
		objects.remove(entity);
	}
	
	public List<StaticEntity> getObjects() {
		return objects;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}

	public Gui getGui() {
		return gui;
	}

	public void setLoading(boolean loading) {
		this.isLoading = loading;
	}

	public boolean isLoading() {
		return isLoading;
	}
}
