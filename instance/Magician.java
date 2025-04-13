package instance;

public class Magician {
	
	private String name;
	private int hp;
	private int mp;
	private int at;
	private int df;
	private int m_at;
	
	public void attack() {
		System.out.println(this.name + "の攻撃！");
		System.out.println(this.at + "のダメージ");
	}
	
	public void attack_magic() {
		System.out.println(this.name + "の魔法攻撃！");
		this.mp = this.mp - 5;
		System.out.println(this.m_at + "のダメージ");
	}
	
	public void heal_magic() {
		System.out.println(this.name + "は回復魔法を唱えた！");
		this.mp = this.mp -5;
		this.hp = this.hp + 50;
		System.out.println(this.name + "の体力が50回復した");
	}
	
	public void rest() {
		System.out.println(this.name + "は休憩した");
		this.mp = this.mp + 10;
		System.out.println(this.name + "は休憩し、MPが" + this.mp + "に回復した！");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		if(name == null || name.length() < 3 || name.length() > 10) {
			throw new IllegalArgumentException("名前がnullです。");
		}
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
	
	public int getMp() {
		return this.mp;
	}
	
	public void setMp(int mp) {
		if(mp < 0) {
			mp = 0;
		}
		this.mp = mp;
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
	
	public int getM_at() {
		return this.m_at;
	}
	
	public void setM_at(int m_at) {
		if(m_at < 0) {
			m_at = 0;
		}
		this.m_at = m_at;
	}
}
