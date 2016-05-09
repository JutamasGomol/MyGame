package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.Font;
import playn.core.ImageLayer;
import tripleplay.game.UIScreen;
import tripleplay.game.ScreenStack;
import tripleplay.ui.Root;
import tripleplay.ui.*;
import tripleplay.ui.layout.*;
import react.UnitSlot;

public class HomeScreen extends UIScreen {

  public static final Font TITLE_FONT = graphics().createFont("Helvetica", Font.Style.PLAIN, 24);

    private final TestScreen testScreen;
    private ScreenStack ss;
    private Root root;

  public HomeScreen(ScreenStack ss) {
    this.ss = ss;
    this.testScreen = new TestScreen(ss);
  }

  @Override
  public void wasShown(){
    super.wasShown();
    root = iface.createRoot(AxisLayout.vertical().gap(15),SimpleStyles.newSheet(), layer);

    root.addStyles(Style.BACKGROUND.is(Background.bordered(0xFFCCCCCC, 0XFF99CCFF, 5).inset(5, 10)));
    root.setSize(width(), height());

    root.add(new Label("START").addStyles(Style.FONT.is(HomeScreen.TITLE_FONT)));

    root.add(new Button("Start").onClick(new UnitSlot() {
      public void onEmit() {
          ss.push(testScreen);
      }
    }));
    
    //root.add(button);
  }

}