<%@ page import="org.mule.example.billestore.domain.Bille,org.mule.example.billestore.service.CatalogService,
                  java.util.ArrayList,
                  java.util.Collection,
                 java.util.Iterator,
                 org.apache.cxf.jaxws.JaxWsProxyFactoryBean"%>
<%@ page language="java" %>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>On-line Billestore</title>
</head>

<body link="#FFFFFF" vlink="#FFFFFF" alink="#FFFFFF" bgcolor="#000055" text="#FFFFFF">

<%
    String field = request.getParameter("title");
    String title = field != null ? field : "";
    field = request.getParameter("author");
    String author = field != null ? field : "";
%>

<center><h3>Welcome to the Mule-powered On-line Billestore</h3></center>
<hr/>
    
<h2>Search for a bille</h2>
<form method="POST" name="submitRequest" action="">
    <table>
        <tr>
            <td>Title: </td>
            <td><input type="text" name="title" value="<%=title%>"/></td>
           </tr>
        <tr>
            <td>Author: </td>
            <td><input type="text" name="author" value="<%=author%>"/></td>
        </tr>
    </table>
    <input type="hidden" name="submitted" value="true"/>
    <input type="submit" name="submit" value="Search" />
</form>

<%
    String submitted = request.getParameter("submitted");

    if (submitted != null) 
    {
        // Invoke the CXF web service
        JaxWsProxyFactoryBean pf = new JaxWsProxyFactoryBean();
        pf.setServiceClass(CatalogService.class);
        pf.setAddress(CatalogService.URL);
        CatalogService catalog = (CatalogService) pf.create();

        Collection <Bille> billes = catalog.getBilles();
        // Something in the way CXF marshalls the response converts an empty collection to null
        if (billes == null)
        {
            billes = new ArrayList();
        }
        %>
        Your search returned the following bille(s):<br/>
        <br/>

        <table>
        <tr><th>Title</th><th>Author</th><th>Price</th><th/></tr>
        <%
        Bille bille;
        for (Iterator<Bille> i = billes.iterator(); i.hasNext();)
        {
            bille = i.next();
            if (bille.getTitle().contains(title) && bille.getAuthor().contains(author))
            {
            %>
                <tr>
                    <td><%=bille.getTitle()%></td>
                    <td><%=bille.getAuthor()%></td>
                    <td>$<%=bille.getPrice()%></td>
                    <td><a href="<%=request.getContextPath()%>/order.jsp?id=<%=bille.getId()%>">Order this bille</a></td>
                   </tr>
        <%
            }
        }
        %>
        </table>
    <%
     } 
     %>

<hr/>
<center><i>
For more information about the Billestore example go <a target="_blank" href="http://www.mulesoft.org/documentation/display/MULE3EXAMPLES/Billestore+Example">here</a>.
</i></center>
</body>
</html>
