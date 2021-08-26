package com.epam.hadler.reader;

import com.epam.hadler.exceptions.TextReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class FileTextReader {

    private static final Logger logger = LogManager.getLogger(FileTextReader.class);
    private final String MESSAGE_READ_FILE = "Reading file : ";
    private final String MESSAGE_SUCCESS_READING = "File is successfully read";
    private final String MESSAGE_CLOSING_FILE = "Closing file";
    private final String MESSAGE_ERROR_IOEXCEPTION = "Something  is wrong with text reading ";

    String path;

    public FileTextReader(String path) {
        this.path = path;
    }

    public String readFileAsString() throws TextReaderException {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader br = null;
        logger.info(MESSAGE_READ_FILE);
        try {
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            String line = "";
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException  e) {
            throw new TextReaderException(MESSAGE_ERROR_IOEXCEPTION, e);
        }
         finally {
                if (fileReader != null && br != null) {
                    try {
                        fileReader.close();
                        br.close();
                        logger.info(MESSAGE_CLOSING_FILE);
                    } catch (IOException e){
                        logger.error(e.getMessage());
                    }
            }
        }

        logger.info(MESSAGE_SUCCESS_READING);
        return sb.toString();
    }
}
