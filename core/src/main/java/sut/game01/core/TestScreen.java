package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Mouse;
import playn.core.ImageLayer;
import sut.game01.core.Zealot.Zealot;
import tripleplay.game.UIScreen;
import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;
import tripleplay.ui.Root;
import tripleplay.ui.*;
import tripleplay.ui.layout.*;
import react.UnitSlot;
import playn.core.Key;
import playn.core.Keyboard;

import java.util.List;
import java.util.Map;

public class TestScreen extends Screen {

    private final ScreenStack ss;
    private final ImageLayer bg; 
   // private final Image bgImage; 
    //private final ImageLayer backButton;
   // private final Image backImage;
    private final ImageLayer startButton;
    //private final ImageLayer exitButton;
    private GamePage gamepage;
    private Zealot z;

  public TestScreen(final ScreenStack ss) {
    this.ss = ss;
      this.gamepage = new GamePage(ss);
      
    Image bgImage = assets().getImage("images/bg.png");
    this.bg = graphics().createImageLayer(bgImage);

    //Image backImage = assets().getImage("images/menu.png");
    //this.backButton = graphics().createImageLayer(backImage);
   // backButton.setTranslation(10, 10);
     // backButton.addListener(new Mouse.LayerAdapter(){
         // @Override
         // public void onMouseUp(Mouse.ButtonEvent event){ss.remove(ss.top()); // pop screen
         // }
    //  });

    Image startImage = assets().getImage("images/startbutton.png");
    startButton = graphics().createImageLayer(startImage);
    startButton.setTranslation(-160, 110);
    
    startButton.addListener(new Mouse.LayerAdapter(){
        @Override
        public void onMouseUp(Mouse.ButtonEvent event){
            if (event.button() == Mouse.BUTTON_LEFT) {
                ss.push(new GamePage(ss)); // pop screen
            }

        }
    });


    //Image exitImage = assets().getImage("images/exit.png");
    //this.exitButton = graphics().createImageLayer(exitImage);
    //exitButton.setTranslation(200, 200);
    




   }
  

    @Override
      public void wasShown(){
      super.wasShown();
      this.layer.add(bg);
      //this.layer.add(backButton);
      this.layer.add(startButton);
      //this.layer.add(exitButton);


       /* keyboard().setListener(new Keyboard.Adapter(){
            @Override
            public void onKeyUp(Keyboard.Event event){
                if (event.key() == Key.ENTER) {
                    ss.push(gamepage);
                }
            }
        });*/
    }
}