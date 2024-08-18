package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.vo.UserVO;

public class RegisterServlet extends HttpServlet {
	
	public RegisterServlet() {
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/register.html").forward(request, response);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		UserVO userVO = new UserVO();
		
		userVO.setName(req.getParameter("name"));
		userVO.setGender(req.getParameter("gender"));
		userVO.setBirthDate(req.getParameter("birth-year"), req.getParameter("birth-month"), req.getParameter("birth-day"));
		userVO.setJob(req.getParameter("job"));
		userVO.setMobile(req.getParameter("first-pho-num"), req.getParameter("mid-pho-num"), req.getParameter("last-pho-num"));
		userVO.setAddress(req.getParameter("address"));
		userVO.setId(req.getParameter("id"));
		userVO.setPw(req.getParameter("pw"));
		
		if (userVO.checkValidation()) {
			UserDAO userDAO = new UserDAO();
			userDAO.adduser(userVO);
			out.println(String.format("<html><head></head><body><h2>%s�� ȸ�� ������ �Ϸ�Ǿ����ϴ�</h2>", userVO.getName()));
			out.println("�̸�<input></input>");
			out.println("</body></html>"); 
		} else {
			out.println("<html><head></head><body><h2>�ۼ����� ���� ������ �־� ȸ�������� �Ϸ���� �ʾҽ��ϴ�.</h2>");
			out.println("<h5>���̵�, ��й�ȣ, �̸�, ����, �������, ����, �ڵ��� ��ȣ, �ּҴ� �ʼ� ���Դϴ�.</h5>");
			out.println("<a href='/register'>ȸ������ �ٷΰ���</a>");
			out.println("</body></html>");
		}
	}
}
