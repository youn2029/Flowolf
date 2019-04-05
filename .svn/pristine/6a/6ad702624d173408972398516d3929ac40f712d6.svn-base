package kr.or.dev.group.kind.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.group.kind.dao.KindDaoInf;
import kr.or.dev.group.kind.model.KindVO;

import org.springframework.stereotype.Service;

@Service("kindService")
public class KindService implements KindServiceInf {
	
	@Resource(name="kindDao")
	private KindDaoInf kindDao;

	/**
	* Method : insertKind
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param kindVo
	* @return
	* Method 설명 : 프로젝트 분류 등록
	*/
	@Override
	public int insertKind(KindVO kindVo) {
		return kindDao.insertKind(kindVo);
	}

	/**
	* Method : updateKind
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param kindVo
	* @return
	* Method 설명 : 프로젝트 분류 수정
	*/
	@Override
	public int updateKind(KindVO kindVo) {
		return kindDao.updateKind(kindVo);
	}

	/**
	* Method : deleteKind
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param kindVo
	* @return
	* Method 설명 : 프로젝트 분류 삭제 처리
	*/
	@Override
	public int deleteKind(KindVO kindVo) {
		return kindDao.deleteKind(kindVo);
	}

	/**
	* Method : getKindAllList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 모든 프로젝트 분류 조회
	*/
	@Override
	public List<KindVO> getKindAllList() {
		return kindDao.getKindAllList();
	}

}
