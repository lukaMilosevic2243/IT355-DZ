
        <%@include file="header.jsp" %>

<h1 class="text-center">Dodaj kategoriju</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addCategory" value="/addCategory" ></c:url>
        <form:form method="POST" modelAttribute="category">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:input type="name" class="form-control" id="name" placeholder="Naziv" path="name" />
            </div>
            <button type="submit" class="btn btn-primary">Dodaj</button>
        </form:form>
    </div></div>
<%@include file="footer.jsp" %>