import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;
import uk.ac.shef.wit.simmetrics.similaritymetrics.CosineSimilarity;
import uk.ac.shef.wit.simmetrics.similaritymetrics.JaroWinkler;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein;
import uk.ac.shef.wit.simmetrics.similaritymetrics.NeedlemanWunch;
import uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWaterman;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Soundex;


public class Cal {
	public static String[] soundex(String[][] d1,String[][] d2,int numb) throws Exception{
		AbstractStringMetric metric = new Soundex();
		String[] result = calculate(d1,d2,numb,metric);
		finalResult(result,numb);
		return result;
	}
	public static String[] cosineSimilarity(String[][] d1,String[][] d2,int numb) throws Exception{
		AbstractStringMetric metric = new CosineSimilarity();
		String[] result = calculate(d1,d2,numb,metric);
		finalResult(result,numb);
		return result;
	}
	public static String[] jaroWinkler(String[][] d1,String[][] d2,int numb) throws Exception{
		AbstractStringMetric metric = new JaroWinkler();
		String[] result = calculate(d1,d2,numb,metric);
		finalResult(result,numb);
		return result;
	}
	public static String[] smithWaterman(String[][] d1,String[][] d2,int numb) throws Exception{
		AbstractStringMetric metric = new SmithWaterman();
		String[] result = calculate(d1,d2,numb,metric);
		finalResult(result,numb);
		return result;
	}
	public static String[] needleman(String[][] d1,String[][] d2,int numb) throws Exception{
		AbstractStringMetric metric = new NeedlemanWunch();
		String[] result = calculate(d1,d2,numb,metric);
		finalResult(result,numb);
		return result;
	}
	public static String[] levenshtein(String[][] d1,String[][] d2,int numb) throws Exception{
		AbstractStringMetric metric = new Levenshtein();
		String[] result = calculate(d1,d2,numb,metric);
		finalResult(result,numb);
		return result;
	}
	public static float finalResult(String[] result, int numb) throws Exception{
		int i = 0;
		float count = 0;
		while(result[i] != null){
			int re = Accuracy.acc(result[i], i, numb);
			//System.out.println(re);
			if(re != 0)
				count++;
			i++;
		}
		//System.out.println(count);
		System.out.println(count/112);
		return count/112;
	}
	public static String[] calculate(String[][] d1,String[][] d2,int numb,AbstractStringMetric metric){
		String[] result = new String[120];
		int row1 = d1.length;
		int row2 = d2.length;
		int reI = 0;
		float temp = 0;
		for(int i = 1; i < row1; i++){
			if(d1[i][numb] == null)
				break;
			for(int j = 1; j < row2; j++){
				if(d2[j][numb] == null)
					break;
				float simi = metric.getSimilarity(d1[i][numb], d2[j][numb]);
				if(simi > temp){
					temp = simi;
					reI = j;
				}
			}
			if(reI == 0){
				result[i-1] = " ";
				//System.out.println(result[i-1]);
			}else{
				result[i-1] = d2[reI][numb];
				//System.out.println(result[i-1]);
			}
			reI = 0;
			temp = 0;
		}
		return result;
	}
}
