package com.atomicobject.com.atomicobject.bbbugs;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.FlowFieldManager;
import net.rim.device.api.ui.container.MainScreen;

// If you put a SeparatorField between buttons in a FlowFieldLayout,
// the listeners for the buttons before the separator get disabled.
public class SeparatorBehaviorDemo extends UiApplication {

  ButtonField button1 = new ButtonField("Button1");
  ButtonField button2 = new ButtonField("Button2");
  ButtonField button3 = new ButtonField("Button3");
  ButtonField button4 = new ButtonField("Button4");


  public static class MyChangeListener implements FieldChangeListener {

    private int buttonNum;

    public MyChangeListener(int buttonNum) {
      this.buttonNum = buttonNum;
    }

    public void fieldChanged(Field field, int i) {
      Dialog.alert("You pressed button " + buttonNum);
    }
  }

  public SeparatorBehaviorDemo() {

    MainScreen screen = new MainScreen();

    FlowFieldManager manager = new FlowFieldManager();
    manager.add(button1);
    manager.add(button2);

    manager.add(new SeparatorField());
    manager.add(button3);
    manager.add(button4);

    button1.setChangeListener(new MyChangeListener(1));
    button2.setChangeListener(new MyChangeListener(2));
    button3.setChangeListener(new MyChangeListener(3));
    button4.setChangeListener(new MyChangeListener(4));
    screen.add(manager);
    pushScreen(screen);
  }


  public static void main(String[] args) {
    new SeparatorBehaviorDemo().enterEventDispatcher();
  }



}
