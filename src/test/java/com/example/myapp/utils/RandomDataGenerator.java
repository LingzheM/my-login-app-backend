package com.example.myapp.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.example.myapp.entity.SyainMain;

public class RandomDataGenerator {
	
	private Random random = new Random();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private Date randomDate(String start, String end) {
		try {
			Date startDate = dateFormat.parse(start);
			Date endDate = dateFormat.parse(end);
			long randomTime = startDate.getTime() 
					+ (long)((random.nextDouble())*(endDate.getTime() - startDate.getTime()));
			return new Date(randomTime);
		} catch (Exception e) {
			return null;
		}
	}
	
	private String randomStringFromList(String[] list) {
		return list[random.nextInt(list.length)];
	}
	
	public SyainMain generateRandomEmployee() {
		String[] firstNamesKanji = {"佐藤", "鈴木", "高橋", "田中", "伊藤"};
        String[] lastNamesKanji = {"太郎", "次郎", "花子", "幸子", "一郎"};
        
        SyainMain employee = new SyainMain();
        employee.setFirstNameKanji(randomStringFromList(firstNamesKanji));
        employee.setLastNameKanji(randomStringFromList(lastNamesKanji));
        employee.setFirstNameKana(randomStringFromList(firstNamesKanji)); // 假设假名与汉字名相同
        employee.setLastNameKana(randomStringFromList(lastNamesKanji));
        employee.setFirstNameEigo("John"); // 假设英文名
        employee.setLastNameEigo("Doe");
        employee.setSeibetu(random.nextInt(2)); // 性别: 0 或 1
        employee.setTanjyobi(randomDate("1980-01-01", "2000-12-31"));
        employee.setKokuseki(random.nextInt(3) + 1); // 国籍: 假设值
        employee.setSyussinn("Tokyo");
        employee.setHaigusya(random.nextInt(2)); // 配偶者: 0 或 1
        employee.setSyozokuKaisya(random.nextInt(2) + 1); // 所属公司: 假设值
        employee.setSyokugyoKind(random.nextInt(6) + 1); // 职业种类: 假设值
        employee.setSaisyuuGakureki(random.nextInt(5) + 1); // 最终学历: 假设值
        employee.setDeleteFlag(0); // 删除标志: 0 为有效
        employee.setTorokubi(new Date()); // 注册日: 当前日期
        employee.setKousinnbi(new Date()); // 更新日: 当前日期

        return employee;
	}
	
	public List<SyainMain> generateRandomEmployees(int numberOfEmployees) {
		List<SyainMain> employees = new ArrayList<>();
		for (int i=0;i<numberOfEmployees;i++) {
			employees.add(generateRandomEmployee());
		}
		return employees;
	}
 
}
