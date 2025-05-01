<%@ page contentTyoe = "text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://ww.springframework.org/tags/form" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
    <h1>Insert</h1>
    <form:form>
        <table>
            <tr>
                <td>
                    Employee_Name:
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="employee_name"/>
                </td>
            <tr>
                <td colspan="2">
                    <input  type="submit" value="Add Employee">
                </td>
            </td>
        </table>
    </form:form>
</body>
</html>
