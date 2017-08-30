
<%@include file="header.jsp" %>
<c:if test="${!empty products}">

    <div class="container">

        <table class="table table-striped"> 
            <thead>
                <tr>
                    <th>Naziv</th>
                    <th>Opis</th>
                    <th>Cena</th>
                    <th>Kategorija</th>
                    <th>Izmeni</th>
                    <th>Obrisi</th>
                </tr>
            </thead>
            <tbody> 
                <c:forEach items="${products}" var="product">

                    <tr>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.category}</td>
                        <td><a href="<c:url value='/editProduct/${product.id}' />"><span class="glyphicon glyphicon-pencil"></span> Izmeni </a></td>
                        <td><a href="<c:url value='/deleteProduct/${product.id}' />"><span class="glyphicon glyphicon-remove"></span> Obrisi </a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</c:if>
<%@include file="footer.jsp" %>