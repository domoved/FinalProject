package forbes;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public List<Forbes> forbesList = new ArrayList<>();
    public CSVParser(String path) {
        try (CSVReader reader = new CSVReader(new FileReader(path))){
            String[] values;
            reader.readNext();
            while ((values = reader.readNext()) != null){
                Forbes forbes = new Forbes(Integer.parseInt(values[0]), values[1], Float.parseFloat(values[2]), Integer.parseInt(values[3]), values[4], values[5], values[6]);
                forbesList.add(forbes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}