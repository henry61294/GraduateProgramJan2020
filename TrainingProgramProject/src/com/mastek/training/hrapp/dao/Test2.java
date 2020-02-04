package com.mastek.training.hrapp.dao;

public class Test2{
	  
	  public static void main(String as[]){
	    System.out.println("value ="+switchIt(5));
	    //System.out.println("Value= "+switchIt(1));

	  }
	  
	  public static int switchIt(int x){
	    int j=1;
	    switch(x){
	      case 1:j++; System.out.println("J =" + j);System.out.println(x);
	      case 2:j++;System.out.println("J =" + j);System.out.println(x);
	      case 3:j++;System.out.println("J =" + j);System.out.println(x);
	      case 4:j++;System.out.println("J =" + j);System.out.println(x);
	      case 5:j++;System.out.println("J =" + j);System.out.println(x);
	      default:j++;System.out.println("J =" + j);System.out.println(x);
	    }
	    return j+x;
	  }
	  
	}
