package com.loader.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@Getter
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String source;
    private String codeListCode;
    private String code;
    private String displayValue;
    private String longDescription;
    private String  fromDate;
    private String toDate;
    private String sortingPriority;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public File(String source, String codeListCode, String code, String displayValue, String longDescription, String fromDate, String toDate, String sortingPriority) {
        this.source = source;
        this.codeListCode = codeListCode;
        this.code = code;
        this.displayValue = displayValue;
        this.longDescription = longDescription;
        this.fromDate =  fromDate;
        this.toDate =  toDate;
        this.sortingPriority = sortingPriority;
    }
}
