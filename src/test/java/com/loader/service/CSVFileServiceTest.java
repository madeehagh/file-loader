package com.loader.service;

import com.loader.repository.FileRepo;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class CSVFileServiceTest {

    @Mock
    private CSVFileService csvFileServiceMock;

    @Mock
    private FileRepo fileRepositoryMock;

   

    @Test
    public void save_file_successfully() throws IOException {
        String fileName = "src//main//resources//exercise.csv";
        File file = new File(fileName);
        csvFileServiceMock.save(file);
        verify(csvFileServiceMock, times(1)).save(file);
    }
}