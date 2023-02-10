/* LabelLine.java */

package clock;

import java.awt.*;

/**
 * Display of the label line beneath a clock
 *
 * @author Russell C. Bjork
 *
 * MODIFIED BY: Adam Bartholomew
 *              February - March, 2013
 */
public class LabelLine {

    /** Constructor
     *
     *  @param leftX the X coordinate of the upper left corner of the bounding
     *         rectangle for the line relative to upper left corner of clock
     *  @param upperY the Y coordinate of the upper left corner of the bounding
     *         rectangle for the line relative to upper left corner of clock
     *  @param lineWidth the width available for the line - displayed line will
     *         be centered within this width
     *  @param label the descriptive text to be displayed in this line
     *  @param color the color of the line
     */
    public LabelLine(int leftX, 
                     int upperY,
                     int lineWidth,
                     String label,
                     Color color) {

        this.leftX = leftX;
        this.upperY = upperY;
        this.lineWidth = lineWidth;
        this.label = label;
        this.color = color;
    }

    /** Draw this line
     *
     *  @param graphics the graphics object on which to draw
     */
    public void draw(Graphics graphics, String digitalTimeLabel) {

        graphics.setColor(color);

        // This may seem like an unnecessary step - but later the content of the
        // line will include information in addition to the label
        
        String city = label;
        String time = digitalTimeLabel;

        // Calculate padding needed to center content if possible for city

        int cityWidth = graphics.getFontMetrics().stringWidth(city);
        int paddingToCenterCity;
        if (cityWidth < lineWidth)
            paddingToCenterCity = (lineWidth - cityWidth) / 2;
        else
            // Not enough room to center
            paddingToCenterCity = 0;
        
        // Calculate padding needed to center content if possible for digital time

        int timeWidth = graphics.getFontMetrics().stringWidth(time);
        int paddingToCenterTime;
        if (timeWidth < lineWidth)
            paddingToCenterTime = (lineWidth - timeWidth) / 2;
        else
            // Not enough room to center
            paddingToCenterTime = 0;

        // Draw the content - note that, for drawString(), the method requires
        // the Y parameter to be the font baseline
        
        int pushLabelUp = lineWidth/5;
        graphics.drawString(city,
                            leftX + paddingToCenterCity,
                            upperY + graphics.getFontMetrics().getHeight()-pushLabelUp);
        graphics.drawString(time,
                            leftX + paddingToCenterTime,
                            upperY + (graphics.getFontMetrics().getHeight()*2)-pushLabelUp);
    }

    // Values passed to the constructor

    private int leftX;
    private int upperY;
    private int lineWidth;
    private String label;
    private Color color;
}
