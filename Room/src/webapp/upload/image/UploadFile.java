package webapp.upload.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public  class UploadFile {
	public static File convert(MultipartFile file)
	{    
	    File convFile=null;
		try {
			convFile = new File(file.getOriginalFilename());
			convFile.createNewFile(); 
			FileOutputStream fos = new FileOutputStream(convFile); 
			fos.write(file.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    return convFile;
	}
	public static boolean upload(String upldpath,MultipartFile[] imgs)
	{
		File fs;
		String filename=null;
		int flag=0;
		for(int i=0;i<imgs.length;i++)
		{
			fs=convert(imgs[i]);
			filename=imgs[i].getOriginalFilename();
			try {
				File upl=new File(upldpath);
				if(!upl.exists())
					upl.mkdirs();
				InputStream is = new FileInputStream(fs);
			    OutputStream os = new FileOutputStream(upldpath+filename);
			    int c;
			    while ((c = is.read()) != -1) {
			      os.write(c);
			    }
			    is.close();
			    os.close();
			    flag++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				flag=0;
			}
		}
		if(flag==imgs.length)
			return true;
		else return false;
	}

}
