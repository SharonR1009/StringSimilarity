import java.util.HashMap;
import java.util.Iterator;


public class Accuracy {
	public static void calClass(HashMap cls,String[][] d1,String[][] truth,int i, int numb, int row){
		
		for(int j = 1; j < row; j++){
			if(d1[i+1][numb].equalsIgnoreCase(truth[j][numb])){
				if(!cls.containsKey(truth[j][4]))
					cls.put(truth[j][4], "1");
			}			
		}
	}
	public static void calClass1(HashMap cls,HashMap hash,String[][] truth,int i, int numb, int row){
		Iterator it = hash.keySet().iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			for(int j = 1; j < row; j++){				
				if(key.equalsIgnoreCase(truth[j][numb])){
					if(!cls.containsKey(truth[j][4]))
						cls.put(truth[j][4], "1");
				}			
			}
		}		
	}
	public static boolean calCell(HashMap hash,String[] classNumb,String[][] truth,int i, int numb, int row){
		int change = 0;
		for(int j = 1; j < row; j++){
			if(truth[j][4] == null)
				break;
			for(int k = 0; k < classNumb.length; k++){
				if(classNumb[k] == null)
					break;
				if(truth[j][4].equalsIgnoreCase(classNumb[k])){
					if(!hash.containsKey(truth[j][numb])){
						hash.put(truth[j][numb],"1");
						change++;
					}
				}	
			}
		}
		if(change == 0)
			return true;
		else
			return false;
	}
	public static String[] hashToString(HashMap cls){
		String[] classNumb = new String[500];
		int m = 0;
		Iterator it = cls.keySet().iterator();
		while(it.hasNext()){
			   String key = (String) it.next();
			   classNumb[m] = key;
			   m++;
			   //System.out.print("class:" + classNumb[m-1]);
		}
		return classNumb;
	}
	public static int acc(String cell, int i, int numb) throws Exception{
		String[][] d1 = ReadFile.read("d1.csv");
		String[][] truth = ReadFile.read("groundtruth.csv");	
		HashMap<String,String> cls = new HashMap<>();
		HashMap<String,String> hash = new HashMap<>();
		int result = 0;
		int row = truth.length;
		int flag = 1;
		calClass(cls,d1,truth,i,numb,row);
		String[] classNumb = hashToString(cls);
		calCell(hash,classNumb,truth,i,numb,row);
		while(flag == 1){
			calClass1(cls,hash,truth,i,numb,row);
			String[] number = hashToString(cls);						
			if(calCell(hash,number,truth,i,numb,row))
				flag = 0;
		}
		Iterator label = hash.keySet().iterator();
		
		while(label.hasNext()){
			String key = (String) label.next();
			if(key.equalsIgnoreCase(cell))
				result++;
		}
		return result;
	}
	/*public static int acc(String cell, int i, int numb) throws Exception{
		String[][] d1 = ReadFile.read("d1.csv");
		String[][] truth = ReadFile.read("groundtruth.csv");
		HashMap<String,String> cls = new HashMap<>();
		HashMap<String,String> hash = new HashMap<>();
		int result = 0;
		int row = truth.length;
		for(int j = 1; j < row; j++){
			if(d1[i+1][numb].equalsIgnoreCase(truth[j][numb])){
				if(!cls.containsKey(truth[j][4]))
					cls.put(truth[j][4], "1");
			}			
		}
		String[] classNumb = new String[500];
		int m = 0;
		Iterator it = cls.keySet().iterator();
		while(it.hasNext()){
			   String key = (String) it.next();
			   classNumb[m] = key;
			   m++;
			   //System.out.print("class:" + classNumb[m-1]);
		}
		//System.out.println("");
		for(int j = 1; j < row; j++){
			if(truth[j][4] == null)
				break;
			for(int k = 0; k < classNumb.length; k++){
				if(classNumb[k] == null)
					break;
				if(truth[j][4].equalsIgnoreCase(classNumb[k])){
					if(!hash.containsKey(truth[j][numb]))
						hash.put(truth[j][numb],"1");
				}	
			}
		}
		Iterator label = hash.keySet().iterator();
		while(label.hasNext()){
			String key = (String) label.next();
			if(key.equalsIgnoreCase(cell))
				result++;
		}
		return result;
	}*/
}
