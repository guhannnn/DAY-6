package com.example.demo.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.child;
import com.example.demo.repositories.childrepo;
import com.example.demo.services.ApiService;


@RestController
public class ApiController {
	 @Autowired
	  childrepo serviceRepository;
	@Autowired
	   ApiService service;
	 
	 @GetMapping("/getvalues")
	   List<child> getList(){
		 return serviceRepository.findAll();
	 }
	 @PostMapping("/post")
	  public child create(@RequestBody child ch) {
		 return serviceRepository.save(ch);
	 }
	 
	 @GetMapping("/{field}")
	 public List<child> getbyid(@PathVariable String field){
		
		return service.getchild(field);
	 }
	  @GetMapping("/child/{offset}/{PageSize}")
	 public List<child> studentWithPagination(@PathVariable int offset,@PathVariable int PageSize){
		return service.setPages(offset, PageSize); 
	 }
	 
	 @GetMapping("/child/{field}")
	 public List<child> childSortList(@PathVariable String field){
		 return service.getSort(field);
	 }
	 @GetMapping("/{offset}/{pagesize}/{field}")
     public Page<child> pageField(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
         return service.pageFields(offset,pagesize,field);
     }

	   
}
