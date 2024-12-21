package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class csvUtilities {
    public static List<String[]> read(String file){
        List<String[]> data = new LinkedList<>();

        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((dataRow = br.readLine()) != null){
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
