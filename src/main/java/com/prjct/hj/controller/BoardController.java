package com.prjct.hj.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.prjct.hj.commons.pagination.Pagination;
import com.prjct.hj.domain.AttachedFileVO;
import com.prjct.hj.domain.PostVO;
import com.prjct.hj.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private List<AttachedFileVO> fileList2 = new ArrayList<AttachedFileVO>();
	@Inject
	BoardService service;
	
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
								@RequestParam("title") String title, MultipartHttpServletRequest mtfRequest) throws Exception {

		List<MultipartFile> fileList1 = mtfRequest.getFiles("file1"); //업로드 파일 list MultipartFile 형태로 가져오기
		fileList2.clear();
		
		String path = "/Users/hyunjin/Pictures/testFile/"; //저장 경로
		
		int i=0;
		
        for (MultipartFile mf : fileList1) {
        	AttachedFileVO af = new AttachedFileVO();
        	
        	logger.info("hi");
        	
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            // 파일 이름 변경
    	    UUID uuid = UUID.randomUUID();
    	    
    	    // 저장시, 파일 이름
    	    String saveName = uuid+ "_" + originFileName;
            long fileSize = mf.getSize(); // 파일 사이즈
            
            logger.info(Integer.toString(i));
            logger.info("originFileName : " + originFileName);
            logger.info("fileSize : " + fileSize);
            logger.info("saveName : " + saveName);
            
            af.setAf_creaID("rohhj622"); //나중에 세션아이디 값으로 변경 
            af.setAf_fileSize(fileSize);
            af.setAf_originalName(originFileName);
            af.setAf_reName(saveName);
            
            fileList2.add(i, af);
            
            i++;
            
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
		model.addAttribute("fileList2", fileList2); //사진
		
		return "board/createWriteContent";
	}
	
	@RequestMapping(value = "/board/writePost")
	public String writePost(Locale locale, Model model, PostVO post,
								@RequestParam("theme") String theme, 
								@RequestParam("sido") String sido, 
								@RequestParam("gugun") String gugun,
								@RequestParam("title") String title,
								@RequestParam("content1") String content) throws Exception{
		
		if(fileList2.isEmpty()) {
			logger.info("엥?");
		}
		String id = "rohhj622";
		
		
		
		post.setMem_id(id); //나중에 고치기 세션값으로.
		post.setPost_title(title);
		post.setPost_content(content);
		post.setPost_sido(sido);
		post.setPost_gugun(gugun);
		post.setPost_theme(theme);
		
		service.insertPost(post); //글쓰기.
		
		int postNum=service.selectPostIdx(post);
		
		for(AttachedFileVO af: fileList2) {
			af.setPost_idx(postNum);		
			service.insertAttachedFile(af);
			
		}
		
		return "board/createDone";
	}
	
	@RequestMapping(value = "/board/postList", method = RequestMethod.GET)
	public String postList(Locale locale, Model model,
							@RequestParam(required = false, defaultValue = "1") int page,
							@RequestParam(required = false, defaultValue = "1") int range) throws Exception {
		
		
		logger.info(Integer.toString(page));
		logger.info(Integer.toString(range));
		
		int listCnt = service.selectPostCnt(); //전체 게시글 개수	

		Pagination pagination = new Pagination(); //Pagination 객체생성
		pagination.pageInfo(page, range, listCnt);
		
		List<PostVO> list = service.selectAllPost(pagination);

		model.addAttribute("pagination", pagination);
		model.addAttribute("list",list);
		
		return "board/boardView";
	}
	
	@RequestMapping(value = "/board/postDetail", method = RequestMethod.GET)
	public String postDetail(Locale locale, Model model,
							@RequestParam("idx") int post_idx ) throws Exception {
		
		logger.info(Integer.toString(post_idx));
		PostVO post = service.selectPostOne(post_idx); //게시글 번호에 맞는 내용 가져오기.
		
		// 첨부파일 테이블에서 게시글 번호에 맞는 첨부파일 이름들 가져오기.
		
		
		
		model.addAttribute("post",post);
		
		return "board/postDetail";
	}
}

