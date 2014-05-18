import java.util.ArrayList;
import java.util.HashSet;

class Banque{
	
	private String nom;
	private ArrayList<Compte> ensembleDesComptes;
	
	
	Banque(String n){
		this.nom = n;
		this.ensembleDesComptes = new ArrayList<Compte>();
	}

	public String getNom() {
		return nom;
	}
	public ArrayList<Compte> getEnsembleDesComptes() {
		return ensembleDesComptes;
	}
	
	public boolean creerCompte (int numero, double solde, Titulaire[] titulaires) {
	    ensembleDesComptes.add(new Compte(numero, solde, titulaires));
		return true;
	}
	public void afficheComptes(){
		System.out.println("BANQUE " +  nom + ": ##############################\n");
		for (Compte c : ensembleDesComptes){
			c.afficheCompte();
		}
	}
	
	public Compte getCompte(int numero){
		for (Compte c : ensembleDesComptes){
			if (c.getNumero() == numero){
				return c;
			}
		}
		return null;
		
	}
	
	
}
class Titulaire{
	private String nom;
	private HashSet<Compte> sesComptes = new HashSet<Compte>();
	
	Titulaire(String n){
		nom = n;
	}
	//TableauCompte mesComptes = new TableauCompte(10);
	
	public String getNom() {
		return nom;
	}
	public HashSet<Compte> getMesComptes() {
		return sesComptes;
	}
	public void afficheComptes(){
		for (Compte c : this.getMesComptes()){
			c.afficheCompte();
		}
	}
	public Compte getCompte(int numero){
		for (Compte c : sesComptes){
			if (c.getNumero() == numero){
				return c;
			}
		}
		return null;
		
	}
	public void virement(double montant, int de, Banque versBanque, int versCompte){
		getCompte(de).virement(montant, versBanque, versCompte);
	}
}

class Compte{
	private int numero;
	private double solde;
	private HashSet<Titulaire> sesTitulaires;

	public Compte(int numero, double solde, Titulaire[] titulaires) {
		this.numero = numero;
		this.solde = solde;
		this.sesTitulaires = new HashSet<Titulaire>();
		
		
		for (Titulaire t : titulaires){
			this.sesTitulaires.add(t);
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
	
	public void virement(double montant, Banque versBanque, int versCompte){
		versBanque.getCompte(versCompte).depot(montant);
		this.retrait(montant);
	}
	
	public String getAfficheTitulaires(){
		String titulaires = "";
		for (Titulaire t : this.sesTitulaires){
			titulaires += t.getNom() + ", ";
		}
		return titulaires;
	}
	
	public void afficheCompte(){
		System.out.println("compte N°" + this.getNumero() + " :\ntitulaire(s) :" + this.getAfficheTitulaires() + "\nsolde :" +  this.getSolde() + " euro(s)\n");
	}
	
}
