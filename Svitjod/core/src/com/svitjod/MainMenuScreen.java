package com.svitjod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen implements Screen {

	final Main main;
	Stage stage;
	private Skin skin;
	OrthographicCamera camera;
	MainMenuScreen mms = this;
	private boolean buttonClicked;
	public MainMenuScreen(final Main m) {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		main = m;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		//gam.playMenuMusic();
		spawnButtons();
	}

	/**
	 * Creates buttons
	 */
	private void spawnButtons() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin = main.skin;

		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		// Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
		final TextButton button1 = new TextButton("Start singleplayer", skin);
		final TextButton button2 = new TextButton("Create game(NYI)", skin);
		final TextButton button3 = new TextButton("Join game(matchmaking. serverlist - NYI)", skin);
		final TextButton button4 = new TextButton("Options", skin);
		table.add(button1);
		table.row();
		table.add(button2);
		table.add(button3);
		table.row();
		table.add(button4);

		// Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
		// Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
		// ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
		// revert the checked state.
		button1.addListener(new ClickListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				if(isOver(button1, x, y)){	
					buttonClicked = true;
					main.setScreen(new GameScreen(main, mms));
				}
			}
		});

		button2.addListener(new ClickListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("#2 NYI");
				return true;
			}

			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("my app", "Released");
				if(isOver(button2, x, y)){	
					buttonClicked = true;
				}
			}
		});

		button3.addListener(new ClickListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				if(isOver(button3, x, y)){	
					buttonClicked = true;
					//main.setScreen(new LobbyScreen(game, mms));
				}
			}
		});

		button4.addListener(new ClickListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				if(isOver(button4, x, y)){	
					buttonClicked = true;
					//main.setScreen(new SettingsScreen(game, mms));
				}
			}
		});
		// Add an image actor. Have to set the size, else it would be the size of the drawable (which is the 1x1 texture).
		//table.add(new Image(skin.newDrawable("white", Color.RED))).size(64);


	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(buttonClicked){
			buttonClicked = false;
			spawnButtons();
		}

		camera.update();
		main.batch.setProjectionMatrix(camera.combined);

		main.batch.begin();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		Table.drawDebug(stage);
		main.batch.end();

		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
			System.out.println("PRESSED");
			//main.setScreen(new GameScreen(game, this, false));
			dispose();
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_3)) {
			System.out.println("PRESSED");
			//main.setScreen(new LobbyScreen(game, this));
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}