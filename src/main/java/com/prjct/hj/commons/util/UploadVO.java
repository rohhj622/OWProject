package com.prjct.hj.commons.util;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadVO {
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	
}
