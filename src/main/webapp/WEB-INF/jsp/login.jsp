<%@include file="header.jsp" %>
<div class="wrapper">
    <form action="<c:url value='/j_spring_security_check'/>" method="POST" name="loginForm" class="form-signin">       
        <h3 class="form-signin-heading">Login</h3>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if><br>

        <input type="text" class="form-control" name="username" placeholder="Korisnicko ime" required="" autofocus="" />
        <br>
        <input type="password" class="form-control" name="password" placeholder="Lozinka" required=""/>     		  
        <br>
        <button class="btn btn-primary"  name="submit" value="Login" type="submit">Login</button>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>			
</div>                   
<%@include file="footer.jsp" %>

