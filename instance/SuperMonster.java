package instance;

public class SuperMonster extends Monster {
	
	private int poison_stack = 2;
	private int p_at;

	public void attack() {
		System.out.println(super.getName() + "の攻撃！");
		System.out.println(super.getAt() + "のダメージ");
		
		if (poison_stack > 0) {
			System.out.println(super.getName() + "はさらに毒を噴射した！");
			System.out.println(this.p_at + "のダメージ");
			poison_stack --;
		}
		
	}
	
	public int getP_at() {
		return this.p_at;
	}
	
	public void setP_at(int p_at) {
		if(p_at < 0) {
			p_at = 0;
		}
		this.p_at = p_at;
	}
	
}
