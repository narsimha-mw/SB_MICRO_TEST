package com.ics.file.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ics.file.dtos.FileResponse;
import com.ics.file.dtos.ResponseMessage;
import com.ics.file.models.Customer;
import com.ics.file.models.FileDB;
import com.ics.file.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/test-server")
    public String displayServerRunUpMsg(){
        return "File service is running up..";
    }
    @GetMapping("/all")
    public ResponseEntity<List<FileResponse>> getAllFiles(){
        List<FileResponse> files = fileService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getName())
                    .toUriString();
            return FileResponse.builder()
                    .name(dbFile.getName())
                    .type(dbFile.getType())
                    .url(fileDownloadUri)
                    .size(dbFile.getData().length)
                    .build();
            }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @PostMapping(path = "/upload", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ResponseMessage> fileUpload(@RequestParam("file") MultipartFile file){
        String message = "";
        try{
        System.err.println(file.getContentType());
        if(file.getContentType().equals("application/xml")){
            fileService.saveFile(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }else {
            message = "File extension only .xml format " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
        }catch (Exception e){
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    /*
     <Customers>
    <Customer customerID="GREAL">
      <CompanyName>Great Lakes Food Market</CompanyName>
      <ContactName>Howard Snyder</ContactName>
      <ContactTitle>Marketing Manager</ContactTitle>
      </Customers>
     */
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> fetchByFile(@PathVariable Integer id) throws JsonProcessingException {
        FileDB fileDB = fileService.getFile(id);
        byte[] xmlResponse = fileDB.getData();
        XmlMapper  xmlMapper =new XmlMapper();
       FileDB customer= xmlMapper.readValue("xml", FileDB.class);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(customer);
        System.err.println(json);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                +fileDB.getName()+"\"")
                .body(fileDB.getData());
    }
}
