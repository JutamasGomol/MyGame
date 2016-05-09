package sut.game01.core.Zealot;


//import sut.game01.core.sprite.Sprite;
// import static playn.core.PlayN.*;
//import playn.core.Game;
//import playn.core.Image;
//import playn.core.ImageLayer;
//import playn.core.util.Clock;
//import tripleplay.game.ScreenStack;
//import tripleplay.game.UIScreen;
//import tripleplay.ui.Root;
//import sut.game01.core.characters.Zealot;
import playn.core.*;
import playn.core.util.Callback;
import sut.game01.core.Sprite.*;

public class Zealot {
    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hasLoaded = false;

    public enum State {
      IDLE, WALK, RUN
    };
	
    private State state = State.IDLE;

    private int e = 0;
    private int offset = 0;

    public Zealot(final float x,final float y){

        PlayN.keyboard().setListener(new Keyboard.Adapter(){
            @Override
            public void onKeyUp(Keyboard.Event event) {
                if (event.key() == Key.SPACE){
                    switch (state) {
                        case IDLE: state = State.WALK; break;
                        case WALK: state = State.RUN; break;
                        case RUN: state = State.IDLE; break;
                    }
                }
            }
        });


      sprite = SpriteLoader.getSprite("images/zealot.json");
      sprite.addCallback(new Callback<Sprite>(){

        @Override
        public void onSuccess(Sprite result) {
          sprite.setSprite(spriteIndex);
          sprite.layer().setOrigin(sprite.width() / 2f,sprite.height() / 2f);
          sprite.layer().setTranslation(x, y + 13f);
          hasLoaded = true;
        }


        @Override
        public void onFailure(Throwable cause) {
                PlayN.log().error("Error loading image!", cause);
        }
      });

        sprite.layer().addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event){
                state = State.RUN;
                spriteIndex = -1;
                e = 0;
            }
        });
    }

    public Layer layer (){
        return sprite.layer();
    }

    public void update(int delta){
        if (!hasLoaded) return;
        e += delta;

        if(e > 150) {
            switch(state) {
                case IDLE: offset = 0;
                    break;
                case WALK:offset = 4;
                    break;
                case RUN: offset = 8;
                    /*if(spriteIndex == 10){
                        state = State.IDLE;
                    }*/
                    break;
            }
            spriteIndex = offset + ((spriteIndex + 1) %4);
            sprite.setSprite(spriteIndex);
            e = 0;
        }
    }
}