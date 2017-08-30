
        <%@include file="header.jsp" %>


        <div class="col-md-6 col-md-offset-3">

        <c:url var="post_url"  value="/addProduct/" />
        <form:form method="POST" action="${post_url}" modelAttribute="product">

            <% String success = (String) request.getAttribute("successMsg"); %>
            <%= (success != null) ? "<div class=\"alert alert-success\">"+success+"</div>" : "" %>

            <div class="form-group">
                <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
                <form:label path="name">
                    Naziv
                </form:label>
                <form:input type="name" id="name" class="form-control" placeholder="naziv" path="name" />
            </div>

            <div class="form-group">
                <form:label path="description">
                    Opis
                </form:label>
                <form:input type="description" id="description" class="form-control" placeholder="Opis" path="description" />
            </div>

            <div class="form-group">
                <form:label path="price">
                    Cena
                </form:label>
                <form:input type="price" id="price" class="form-control" placeholder="Cena" path="price" />
            </div>

            <div class="form-group">
                <form:label for="category" path="category">Kategorije</form:label>

                <form:select id="slcRole" class="form-control" path="category">
                    <form:option value="">Odaberi</form:option>
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </div>

            <button type="submit" class="btn btn-primary">Dodaj</button>
        </form:form>
        </div>
        <%@include file="footer.jsp" %> 

