package com.learnautomation.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class TextRepositoryData {
	 Properties TextRepoProp;

		
	//Fetching XPATH
   public static Properties p;
   /**
    * Load Property File.
    *
    **/
   public static String getValue(String key)
   {
       String v="./TestData/TextRepository.properties";
       try
       {
           p=new Properties();
           p.load(new FileInputStream(v));
           v=p.getProperty(key);
       }
       catch(Exception e)
       {

       }
       return v;
	
	}
}

