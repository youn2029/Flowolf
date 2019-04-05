package kr.or.dev.group.box.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.box.dao.BoxDaoInf;
import kr.or.dev.group.box.model.BoxVO;

import org.springframework.stereotype.Service;

@Service("boxService")
public class BoxService implements BoxServiceInf {
	
	@Resource(name="boxDao")
	private BoxDaoInf boxDao;

	@Override
	public List<BoxVO> getBoxMyList(String mem_id) {
		return boxDao.getBoxMyList(mem_id);
	}

	@Override
	public int insertBox(BoxVO boxVo) {
		
		int index = boxDao.getBoxMaxIndex(boxVo.getMem_id());
		boxVo.setBox_index(index+1);
		
		return boxDao.insertBox(boxVo);
	}

	@Override
	public int updateBox(BoxVO boxVo) {
		return boxDao.updateBox(boxVo);
	}

	@Override
	public int deleteBox(int box_no) {
		return boxDao.deleteBox(box_no);
	}

	@Override
	public BoxVO getBoxDetail(int box_no) {
		return boxDao.getBoxDetail(box_no);
	}

	@Override
	public int getBoxMaxIndex(String mem_id) {
		return boxDao.getBoxMaxIndex(mem_id);
	}

	@Override
	public List<BoxVO> getProBoxList(Map<String, Object> paramMap) {
		return boxDao.getProBoxList(paramMap);
	}

}
