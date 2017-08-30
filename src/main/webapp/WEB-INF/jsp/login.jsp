<%@include file="header.jsp" %>
<div class="wrapper">
    <form action="<c:url value='/j_spring_security_check'/>" method="POST" name="loginForm" class="form-signin">    
        <h3 class="form-signin-heading">Dobrodosli</h3>

        <input type="hidden" name="_eventId" value="performLogin">
        <input type="hidden" name="_flowExecutionKey" value="" />
        <br>
        <input type="text" class="form-control" name="username" placeholder="Korisnicko ime" required="" autofocus="" />
        <br>
        <input type="password" class="form-control" name="password" placeholder="Lozinka" required=""/>     		  
        <br>
        <button class="btn btn-primary"  name="submit" value="Login" type="submit">Uloguj se</button>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>				
</div>                   
<%@include file="footer.jsp" %>

