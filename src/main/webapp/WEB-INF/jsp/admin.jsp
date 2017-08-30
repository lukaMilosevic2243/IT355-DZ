<%@include file="header.jsp" %>
<div class = "container">
    <div class="wrapper text-center">
        <h1>Admin Strana!</h1>
        <h1> ${message}</h1>
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="POST"
              id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>
        <c:if test="${pageContext.request.userPrincipal.name !=
                      null}">
              <h2>
                  Username je :
                  ${pageContext.request.userPrincipal.name} | <a
                      href="javascript:formSubmit()"> Izloguj se</a>
              </h2>
        </c:if>
    </div>
</div>

<%@include file="footer.jsp" %>