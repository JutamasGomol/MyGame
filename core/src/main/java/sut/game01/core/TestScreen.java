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

  public TestScreen(final ScreenStack ss) {
    this.ss = ss;
      
    Image bgImage = assets().getImage("images/bg.png");
    this.bg = graphics().createImageLayer(bgImage);

    Image backImage = assets().getImage("images/backbutton.png");
    this.backButton = graphics().createImageLayer(backImage);
    backButton.setTranslation(10, 10);
    
    backButton.addListener(new Mouse.LayerAdapter(){
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

    }
}