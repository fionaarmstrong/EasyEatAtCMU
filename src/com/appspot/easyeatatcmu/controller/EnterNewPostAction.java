package com.appspot.easyeatatcmu.controller;

import java.util.List;

import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.model.TagService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * From main page enter into new post page.
 * Read tag list from database for auto completion.
 * @author remonx
 *
 */
public class EnterNewPostAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private ArrayList<String> tagList;
	private List<Tag> tagList;
	
	
	public String execute(){
		//System.out.println("entered");
		TagService ts = new TagService();
		tagList = ts.listTags();
		
		//System.out.println(tagList.get(1).getTagname());
//		for(int i=0;i<tagList.size();i++){
//			tagList.add(tagList.get(i).getTagname());
//		}
		return SUCCESS;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	
}
