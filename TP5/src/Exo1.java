import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class Exo1 {

	public static void main(String[] args) {
		String[] tab = {"un",
				        "deux",
				        "trois",
				        "quatre",
				        "cinq"
		};
		
		ArrayList<String> ac = new ArrayList<String>();
		for (String s : tab){
			ac.add(s);
		}
		HashSet<String> sc = new HashSet<String>();
		for (String s : tab){
			sc.add(s);
		}
		afficheCollV1(ac);
		afficheCollV1(sc);
		afficheCollV2(ac);
		afficheCollV2(sc);


	}
	
	public static void afficheCollV1(Collection<String> c){
		
		System.out.println("Affichage d'un" + (c instanceof ArrayList<?> ? "e Arraylist " : " HashSet") + "avec une boucle for each :\n");
		for (String s : c){
			System.out.println(s);
		}
		System.out.println();
	}
	
    public static void afficheCollV2(Collection<String> c){
    	System.out.println("Affichage d'un" + (c instanceof ArrayList<?> ? "e Arraylist " : " HashSet") + " avec un itérateur :\n");
    	Iterator<String> i = c.iterator();
    	while (i.hasNext()){
    		System.out.println(i.next());
    	}
    	System.out.println();
		
	}

}


