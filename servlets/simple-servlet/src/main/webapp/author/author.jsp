<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../_templates/header.jsp"/>

<div class="container">
    <div class="page-title mt-5 mb-5">
        <h1>Cadastrar Autor</h1>
    </div>
    <div class="form-new">
        <form action="${pageContext.request.contextPath}/author/${author == null ? "new-author" : "edit-author"}" method="post">
            <label for="name" class="form-label">Nome:</label>
            <c:if test="${author != null}">
                <input type="hidden" value="${author.id}" name="id">
            </c:if>
            <input type="text" id="name" name="name" class="form-control" value="${author.name == null ? "" : author.name}">
            <br>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>
</div>

<jsp:include page="../_templates/footer.jsp"/>