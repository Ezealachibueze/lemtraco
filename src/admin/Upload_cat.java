package admin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.paypal.api.payments.Measurement;

import lemtraco02.*;

@ManagedBean
@SessionScoped
public class Upload_cat {

	 Server_Request server_Request =new Server_Request();
	  UploadedFile  file;
	  String w1="",w2="",w4="";
		
	  
	  
	public String getW1() {
		return w1;
	}

	public void setW1(String w1) {
		this.w1 = w1;
	}

	public String getW2() {
		return w2;
	}

	public void setW2(String w2) {
		this.w2 = w2;
	}



	public String getW4() {
		return w4;
	}

	public void setW4(String w4) {
		this.w4 = w4;
	}

	
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	
	
	public void send_in() {
		
		
		//System.out.println(w1+w2+w4);
		
		
		
		InputStream by=null;
		if(file.getSize()==0)
			message("Pls select a Pics");
			else
				if(w1.trim().length()>0 &&w2.trim().length()>0){
				try {
					 by = file.getInputstream();
					} catch (IOException e) {
						System.out.println(e);
					}
					ObjectMetadata  meta=new ObjectMetadata();
					meta.setContentType(file.getContentType());
					meta.setContentLength(file.getSize());
						  String n1 =name_gen();
						 int x= 	server_Request.put_in(w1,Integer.parseInt(w2),n1);
							  server_Request.Upload_file(Creden.bucket, n1,by, meta); //aws
							  if(x==200)
								message("Upload Successfully ");
							  else
								  message("Error Occured ! ");
							     	w1=""; w2="";
									}
										else
											message("Pls fill out all fields");
	}
	
	
	
	
			public String disables() {
				FacesContext  context=FacesContext.getCurrentInstance();
				String xc=context.getExternalContext().getRequestParameterMap().get("dis");
			    int c=	server_Request.disables_user_account(xc);  
			    
			    if(c==200)
			    	message("Account Disabled");
			    else
			    	message("Error Occured Pls try again");
		
			return  null;}
			
			
			public String enables() {
				FacesContext  context=FacesContext.getCurrentInstance();
				String xc=context.getExternalContext().getRequestParameterMap().get("ens");
			    int c=	server_Request.enables_user_account(xc);  
			    
			    if(c==200)
			    	message("Account Enabled");
			    else
			    	message("Error Occured Pls try again");
		
			return  null;}

	
	
	private String name_gen() {
	  String  l =String.valueOf(System.nanoTime());
	  String  w =String.valueOf(System.currentTimeMillis());
	  String e =l.concat(w).concat(".png");
	  return  e;
	}
	



	public void message(String h) {
		   RequestContext  context=RequestContext.getCurrentInstance();
		   context.execute(" swal('"+h+"')");	
	}
	
	
	
//	private byte[] read_pic() {
//	
//	FileOutputStream  outputStream=null;
//	try {
//		
//		 outputStream =new FileOutputStream("");
//		
//		try {
//			outputStream.write((int)file.getInputstream().transferTo(outputStream));
//			outputStream.close();
//		} catch (IOException e) {
//		System.out.println(e);
//		}
//		
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//		}
//	return outputStream;
//}
}
