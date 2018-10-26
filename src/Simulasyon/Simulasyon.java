
package Simulasyon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Simulasyon {

 
    public static void main(String[] args) {
        
        final MainFrame mf = new MainFrame();
        mf.setVisible(true);
        mf.addWindowListener(
            new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we)   // Ekran Kapatma Komutu
                {
                   
                        System.exit(0);   
                    
                }
            }
        );
    }
}
