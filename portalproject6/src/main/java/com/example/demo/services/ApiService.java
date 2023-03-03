package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.Models.child;
import com.example.demo.repositories.childrepo;

@Service
public class ApiService {

	@Autowired
	childrepo repository;

	
	
	public List<child> getchild(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	

	public List<child> setPages(@PathVariable int offset,@PathVariable int pageSize){
		Page<child> page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

	public List<child> getSort(String field){
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));

}
	public Page<child> pageFields(int offset,int pagesize,String field){
		Pageable page1=PageRequest.of(offset,pagesize,Sort.by(Direction.ASC,field));
		return repository.findAll(page1);
	}
}
