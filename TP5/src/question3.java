import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class question3 {

	public static void main(String[] args) {
		
		String[] tab1 = {"un",
						"deux",
						"trois",
						 "quatre",
						 "cinq"
				       };
		String[] tab2 = {"un",
				         "trois",
				         "cinq"
		                };
		String[] tab3 = {"sept",
		                 "huit",
		                 "cinq"
                        };
				
		HashSet<String> hs1 = new HashSet<String>();
		for (String s : tab1){
			hs1.add(s);
		}
		TreeSet<String> ts2 = new TreeSet<String>();
		for (String s : tab2){
			ts2.add(s);
		}
		TreeSet<String> s3 = new TreeSet<String>();
		for (String s : tab3){
			s3.add(s);
		}
		
		System.out.println(isSubsetV1(hs1, ts2));
		System.out.println(isSubsetV1(ts2, hs1));
		System.out.println(isSubsetV1(hs1, s3));
		System.out.println(isSubsetV1(s3, hs1));
		System.out.println(isSubsetV1(s3, ts2));
		
		System.out.println(isSubsetV2(hs1, ts2));
		System.out.println(isSubsetV2(ts2, hs1));
		System.out.println(isSubsetV2(hs1, s3));
		System.out.println(isSubsetV2(s3, hs1));
		System.out.println(isSubsetV2(s3, ts2));
		
		System.out.println(isSubsetV3(hs1, ts2));
		System.out.println(isSubsetV3(ts2, hs1));
		System.out.println(isSubsetV3(hs1, s3));
		System.out.println(isSubsetV3(s3, hs1));
		System.out.println(isSubsetV3(s3, ts2));
		

	}
	public static boolean isSubsetV1 (Set<String> set1, Set<String> set2){
		Set<String> inter = new TreeSet<String>(set1);
		return inter.containsAll(set2);
	}
	public static boolean isSubsetV2 (Set<String> set1, Set<String> set2){
		Set<String> diff = new TreeSet<String>(set2);
		diff.removeAll(set1);
		return (diff.size() == 0);
	}
	public static boolean isSubsetV3 (Set<String> set1, Set<String> set2){
		Iterator<String> i = set2.iterator();
		while (i.hasNext()){
			if (! set1.contains(i.next())){
				return false;
			}
		}
		return true;
	}

}
