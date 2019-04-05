package kr.or.dev.timeline.emoticon.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import kr.or.dev.timeline.emoticon.model.EmoticonVO;
import kr.or.dev.timeline.emoticon.service.EmoticonServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("emoController")
@RequestMapping("/emo")
public class EmoticonController {

	@Resource(name="emoService")
	private EmoticonServiceInf emoService;
	
	@RequestMapping("/view")
	public void emoView(HttpServletResponse response
					  , @RequestParam("emo_no") int emo_no) throws IOException{
		
		EmoticonVO emoVo = emoService.getEmoDetail(emo_no);
		
		String file = emoVo.getEmo_pic_path()+ File.separator + emoVo.getEmo_pic_name();
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+ emoVo.getEmo_pic_name() +"\"");
		response.setContentType("application/octet-stream");
		
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
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
