import dao.UserinfoDao;
import model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addUser",urlPatterns = "/addUser")
public class addUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //从页面获取文本框数据
        Integer uid=Integer.valueOf( request.getParameter("userId"));
        String uname=request.getParameter("userName");
        String upwd=request.getParameter("userPwd");
        Integer urole=Integer.valueOf(request.getParameter("userRole"));
        boolean ustatus=Boolean.valueOf( request.getParameter("userStatus"));


        UserInfo user=new UserInfo();
        user.setUserId(uid);user.setUserName(uname);
        user.setPassword(upwd);user.setRole(urole);
        user.setStatus(ustatus);
        response.getWriter().println(user);
        //调试时实在不行关闭一下
        System.out.println(user);

        UserinfoDao dao=new UserinfoDao();
        int n= dao.addUserinfo(user);
        if(n>0)
            response.sendRedirect("././userinfo.jsp");//请注意javaWeb加了_web ,也可以用相对路径，回到上一级
        else
            response.sendRedirect("/javaWeb_web/error.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
