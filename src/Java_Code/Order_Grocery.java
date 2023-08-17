package Java_Code;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Order_Grocery")
public class Order_Grocery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String[] selected = request.getParameterValues("select");
		String req_qty, itemName, price="",ava_qty="";
		
		try {
			HttpSession session2 = request.getSession(false);
			String userName = (String) session2.getAttribute("userName");
			String groupName = (String) session2.getAttribute("groupName");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			
			int i = 0,k=0;
			int flag = 1;
			while( i < selected.length) {
				itemName = selected[i];
				req_qty = request.getParameter(itemName+"_qty");
				//price = request.getParameter(selected[i]+"_price");
				String sql1 = "select * from "+ groupName+"_Grocery where itemName = ?";
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ps1.setString(1, itemName);
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()){
					price = rs1.getString("price");
					ava_qty = rs1.getString("qty");
				}
				
				int price1 = Integer.parseInt(price);
				int req_qty1 = Integer.parseInt(req_qty);
				int ava_qty1 = Integer.parseInt(ava_qty);
				
				int TotPrice = price1 * req_qty1;
				String Totprice = Integer.toString(TotPrice);
				
				int rem_qty = ava_qty1 - req_qty1;
				String remQty = Integer.toString(rem_qty);
				if(req_qty1 < ava_qty1) {
				String sql ="insert into " + groupName + "_GroceryOrder values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, itemName);
				ps.setString(3, req_qty );
				ps.setString(4, Totprice );
				ps.executeUpdate();
				
				String sql3="update " + groupName + "_Grocery set qty = ? where itemName = ?";
				PreparedStatement ps3= con.prepareStatement(sql3);
				ps3.setString(1, remQty);
				ps3.setString(2, itemName);
				ps3.executeUpdate();
				
				
				
				}else{
					flag = 0;
					k = i;
					//response.sendRedirect("MoreQuantity.jsp");
				}
				i = i+1;
			}
			
			if(flag == 1) {
				response.sendRedirect("GroceryOrder_Succesfull.jsp");
			} else {
				HttpSession session1 = request.getSession();
				session1.setAttribute("overItem", selected[k]);
				
				response.sendRedirect("MoreQuantity.jsp");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
