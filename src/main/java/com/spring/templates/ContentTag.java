package com.spring.templates;

import com.spring.utils.JavaUtil;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class ContentTag extends BodyTagSupport {

    private String name;

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        ServletRequest request = pageContext.getRequest();
        String defaultContent = JavaUtil.getStr(getBodyContent());
        try {
            String bodyContent = JavaUtil.getStr(request.getAttribute(OverwriteTag.PREFIX+name));
            if(JavaUtil.StrUtil.isEmpty(bodyContent)){
                pageContext.getOut().write(defaultContent);
            }else{
                pageContext.getOut().write(bodyContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.doEndTag();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
