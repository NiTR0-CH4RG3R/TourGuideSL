/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

/**
 *
 * @author Buddhima Zoysa
 */
public class Application {
    
    private final Database db;
    
    private Application () {
        // Initialize the database
        db = new Database(); 
    }
   
    private void Run() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (
                    ClassNotFoundException | 
                    InstantiationException | 
                    IllegalAccessException | 
                    javax.swing.UnsupportedLookAndFeelException
                    e
                )
        {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    
    public Database GetDB() {
        return db;
    }
    
    static Application g_app = null;
    public static void main(String[] args) {
        g_app = new Application();
        g_app.Run();
    }
}
