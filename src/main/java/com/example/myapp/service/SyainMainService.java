package com.example.myapp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.SyainMain;
import com.example.myapp.mapper.SyainMainRepository;
import com.example.myapp.vo.EmployeeVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class SyainMainService {
	
	@Autowired
	SyainMainRepository syainMainRepository;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private EntityManager entityManager;
	
	public List<EmployeeVO> searchEmployess(Integer company, String employeeName, Integer positionType) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SyainMain> cq = cb.createQuery(SyainMain.class);
		Root<SyainMain> syainMain = cq.from(SyainMain.class);
		
		List<Predicate> predicates = new ArrayList<>();
	    // 职位类型是必须的查询条件
	    predicates.add((Predicate) cb.equal(syainMain.get("syokugyoKind"), positionType));
	    // 公司名是可选的查询条件
		if (company != null && company != 0) {
			predicates.add((Predicate) cb.equal(syainMain.get("syozokuKaisya"), company));
		}
	    // 用户名是可选的查询条件
		if (employeeName != null && !employeeName.isEmpty()) {
			predicates.add((Predicate) cb.like(syainMain.get("firstNameKanji"), "%" + employeeName + "%"));
		}
		cq.where(cb.and((jakarta.persistence.criteria.Predicate[]) predicates.toArray(new Predicate[0])));
		TypedQuery<SyainMain> query = entityManager.createQuery(cq);
		
		return convertToEmployeeList(query.getResultList());
	}
	
	
	/**
	 * 保存
	 * @param syainMain
	 */
	public void saveSyainMain(SyainMain syainMain) {
		syainMainRepository.save(syainMain);
	}
	
	public List<EmployeeVO> searchSyain() {
		List<SyainMain> employees = syainMainRepository.findAll();
		return convertToEmployeeList(employees);
	}
	
	/**
	 * 社員名は記入ありの場合
	 * 曖昧検索
	 * @param company
	 * @param name
	 * @param positionType
	 * @param is
	 * @return
	 */
	public List<EmployeeVO> searchSyainMainByConditions(Integer company, String name, Integer positionType, Integer is) {
		List<SyainMain> employees = syainMainRepository.findBySyozokuKaisyaAndSyokugyoKindAndFirstNameKanjiContainingAndDeleteFlag(company, positionType, name, is);
		return convertToEmployeeList(employees);
	}
	
	/**
	 * 社員名が空欄の場合
	 * 全検索として、社員名を上記条件から省く
	 * @param company
	 * @param positionType
	 * @param is
	 * @return
	 */
	public List<EmployeeVO> searchSyainMainByConditions(Integer company, Integer positionType, Integer is) {
		List<SyainMain> employees = syainMainRepository.findBySyozokuKaisyaAndSyokugyoKindAndDeleteFlag(company, positionType, is);
		return convertToEmployeeList(employees);
	}
	
	/**
	 * 所属会社が「全て」で選択した場合
	 * 所属会社IDを上記条件から省く
	 * @param name
	 * @param positionType
	 * @param is
	 * @return
	 */
	public List<EmployeeVO> searchSyainMainByConditions(String name, Integer positionType, Integer is) {
		List<SyainMain> employees = syainMainRepository.findByFirstNameKanjiContainingAndSyokugyoKindAndDeleteFlag(name, positionType, is);
		return convertToEmployeeList(employees);
	}
	
	/**
	 * 退社日＝空白
	 * @param company
	 * @param positionType
	 * @return
	 */
	public List<EmployeeVO> searchSyainMainByConditions(Integer company, Integer positionType) {
		List<SyainMain> employees = syainMainRepository.findBySyozokuKaisyaAndSyokugyoKindAndTaisyaDateIsNull(company, positionType);
		return convertToEmployeeList(employees);
	}
	
		
	// 根据实体类SyainMain提取和转换为前端展示的VO
	public List<EmployeeVO> convertToEmployeeList(List<SyainMain> syainMainList){
		List<EmployeeVO> employeeVOList = new ArrayList<>();
		for (SyainMain syainMain: syainMainList) {
			Integer id = syainMain.getSyainId();
			String company = mapCompany(syainMain.getSyozokuKaisya());
			String employeeName = syainMain.getFirstNameKanji() + " " + syainMain.getLastNameKanji();
			String gender = syainMain.getSeibetu() == 1 ? "男":"女";
			String positionType = mapPositionType(syainMain.getSyokugyoKind());
			String joinDate = syainMain.getNyusyaDate() != null ? dateFormat.format(syainMain.getNyusyaDate()) : "";
			String leaveDate = syainMain.getTaisyaDate() != null ? dateFormat.format(syainMain.getTaisyaDate()) : "";
			EmployeeVO employeeVO = new EmployeeVO(id, company, employeeName, gender, positionType, joinDate, leaveDate);
			employeeVOList.add(employeeVO);
		}
 		return employeeVOList;
	}
	
	// 根据所属公司ID转换为公司名称的方法
	private String mapCompany(Integer syozokuKaisyaId) {
		switch (syozokuKaisyaId) {
		case 1:
			return "株式会社ブライトスター";
		case 2:
			return "株式会社トップクラウド";
		default:
				return "";
		}
	}
	
	//根据职位种类ID转换为职位种类名称
	private String mapPositionType(Integer syokugyoKinId) {
		switch (syokugyoKinId) {
		case 1:
			return "役員";
		case 2:
			return "総務";
		case 3:
			return "IT営業";
		case 4:
			return "ITエンジニア";
		case 5:
			return "不動産スタッフ";
		case 6:
			return "個人事業主";
		default: 
			return "";
		}
	}
	
	

}
