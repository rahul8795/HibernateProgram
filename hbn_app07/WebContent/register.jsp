<%@page import="com.cts.factory.UserServiceFactory"%>
<%@page import="com.cts.service.UserService"%>
<%!
String uname;
String upwd;
String uemail;
String umobile;
UserService userService;
String status;
String message;
%>
<%
uname = request.getParameter("uname");
upwd = request.getParameter("upwd");
uemail = request.getParameter("uemail");
umobile = request.getParameter("umobile");
userService = UserServiceFactory.getUserService();
status = userService.register(uname, upwd, uemail, umobile);
//System.out.println("Staus"+status);
if(status.equals("success")){
	message = "User registration Success";
}
if(status.equals("failure")) {
	message = "User Registration Failure";
}
if(status.equals("exited")) {
	message = "User exited Already";
}
request.setAttribute("status_Meassage", message);

%>
<<jsp:forward page="status.jsp"></jsp:forward>
