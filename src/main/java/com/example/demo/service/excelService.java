package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.category;
import com.example.demo.helper.categoryHelper;
import com.example.demo.repository.categoryRepository;

@Service
public class excelService 
{
	@Autowired
	private categoryRepository categoryRepository;
	
	public ByteArrayInputStream getdata() throws IOException
	{
		List<category> lists = categoryRepository.findAll();
		ByteArrayInputStream arrayInputStream = categoryHelper.dataToExcel(lists);
		return arrayInputStream;
	}
}
