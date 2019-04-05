package kr.or.dev.files.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dev.files.model.FilesVO;

import org.springframework.web.servlet.View;

public class FileDownloadView implements View {

	@Override
	public String getContentType() {
		return "application/octet-stream";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FilesVO filesVo = (FilesVO) model.get("filesVo");
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+filesVo.getFiles_name()+"\"");
		response.setContentType("application/octet-stream");
		
		String files = filesVo.getFiles_path()+File.separator+filesVo.getFiles_upload();
		
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(files);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len;
		
		while ((len = fis.read(b)) != -1) {
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();
	}

}
