package com.mongo.dao;

import java.util.List;
import com.mongo.entity.Page;
import com.mongo.entity.Person;

public interface MongoDao {
	
	//全部查询,并且降序排列
	public List<Person> findAll(Page page);
	
	//模糊查询
	public List<Person> findByRegex(String regex);
	
}
