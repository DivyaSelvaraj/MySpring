package spring;

import java.io.IOException;
import javax.jdo.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spring.PMF;
import javax.jdo.PersistenceManager;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

@Controller
public class SpringsServlet 
{
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
@RequestMapping (value="/springs")
	public String first(HttpServletRequest req, HttpServletResponse resp)throws IOException 
	{ 
	return "login"; 
	}
@RequestMapping (value="/logging" , method=RequestMethod.GET)
	public String login1(HttpServletRequest req, HttpServletResponse resp)throws IOException 
	{
	String email = req.getParameter("emailId");
	String passwords = req.getParameter("password");
	PersistenceManager pm = PMF.get().getPersistenceManager();
	req.setAttribute("UserName", email);
    Query query1 = pm.newQuery(SpringDB.class, "emailId == email");
    query1.declareParameters("String email");
    ArrayList<String> op =new ArrayList<String>();
	List<SpringDB> results = (List<SpringDB>) query1.execute(email);
    if(results.iterator().hasNext())
    
    	for(SpringDB db : results )
    	{
    	System.out.println(db.getEmailId()+"123113");
    	System.out.println(email+"123113");
    	System.out.println(db.getPassword()+"123113");
    	System.out.println(passwords+"123113");
    	System.out.println("Hello "+ db.getBlobKey());
		  	
    		if(db.getEmailId().equalsIgnoreCase(email) && db.getPassword().equals(passwords))
    		{
    			System.out.println("Hi welcome");
    			ImagesService image = ImagesServiceFactory.getImagesService();
    			String imageUrl = image.getServingUrl(db.getBlobKey(),250,false);
    			System.out.println("Print "+ image);
      		  	req.setAttribute("imageUrl", imageUrl);	
    			req.setAttribute("UserName", db.getFirstName());
    			return "yourpage";
    		}    
    		else
    		{
       			return "failslogin";
    		}
    	}			
    		return "doregister";
    
    	}
	

@RequestMapping (value="/register" , method=RequestMethod.GET)
	public String register(HttpServletRequest req, HttpServletResponse resp)throws IOException 
	{
	
		return "register";
	}
@RequestMapping (value="/registration" , method=RequestMethod.POST)
	public String registration(HttpServletRequest req, HttpServletResponse resp)throws IOException 
	{
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String emailId = req.getParameter("emailId");
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
		BlobKey blobKey = blobs.get("myFile");
		System.out.println(blobKey);
		PersistenceManager pm = PMF.get().getPersistenceManager();
			try 
				{
				
				SpringDB db2=new SpringDB(firstName, lastName, emailId,password, password1, blobKey);
				db2.setFirstName(firstName);
				db2.setLastName(lastName);
				db2.setEmailId(emailId);
				db2.setPassword(password);
				db2.setPassword1(password1);
				db2.setBlobKey(blobKey);
				pm.makePersistent(db2);
				
		    	return "successregis";				}
			finally 
			{
				pm.close();
			}
	}
	}
