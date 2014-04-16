import java.util.ArrayList;
import java.util.HashSet;



//class TableauCompte{
//  Compte[] tab;
//  int longueur;
//  TableauCompte(int n){
//        tab = new Compte[n];
//    }
//  void ajouter(Compte c){
//        if (longueur < tab.length){
//            tab[longueur]=c;
//            longueur++;
//        }
//    }
//}

class Banque{
	public String getNom() {
		return nom;
	}
	public ArrayList<Compte> getEnsembleDesComptes() {
		return ensembleDesComptes;
	}
	private String nom;
	//TableauCompte tous = new TableauCompte(50);
	private ArrayList<Compte> ensembleDesComptes = new ArrayList<Compte>();
	Banque(String n){
		nom = n;
	}
}
class Titulaire{
	private String nom;
	Titulaire(String n){
		nom = n;
	}
	//TableauCompte mesComptes = new TableauCompte(10);
	private HashSet<Compte> mesComptes = new HashSet<Compte>();
	public String getNom() {
		return nom;
	}
	public HashSet<Compte> getMesComptes() {
		return mesComptes;
	}
	public void afficheComptes(){
		for (Compte c : this.getMesComptes()){
			c.afficheCompte();
		}
	}
}

class Compte{
	private int numero;
	private double solde;

	public Compte(int numero, double solde, Titulaire[] titulaires , Banque banque) {
		this.numero = numero;
		this.solde = solde;
		banque.getEnsembleDesComptes().add(this);
		for (Titulaire t : titulaires){
			t.getMesComptes().add(this);
		}
	}
	public int getNumero() {
		return numero;
	}
	public double getSolde() {
		return solde;
	}
	public void retrait(double m) {
		solde = solde - m;
	}
	public void depot(double m){
		solde = solde + m;
	}
	public void afficheCompte(){
		System.out.println("compte N°" + this.getNumero() + " : " +  this.getSolde() + " euro(s)");
	}
}
