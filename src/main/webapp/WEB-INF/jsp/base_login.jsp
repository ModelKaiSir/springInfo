<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://springinfo.com/templ" prefix="templ" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<templ:overwrite name="headContent">
</templ:overwrite>

<templ:overwrite name="bodyContent">
    <div class="container" style="margin-top: 5px;">
        <div class="row">
            <div class="col-md-12">
                <!--navbar login-->
                <div class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">Spring</a>
                    </div>
                    <c:if test="${empty user}">
                        <form class="navbar-form navbar-left" action="<c:url value="/loginCheck"/>" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" id="userName" name="userName"
                                       placeholder="userName">
                                <input type="password" class="form-control" id="passWord" name="passWord"
                                       placeholder="passWord">
                            </div>
                            <button type="submit" class="btn btn-default">Login</button>
                            <c:if test="${!empty error}">
                                <p class="text-danger"><c:out value="${error}"></c:out></p>
                            </c:if>
                        </form>
                    </c:if>
                    <div class="navbar-right">
                        <p class="navbar-text" style="padding-right: 5px;">
                            欢迎回来，<a href="<c:url value="/info" />">${user.userName}</a>。当前积分：${user.credits}
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <templ:content name="content"></templ:content>
    </div>
</templ:overwrite>
<templ:overwrite name="scriptContent">
    <script>
        // js
    </script>
</templ:overwrite>
<jsp:include page="base.jsp"></jsp:include>