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
	private int xAcc = 0, yAcc = 0;
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
		camera.position.x += 1500;
		camera.position.y -= 500;
	}

	private void update()
	{
		map.update();
		//camera.position.x += xAcc;
		//camera.position.y += yAcc;
		camera.translate(xAcc, yAcc); //exakt samma som ovan
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
		/*ArrayList<ArrayList<Things>> tempList = map.tiles();
		for(int i = 0; i < tempList.size(); i++)
		{
			for(Things t : tempList.get((i % Map.mapHeight) * Map.mapWidth + (i / Map.mapWidth)))
			{
				t.getSprite().draw(main.batch);
			}
		}
			*/
		for(ArrayList<Things> at : map.tiles())
		{
			for(Things t : at)
			{
				t.getSprite().draw(main.batch);
			}
		}
		Sprite s = new Sprite(tex);
		//s.draw(main.batch);
		main.batch.end();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode==Keys.A)
			xAcc -= 50;
		if(keycode==Keys.D)
			xAcc += 50;
		if(keycode==Keys.S)
			yAcc -= 50;
		if(keycode==Keys.W)
			yAcc += 50;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode==Keys.A)
			xAcc += 50;
		if(keycode==Keys.D)
			xAcc -= 50;
		if(keycode==Keys.S)
			yAcc += 50;
		if(keycode==Keys.W)
			yAcc -= 50;
		if(keycode==Keys.Q)
			camera.zoom += 0.2f;
		if(keycode==Keys.E)
			camera.zoom -= 0.2f;
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
		if(amount==-1)
			camera.zoom -= 0.2f;
		else
			camera.zoom +=0.2f;
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
