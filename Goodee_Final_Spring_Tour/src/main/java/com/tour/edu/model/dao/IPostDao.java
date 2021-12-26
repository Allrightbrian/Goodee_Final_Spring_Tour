package com.tour.edu.model.dao;

import java.util.List;

import com.tour.edu.vo.MyTourBookVo;
import com.tour.edu.vo.Post_Vo;

public interface IPostDao {
	public List<Post_Vo> postAllSelect();
	public List<Post_Vo> userPostSelect(String id);
	public List<Post_Vo> themePostSelect(String id);
	public Post_Vo detailPostSelect(int postid);
	public List<Post_Vo> profilePostSelect(String userid);
	public int wirtePost(Post_Vo vo);
	public List<MyTourBookVo> myTourSelect(String userid);
}
