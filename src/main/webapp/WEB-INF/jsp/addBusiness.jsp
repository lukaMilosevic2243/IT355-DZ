
        <%@include file="header.jsp" %>

        <form:form method="POST" action="/BizDash/business" commandName="addBusiness">
            <div class="text-center">
                <div >
                    <h2>Informacije o biznisu</h2>
                    <table class="table">
                    <tr>
                        <td><form:label path="name">Ime biznisa</form:label></td>
                        <td><form:input path="name" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="location">Lokacija</form:label></td>
                        <td><form:input path="location" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="pib">Pib</form:label></td>
                        <td><form:input path="pib" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div> <input type="submit" value="Dodaj biznis" class="btn btn-primary"/></div>
                        </td>
                    </tr>
                </table>


                </div>
            </div>    
        </form:form>


        <%@include file="footer.jsp" %> 

