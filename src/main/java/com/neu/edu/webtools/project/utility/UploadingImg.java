package com.neu.edu.webtools.project.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.util.FileUtil;

public class UploadingImg {
	
	private static final String PATH_ABS = "/Users/jayashree/eclipse-workspace/webtools.project/src/main/webapp/frontend/images/";
	private static String PATH_REAL = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String itemcode) {
		// TODO Auto-generated method stub
		
		PATH_REAL = request.getSession().getServletContext().getRealPath("/frontend/images/");
		
		
		logger.info(PATH_REAL);					

		
		if(!new File(PATH_REAL).exists()) {
			new File(PATH_REAL).mkdirs();
		}
		
		if(!new File(PATH_ABS).exists()) {
			new File(PATH_ABS).mkdirs();
		}
		
		try {
			file.transferTo(new File(PATH_REAL + itemcode + ".jpg"));
			file.transferTo(new File(PATH_ABS + itemcode + ".jpg"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	
		
	}

}
