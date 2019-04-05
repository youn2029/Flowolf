package kr.or.dev.group.kind.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.group.kind.model.KindVO;

@Repository("kindDao")
public class KindDao implements KindDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

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
		return template.insert("kind.insertKind", kindVo);
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
		return template.update("kind.updateKind", kindVo);
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
		return template.update("kind.deleteKind", kindVo);
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
		return template.selectList("kind.getKindAllList");
	}

}
