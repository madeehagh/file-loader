package com.loader.controller;

import com.loader.service.CSVFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/v1/csv")
public class FileController {

    @Autowired
     private CSVFileService csvFileService;

    @GetMapping("/") // TODO: change to POST and get URL/filelocation for file
    // Add validation on request
    public ResponseEntity<String> loadFile() throws IOException {
        String fileName = "src/main/resources/exercise.csv";
        try {
            csvFileService.save(new File(fileName));
            return ResponseEntity.status(HttpStatus.OK).body( "\" message \": \" "+ " File Uploaded " +" \"");
            // fileReader(fileName);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "File Not Found");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<com.loader.model.File>> getAllData() {
        try {
            List<com.loader.model.File> files = csvFileService.getAllData();
            if (files.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(files, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<com.loader.model.File> getByCode(@PathVariable String code){
        //TODO: validation on code
        try {
            return new ResponseEntity<>(csvFileService.getDataByCode(code), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteData(){
        try {
            csvFileService.deleteData();
            return  ResponseEntity.status(HttpStatus.OK).body( "\" message \": \" "+ " Data Uploaded " +" \"");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
