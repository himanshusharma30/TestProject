package webapp.upload.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class CompressImage {
	
	public static boolean compress(String uploadpath,MultipartFile[] imgs)throws IOException
	{
		int flag=0;
		File input=null;
		String filename=null;
		for(int i=0;i<imgs.length;i++)
		{
			input=UploadFile.convert(imgs[i]);
			filename=imgs[i].getOriginalFilename();
		      try {
				BufferedImage image = ImageIO.read(input);
					File uploadDir=new File(uploadpath);
					if(!uploadDir.exists())
					{
						uploadDir.mkdir();
					}
				  String filePath=uploadpath+File.separator+filename;
				  File storeFile=new File(filePath);			
				  OutputStream os =new FileOutputStream(storeFile);
	
				  Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
				  ImageWriter writer = (ImageWriter) writers.next();
	
				  ImageOutputStream ios = ImageIO.createImageOutputStream(os);
				  writer.setOutput(ios);
	
				  ImageWriteParam param = writer.getDefaultWriteParam();
				  
				  param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				  param.setCompressionQuality(0.25f);
				  writer.write(null, new IIOImage(image, null, null), param);
				  
				  os.close();
				  ios.close();
				  writer.dispose();
				  flag++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=0;
			}
		}
		if(flag==imgs.length)
			return true;
		else return false;
	}

}
