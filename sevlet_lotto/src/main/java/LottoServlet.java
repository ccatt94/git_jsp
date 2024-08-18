
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.lotto.Lotto;

@WebServlet("/lottoResult")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LottoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int num1 = Integer.valueOf(request.getParameter("num1"));
		int num2 = Integer.valueOf(request.getParameter("num2"));
		int num3 = Integer.valueOf(request.getParameter("num3"));
		int num4 = Integer.valueOf(request.getParameter("num4"));
		int num5 = Integer.valueOf(request.getParameter("num5"));
		int num6 = Integer.valueOf(request.getParameter("num6"));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		Set<Integer> userLotto = new HashSet<>();
		Set<Integer> comLotto = new HashSet<>();
		Set<Integer> sameLotto = new HashSet<>();
		Set<Integer> differLotto = new HashSet<>();

		userLotto.add(num1);
		userLotto.add(num2);
		userLotto.add(num3);
		userLotto.add(num4);
		userLotto.add(num5);
		userLotto.add(num6);

		while (comLotto.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			comLotto.add(num);
		}

		differLotto.addAll(comLotto);

		for (Integer userNum : userLotto) {

			if (comLotto.contains(userNum)) {
				sameLotto.add(userNum);
				differLotto.remove(userNum);
			}

		}

		out.print("<html>");
		out.print("<body>");

		out.print("입력한 로또 번호 : " + userLotto + "<br>");
		out.print("랜덤 로또 번호 : " + comLotto.toString() + "<br>");
		out.print("맞은 번호 : " + sameLotto + "<br>");
		out.print("틀린 번호 : " + differLotto + "<br>");

		out.print("</body>");
		out.print("</html>");

	}

}
