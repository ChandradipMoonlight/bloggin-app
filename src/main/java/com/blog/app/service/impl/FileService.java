package com.blog.app.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.app.service.IFileService;

@Service
public class FileService implements IFileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		String name = getFileNameWithDateAndTime(file);
		String filePath = path + File.separator + name;
		File fileFolder = new File(path);
		if(!fileFolder.exists()) {
			fileFolder.mkdirs();
		}
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path +File.separator + fileName;
		InputStream input = new FileInputStream(fullPath);
		return input;
	}
	
	public String getFileNameWithDateAndTime(MultipartFile file) {
		String originalFileName = file.getOriginalFilename();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		String fileNamePrefix = originalFileName.substring(0, originalFileName.lastIndexOf("."));
		String fileNameSuffix = originalFileName.substring(originalFileName.lastIndexOf("."));
		String newName = fileNamePrefix + "_" + LocalDateTime.now().format(formatter) + fileNameSuffix;
		return newName;
	}
}
