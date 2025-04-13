package instance;

public class Story {

	public static void main(String[] args) {
		
		SuperHero h = new SuperHero();
		h.setName("アルス");
		h.setHp(150);
		h.setAt(30);
		h.setDf(20);
		
		SuperMonster m = new SuperMonster();
		m.setName("オルゴデミーラ");
		m.setHp(200);
		m.setAt(40);
		m.setDf(10);
		m.setP_at(25);
		
		SuperMagician w = new SuperMagician();
		w.setName("マリベル");
		w.setHp(120);
		w.setMp(50);
		w.setAt(15);
		w.setDf(10);
		w.setM_at(30);
		
		h.attack();
		m.setHp(m.getHp() - (h.getAt() * 2 - m.getDf()));
		System.out.println(m.getName() + "のHPが" + m.getHp() + "になった");
		System.out.println();
		
		m.attack();
		h.setHp(h.getHp() - ((m.getAt() - h.getDf()) + (m.getP_at() - h.getDf())));
		System.out.println(h.getName() + "のHPが" + h.getHp() + "になった");
		System.out.println();
		
		m.attack();
		w.setHp(w.getHp() - ((m.getAt() - w.getDf()) + (m.getP_at() - w.getDf())));
		System.out.println(w.getName() + "のHPが" + w.getHp() + "になった");
		System.out.println();
		
		w.attack_magic();
		m.setHp(m.getHp() - (w.getM_at() * 2 - m.getDf()));
		System.out.println(w.getName() + "のMPが" + w.getMp() + "になった");
		System.out.println(m.getName() + "のHPが" + m.getHp() + "になった");
		System.out.println();
		
		h.attack();
		m.setHp(m.getHp() - (h.getAt() * 2 - m.getDf()));
		System.out.println(m.getName() + "のHPが" + m.getHp() + "になった");
		System.out.println();
		
		m.defense();
		System.out.println(m.getName() + "の防御力が" + m.getDf() + "になった");
		System.out.println();
		
		m.attack();
		w.setHp(w.getHp() - ((m.getAt() - w.getDf()) + (m.getP_at() - w.getDf())));
		System.out.println(w.getName() + "のHPが" + w.getHp() + "になった");
		System.out.println();
		
		w.heal_magic();
		System.out.println(w.getName() + "のHPが" + w.getHp() + "になった");
		System.out.println();
		
		h.attack();
		m.setHp(m.getHp() - (h.getAt() * 2 - m.getDf()));
		System.out.println(m.getName() + "のHPが" + m.getHp() + "になった");
		System.out.println();
		
		m.attack();
		h.setHp(h.getHp() - ((m.getAt() - h.getDf()) + (m.getP_at() - h.getDf())));
		System.out.println(h.getName() + "のHPが" + h.getHp() + "になった");
		System.out.println();
		
		m.attack();
		h.setHp(h.getHp() - ((m.getAt() - h.getDf()) + (m.getP_at() - h.getDf())));
		System.out.println(h.getName() + "のHPが" + h.getHp() + "になった");
		System.out.println();
		
		w.attack_magic();
		m.setHp(m.getHp() - (w.getM_at() * 2 - m.getDf()));
		System.out.println(w.getName() + "のMPが" + w.getMp() + "になった");
		System.out.println(m.getName() + "のHPが" + m.getHp() + "になった");
		System.out.println();
		
		System.out.println(m.getName() + "を倒した！");
	}
}
