package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean search(ArrayList<Integer> array, int e) {
      System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array) {
        if (elt == e) return true;
      }
      return false;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
          MergeSort(inputList,0,inputList.size()-1);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          boolean result = App.search(inputList, input2AsInt);

         Map map = new HashMap();
         Map map = new HashMap();
	  for(int i = 0; i < inputList.size(); i++){
			if(i<inputList.size()-1){
				//hepsi = String.valueof(inputList.get(i)) + ", ";
				map.put("result", inputList);
			}
			else{
				//hepsi = String.valueof(inputList.get(i));
				map.put("result", inputList);
			}
	  }
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

     public static void MergeSort(ArrayList<Integer> A, int p, int r){
		//p = starting position
		//r = end position
		
		
		// A = [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
		//      ^                          ^
		//      |                          |
		//      P <-----Sorted Place-----> R ( You have to choose which item do you want to sort)
		if(p<r){
			int m=(p+r)/2;
			MergeSort(A,p,m);
			MergeSort(A,m+1,r);
			Merge(A,p,m,r);
		}
	}
	
	public static void Merge(ArrayList<Integer> A, int p, int m, int r){
		int i =p;
		int j=m+1;
		int k=p;
		int temp[] = new int[A.size()];
		while(i<=m && j<=r){
			if(A.get(i)<A.get(j))
				temp[k++]=A.get(i++);
			else
				temp[k++]=A.get(j++);
		}
		while(i<=m)
			temp[k++]=A.get(i++);
		while(j<=r)
			temp[k++]=A.get(j++);
		for(int t = p; t <=r; t++)
			A.set(t, temp[t]);
	}
}

