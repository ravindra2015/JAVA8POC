package com.santosh;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

	public class ReferenceToInstanceMethodOAPO {
		 
	    /**
	     * @param args the command line arguments
	     */
	 
	 
	    public static void main(String[] args) {
	        // TODO code application logic here
	        List<String> names = new ArrayList<String>();
	            names.add("David");
	            names.add("Richard");
	            names.add("Samuel");
	            names.add("Rose");
	            names.add("John");
	 
	           ReferenceToInstanceMethodOAPO.printNames(names,System.out::println);
	    }
	 
	 
	    private static void printNames(List<String> list, Consumer<String> c ){
	        list.forEach(x -> c.accept(x));
	    }
	}
