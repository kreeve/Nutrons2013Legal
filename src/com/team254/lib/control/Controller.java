package com.team254.lib.control;

import java.util.Vector;

/**
 * Base class for all controllers.
 *
 * @author richard@tean254.com (Richard Lin)
 */
public abstract class Controller implements Updatable {
  private static Vector controllers = new Vector();
  protected String name;
  protected boolean enabled;
  
  public Controller(String name) {
    ControlUpdater.getInstance().add(this);
    controllers.addElement(this);
    this.name = name;
  }
  
  public String getName(){
    return name;
  }
  public static void updateAll() {
    for(int i = 0; i < controllers.size(); i++) {
      Controller c = (Controller) controllers.elementAt(i);
      c.update();
    }
  }
  
  public void enable() {
    enabled = true;
  }
  
  public void disable() {
    enabled = false;
  }
  
  public boolean isEnabled() {
    return enabled;
  }
  
  public abstract void update();
  
  public abstract void setGoal(double goal);
  
  public abstract double getGoal();
}
