package com.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElvisExprSample {


    /**
     *  spEl
     *   安全导航操作符
     *     obj?.field 如果obj为空调用obj.field不会报空指针 只会返回Null
     *   正则表达式操作符
     *     'str' matches 'regex'
     *   instanceof
     *      'value' instanceof T(type)
     *   Elvis操作符
     *      name != null?:'不能为空' 三元表达式简写
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //集合过滤
        ExpressionParser parser =new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        filterMap(parser,context);
        System.out.println("-------------------");
        filterList(parser,context);
        System.out.println("-------------------");
        compilerList(parser,context);
    }

    public static void filterMap(ExpressionParser parser,EvaluationContext context){
        Map<String,Integer> creditsMap = new HashMap<>();

        creditsMap.put("Tom",95);
        creditsMap.put("Tony",110);
        creditsMap.put("Morin",85);
        creditsMap.put("Mose",120);
        creditsMap.put("Morrow",60);

        context.setVariable("credits",creditsMap);

        String expression = "#credits.?[value>90]";

        Map<String,Integer> creditsGreater100 = (Map<String,Integer>) parser.parseExpression(expression).getValue(context);

        for (Map.Entry<String,Integer> er:creditsGreater100.entrySet()){
            System.out.println(er.getKey()+":"+er.getValue());
        }
    }

    /**
     * ?[expression]
     * @param parser
     * @param context
     */
    public static void filterList(ExpressionParser parser,EvaluationContext context){
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(85);
        list.add(70);
        list.add(95);
        list.add(120);
        context.setVariable("lists",list);
        String expression = "#lists.?[#this>100]";

        List<Integer> newList = (ArrayList<Integer>)parser.parseExpression(expression).getValue(context);

        for (Integer i:newList){
           System.out.println(i);
        }
    }

    /**
     *  ![expression]
     * @param parser
     * @param context
     */
    public static void compilerList(ExpressionParser parser,EvaluationContext context){
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(85);
        list.add(70);
        list.add(95);
        list.add(120);
        context.setVariable("lists",list);
        String expression = "#lists.![#this>100]";

        List<Boolean> newList = (ArrayList<Boolean>)parser.parseExpression(expression).getValue(context);

        for (Boolean i:newList){
            System.out.println(i);
        }
    }
}
