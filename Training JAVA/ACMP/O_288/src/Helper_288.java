
public class Helper_288 {

	public static int FindhAVEkOMENTARII_bEGAN(char charAt, char charAt2) {
if(charAt=='/')
	if(charAt2=='/')
		return 0;

   if(charAt=='{')		
	  return 1;
   
   if(charAt=='(')
		if(charAt2=='*') 
			return 2;
   
  String s=	charAt+"";
  if(s.equals("'"))
	  return 4;
   
   
		return 3;
	}


		
	

}
