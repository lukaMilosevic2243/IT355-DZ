
<%@include file="header.jsp" %>
<div id="box">
    <h2>Podaci o biznisu</h2>
    <table class="table">
        <tr>
            <td>Ime</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>Lokacija</td>
            <td>${location}</td>
        </tr>
        <tr>
            <td>Pib</td>
            <td>${pib}</td>
        </tr>
    </table>
</div>
<%@include file="footer.jsp" %> 