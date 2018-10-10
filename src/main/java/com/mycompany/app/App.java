package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.core.appender.ConsoleAppender;
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

    public static void SumArrayLists(ArrayList<Integer> array, int e, ArrayList<Integer> array2, int e2, ArrayList<Integer> arraySum, int summation) {
        System.out.println("inside search");
        if (array == null || array2 == null){
            System.out.println("Empty ArrayList Detected !!");
        }
        summation = e+e2;

        //filling the sum array with sum of our two arrays
        for (int i = 0; i < array.size(); i++) {
            arraySum.add(array.get(i) + array2.get(i));
        }
    }



    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);

            //New in project
            String input3 = req.queryParams("input3");
            java.util.Scanner sc3 = new java.util.Scanner(input3);

            sc1.useDelimiter("[;\r\n]+");

            //New in project
            sc3.useDelimiter("[;\r\n]+");

            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();

            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc1.hasNext()&& sc3.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));

                int value2 = Integer.parseInt(sc3.next().replaceAll("\\s",""));

                inputList.add(value);

                inputList2.add(value2);
            }
            System.out.println(inputList);
            System.out.println(inputList2);


            String input2 = req.queryParams("input2").replaceAll("\\s","");
            int input2AsInt = Integer.parseInt(input2);

            //New in project

            String input4 = req.queryParams("input4").replaceAll("\\s","");
            int input4AsInt = Integer.parseInt(input4);

            java.util.ArrayList<Integer> sumArray = new java.util.ArrayList<>();

            int sumNumbers = 0;

            SumArrayLists(inputList,input2AsInt,inputList2,input4AsInt, sumArray, sumNumbers);

            boolean result = App.search(sumArray, sumNumbers);

            boolean result2 = App.search(inputList2, input4AsInt);

            Map map = new HashMap();
            map.put("result", result);
            map.put("result2", result2);


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
}
