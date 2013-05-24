package com.appspot.easyeatatcmu.controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.databean.User;
import com.appspot.easyeatatcmu.model.TagService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This class prepares the data for the Tags page.
 * @author Yin Xu
 *
 */
public class EnterTagsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String tagStat[][];
	private List<Tag> allTagList;
	
	public String execute(){

		/**
		 * get the tag list and statistical info
		 */
//		PostTagService pts = new PostTagService();
//		tagStat = pts.tagStat();
		TagService ts = new TagService();
		allTagList = ts.listTags();
		//System.out.println("list size: "+tagList.size());
		//System.out.println(tagList.get(0).getTagname());
		
		return SUCCESS;
	}

	public List<Tag> getAllTagList() {
		return allTagList;
	}

	public void setAllTagList(List<Tag> allTagList) {
		this.allTagList = allTagList;
	}


//	public String[][] getTagStat() {
//		return tagStat;
//	}
//
//	public void setTagStat(String[][] tagStat) {
//		this.tagStat = tagStat;
//	}

}
