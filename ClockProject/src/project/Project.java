/* Project.java */

package project;

import clock.Clock;
import java.awt.*;
import javax.swing.*;

/** Applet for CPS122 Individual Project
 *
 *  @author Russell C. Bjork
 *  
 *  MODIFIED BY: Adam Bartholomew
 *               February - March, 2013
 */
public class Project extends JApplet {

    /** Start the execution of the applet
     */
    public void start()
    {
        getContentPane().setLayout(null);
        getContentPane().setBackground(BACKGROUND_COLOR);
        RepaintManager.currentManager(this).setDoubleBufferingEnabled(true);
        
        // Create and start the clocks
        
        Clock boston = new Clock(BOSTON_LEFT_X,
                                 BOSTON_UPPER_Y,
                                 BOSTON_FACE_DIAMETER,
                                 BOSTON_LABEL,
                                 FACE_COLOR,
                                 HOUR_HAND_COLOR,
                                 MINUTE_HAND_COLOR,
                                 SECOND_HAND_COLOR,
                                 LABEL_LINE_COLOR,
                                 BOSTON_TIMEZONE_OFFSET);
        add(boston);
        boston.start();

        Clock seattle = new Clock(SEATTLE_LEFT_X,
                                  SEATTLE_UPPER_Y,
                                  SEATTLE_FACE_DIAMETER,
                                  SEATTLE_LABEL,
                                  FACE_COLOR,
                                  HOUR_HAND_COLOR,
                                  MINUTE_HAND_COLOR,
                                  SECOND_HAND_COLOR,
                                  LABEL_LINE_COLOR,
                                  SEATTLE_TIMEZONE_OFFSET);
        add(seattle);
        seattle.start();

        Clock london = new Clock(LONDON_LEFT_X,
                                 LONDON_UPPER_Y,
                                 LONDON_FACE_DIAMETER,
                                 LONDON_LABEL,
                                 FACE_COLOR,
                                 HOUR_HAND_COLOR,
                                 MINUTE_HAND_COLOR,
                                 SECOND_HAND_COLOR,
                                 LABEL_LINE_COLOR,
                                 LONDON_TIMEZONE_OFFSET);
        add(london);
        london.start();

        Clock istanbul = new Clock(ISTANBUL_LEFT_X,
                                   ISTANBUL_UPPER_Y,
                                   ISTANBUL_FACE_DIAMETER,
                                   ISTANBUL_LABEL,
                                   FACE_COLOR,
                                   HOUR_HAND_COLOR,
                                   MINUTE_HAND_COLOR,
                                   SECOND_HAND_COLOR,
                                   LABEL_LINE_COLOR,
                                   ISTANBUL_TIMEZONE_OFFSET);
        add(istanbul);
        istanbul.start();

        Clock hongKong = new Clock(HONG_KONG_LEFT_X,
                                   HONG_KONG_UPPER_Y,
                                   HONG_KONG_FACE_DIAMETER,
                                   HONG_KONG_LABEL,
                                   FACE_COLOR,
                                   HOUR_HAND_COLOR,
                                   MINUTE_HAND_COLOR,
                                   SECOND_HAND_COLOR,
                                   LABEL_LINE_COLOR,
                                   HONG_KONG_TIMEZONE_OFFSET);
        add(hongKong);
        hongKong.start();

        Clock shriLanka = new Clock(SHRI_LANKA_LEFT_X,
                                    SHRI_LANKA_UPPER_Y,
                                    SHRI_LANKA_FACE_DIAMETER,
                                    SHRI_LANKA_LABEL,
                                    FACE_COLOR,
                                    HOUR_HAND_COLOR,
                                    MINUTE_HAND_COLOR,
                                    SECOND_HAND_COLOR,
                                    LABEL_LINE_COLOR,
                                    SHRI_LANKA_TIMEZONE_OFFSET);
        add(shriLanka);
        shriLanka.start();     
    }
    
    /** Main method for running this as an application
     */
    public static void main(String [] args) {
        JFrame frame = new JFrame();
        frame.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Project project = new Project();
        project.start();
        frame.add(project);
        frame.setVisible(true);
    }

    // Overall dimensions when run as an application. (If run as an applet,
    // dimenions are specified by the html file, which needs to be modifed
    // to use the same values for width and height.)

    private static final int APPLICATION_WIDTH = 800;
    private static final int APPLICATION_HEIGHT = 600;

    // Constants for Boston clock
    
    private static final int BOSTON_LEFT_X = 250;
    private static final int BOSTON_UPPER_Y = 25;
    private static final int BOSTON_FACE_DIAMETER = 200;
    private static final String BOSTON_LABEL = "Boston";
    private static final String BOSTON_TIMEZONE_OFFSET = "GMT-05:00";

    // Constants for Pacific Time Zone clock
    
    private static final int SEATTLE_LEFT_X = 590;
    private static final int SEATTLE_UPPER_Y = 100;
    private static final int SEATTLE_FACE_DIAMETER = 100;
    private static final String SEATTLE_LABEL = "Seattle";
    private static final String SEATTLE_TIMEZONE_OFFSET = "GMT-08:00";

    // Constants for London clock
    
    private static final int LONDON_LEFT_X = 20;
    private static final int LONDON_UPPER_Y = 100;
    private static final int LONDON_FACE_DIAMETER = 100;
    private static final String LONDON_LABEL = "London";
    private static final String LONDON_TIMEZONE_OFFSET = "GMT+00:00";

    // Constants for Istanbul clock
    
    private static final int ISTANBUL_LEFT_X = 30;
    private static final int ISTANBUL_UPPER_Y = 300;
    private static final int ISTANBUL_FACE_DIAMETER = 150;
    private static final String ISTANBUL_LABEL = "Istanbul";
    private static final String ISTANBUL_TIMEZONE_OFFSET = "GMT+02:00";

    // Constants for Hong Kong clock
    
    private static final int HONG_KONG_LEFT_X = 530;
    private static final int HONG_KONG_UPPER_Y = 300;
    private static final int HONG_KONG_FACE_DIAMETER = 150;
    private static final String HONG_KONG_LABEL = "Hong Kong";
    private static final String HONG_KONG_TIMEZONE_OFFSET = "GMT+08:00";

    // Constants for Shri Lanka clock
    
    private static final int SHRI_LANKA_LEFT_X = 300;
    private static final int SHRI_LANKA_UPPER_Y = 380;
    private static final int SHRI_LANKA_FACE_DIAMETER = 100;
    private static final String SHRI_LANKA_LABEL = "Shri Lanka";
    private static final String SHRI_LANKA_TIMEZONE_OFFSET = "GMT+05:30";

    // Shared constants for all clocks
    
    private static final Color HOUR_HAND_COLOR = Color.BLUE;
    private static final Color MINUTE_HAND_COLOR = Color.CYAN;
    private static final Color SECOND_HAND_COLOR = Color.RED;
    private static final Color LABEL_LINE_COLOR = Color.BLACK;
    private static final Color FACE_COLOR = Color.ORANGE;
    private static final Color BACKGROUND_COLOR = Color.MAGENTA;
}
