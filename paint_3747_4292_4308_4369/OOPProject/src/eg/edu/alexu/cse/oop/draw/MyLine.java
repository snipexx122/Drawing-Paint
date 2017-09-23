/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aliaa Abbas
 */
public class MyLine implements Shape, Serializable{
    //private int length=100;
    private Point startPoint= new Point(50, 50);
    private Color strokeColor;
    //private Color fillColor;
    private Map<String, Double> properties;
    
    public MyLine() {
	properties = new HashMap<String, Double>();
	properties.put("length", 100.0);
    }
    
    @Override
    public void setPosition(Point position) {
        //To change body of generated methods, choose Tools | Templates.
        this.startPoint=position;
    }

    @Override
    public Point getPosition() {
        //To change body of generated methods, choose Tools | Templates.
        return this.startPoint;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        //To change body of generated methods, choose Tools | Templates.
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        //To change body of generated methods, choose Tools | Templates.
        return this.properties;
    }

    @Override
    public void setColor(Color color) {
        //To change body of generated methods, choose Tools | Templates.
        this.strokeColor=color;
    }

    @Override
    public Color getColor() {
        //To change body of generated methods, choose Tools | Templates.
        return this.strokeColor;
    }

    @Override
    public void setFillColor(Color color) {
        //To change body of generated methods, choose Tools | Templates.
        //this.fillColor=color;
    }

    @Override
    public Color getFillColor() {
        //To change body of generated methods, choose Tools | Templates.
        return this.strokeColor;
    }
    
    @Override
    public void draw(Graphics canvas) {
        //To change body of generated methods, choose Tools | Templates.
        canvas.setColor(this.strokeColor);
        canvas.drawLine(this.startPoint.x, this.startPoint.y, this.startPoint.x+(int)(properties.get("length").doubleValue()), this.startPoint.y+(int)(properties.get("length").doubleValue()));
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        try{
          ByteArrayOutputStream baos = new ByteArrayOutputStream();  
          ObjectOutputStream oos = new ObjectOutputStream(baos);
          oos.writeObject(this);
          ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
          ObjectInputStream ois = new ObjectInputStream(bais); 
          return ois.readObject();
        }
        catch (IOException ex) {
        Logger.getLogger(MyLine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(MyLine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Line";
    }
    
    
}
