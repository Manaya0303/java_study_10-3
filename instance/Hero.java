package instance;

public class Hero {
	
	//フィールド
	private String name;	
	private int hp;			
	private int at;			
	private int df;
	
	public void attack() {
		System.out.println(this.name + "の攻撃！");
		System.out.println( + this.at + "のダメージ");
	}
	
	public void defence() {
		System.out.println("勇者は防御の姿勢をとった");
		this.df = this.df + 10;
		System.out.println("防御力が10upし、" + this.df + "になった");
	}
	
	public void heal() {
		System.out.println("勇者は休憩した");
		this.hp = this.hp + 10;
		System.out.println(this.name + "はHPが10回復し、" + this.hp + "になった");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if(name == null || name.length() < 3 || name.length() > 10) {
			throw new IllegalArgumentException("名前が不正です。");
		}
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		if(hp < 0) {
			hp = 0;
		}
		this.hp = hp;
	}
	
	public int getAt() {
		return this.at;
	}
	
	public void setAt(int at) {
		if(at < 0) {
			at = 0;
		}
		this.at = at;
	}
	
	public int getDf() {
		return this.df;
	}
	
	public void setDf(int df) {
		if(df < 0) {
			df = 0;
		}
		this.df = df;
	}
}
