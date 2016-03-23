package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Mouse;
import playn.core.ImageLayer;
import tripleplay.game.UIScreen;
import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;
import tripleplay.ui.Root;
import tripleplay.ui.*;
import tripleplay.ui.layout.*;
import react.UnitSlot;

public class TestScreen extends Screen {

    private final ScreenStack ss;
    private final ImageLayer bg; 
   // private final Image bgImage; 
    private final ImageLayer backButton;
   // private final Image backImage;
    private final ImageLayer startButton;
    private final ImageLayer exitButton;

  public TestScreen(final ScreenStack ss) {
    this.ss = ss;
      
    Image bgImage = assets().getImage("images/bg.png");
    this.bg = graphics().createImageLayer(bgImage);

    Image backImage = assets().getImage("images/menu.png");
    this.backButton = graphics().createImageLayer(backImage);
    backButton.setTranslation(10, 10);
    
    backButton.addListener(new Mouse.LayerAdapter(){
          @Override
          public void onMouseUp(Mouse.ButtonEvent event){
            ss.remove(ss.top()); // pop screen
          }
      });

    Image startImage = assets().getImage("images/start.png");
    this.startButton = graphics().createImageLayer(startImage);
    startButton.setTranslation(100, 100);
    
    startButton.addListener(new Mouse.LayerAdapter(){
          @Override
          public void onMouseUp(Mouse.ButtonEvent event){
            ss.remove(ss.top()); // pop screen
          }
      });

    Image exitImage = assets().getImage("images/exit.png");
    this.exitButton = graphics().createImageLayer(exitImage);
    exitButton.setTranslation(200, 200);
    
    exitButton.addListener(new Mouse.LayerAdapter(){
          @Override
          public void onMouseUp(Mouse.ButtonEvent event){
            ss.remove(ss.top()); // pop screen
          }
      });



   }
  

    @Override
      public void wasShown(){
      super.wasShown();
      this.layer.add(bg);
      this.layer.add(backButton);
      this.layer.add(startButton);
      this.layer.add(exitButton);

    }
}