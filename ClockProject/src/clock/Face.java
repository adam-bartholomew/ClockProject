/* Face.java */

package clock;

import java.awt.*;

/**
 * Create the face of a Clock
 * 
 * @author Adam Bartholomew
 *         February - March, 2013
 */
public class Face 
{
    /** Constructor
     *
     *  @param leftX - the X coordinate of the upper left corner of the bounding
     *         rectangle for the line relative to upper left corner of clock
     *  @param upperY - the Y coordinate of the upper left corner of the bounding
     *         rectangle for the line relative to upper left corner of clock
     *  @param faceDiameter - the diameter of the face
     *  @param color - the color of the face
     */
     public Face(int leftX, int upperY, int faceDiameter, java.awt.Color color)
     {
        this.leftX = leftX;
        this.upperY = upperY;
        this.faceDiameter = faceDiameter;
        this.color = color;
     }
    
     /**
      * Draw the face of the clock
      * 
      * @param graphics - the graphics object on which to draw
      */
     public void draw(java.awt.Graphics graphics)
     {
         int radius = faceDiameter/2;
         // Draw the face
         graphics.setColor(color);
         graphics.fillOval(leftX, upperY, faceDiameter, faceDiameter);
         graphics.setColor(Color.BLACK);
         graphics.drawOval(leftX, upperY, faceDiameter, faceDiameter);
         graphics.drawLine(leftX+(radius/2), upperY+radius,
                           leftX+radius+(radius/2), upperY+radius);
         graphics.drawLine(leftX+radius, upperY+(radius/2), leftX+radius,
                           upperY+radius+(radius/2));
         
         // Draw numbers around the clock face
         String[] numbers = {"5", "4", "3", "2", "1", "12", "11", "10", "9",
                             "8", "7", "6"};
         for(int x=0; x<12; x++)
         {
             String num = numbers[x];
             int contentWidth = graphics.getFontMetrics().stringWidth(num);
             int contentHeight = graphics.getFontMetrics().getAscent();
             int bufferX = contentWidth/2;
             int bufferY = contentHeight/2;
             int centerX = leftX+radius-bufferX;
             int centerY = upperY+radius+bufferY;
             double radAngle = Math.toRadians(DEGREES_BETWEEN_HOUR*(x+1));
             graphics.drawString(num, 
                                 ((int)(centerX+((radius*OUTER_CIRCLE_RATIO)*Math.sin(radAngle)))), 
                                 ((int)(centerY+((radius*OUTER_CIRCLE_RATIO)*Math.cos(radAngle)))));
         }
         
         // Draw markers around the clock face at hours
         int faceCenterX, faceCenterY;
         faceCenterX = leftX + radius;
         faceCenterY = upperY + radius;
         for(int x=0; x<HOUR_MARKERS; x++)
         {
             int x1, x2, y1, y2, hashLength;
             hashLength = faceDiameter/HOUR_MARK_RATIO;
             double radAngle = Math.toRadians(DEGREES_BETWEEN_HOUR*(x+1));
             x1 = faceCenterX+(int)((radius-(hashLength/2))*(Math.sin(radAngle)));
             x2 = x1 + (int)(hashLength*(Math.sin(radAngle)));
             y1 = faceCenterY+(int)((radius-(hashLength/2))*(Math.cos(radAngle)));
             y2 = y1 + (int)(hashLength*(Math.cos(radAngle)));
             graphics.drawLine(x1, y1, x2, y2);
         }
         
         // Draw markers around the clock at each minute not divisible by 5
         for(int x=0; x<MINUTE_MARKERS; x++)
         {
             double angle = DEGREES_BETWEEN_MINUTE*(x+1);
             if(angle % 5 != 0)
             {
                 int x1, y1;
                 int hashDiam = faceDiameter/MINUTE_MARK_RATIO;
                 int hashRadius = hashDiam/2;
                 double radAngle = Math.toRadians(angle);
                 x1 = faceCenterX+(int)((radius-hashRadius)*(Math.sin(radAngle)))-hashRadius;
                 y1 = faceCenterY+(int)((radius-hashRadius)*(Math.cos(radAngle)))-hashRadius;
                 graphics.drawOval(x1, y1, hashDiam, hashDiam);
             }
         }
     }
     
    // Values passed to the constructor
     
    private int leftX;
    private int upperY;
    private int faceDiameter;
    private Color color;
    
    // Constants for number labels
    
    private static final double DEGREES_BETWEEN_HOUR = 30;
    private static final double DEGREES_BETWEEN_MINUTE = 6;
    private static final int HOUR_MARKERS = 12;
    private static final int MINUTE_MARKERS = 60;
    private static final int HOUR_MARK_RATIO = 17; // Ratio between clock diameter and length of hash mark
    private static final int MINUTE_MARK_RATIO = 30; // Ratio between clock diameter and marker diameter
    private static final double OUTER_CIRCLE_RATIO = 1.17; // Space between numbers and clock face
}
