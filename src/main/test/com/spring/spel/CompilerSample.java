package com.spring.spel;

import com.spring.domain.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class CompilerSample {

    public static void main(String[] args) {

        User user = new User();

        SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,CompilerSample.class.getClassLoader());

        SpelExpressionParser parser = new SpelExpressionParser(configuration);

        EvaluationContext context = new StandardEvaluationContext(user);

        String expression = "isVipMember('Tom') && isVipMember('QiuKai')";

        SpelExpression spelExpression = parser.parseRaw(expression);

        System.out.println(spelExpression.getValue(context));

        System.out.println(spelExpression.getValue(context));

    }
}
