
public class Similarity {
	public static void main(String args[]) throws Exception{
		String[][] d1 = ReadFile.read("d1.csv");
		String[][] d2 = ReadFile.read("d2.csv");
		//name
		System.out.println("name");
		String[] name1 = Cal.levenshtein(d1, d2, 0);
		String[] name2 = Cal.needleman(d1, d2, 0);
		String[] name3 = Cal.smithWaterman(d1, d2, 0);
		String[] name4 = Cal.jaroWinkler(d1, d2, 0);
		String[] name5 = Cal.cosineSimilarity(d1, d2, 0);
		String[] name6 = Cal.soundex(d1, d2, 0);
		System.out.println("d1,levenshtein,needleman,smithWaterman,jaroWinkler,tf-idf,soundex");
		for(int i = 0; i < 112; i++){
			System.out.println(d1[i+1][0]+","+name1[i]+","+name2[i]+","+name3[i]+","+name4[i]+","+name5[i]+","+name6[i]);
		}
		System.out.println("--------------------------------------------------------------------------");
		//addr
		System.out.println("addr");
		String[] addr1 = Cal.levenshtein(d1, d2, 1);
		String[] addr2 = Cal.needleman(d1, d2, 1);
		String[] addr3 = Cal.smithWaterman(d1, d2, 1);
		String[] addr4 = Cal.jaroWinkler(d1, d2, 1);
		String[] addr5 = Cal.cosineSimilarity(d1, d2, 1);
		String[] addr6 = Cal.soundex(d1, d2, 1);
		System.out.println("d1,levenshtein,needleman,smithWaterman,jaroWinkler,tf-idf,soundex");
		for(int i = 0; i < 112; i++){
			System.out.println(d1[i+1][1]+","+addr1[i]+","+addr2[i]+","+addr3[i]+","+addr4[i]+","+addr5[i]+","+addr6[i]);
		}
		System.out.println("--------------------------------------------------------------------------");
		//city
		System.out.println("city");
		String[] city1 = Cal.levenshtein(d1, d2, 2);
		String[] city2 = Cal.needleman(d1, d2, 2);
		String[] city3 = Cal.smithWaterman(d1, d2, 2);
		String[] city4 = Cal.jaroWinkler(d1, d2, 2);
		String[] city5 = Cal.cosineSimilarity(d1, d2, 2);
		String[] city6 = Cal.soundex(d1, d2, 2);
		System.out.println("d1,levenshtein,needleman,smithWaterman,jaroWinkler,tf-idf,soundex");
		for(int i = 0; i < 112; i++){
			System.out.println(d1[i+1][2]+","+city1[i]+","+city2[i]+","+city3[i]+","+city4[i]+","+city5[i]+","+city6[i]);
		}
		System.out.println("--------------------------------------------------------------------------");
		//type
		System.out.println("type");
		String[] type1 = Cal.levenshtein(d1, d2, 3);
		String[] type2 = Cal.needleman(d1, d2, 3);
		String[] type3 = Cal.smithWaterman(d1, d2, 3);
		String[] type4 = Cal.jaroWinkler(d1, d2, 3);
		String[] type5 = Cal.cosineSimilarity(d1, d2, 3);
		String[] type6 = Cal.soundex(d1, d2, 3);
		System.out.println("d1,levenshtein,needleman,smithWaterman,jaroWinkler,tf-idf,soundex");
		for(int i = 0; i < 112; i++){
			System.out.println(d1[i+1][3]+","+type1[i]+","+type2[i]+","+type3[i]+","+type4[i]+","+type5[i]+","+type6[i]);
		}
	}
}
