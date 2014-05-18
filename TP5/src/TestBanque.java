
public class TestBanque {

	public static void main(String[] args) {

		Banque b1 = new Banque("BNP");
		Banque b2 = new Banque("CL");

		Titulaire t1 = new Titulaire("Paul");
		Titulaire t2 = new Titulaire("Pierre");
		Titulaire t3 = new Titulaire("Fatima");
		Titulaire t4 = new Titulaire("May");

		b1.creerCompte(1, 150.00,  new Titulaire[] {t1, t3});
		b1.creerCompte(6, 1150.00,  new Titulaire[] {t2});
		b1.creerCompte(34, 50.00,  new Titulaire[] {t3});
		b2.creerCompte(1002, 500.00,  new Titulaire[] {t4});
		
		System.out.println("\nApres création :\n");
		b1.afficheComptes();
		b2.afficheComptes();
		b1.getCompte(1).depot(3000);
		b1.getCompte(6).retrait(523);
		b2.getCompte(1002).virement(400.00, b1, 34);
		System.out.println("\nApres dépot/retrait/virement :\n");
		b1.afficheComptes();
		b2.afficheComptes();
	}
}


