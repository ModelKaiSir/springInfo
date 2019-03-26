package com.spring.templates;

import com.spring.utils.JavaUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class OverwriteTag extends BodyTagSupport {

    public static final String PREFIX = "JspTemplateBlockName_";

    private String name;

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        ServletRequest request = pageContext.getRequest();
        //标签内容
        BodyContent bodyContent = getBodyContent();
        if(JavaUtil.StrUtil.isEmpty(bodyContent)){
        }else{
            request.setAttribute(PREFIX + name, StringUtils.trim(bodyContent.getString()));
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
