package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.poi.util.Removal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.excelService;

@RestController
@RequestMapping("/down")
public class categoryController 
{
	@Autowired
	private excelService excelService;
	
	@GetMapping("/excel")
	public ResponseEntity<Resource> getFile() throws IOException
	{
		String fileName = "simple.xlsx";
		ByteArrayInputStream datas = excelService.getdata();
		InputStreamResource resource = new InputStreamResource(datas);
		ResponseEntity<Resource> resp = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName)
		.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		.body(resource);
		return resp;
	}
}
