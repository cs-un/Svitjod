package com.svitjod;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.entities.Things;

public class GameScreen implements Screen, InputProcessor {
	private Screen previous;
	private Main main;
	private SpriteBatch batch;
	private Map map;
	private int h, w;
	private OrthographicCamera camera;
	private Texture tex;
	public GameScreen(Main main, MainMenuScreen mms) {
		previous = mms;
		this.main = main;
		batch = new SpriteBatch();
		map = new Map("Uppsala");
		tex = new Texture(Gdx.files.internal("badlogic.jpg"));
		Gdx.input.setInputProcessor(this);
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(1, h/w);
		camera.setToOrtho(false, w, h);
	}

	private void update()
	{
		map.update();
		camera.update();
		//ui.update();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();

		main.batch.setProjectionMatrix(camera.combined);
		main.batch.begin();
		for(ArrayList<Things> at : map.tiles())
		{
			for(Things t : at)
			{
				t.getSprite().draw(main.batch);
			}
		}
		Sprite s = new Sprite(tex);
		s.draw(main.batch);
		main.batch.end();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode==Keys.A)
			camera.rotate(-45);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
