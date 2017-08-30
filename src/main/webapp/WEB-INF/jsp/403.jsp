<%@include file="header.jsp" %>
    <div class="wrapper">
        <c:choose>
            <c:when test="${empty username}">
                <h1><a href="/BizDash/login">Login</a></h1>
            </c:when>
            <c:otherwise>
                <h1>${username} <br/>, nemate pristup ovoj strani!</h1>
                </c:otherwise>
            </c:choose>
    </div>
<%@include file="footer.jsp" %>

