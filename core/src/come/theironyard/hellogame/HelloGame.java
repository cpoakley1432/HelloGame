package come.theironyard.hellogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGame extends ApplicationAdapter {
	SpriteBatch batch;//drawing images
	Texture img;

	float x = 0;//assigning value to plane
    float y = 0;
    float xv = 0;
    float yv = 0;//v = velocity

    final float MAX_VELOCITY = 100;
	
	@Override
	public void create () {//only runs once when game boots up, initialize
		batch = new SpriteBatch();
		img = new Texture("Randy.jpg");//loading image
	}

	@Override
	public void render () {//running constantly
		if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            yv = MAX_VELOCITY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            yv = MAX_VELOCITY * -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            xv = MAX_VELOCITY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            xv = MAX_VELOCITY * -1;
        }

        x += xv * Gdx.graphics.getDeltaTime();
        y += yv * Gdx.graphics.getDeltaTime();

        xv *= 0.9;//dampening, adding friction so image slows down
        yv *= 0.9;

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//clearing what was previously drawn
		batch.begin();// links with spriteBatch
		batch.draw(img, x, y);
		batch.end();
	}
}
