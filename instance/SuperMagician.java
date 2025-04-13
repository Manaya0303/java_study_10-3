package instance;

public class SuperMagician extends Magician {
	
	public void attack_magic() {
		System.out.println(super.getName() + "の超魔法攻撃！");
		super.setMp(super.getMp() - 10);
		System.out.println(super.getM_at() * 2 + "のダメージ");
	}
}
