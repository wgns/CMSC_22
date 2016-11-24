/**
 * Created by Wina Gen Sotto on November 24, 2016.
 */
public abstract class Character {
   protected WeaponBehavior weapon;

   public abstract void fight();

   public void setWeapon(WeaponBehavior w) {
      weapon = w;
   }
}
