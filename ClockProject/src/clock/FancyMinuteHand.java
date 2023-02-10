/* FancyMinuteHand.java */

package clock;

import java.awt.*;

/**
 * Create the fancy minute hands of a clock
 *
 * @author Adam Bartholomew
 *         February - March, 2013
 */
public class FancyMinuteHand
{
    /** Constructor
     * 
     *  @param centerX - the X coordinate of the center of the clock of which 
     *         this is a part relative to upper left corner of clock
     *  @param centerY - the Y coordinate of the center of the clock of which 
     *         this is a part relative to upper left corner of clock
     *  @param length - the length of this hand
     *  @param color - the color of this hand
     */
    public FancyMinuteHand(int centerX, int centerY, int length, java.awt.Color color)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.length = length;
        this.color = color;
    }
    
    /**
      * Set the angle for this hand
      * 
      * @param angle - the angle (in degrees relative to the vertical) for this hand
      */
    public void setAngle(long angle)
    {
        this.angle = angle;
    }
    
    /**
      * Draw this hand
      * 
      * @param graphics - the graphics object on which to draw 
      */
    public void draw(java.awt.Graphics graphics)
    {
        graphics.setColor(color);
        int x1;
        int x2;
        int y1;
        int y2;
        double radAngle;
        
        // Draw actual lines for hands 
        radAngle = Math.toRadians(angle);
        x1 = centerX;
        y1 = centerY;
        x2 = centerX + (int)(length*(Math.sin(radAngle)));
        y2 = centerY - (int)(length*(Math.cos(radAngle)));
        graphics.drawLine(x1, y1, x2, y2);
        
        // Draw circles centered at the hand down the length of the hand
        for(int x=0; x<length/CIRCLES_DIAMETER; x++)
        {
            int newX = centerX + (int)((length-(CIRCLES_DIAMETER*x))*(Math.sin(radAngle)));
            int newY = centerY - (int)((length-(CIRCLES_DIAMETER*x))*(Math.cos(radAngle)));
            graphics.fillOval(newX-(CIRCLES_RADIUS), newY-(CIRCLES_RADIUS),
                              CIRCLES_DIAMETER, CIRCLES_DIAMETER);
        }
    }
    
    // Variables to passed into the constructor
    
    private int centerX;
    private int centerY;
    private int length;
    private Color color;
    
    // Variables for circles on the hand
    
    private long angle;
    private static final int CIRCLES_DIAMETER = 7;
    private static final int CIRCLES_RADIUS = CIRCLES_DIAMETER/2;  
}