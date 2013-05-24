package com.appspot.easyeatatcmu.controller;

import java.util.ArrayList;
import java.util.List;

import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.model.TagService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * this class reponse to the tag search ajax.
 * @author Yin Xu
 *
 */
public class SearchTagAjaxAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String prefix;
	private List<Tag> tagList;
	
	public String execute(){
		tagList = new ArrayList<Tag>();
		System.out.println("search tag executed");
		TagService ts = new TagService();
		tagList = ts.prefixTags(prefix);
//		Tag tag = new Tag();
//		tagList.add(tag);
		
//		for(int i=0;i<tagList.size();i++){
//			System.out.println(tagList.get(i).getTagname());
//		}
		return SUCCESS;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

}
