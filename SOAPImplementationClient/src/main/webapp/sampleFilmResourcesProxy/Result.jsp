<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleFilmResourcesProxyid" scope="session" class="rest.services.resources.FilmResourcesProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleFilmResourcesProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleFilmResourcesProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleFilmResourcesProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        rest.services.resources.FilmResources getFilmResources10mtemp = sampleFilmResourcesProxyid.getFilmResources();
if(getFilmResources10mtemp == null){
%>
<%=getFilmResources10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 19:
        gotMethod = true;
        String id_1id=  request.getParameter("id22");
        int id_1idTemp  = Integer.parseInt(id_1id);
        java.lang.String getFilmByIDAsString19mtemp = sampleFilmResourcesProxyid.getFilmByIDAsString(id_1idTemp);
if(getFilmByIDAsString19mtemp == null){
%>
<%=getFilmByIDAsString19mtemp %>
<%
}else{
        String tempResultreturnp20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getFilmByIDAsString19mtemp));
        %>
        <%= tempResultreturnp20 %>
        <%
}
break;
case 24:
        gotMethod = true;
        java.lang.String getAllFilmsAsString24mtemp = sampleFilmResourcesProxyid.getAllFilmsAsString();
if(getAllFilmsAsString24mtemp == null){
%>
<%=getAllFilmsAsString24mtemp %>
<%
}else{
        String tempResultreturnp25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllFilmsAsString24mtemp));
        %>
        <%= tempResultreturnp25 %>
        <%
}
break;
case 27:
        gotMethod = true;
        String year_2id=  request.getParameter("year30");
        int year_2idTemp  = Integer.parseInt(year_2id);
        java.lang.String getFilmByYearAsString27mtemp = sampleFilmResourcesProxyid.getFilmByYearAsString(year_2idTemp);
if(getFilmByYearAsString27mtemp == null){
%>
<%=getFilmByYearAsString27mtemp %>
<%
}else{
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getFilmByYearAsString27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
}
break;
case 32:
        gotMethod = true;
        String name_3id=  request.getParameter("name35");
            java.lang.String name_3idTemp = null;
        if(!name_3id.equals("")){
         name_3idTemp  = name_3id;
        }
        java.lang.String getFilmByNameAsString32mtemp = sampleFilmResourcesProxyid.getFilmByNameAsString(name_3idTemp);
if(getFilmByNameAsString32mtemp == null){
%>
<%=getFilmByNameAsString32mtemp %>
<%
}else{
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getFilmByNameAsString32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
}
break;
case 37:
        gotMethod = true;
        rest.services.models.Film[] getAllFilms37mtemp = sampleFilmResourcesProxyid.getAllFilms();
if(getAllFilms37mtemp == null){
%>
<%=getAllFilms37mtemp %>
<%
}else{
        String tempreturnp38 = null;
        if(getAllFilms37mtemp != null){
        java.util.List listreturnp38= java.util.Arrays.asList(getAllFilms37mtemp);
        tempreturnp38 = listreturnp38.toString();
        }
        %>
        <%=tempreturnp38%>
        <%
}
break;
case 40:
        gotMethod = true;
        String stars_5id=  request.getParameter("stars45");
            java.lang.String stars_5idTemp = null;
        if(!stars_5id.equals("")){
         stars_5idTemp  = stars_5id;
        }
        String review_6id=  request.getParameter("review47");
            java.lang.String review_6idTemp = null;
        if(!review_6id.equals("")){
         review_6idTemp  = review_6id;
        }
        String director_7id=  request.getParameter("director49");
            java.lang.String director_7idTemp = null;
        if(!director_7id.equals("")){
         director_7idTemp  = director_7id;
        }
        String year_8id=  request.getParameter("year51");
        int year_8idTemp  = Integer.parseInt(year_8id);
        String title_9id=  request.getParameter("title53");
            java.lang.String title_9idTemp = null;
        if(!title_9id.equals("")){
         title_9idTemp  = title_9id;
        }
        String id_10id=  request.getParameter("id55");
        int id_10idTemp  = Integer.parseInt(id_10id);
        %>
        <jsp:useBean id="rest1services1models1Film_4id" scope="session" class="rest.services.models.Film" />
        <%
        rest1services1models1Film_4id.setStars(stars_5idTemp);
        rest1services1models1Film_4id.setReview(review_6idTemp);
        rest1services1models1Film_4id.setDirector(director_7idTemp);
        rest1services1models1Film_4id.setYear(year_8idTemp);
        rest1services1models1Film_4id.setTitle(title_9idTemp);
        rest1services1models1Film_4id.setId(id_10idTemp);
        sampleFilmResourcesProxyid.updateFilm(rest1services1models1Film_4id);
break;
case 57:
        gotMethod = true;
        String id_11id=  request.getParameter("id60");
        int id_11idTemp  = Integer.parseInt(id_11id);
        rest.services.models.Film[] getFilmByID57mtemp = sampleFilmResourcesProxyid.getFilmByID(id_11idTemp);
if(getFilmByID57mtemp == null){
%>
<%=getFilmByID57mtemp %>
<%
}else{
        String tempreturnp58 = null;
        if(getFilmByID57mtemp != null){
        java.util.List listreturnp58= java.util.Arrays.asList(getFilmByID57mtemp);
        tempreturnp58 = listreturnp58.toString();
        }
        %>
        <%=tempreturnp58%>
        <%
}
break;
case 62:
        gotMethod = true;
        String year_12id=  request.getParameter("year65");
        int year_12idTemp  = Integer.parseInt(year_12id);
        rest.services.models.Film[] getFilmByYear62mtemp = sampleFilmResourcesProxyid.getFilmByYear(year_12idTemp);
if(getFilmByYear62mtemp == null){
%>
<%=getFilmByYear62mtemp %>
<%
}else{
        String tempreturnp63 = null;
        if(getFilmByYear62mtemp != null){
        java.util.List listreturnp63= java.util.Arrays.asList(getFilmByYear62mtemp);
        tempreturnp63 = listreturnp63.toString();
        }
        %>
        <%=tempreturnp63%>
        <%
}
break;
case 67:
        gotMethod = true;
        String name_13id=  request.getParameter("name70");
            java.lang.String name_13idTemp = null;
        if(!name_13id.equals("")){
         name_13idTemp  = name_13id;
        }
        rest.services.models.Film[] getFilmByName67mtemp = sampleFilmResourcesProxyid.getFilmByName(name_13idTemp);
if(getFilmByName67mtemp == null){
%>
<%=getFilmByName67mtemp %>
<%
}else{
        String tempreturnp68 = null;
        if(getFilmByName67mtemp != null){
        java.util.List listreturnp68= java.util.Arrays.asList(getFilmByName67mtemp);
        tempreturnp68 = listreturnp68.toString();
        }
        %>
        <%=tempreturnp68%>
        <%
}
break;
case 72:
        gotMethod = true;
        java.lang.String getNextID72mtemp = sampleFilmResourcesProxyid.getNextID();
if(getNextID72mtemp == null){
%>
<%=getNextID72mtemp %>
<%
}else{
        String tempResultreturnp73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getNextID72mtemp));
        %>
        <%= tempResultreturnp73 %>
        <%
}
break;
case 75:
        gotMethod = true;
        String stars_15id=  request.getParameter("stars80");
            java.lang.String stars_15idTemp = null;
        if(!stars_15id.equals("")){
         stars_15idTemp  = stars_15id;
        }
        String review_16id=  request.getParameter("review82");
            java.lang.String review_16idTemp = null;
        if(!review_16id.equals("")){
         review_16idTemp  = review_16id;
        }
        String director_17id=  request.getParameter("director84");
            java.lang.String director_17idTemp = null;
        if(!director_17id.equals("")){
         director_17idTemp  = director_17id;
        }
        String year_18id=  request.getParameter("year86");
        int year_18idTemp  = Integer.parseInt(year_18id);
        String title_19id=  request.getParameter("title88");
            java.lang.String title_19idTemp = null;
        if(!title_19id.equals("")){
         title_19idTemp  = title_19id;
        }
        String id_20id=  request.getParameter("id90");
        int id_20idTemp  = Integer.parseInt(id_20id);
        %>
        <jsp:useBean id="rest1services1models1Film_14id" scope="session" class="rest.services.models.Film" />
        <%
        rest1services1models1Film_14id.setStars(stars_15idTemp);
        rest1services1models1Film_14id.setReview(review_16idTemp);
        rest1services1models1Film_14id.setDirector(director_17idTemp);
        rest1services1models1Film_14id.setYear(year_18idTemp);
        rest1services1models1Film_14id.setTitle(title_19idTemp);
        rest1services1models1Film_14id.setId(id_20idTemp);
        sampleFilmResourcesProxyid.insertFilm(rest1services1models1Film_14id);
break;
case 92:
        gotMethod = true;
        String id_21id=  request.getParameter("id95");
            java.lang.String id_21idTemp = null;
        if(!id_21id.equals("")){
         id_21idTemp  = id_21id;
        }
        sampleFilmResourcesProxyid.deleteFilm(id_21idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>