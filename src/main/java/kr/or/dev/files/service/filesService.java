package kr.or.dev.files.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.files.dao.FilesDaoInf;
import kr.or.dev.files.model.FilesVO;

@Service("filesService")
public class filesService implements FilesServiceInf {
	
	@Resource(name="filesDao")
	private FilesDaoInf filesDao;

	@Override
	public int insertFiles(Map<String, Object> paramMap) {
		return filesDao.insertFiles(paramMap);
	}

	@Override
	public int deleteFilesR(int files_no) {
		return filesDao.deleteFilesR(files_no);
	}

	@Override
	public FilesVO getFilesDetail(int files_no) {
		return filesDao.getFilesDetail(files_no);
	}

	@Override
	public List<FilesVO> getFilesList(Map<String, Object> paramMap) {
		return filesDao.getFilesList(paramMap);
	}

	@Override
	public List<FilesVO> getFilesSearchList(Map<String, String> searchMap) {
		return filesDao.getFilesSearchList(searchMap);
	}

	@Override
	public List<FilesVO> getFilesBaTaAllList(Map<String, String> paramMap) {
		return filesDao.getFilesBaTaAllList(paramMap);
	}
	@Override
	public List<FilesVO> getFilesRepAllList(Map<String, String> paramMap) {
		return filesDao.getFilesRepAllList(paramMap);
	}

	@Override
	public List<FilesVO> getProFilesBaTaAllList(Map<String, Object> paramMap) {
		return filesDao.getProFilesBaTaAllList(paramMap);
	}

	@Override
	public List<FilesVO> getProFilesRepAllList(Map<String, Object> paramMap) {
		return filesDao.getProFilesRepAllList(paramMap);
	}
}
