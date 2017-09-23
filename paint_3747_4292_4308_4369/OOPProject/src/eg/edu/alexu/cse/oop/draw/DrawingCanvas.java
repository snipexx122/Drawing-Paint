/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JPanel;

/**
 *
 * @author Aliaa Abbas
 */
public class DrawingCanvas extends JPanel implements DrawingEngine{
    
   public ArrayList<Shape> shapes;
   public ArrayList<Shape> stack1;
   public Stack<Shape> deleted;
   List<Class<? extends Shape>> supportedShapes;
   
   public DrawingCanvas(){
       shapes = new ArrayList<>();
       stack1 = new ArrayList<>();
       deleted= new Stack<>();
       supportedShapes = new ArrayList<Class<? extends Shape>>();
   }
   
   @Override
   public void paintComponent(Graphics g){
       super.paintComponent(g);
       for(Shape sh : shapes){
           sh.draw(g);
       }
   }

    @Override
    public void addShape(Shape shape) {
        //To change body of generated methods, choose Tools | Templates.
        // Remove deleted shapes
        stack1= new ArrayList<>();
        deleted = new Stack<>();
        // Add to array of shapes
        shapes.add(shape);
        //Repaint Canvas
        this.repaint();
    }

    @Override
    public void removeShape(Shape shape) {
        //To change body of generated methods, choose Tools | Templates.
        // Remove from array of shapes
        shapes.remove(shape);
        //Repaint canvas
        this.repaint();
    }

    @Override
    public Shape[] getShapes() {
        //To change body of generated methods, choose Tools | Templates.
        //return this.shapes.toArray();
        return shapes.toArray(new Shape[shapes.size()]);
    }

    @Override
    public void refresh(Graphics canvas) {
        //To change body of generated methods, choose Tools | Templates.
        super.paintComponent(canvas);
        for (Shape sh : shapes){
            sh.draw(canvas);
        }
        this.repaint();
    }

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        return this.supportedShapes;
    }

    @Override
    public void installPluginShape(Class<? extends Shape> shapeClass) {
        this.supportedShapes.add(shapeClass);
    }

    @Override
    public void undo() {
        //To change body of generated methods, choose Tools | Templates.
        if(stack1.size()>=20) stack1.remove(0);
        stack1.add(shapes.get(shapes.size()-1));
        shapes.remove(shapes.size()-1);
        this.repaint();
    }

    @Override
    public void redo() {
        //To change body of generated methods, choose Tools | Templates.
        shapes.add(stack1.remove(stack1.size()-1));
        this.repaint();
    }

}
