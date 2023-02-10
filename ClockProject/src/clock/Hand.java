/* Hand.java */

package clock;

import java.awt.*;

/**
 * Create the hands of a clock
 * 
 * @author Adam Bartholomew
 *         February - March, 2013
 */
public class Hand 
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
     public Hand(int centerX, int centerY, int length, java.awt.Color color)
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
         int centerDotDiameter = length/CENTER_DOT_RATIO;
         int centerDotRadius = centerDotDiameter/2;
         int handDotDiameter = length/HAND_DOT_RATIO;
         int handDotRadius = handDotDiameter/2;
         
         // Draw the hand
         radAngle = Math.toRadians(angle);
         x1 = centerX;
         y1 = centerY;
         x2 = centerX + (int)(length*(Math.sin(radAngle)));
         y2 = centerY - (int)(length*(Math.cos(radAngle)));
         graphics.drawLine(x1, y1, x2, y2);
         graphics.drawOval(x2-handDotRadius, y2-handDotRadius, handDotDiameter,
                           handDotDiameter);
         
         // Draw a dot at the center of the face where the hands meet
         graphics.setColor(Color.BLACK);
         graphics.fillOval(centerX-centerDotRadius, centerY-centerDotRadius,
                           centerDotDiameter, centerDotDiameter);  
     }
     
     // Variables to be passed into the constructor
     
     private int centerX;
     private int centerY;
     private int length;
     private Color color;
     private long angle;
     
     // Other symbolic constants
     
     private static final int CENTER_DOT_RATIO = 5;
     private static final int HAND_DOT_RATIO = 10;
}
