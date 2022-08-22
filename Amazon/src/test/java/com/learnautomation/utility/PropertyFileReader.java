/**
 * 
 */
package com.learnautomation.utility;

import java.util.Properties;

/**
 * @author Kusuma.HT
 *
 */
public class PropertyFileReader {
	
	public static ThreadLocal<Properties> ObjRepoProp = new ThreadLocal<Properties>();
	
	public static ThreadLocal<Properties> getObjRepoProp()
	{
		return ObjRepoProp;
	}

}
