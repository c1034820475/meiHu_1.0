package meiHu.service;

import meiHu.entity.ForumPost;
import meiHu.entity.ForumTopic;

import java.util.List;

public interface LuntanService {

    public List<ForumTopic> getAllTopics() ;

    public List<ForumPost> selectPostsByTid(int tid) ;

    public ForumPost selectPostByPid(int pid);

    public List<ForumPost> selectAllPostsOrderByVisits(int tid) ;

    public List<ForumPost> selectAllPostsOrderByCreatetime(int tid) ;
}
