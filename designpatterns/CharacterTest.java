/**
 * Created by Wina Gen Sotto on November 24, 2016.
 */
public class CharacterTest {
   public static void main(String[] args) {
      Character c1 = new King();
      c1.setWeapon(new AxeBehavior());
      c1.fight();

      Character c2 = new Troll();
      c2.setWeapon(new KnifeBehavior());
      c2.fight();
   }
}