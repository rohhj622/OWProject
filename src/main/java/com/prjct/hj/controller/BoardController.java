package com.prjct.hj.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.prjct.hj.commons.util.UploadVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/board/selectLoc")
	public String selectLoc(Locale locale, Model model) {
		//게시글쓰기 시작 
		return "board/createSelectLoc";
	}
	
	
	@RequestMapping(value = "/board/selectTheme")
	public String selectTheme(Locale locale, Model model, 
								@RequestParam("sido1") String sido, @RequestParam("gugun1") String gugun  ) {
		
		model.addAttribute("sido", sido); // 시도
		model.addAttribute("gugun", gugun); //구군 
		
		return "board/createSelectTheme";
	}
	
	
	
	@RequestMapping(value = "/board/writeTitle")
	public String writeTitle(Locale locale, Model model, 
								@RequestParam("theme1") String theme, @RequestParam("sido") String sido, @RequestParam("gugun") String gugun  ) {
		
		model.addAttribute("sido", sido); // 시도
		model.addAttribute("gugun", gugun); //구군 
		model.addAttribute("theme", theme); // 장소
		
		return "board/createWriteTitle";
	}
	
	@RequestMapping(value = "/board/uploadPhoto")
	public String uploadPhoto(Locale locale, Model model, 
								@RequestParam("theme") String theme, 
								@RequestParam("sido") String sido, 
								@RequestParam("gugun") String gugun,
								@RequestParam("title1") String title) {
		
		model.addAttribute("sido", sido); // 시도
		model.addAttribute("gugun", gugun); //구군 
		model.addAttribute("theme", theme); // 장소
		model.addAttribute("title", title); //글 제목 
		
		return "board/createUploadPhoto";
	}
	
	@RequestMapping(value = "/board/writeContent")
	public String writeContent(Locale locale, Model model, 
								@RequestParam("theme") String theme, 
								@RequestParam("sido") String sido, 
								@RequestParam("gugun") String gugun,
								@RequestParam("title") String title, MultipartHttpServletRequest mtfRequest) {

		List<MultipartFile> fileList = mtfRequest.getFiles("file1"); //업로드 파일 list MultipartFile 형태로 가져오기
		
		String path = "/Users/hyunjin/Pictures/testFile/"; //저장 경로

        for (MultipartFile mf : fileList) {
        	logger.info("hi");
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            // 파일 이름 변경
    	    UUID uuid = UUID.randomUUID();
    	    
    	    // 저장시, 파일 이름
    	    String saveName = uuid + "_" + originFileName;
            long fileSize = mf.getSize(); // 파일 사이즈

            logger.info("originFileName : " + originFileName);
            logger.info("fileSize : " + fileSize);

            File saveFile = new File(path,saveName);
            try {
                mf.transferTo(saveFile);
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        
		model.addAttribute("sido", sido); //시도
		model.addAttribute("gugun", gugun); //구군 
		model.addAttribute("theme", theme); //장소
		model.addAttribute("title", title); //글 제목 
		model.addAttribute("fileList", fileList); //사진
		
		return "board/createWriteContent";
	}
	
	@RequestMapping(value = "/board/writePost")
	public String writePost(Locale locale, Model model, 
								@RequestParam("theme") String theme, 
								@RequestParam("sido") String sido, 
								@RequestParam("gugun") String gugun,
								@RequestParam("title") String title,
								@RequestParam("content1") String content,
								@RequestParam("fileList") List<MultipartFile> fileList) {
		
		String path = "/Users/hyunjin/Pictures/testFile/"; //저장 경로
		
		if(fileList.isEmpty()) {
			logger.info("엥?");
		}
        
		model.addAttribute("sido", sido); //시도
		model.addAttribute("gugun", gugun); //구군 
		model.addAttribute("theme", theme); //장소
		model.addAttribute("title", title); //글 제목 
		model.addAttribute("fileList", fileList); //사진
		
		return "board/createDone";
	}
}

