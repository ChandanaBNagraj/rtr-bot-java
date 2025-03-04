import dev.robocode.tankroyale.botapi.*;
import dev.robocode.tankroyale.botapi.events.*;
import java.awt.*;


// ------------------------------------------------------------------
// Rcb
// ------------------------------------------------------------------
// A sample bot original made for Robocode by Mathew Nelson.
// Ported to Robocode Tank Royale by Flemming N. Larsen.
//
// Probably the first bot you will learn about.
// Moves in a seesaw motion, and spins the gun around at each end.
// ------------------------------------------------------------------
public class Rcb extends Bot {

    // The main method starts our bot
    public static void main(String[] args) {
        new Rcb().start();
    }

    // Constructor, which loads the bot config file
    Rcb() {
        super(BotInfo.fromFile("Rcb.json"));
    }
   
// setBodyColor(new Color(255, 0, 0)); // Metallic silversetGunColor(new Color(0, 255, 0)); // Darker metallic silversetRadarColor(new Color(169, 169, 169)); // Metallic silversetBulletColor(new Color(255, 215, 0)); // Gold for the lightning effectsetScanColor(new Color(255, 255, 255));
 
    // Called when a new round is started -> initialize and do some movement
    @Override
    public void run() {
        // Repeat while the bot is running
        setBodyColor(new Color(255, 255, 0)); 
         //Metallic silver
         setGunColor(new Color(0, 255, 255)); 
         //Darker metallic silver
         setRadarColor(new Color(255, 255, 255)); 
         // Metallic silver
          setBulletColor(new Color(255, 215, 0)); 
          // Gold for the lightning effect
          setScanColor(new Color(255, 255, 255));

        while (isRunning()) {
            forward(50);
          
            turnGunRight(360);
            //fire(1);
            back(100);
            turnGunRight(360);
            turnGunRight(360);
            fire(1);

        }
    }

    // We saw another bot -> fire!
    @Override
    public void onScannedBot(ScannedBotEvent e) {
        fire(3);
        //fire(3);
    }

    // We were hit by a bullet -> turn perpendicular to the bullet
    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        // Calculate the bearing to the direction of the bullet
        var bearing = calcBearing(e.getBullet().getDirection());

        // Turn 90 degrees to the bullet direction based on the bearing
        turnLeft(90 - bearing);
    }
}
