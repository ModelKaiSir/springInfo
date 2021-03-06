package com.spring.spel;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptSample {

    public static void main(String[] args) throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String script = "function sum(a,b){return a+b}";
        engine.eval(script);
        Invocable invocable = (Invocable) engine;

        Object result = invocable.invokeFunction("sum",100,23);

        System.out.println(result);

    }
}
