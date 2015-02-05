/**
 * MainClass.java
 * 
 * Starts and initializes the application
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
import daimanager.DataModel;
import daimanager.MainWindow;
import daimanager.SplashScreen;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Andy Dunkel
 */
public class MainClass {

    /** Creates a new instance of MainClass */
    public MainClass() {
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
     //first we show the splash
        SplashScreen splash = new SplashScreen();

        splash.showFor (1000);

        //then the appwindow
        MainWindow my = new MainWindow(new DataModel());
        
        //if there are any arguments we have to open a file
        if (args.length > 0)
        {
            my.openFile(args[0]);
        }

        //my.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        my.setLocationByPlatform (true);

        my.setVisible (true);
    }
    
}
