<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="authors" scope="request" type="java.util.List"/>

<jsp:include page="../_templates/header.jsp"/>

<div class="container">
    <div class="page-title mt-5 mb-5">
        <h1>Listagem de Autores</h1>
    </div>
    <div class="page-new-button mb-3">
        <a href="${pageContext.request.contextPath}/author/new-author">
            <button class="btn btn-success">Cadastrar</button>
        </a>
    </div>
    <div class="list-table">
        <table class="table" aria-describedby="Tabela de listagem de Autores">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Options</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty authors}">
                        <c:forEach items="${authors}" var="author">
                            <tr>
                                <td>${author.id}</td>
                                <td>${author.name}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/author/edit-author?id=${author.id}">
                                        <button class="btn btn-warning">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                    </a>
                                    <a href="${pageContext.request.contextPath}/author/delete-author?id=${author.id}">
                                        <button class="btn btn-danger">
                                            <i class="fa fa-trash" aria-hidden="true"></i>
                                        </button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="../_templates/footer.jsp"/>