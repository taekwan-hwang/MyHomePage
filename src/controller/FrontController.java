package controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * Servlet implementation class FrontController
 */

@WebServlet(
		urlPatterns={"/"},
		initParams={@WebInitParam(name="contextPath", value="/config/"), @WebInitParam(name="contextFilename", value="action.xml")}
	)
public class FrontController extends HttpServlet {
	
	private Map<String, Map<String, String>> actionMap = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String contextPath = config.getInitParameter("contextPath");
		String contextFilename = config.getInitParameter("contextFilename");
		
		//웹상경로 -> file system상의 경로(절대경로)
		String absPath = config.getServletContext().getRealPath(contextPath);
		
		File actionXml=new File(absPath, contextFilename);
		try{
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(actionXml);
			Element actions = doc.getRootElement();
			
			List<Element> actionList= actions.getChildren("action");
			for(Element action:actionList){
				String path = action.getAttributeValue("path");
				String className = action.getAttributeValue("className");
				String methodName = action.getAttributeValue("methodName");
				
				if(methodName==null){
					methodName="execute";
				}
				
				Element result=action.getChild("result");
				String resultType = result.getAttributeValue("type");
				
				if(resultType==null){
					resultType="dispatcher";
				}
				
				String resultPage=result.getText();
				
				Map<String, String> map = new HashMap<>();
				map.put("className", className);
				map.put("methodName",methodName);
				map.put("resultType", resultType);
				map.put("resultPage", resultPage);
				
				actionMap.put(path, map);
			}
		}catch(Exception e){e.printStackTrace();}
		System.out.println("init complete");
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		System.out.println(uri);
		int idx = uri.indexOf("/", 1);
		//String path=uri.substring(idx);
		String path = uri;
		Map <String ,String> map = actionMap.get(path);
		if(map==null){
			response.sendError(404);
			return;
		}
		
		String className = map.get("className");
		String methodName = map.get("methodName");
		String resultType = map.get("resultType");
		String resultPage = map.get("resultPage");
		
		try{//동적 클래스 선언
			Class c = Class.forName(className);
			
			//동적 instance 생성
			Object obj = c.newInstance();
			
			//동적 method 선언
			Method method = c.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			//동적 method 호출
			String result = (String)method.invoke(obj, request, response);
			
			if(result.equals("success")){
				if(resultType.equals("dispatcher")){
					RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
					dispatcher.include(request, response);
					dispatcher.forward(request, response);
				}else{
					response.sendRedirect(resultPage);
				}
			}else if(result==null){
				response.sendError(500);
			}else{
				if(resultType.equals("dispatcher")){
					request.getRequestDispatcher(result).forward(request, response);;
				}else{
					response.sendRedirect(result);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}