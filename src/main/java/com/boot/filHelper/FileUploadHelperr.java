package com.boot.filHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelperr {
	
	//public final String UPLOAD_DIR="D:\\spring boot\\SpringBootDevProject\\src\\main\\resources\\static\\image";
	
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	public FileUploadHelperr()throws IOException
	{
		
	}
	
	public boolean uploadFile(MultipartFile file)
	{
		boolean f=false;
		try {
			InputStream is = file.getInputStream();
			byte data[]=new byte[is.available()];
			is.read(data);
			
			//write
			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			
			// or  2nd method
			
			//Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+"\\"+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			
			f=true;
		} catch (Exception e) {
		e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		return f;
	}

}
