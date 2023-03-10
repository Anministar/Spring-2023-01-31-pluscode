package com.test.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/upload")
@Log4j
public class UploadController {
	private String uploadDir = "c:\\upload";
	
	@GetMapping("/form")
	public void func1() {
		log.info("Upload form...");
	}
	
	@PostMapping("/reqUpload")
	public void func2(@RequestParam("files") MultipartFile[] uploadfiles, Model model) throws Exception {
		System.out.println("UPLOAD FILE : " + uploadfiles.length);
		
		//uploaddir + UUID.random()
		String path = uploadDir + File.separator + UUID.randomUUID();
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs(); //mkdir에서 s가 붙이면 상위 폴더도 다 만들어주는 역할을 함.
		}
		
		for(MultipartFile part : uploadfiles) {
			System.out.println("-----------------------------------------------");
			System.out.println("file name : " + part.getOriginalFilename());
			System.out.println("file size : " + part.getSize());
			System.out.println("-----------------------------------------------");
			
			//파일명 추출
			String filename = part.getOriginalFilename();
			//파일객체 생성
			File savefile = new File(path, filename);
			//UPLOAD
			part.transferTo(savefile);
		}
		
		
	}
	
	@GetMapping("/showfile")
	public void func3(Model model) {
		File root = new File(uploadDir); //c:\\upload
		File [] uuidDirs = root.listFiles(); 
		// c:\\upload\\f1d0d060-ed01-436f-94f5-25f0d3dc39f7
		// c:\\upload\\f97d077b-fbb3-4644-8cd5-0f339cd741da
		
		
		for(File dir : uuidDirs) {
			System.out.println("---------------------");
			System.out.println("Folder : " + dir.getPath());
			System.out.println("---------------------");
			File subdir = new File(dir.getPath());
			File [] files = subdir.listFiles();
			
			
			for(File file : files) {
				System.out.println("files : " + file.getName());
			}
			model.addAttribute("uploadDir", root);
			model.addAttribute("files", files);
		}
	}
	
	
}
