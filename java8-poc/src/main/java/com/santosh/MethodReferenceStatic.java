package com.santosh;

import java.util.ArrayList;
import java.util.List;
public class MethodReferenceStatic {

	   public static void main(String args[]){
	      List<String> names = new ArrayList<String>();
			
	      names.add("Santosh");
	      names.add("Ravindra");
	      names.add("Minal");
	      names.add("Sameer");
	      names.add("Ashutosh");
			
	      names.forEach(System.out::println);
	   }
	}

// Here System.out is an instance of type PrintStream, we then call the println method of the instance.