package com.loader.service;

import com.loader.helper.CSVTOObject;
import com.loader.repository.FileRepo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class CSVFileService {

    @Autowired
    private FileRepo fileRepo;

    public void save(File file) throws IOException {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(file));
            List<String[]> files = csvReader.readAll();
            List<com.loader.model.File> fileListObject = CSVTOObject.csvToFileObject(files);
            System.out.println(fileListObject);
            fileRepo.saveAll(fileListObject);

        } catch (IOException | CsvException e ) {
           throw new RuntimeException(e);
        }
        finally {
            csvReader.close();
        }
    }

    public List<com.loader.model.File> getAllData(){
        return (List<com.loader.model.File>) fileRepo.findAll();
    }

    public com.loader.model.File getDataByCode(String code){
       List<com.loader.model.File> files = (List<com.loader.model.File>) fileRepo.findAll();
       for (com.loader.model.File file : files) {
           if (file.getCode().equalsIgnoreCase(code))
               return file;
       }
       return null;
    }

    public void deleteData(){
        fileRepo.deleteAll();
    }
}
