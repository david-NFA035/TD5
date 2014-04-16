
public class TestBanque {

	public static void main(String[] args) {

		Banque b1 = new Banque("mabanque");

		Titulaire t1 = new Titulaire("monsieur1");
		Titulaire t2 = new Titulaire("monsieur2");
		Titulaire t3 = new Titulaire("monsieur3");
		Titulaire t4 = new Titulaire("monsieur4");

		Compte c1 = new Compte(1, 150.00,  new Titulaire[] {t1, t2}, b1);
		Compte c2 = new Compte(6, 1150.00,  new Titulaire[] {t1}, b1);
		Compte c3 = new Compte(34, 50.00,  new Titulaire[] {t3}, b1);
		Compte c4 = new Compte(112, 1.00,  new Titulaire[] {t1, t4}, b1);

		
		System.out.println("\nApres création :\n");
		t1.afficheComptes();
		c1.depot(3000);
		c2.retrait(523);
		System.out.println("\nApres dépot/retrait :\n");
		t1.afficheComptes();
	}
}


