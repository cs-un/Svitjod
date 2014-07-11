package com.svitjod;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;

public class Main extends Game {
	public MainMenuScreen MainMenu;
	public SpriteBatch batch;
	public BitmapFont font;
	public BitmapFont sctFont;
	public Skin skin;
	public static float volume;
	private boolean playingMenuMusic;
	private Music menu;
	
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setScale(1.5f);
		sctFont = new BitmapFont();
		sctFont.setColor(Color.RED);
		sctFont.setScale(1.5f);
		loadSkins();
		loadSettings();
		setScreen(new MainMenuScreen(this));
}

	private void loadSkins() {
		skin = new Skin();
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("muscleman", new Texture(Gdx.files.internal(("hero/muscleman/idle.png"))));
		skin.add("button1", new Texture(Gdx.files.internal(("UI/button.png"))));
		skin.add("slider", new Texture(Gdx.files.internal(("hero/testgubbar/gubbe1.png"))));
		skin.add("white", new Texture(pixmap));
		skin.add("cursor", new Texture(Gdx.files.internal("colors/cursor.png")));
		// Store the default libgdx font under the name "default".
		skin.add("default", new BitmapFont());
	
		// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("button1", Color.WHITE);
		textButtonStyle.down = skin.newDrawable("button1", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("button1", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("button1", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);
		// SelectBoxStyle
		SelectBoxStyle selectboxstyle = new SelectBoxStyle();
		selectboxstyle.background = skin.newDrawable("button1", Color.WHITE);
		selectboxstyle.backgroundOpen = skin.newDrawable("button1", Color.DARK_GRAY);
		selectboxstyle.backgroundOver = skin.newDrawable("button1", Color.LIGHT_GRAY);
		selectboxstyle.font = skin.getFont("default");
		selectboxstyle.backgroundDisabled = skin.newDrawable("button1", Color.BLUE);
		selectboxstyle.scrollStyle = new ScrollPaneStyle();
		selectboxstyle.scrollStyle.background = skin.newDrawable("button1", Color.DARK_GRAY);
		selectboxstyle.listStyle = new ListStyle();
		selectboxstyle.listStyle.background = skin.newDrawable("button1", Color.DARK_GRAY);
		selectboxstyle.listStyle.selection = skin.newDrawable("button1", Color.RED);
		selectboxstyle.listStyle.font = skin.getFont("default");
		skin.add("default", selectboxstyle);
		// SliderStyle
		SliderStyle sliderStyle = new SliderStyle();
		sliderStyle.background = skin.newDrawable("white", Color.WHITE);
		sliderStyle.knob = skin.newDrawable("slider", Color.RED);
		sliderStyle.knobBefore = skin.newDrawable("white", Color.RED);
		skin.add("default-horizontal", sliderStyle);
		// LabelStyle
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.background = skin.newDrawable("white", Color.WHITE);
		labelStyle.font = skin.getFont("default");
		skin.add("default", labelStyle);
		// TextFieldStyle
		TextFieldStyle textFieldStyle = new TextFieldStyle();
		textFieldStyle.background = skin.newDrawable("white", Color.RED);
		textFieldStyle.focusedBackground = skin.newDrawable("white", Color.RED);
		textFieldStyle.selection = skin.newDrawable("white", Color.BLUE);
		textFieldStyle.font = font;
		textFieldStyle.fontColor = Color.WHITE;
		textFieldStyle.cursor = skin.newDrawable("cursor", Color.BLUE);
		textFieldStyle.cursor.setMinWidth(2f);
		skin.add("default", textFieldStyle);
	}
	
	public void render() {
		super.render(); // important!
	}
	
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
	
	public static void loadSettings() {
		Preferences settings = Gdx.app.getPreferences("settings");
		volume = settings.getFloat("Volume", 100f)/100;
	}
	
	public void playMenuMusic()
	{
		if(!playingMenuMusic)
		{
			menu.setLooping(true);
			menu.play();
			playingMenuMusic = true;
		}
	}
	
	public void stopMenuMusic()
	{
		playingMenuMusic = false;
		menu.stop();
	}

}
