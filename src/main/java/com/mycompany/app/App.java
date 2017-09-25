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
    static int count =0;
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
          java.util.ArrayList<String> inputListString = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
	    inputListString.add(sc1.nextLine().replaceAll("\\s",""));
          }
	  String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input1);
          java.util.ArrayList<String> inputListString2 = new java.util.ArrayList<>();
	while (sc2.hasNext())
          {
	    inputListString2.add(sc2.nextLine().replaceAll("\\s",""));
          }

          MergeSort(inputListString,inputListString2,count);


         Map map = new HashMap();
	  if(count == 0) map.put("result","Bulunamadı");
	  else map.put("result",count+" tane bulundu");
	  
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

     public static boolean MergeSort(ArrayList<String> A, ArrayList<String> B, int count){
	//if(A.size()==0 || B.size()==0) return false;
	for(int i = 0; i < A.size();i++){
		if(A.get(i)==B.get(0))	count++;
	}
	return true;
     }
}

