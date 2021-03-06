package meiHu.control;


import com.github.pagehelper.PageInfo;
import meiHu.entity.*;
import meiHu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping(value = "/luntan")
public class LuntanControl {
    @Autowired
    private UserService userService;
    @Autowired
    private LuntanService luntanService;
    @Autowired
    private FocusService focusService;
    @Autowired
    private PostService postService ;
    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "/luntanshouye.action")
    public void luntanshouye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ForumTopic> topicList=luntanService.getAllTopics();
        List<ForumTopic> topicList1 = new ArrayList<>();
        for(int i=0;i<topicList.size()-1;i++){
            topicList1.add(topicList.get(i));
        }
        request.setAttribute("topicList1",topicList1);
        String tid = request.getParameter("tid");
        int tid1 = Integer.parseInt(tid);
        Map<String ,Object> cmap=new HashMap<>();

        //每页显示的条数
        int pageSize=7;
        //当前的页面默认是首页
        int curPage=1;
        String scurPage=request.getParameter("curPage");
        if (scurPage!=null&&!scurPage.trim().equals("")){

            curPage=Integer.parseInt(scurPage);
        }
        cmap.put("curPage",curPage);
        cmap.put("pageSize",pageSize);
        cmap.put("tid",tid1) ;
        PageInfo<ForumPost> pageInfo= postService.selectPosts(cmap);
        request.setAttribute("pageInfo",pageInfo);
        String tname = luntanService.selectTnameBuTid(tid1);
        request.setAttribute("tname",tname);
        request.setAttribute("userlist",userService.selectUsersByTitleId());
        request.getRequestDispatcher("/jsp/luntan.jsp").forward(request,response);


    }


    @RequestMapping(value = "/tiezidetail.action",method = RequestMethod.GET)
    public void tiezidetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        int pid1 = Integer.parseInt(pid);
        luntanService.updatePostVisitNum(pid1);

        int collection = luntanService.selectCollectedCountByPid(pid1);
        request.setAttribute("collectionnum",collection);
        ForumPost forumPost = luntanService.selectPostByPid(pid1);

        int uid = luntanService.SelectUidByPid(pid1);
        request.setAttribute("focusnum",focusService.selectUserFocusNum(uid));
        request.setAttribute("focusednum",focusService.selectUserFocusedNum(uid));



        request.setAttribute("forumPost",forumPost);
        int postCommentNum = luntanService.selectPostCommentNum(pid1);
        request.setAttribute("postCommentNum",postCommentNum);
        List<ForumComment> forumCommentList = luntanService.selectAllPostCommentByPid(pid1);
        request.setAttribute("forumCommentList",forumCommentList);
        //根据pid查找出所有评论帖子的评论标号
        int[] cidshuzu = luntanService.selectAllCidByPid(pid1);
        Map<String,List<ForumComment>> map = new HashMap<>();
        for(int i =0;i<cidshuzu.length;i++){
            List<ForumComment> commentforcommentList = luntanService.selectAllCommentForComment(cidshuzu[i]);
            map.put(cidshuzu[i]+"",commentforcommentList);
        }
        Map<String,String> mapnum = new HashMap<>();
        for(int i =0;i<cidshuzu.length;i++){
            int num = luntanService.selectCommentCommentNum(cidshuzu[i]);
            mapnum.put(cidshuzu[i]+"",num+"");
        }
        //Set<String> set=map.keySet();
       /* for(String key:set){
            List<ForumComment> value=map.get(key);
            System.out.println(key+"___"+value);
        }*/
        request.setAttribute("map",map);
        request.setAttribute("mapnum",mapnum);
        request.getRequestDispatcher("/jsp/tiezidetail.jsp").forward(request,response);
    }




   @RequestMapping("/tiaojian.action")
   public void tiaojian(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String tiaojian = request.getParameter("tiaojian");
       String tid = request.getParameter("tid");
       int tid1 = Integer.parseInt(tid);
        if("tuijian".equals(tiaojian)){
            List<ForumTopic> topicList=luntanService.getAllTopics();
            List<ForumTopic> topicList1 = new ArrayList<>();
            for(int i=0;i<topicList.size()-1;i++){
                topicList1.add(topicList.get(i));
            }
            request.setAttribute("topicList1",topicList1);
            Map<String ,Object> cmap=new HashMap<>();

            //每页显示的条数
            int pageSize=7;
            //当前的页面默认是首页
            int curPage=1;
            String scurPage=request.getParameter("curPage");
            if (scurPage!=null&&!scurPage.trim().equals("")){

                curPage=Integer.parseInt(scurPage);
            }
            cmap.put("curPage",curPage);
            cmap.put("pageSize",pageSize);
            cmap.put("tid",tid1) ;
            PageInfo<ForumPost> pageInfo= postService.selectPostsByVisit(cmap);
            request.setAttribute("pageInfo",pageInfo);
            String tname = luntanService.selectTnameBuTid(tid1);
            request.setAttribute("tname",tname);
            request.setAttribute("userlist",userService.selectUsersByTitleId());

            request.getRequestDispatcher("/jsp/luntan.jsp").forward(request,response);
       }else if("zuixin".equals(tiaojian)){
            List<ForumTopic> topicList=luntanService.getAllTopics();
            List<ForumTopic> topicList1 = new ArrayList<>();
            for(int i=0;i<topicList.size()-1;i++){
                topicList1.add(topicList.get(i));
            }
            request.setAttribute("topicList1",topicList1);
            Map<String ,Object> cmap=new HashMap<>();

            //每页显示的条数
            int pageSize=7;
            //当前的页面默认是首页
            int curPage=1;
            String scurPage=request.getParameter("curPage");
            if (scurPage!=null&&!scurPage.trim().equals("")){

                curPage=Integer.parseInt(scurPage);
            }
            cmap.put("curPage",curPage);
            cmap.put("pageSize",pageSize);
            cmap.put("tid",tid1) ;
            PageInfo<ForumPost> pageInfo= postService.selectPostsByCreatetime(cmap);
            request.setAttribute("pageInfo",pageInfo);
            String tname = luntanService.selectTnameBuTid(tid1);
            request.setAttribute("tname",tname);
            request.setAttribute("userlist",userService.selectUsersByTitleId());

            request.getRequestDispatcher("/jsp/luntan.jsp").forward(request,response);
       }
   }

   @RequestMapping("/shoucang.action")
   public  void shoucang(HttpServletRequest request,HttpServletResponse response) throws IOException {
       String uid =request.getParameter("uid");
       String pid =request.getParameter("pid");

       int uidd = Integer.parseInt(uid);
       int pidd = Integer.parseInt(pid);
       PrintWriter out = response.getWriter();

       if(luntanService.selectIfCollection(uidd,pidd)==null){
           if(luntanService.addCollectionByUidAndPid(uidd,pidd)){
               out.print(1);
           }else {
               out.print(0);

           }
       }else{
           out.print(2);
       }

   }
    @RequestMapping("/quxiaoshoucang.action")
    public  void quxiaoshoucang(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uid =request.getParameter("uid");
        String pid =request.getParameter("pid");
        int uidd = Integer.parseInt(uid);
        int pidd = Integer.parseInt(pid);
        luntanService.updatePostVisitNumSub(pidd);
        PrintWriter out = response.getWriter();
        if(luntanService.deleteCollectionByUidAndPid(uidd,pidd)){
            out.print(1);
        }else {
            out.print(0);

        }
    }

   @RequestMapping("/dianzan.action")
   public  void dianzan(HttpServletRequest request,HttpServletResponse response) throws IOException {
       String uid =request.getParameter("uid");
       String pid =request.getParameter("pid");
       int uidd = Integer.parseInt(uid);
       int pidd = Integer.parseInt(pid);
       luntanService.updatePostLikeNumByPid(pidd);
       PrintWriter out = response.getWriter();
       if(luntanService.addLikeByUidAndPid(uidd,pidd)){
           out.print(1);
       }else{
           out.print(0);

       }
   }
    @RequestMapping("/quxiaodianzan.action")
    public  void quxiaodianzan(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uid =request.getParameter("uid");
        String pid =request.getParameter("pid");

        int uidd = Integer.parseInt(uid);
        int pidd = Integer.parseInt(pid);
        luntanService.updatePostLikeNumByPidSub(pidd);
        PrintWriter out = response.getWriter();
        if(luntanService.deleteLikeByUidAndPid(uidd,pidd)){
            out.print(1);
        }else{
            out.print(0);

        }
    }


    @RequestMapping("/postreport.action")
    public void postreport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uid =request.getParameter("uid");
        String pid =request.getParameter("pid");
        String reportreason = request.getParameter("reportreason");
        int uidd = Integer.parseInt(uid);
        int pidd = Integer.parseInt(pid);
        ForumPostreport forumPostreport = new ForumPostreport(uidd,pidd,reportreason);
        PrintWriter out = response.getWriter();
        if(luntanService.addPostReport(forumPostreport)){
            out.print(1);
        }else{
            out.print(0);

        }

    }

    @RequestMapping("/postcomment.action")
    public void postcomment(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uid =request.getParameter("uid");
        String pid =request.getParameter("pid");
        int uidd = Integer.parseInt(uid);
        int pidd = Integer.parseInt(pid);
        String postcomment = request.getParameter("postcomment");
        ForumComment forumComment = new ForumComment(uidd,pidd,postcomment);
        PrintWriter out = response.getWriter();
        if(luntanService.addForumComment(forumComment)){
            articleService.fapinglunjialiangfen(uidd);
            out.print(1);
        }else{
            out.print(0);

        }
    }

    @RequestMapping("/commentreport.action")
    public void commentjubao(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uid =request.getParameter("uid");
        String cid =request.getParameter("cid");
        int uidd = Integer.parseInt(uid);
        int cidd = Integer.parseInt(cid);
        String reason = request.getParameter("reason");
        ForumCommentreport forumCommentreport = new ForumCommentreport(uidd,cidd,reason);
        PrintWriter out = response.getWriter();

        if(luntanService.addCommentReport(forumCommentreport)){
            out.print(1);
        }else{
            out.print(0);

        }
    }
    @RequestMapping("/commentcomment.action")
    public void commentcomment(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uid =request.getParameter("uid");
        String pid =request.getParameter("pid");
        String ccid =request.getParameter("ciddd");
        int uidd = Integer.parseInt(uid);
        int pidd = Integer.parseInt(pid);
        int ccidd = Integer.parseInt(ccid);
        String commentcomment = request.getParameter("commentcomment");
        ForumComment forumComment = new ForumComment(uidd,pidd,ccidd,commentcomment);
        PrintWriter out = response.getWriter();

       if(luntanService.addCommentForComment(forumComment)){
           articleService.fapinglunjialiangfen(uidd);
           System.out.println("发评论加五分"+uidd);
            out.print(1);
        }else{
            out.print(0);

        }
    }

    @RequestMapping("/focus.action")
    public void focus( HttpServletRequest request,HttpServletResponse response) throws IOException {
        String focusuid = request.getParameter("focusuid");
        String focusduid = request.getParameter("focusduid");
        int uid = Integer.parseInt(focusuid);
        int postuid = Integer.parseInt(focusduid);
        PrintWriter out = response.getWriter();
        if(focusService.selectFocusIfExist(uid,postuid)==null){
            if(focusService.addFocusUser(uid,postuid)){
                out.print(1);
            }else {
                out.print(0);
            }
        }else {
            out.print(2);
        }


    }
    @RequestMapping("userdetail.action")
    public void userpostdetail(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));

        List<ForumPost> postList = postService.selectPostsByUid(uid);
        request.setAttribute("userlikenum",userService.selectLikeNumByUid(uid));
        request.setAttribute("forumUser",userService.selectUserByUid(uid));
        request.setAttribute("point",userService.selectPointByUid(uid));
        request.setAttribute("postList",postList);
        request.setAttribute("focusnum",focusService.selectUserFocusNum(uid));
        request.setAttribute("focusednum",focusService.selectUserFocusedNum(uid));
        request.setAttribute("collectionnum",userService.selectCollectionNumByUid(uid));
        request.getRequestDispatcher("/jsp/userdetail.jsp").forward(request,response);
    }




}
