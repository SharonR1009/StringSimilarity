import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {
	public static String[][] read(String fileName) throws Exception{
		File file = new File(fileName);
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        String[][] data = new String[900][5];
        int line = 0;
        while ((tempString = reader.readLine()) != null) {
        	data[line] = tempString.split(",");
            data[line][1] = tempString.split(",")[1];
            data[line][2] = tempString.split(",")[2];
            data[line][3] = tempString.split(",")[3];
        	//System.out.println(data[line][3]);
        	line++;
            
        }
        reader.close();
        return data;
	}
}
