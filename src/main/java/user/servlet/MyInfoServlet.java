package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.vo.UserVO;

public class MyInfoServlet extends HttpServlet {
	public MyInfoServlet() {
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");

		UserVO userVO = new UserVO();
		UserDAO userDAO = new UserDAO();

		userVO = userDAO.getUserInfo(name);

		if (Objects.nonNull(userVO)) {
			out.println(String.format("<!DOCTYPE html>\r\n"
					+ "\r\n"
					+ "<html lang=\"ko\">\r\n"
					+ "<head>\r\n"
					+ "<title>내 정보 보기</title>\r\n"
					+ "<meta charset=\"EUC-KR\">\r\n"
					+ "</head>\r\n"
					+ "<style>\r\n"
					+ "* {\r\n"
					+ "	box-sizing: border-box;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form-body {\r\n"
					+ "	width: 1000px;\r\n"
					+ "	margin: auto;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form {\r\n"
					+ "	width: 1000px;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form table {\r\n"
					+ "	width: 100%%;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".star {\r\n"
					+ "	color: #c21818;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form table, .form th, .form td {\r\n"
					+ "	border: 1px solid #ccc;\r\n"
					+ "	border-collapse: collapse;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".d-flex {\r\n"
					+ "	display: flex;\r\n"
					+ "	align-items: center;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form th {\r\n"
					+ "	width: 200px;\r\n"
					+ "	height: 40px;\r\n"
					+ "	padding: 5px;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".space-between {\r\n"
					+ "	justify-content: space-between;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".margin5px {\r\n"
					+ "	margin-left: 5px;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "</style>\r\n"
					+ "<body>\r\n"
					+ "	<div class=\"form-body\">\r\n"
					+ "		<div class=\"d-flex space-between\">\r\n"
					+ "			<h2>내 정보 보기</h2>\r\n"
					+ "		</div>\r\n"
					+ "		<form class=\"form\" action=\"/register\" method=\"POST\">\r\n"
					+ "			<table>\r\n"
					+ "				<tbody>\r\n"
					+ "					<tr>\r\n"
					+ "						<th><label for=\"name-form\"> <span class=\"star\">*</span>\r\n"
					+ "								이름\r\n"
					+ "						</label></th>\r\n"
					+ "						<td colspan=\"3\"><span class=\"margin5px\">%s</span></td>\r\n"
					+ "					</tr>\r\n"
					+ "					<tr>\r\n"
					+ "						<th><label for=\"gender-male\"> <span class=\"star\">*</span>\r\n"
					+ "								성별\r\n"
					+ "						</label></th>\r\n"
					+ "						<td colspan=\"3\"><span class=\"margin5px\">%s</span></td>\r\n"
					+ "					</tr>\r\n"
					+ "					<tr>\r\n"
					+ "						<th><label for=\"year-input\" class=\"form-label\"><span\r\n"
					+ "								class=\"star\">*</span> 생년월일</label></th>\r\n"
					+ "						<td colspan=\"3\">\r\n"
					+ "							<div class=\"d-flex\">\r\n"
					+ "								<span class=\"margin5px\">%s</span> 일\r\n"
					+ "							</div>\r\n"
					+ "						</td>\r\n"
					+ "					</tr>\r\n"
					+ "					<tr>\r\n"
					+ "						<th><label for=\"job-select\" class=\"form-label\"><span\r\n"
					+ "								class=\"star\">*</span> 직업</label></th>\r\n"
					+ "						<td><span class=\"margin5px\">%s</span></td>\r\n"
					+ "					</tr>\r\n"
					+ "					<tr>\r\n"
					+ "						<th rowspan=\"2\"><label for=\"tel1\"><span class=\"star\">*</span>\r\n"
					+ "								연락처</label></th>\r\n"
					+ "					</tr>\r\n"
					+ "					<tr>\r\n"
					+ "						<td>\r\n"
					+ "							<div class=\"margin5px\">\r\n"
					+ "								 <span>%s</span>\r\n"
					+ "							</div>\r\n"
					+ "						</td>\r\n"
					+ "					</tr>\r\n"
					+ "					<tr>\r\n"
					+ "						<th><label for=\"addr-input\"><span class=\"star\">*</span>거주지\r\n"
					+ "								주소</label></th>\r\n"
					+ "						<td colspan=\"3\">\r\n"
					+ "							<div class=\"margin5px\">\r\n"
					+ "								<span>%s</span>\r\n"
					+ "							</div>\r\n"
					+ "						</td>\r\n"
					+ "					</tr>\r\n"
					+ "				</tbody>\r\n"
					+ "			</table>\r\n"
					+ "			<div class=\"d-flex\" style=\"justify-content: center; margin-top: 30px\">\r\n"
					+ "				<a href='/search-info'>사용자 정보 조회하기로 돌아가기</a>\r\n"
					+ "			</div>\r\n"
					+ "		</form>\r\n"
					+ "\r\n"
					+ "	</div>\r\n"
					+ "</body>\r\n"
					+ "</html>", userVO.getName(), userVO.getGender(), userVO.getBirthDateString(), userVO.getJob(), userVO.getMobile(), userVO.getAddress()));
		} else {
			out.println("<html><head></head><body><h2>그런 이름은 없습니다.</h2>");
			out.println("<a href = '/search-info'>내 정보 찾기 화면으로 이동</a>");
			out.println("</body></html>");
		}
	}

}
