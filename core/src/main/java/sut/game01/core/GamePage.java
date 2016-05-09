package sut.game01.core;

import playn.core.Keyboard;
import playn.core.Mouse;
import sut.game01.core.Zealot.Zealot;
import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;
import playn.core.Image;
import playn.core.ImageLayer;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.keyboard;

public class GamePage extends Screen{

    private ImageLayer bg;
    private final ScreenStack ss;
    private Zealot z;
    private ImageLayer backButton;

    public GamePage (final ScreenStack ss){
        this.ss = ss;
        Image bgImage = assets().getImage("images/p1.png");
        this.bg = graphics().createImageLayer(bgImage);


        Image backImage = assets().getImage("images/menu.png");
        this.backButton = graphics().createImageLayer(backImage);
        backButton.setTranslation(400, 300);
        backButton.addListener(new Mouse.LayerAdapter(){
            @Override
            public void onMouseUp(Mouse.ButtonEvent event){//ss.remove(ss.top()); // pop screen
            }
        });

        z = new Zealot(300f,200f);


    }

    @Override
    public void wasShown(){
        super.wasShown();
        this.layer.add(bg);
        this.layer.add(z.layer());
        this.layer.add(backButton);

     //   z = new Zealot(300f,200f);
      //  this.layer.add(z.layer());

           /* keyboard().setListener(new Keyboard.Adapter(){
                @Override
                public void onKeyUp(Keyboard.Event event){
                    if (event.key() == Key.ESCAPE){
                        ss.remove(ss.top());
                    }
                }
            });*/
    }

    public void update(int delta){
        super.update(delta);
       // z.update(delta);
    }
}

