package com.ics.file.services;

import com.ics.file.models.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface FileService {

    FileDB getFile(Integer id);
    Stream<FileDB> getAllFiles();

    FileDB saveFile(MultipartFile file) throws IOException;
}
