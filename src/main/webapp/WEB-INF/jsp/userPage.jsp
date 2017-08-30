<%@include file="header.jsp" %>
<div class="wrapper text-center">
    <h1>Korisnicka Strana</h1><br>
    <h1> ${message}</h1>
    <sec:authorize access="hasRole('ROLE_USER')">
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Vase korisnicko ime je :
                ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()">Izloguj se</a>
            </h2>
        </c:if>
        
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>
    </sec:authorize>
</div>
<%@include file="footer.jsp" %>
