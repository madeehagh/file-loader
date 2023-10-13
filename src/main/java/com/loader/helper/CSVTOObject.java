package com.loader.helper;

import com.loader.model.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVTOObject {


        // Hashmap to map CSV data to
        // Bean attributes.
        private static Map<String, String> mapping = new
                HashMap<String, String>();

    static {
        mapping.put("source", "source");
        mapping.put("codeListCode", "codeListCode");
        mapping.put("code", "code");
        mapping.put("displayValue", "displayValue");
        mapping.put("longDescription", "longDescription");
        mapping.put("fromDate", "fromDate");
        mapping.put("toDate", "toDate");
        mapping.put("sortingPriority", "sortingPriority");
    }
    public static List<File> csvToFileObject(List<String[]> fileData) throws FileNotFoundException {
        List<File> fileList = new ArrayList<>();

        if (fileData.size() == 0)
            return fileList;

        //String[] header = fileData.get(0);

        for (int i = 1; i< fileData.size(); i++){
            String[] fileCsv = fileData.get(i);
            File file = new File(fileCsv[0], fileCsv[1], fileCsv[2], fileCsv[3], fileCsv[4], fileCsv[5], fileCsv[6], fileCsv[7]);

            fileList.add(file);
        }

        return fileList;

       /* HeaderColumnNameTranslateMappingStrategy<File> strategy =
                new HeaderColumnNameTranslateMappingStrategy<File>();
        strategy.setType(File.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;

        try {
             csvReader = new CSVReader(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CsvToBean csvToBean = new CsvToBean();

        List<File> list = csvToBean.parse();
*/


    }
}
