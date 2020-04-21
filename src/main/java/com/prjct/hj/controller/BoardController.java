package com.prjct.hj.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	 * 
	 * 1 -> 글쓰기 
	 * 2 -> 게시글 리스트 
	 * 3 -> 게시글 수정 
	 * 4 -> 게시글 삭제 
	 *  
	 */
	
	// 1-1. 게시글쓰기 시작 & 지역 선택  
	@RequestMapping(value = "/board/selectLoc")
	public String selectLoc(Locale locale, Model model) {
		
		//String pdfPath = request.getSession().getServletContext().getRealPath("/uploadImg/1b4c6f0d-fdd0-4cee-a2c8-fe461d83c014_스캔.jpeg");
		//logger.info(pdfPath);	
		
		
		return "board/createSelectLoc";
	}
	
	// 1-2. 장소 선택
	@RequestMapping(value = "/board/selectTheme")
	public String selectTheme(Locale locale, Model model, 
								@RequestParam("sido1") String sido, @RequestParam("gugun1") String gugun  ) {
		
		model.addAttribute("sido", sido); // 시도
		model.addAttribute("gugun", gugun); //구군 
		
		return "board/createSelectTheme";
	}
	
	
	// 1-3. 글 제목 입력 
	@RequestMapping(value = "/board/writeTitle")
	public String writeTitle(Locale locale, Model model, 
								@RequestParam("theme1") String theme, @RequestParam("sido") String sido, @RequestParam("gugun") String gugun  ) {
		
		model.addAttribute("sido", sido); // 시도
		model.addAttribute("gugun", gugun); //구군 
		model.addAttribute("theme", theme); // 장소
		
		return "board/createWriteTitle";
	}
	
	// 1-4. 사진 업로드하기 
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
	
	// 1-5. 내용 입력하기 
	@RequestMapping(value = "/board/writeContent")
	public String writeContent(Locale locale, Model model, 
								@RequestParam("theme") String theme, 
								@RequestParam("sido") String sido, 
								@RequestParam("gugun") String gugun,
								@RequestParam("title") String title, 
								MultipartHttpServletRequest mtfRequest,
								HttpServletRequest request) throws Exception {

		List<MultipartFile> fileList1 = mtfRequest.getFiles("file1"); //업로드 파일 list MultipartFile 형태로 가져오기
		fileList2.clear();
		
		String fileName2 = request.getSession().getServletContext().getRealPath("/uploadImg");
		
		logger.info("a:"+fileName2);
		
//		String path = "/Users/hyunjin/Documents/spring-ex/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OWprjct/src/main/webapp/resources/uploadImg"; //저장 경로
		String path = "/Users/hyunjin/Pictures/testFile";
//		String path = "/usr/uploadImg";
//		String path = "/OWprjct/src/main/webapp/resources/uploadImg";
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
            logger.info("uploadRoute: " + path  );
            
            af.setAf_creaID("rohhj622"); //나중에 세션아이디 값으로 변경 
            af.setAf_fileSize(fileSize);
            af.setAf_originalName(originFileName);
            af.setAf_reName(saveName);
            
            fileList2.add(i, af);
            
            i++;
            
            File saveFile = new File(path,saveName);
            
            try {
                mf.transferTo(saveFile);
                logger.info("123456");
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
	
	// 1-6. 글 작성 완료하기.
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
	
	
	// 2-1.  게시글 리스트 보여주기  
//	@RequestMapping(value = "/board/postList", method = RequestMethod.GET)
//	public String postList(Locale locale, Model model,
//							@RequestParam(required = false, defaultValue = "1") int page,
//							@RequestParam(required = false, defaultValue = "1") int range) throws Exception {
//		
//		
//		logger.info(Integer.toString(page));
//		logger.info(Integer.toString(range));
//		
//		int listCnt = service.selectPostCnt(); //전체 게시글 개수	
//
//		Pagination pagination = new Pagination(); //Pagination 객체생성
//		pagination.pageInfo(page, range, listCnt);
//		
//		List<PostVO> list = service.selectAllPost(pagination);
//
//		model.addAttribute("pagination", pagination);
//		model.addAttribute("list",list);
//		model.addAttribute("listCnt",listCnt);
//		
//		return "board/boardView2";
//	}
	@RequestMapping(value = "/board/postList", method = RequestMethod.GET)
	public String postList(Locale locale, Model model,
							PostVO post,
							@RequestParam(required = false, defaultValue = "1") int page,
							@RequestParam(required = false, defaultValue = "1") int range,
							@RequestParam(required = false, defaultValue = "시/도 선택") String sido,
							@RequestParam(required = false, defaultValue = "구/군 선택") String gugun,
							@RequestParam(required = false, defaultValue = "장소 선택") String theme) throws Exception {
		
		int listCnt = service.selectPostCnt(); //전체 게시글 개수	
		
		logger.info(sido+":"+gugun+":"+theme);
		
		if(sido.equals("시/도 선택")&gugun.equals("구/군 선택")&theme.equals("장소 선택")){
			
			Pagination pagination = new Pagination(); //Pagination 객체생성
			pagination.pageInfo(page, range, listCnt);
					
			List<PostVO> list = service.selectAllPost(pagination);
				
			model.addAttribute("pagination", pagination);
			model.addAttribute("list",list);
			
		}else if(gugun.equals("구/군 선택")&theme.equals("장소 선택")) {
//			시만 선택
			
			post.setPost_sido(sido);
			
			Pagination pagination = new Pagination(); //Pagination 객체생성
			pagination.pageInfo(page, range, listCnt);
					
			List<PostVO> list = service.selectPostSido(pagination,post);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("list",list);
			
		}else if(sido.equals("시/도 선택")&gugun.equals("구/군 선택")) {
			// 장소만 선택 
			
			logger.info("아아");
			post.setPost_theme(theme);
			
			Pagination pagination = new Pagination(); //Pagination 객체생성
			pagination.pageInfo(page, range, listCnt);
					
			List<PostVO> list = service.selectPostTheme(pagination,post);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("list",list);
			
		}else if(theme.equals("장소 선택")) {
//			시도 + 구군 선택
			
			post.setPost_sido(sido);
			post.setPost_gugun(gugun);
			
			Pagination pagination = new Pagination(); //Pagination 객체생성
			pagination.pageInfo(page, range, listCnt);
					
			List<PostVO> list = service.selectPostSidoGugun(pagination,post);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("list",list);
			
		}else if(gugun.equals("구/군 선택")) {
//			시도 + 장소 선택
			
			post.setPost_sido(sido);
			post.setPost_theme(theme);
			
			
			Pagination pagination = new Pagination(); //Pagination 객체생성
			pagination.pageInfo(page, range, listCnt);
					
			List<PostVO> list = service.selectPostSidoTheme(pagination,post);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("list",list);
			
		}
		
		model.addAttribute("listCnt",listCnt);
		
		return "board/boardView2";
	}
	
	
	// 2-2. 게시글 클릭 시, 세부내용 보여주기, 조회수 +1
	@RequestMapping(value = "/board/postDetail", method = RequestMethod.GET)
	public String postDetail(Locale locale, Model model,
							@RequestParam("idx") int post_idx ) throws Exception {
		
		logger.info(Integer.toString(post_idx));
		
		// 조회수 +1
		service.updatePostView(post_idx);		
		
		//게시글 번호에 맞는 내용 가져오기.
		PostVO post = service.selectPostOne(post_idx); 
		
		// 첨부파일 테이블에서 게시글 번호에 맞는 첨부파일 이름들 가져오기.
		List<AttachedFileVO> fileList = service.selectAttachedFile(post_idx);

		model.addAttribute("fileList",fileList);
		model.addAttribute("post",post);
		
		return "board/postDetail";
	}
	

//	@RequestMapping(value = "/board/deletePost", produces="application/json")
//	@ResponseBody
//	public String deletePost(Locale locale, Model model,
//							@RequestParam("post_idx") int post_idx) throws Exception {
//		
//		logger.info("hi"+Integer.toString(post_idx));
//				
//		// 게시글 삭제
//		int result= service.deletePost(post_idx);
//		int result1=service.updateAttachedFileIsDel(post_idx);
//		
//		if(result==result1) {
//			logger.info("222222222");
//			return "good";
//			
//		}else {
//			logger.info("333333333");
//			return "bad";
//		}
//	}
	
	@RequestMapping(value = "/board/deletePost", produces="application/json")
	public String deletePost(Locale locale, Model model,
							@RequestParam("post_idx") int post_idx) throws Exception {
		
		logger.info("hi"+Integer.toString(post_idx));
				
		// 게시글 삭제
		int result= service.deletePost(post_idx);
		int result1=service.updateAttachedFileIsDel(post_idx);
		
		if(result==result1) {
			logger.info("222222222");
			
		}
		return "board/deleteDone";
	}
}

