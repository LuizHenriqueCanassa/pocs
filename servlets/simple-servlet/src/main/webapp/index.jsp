<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="_templates/header.jsp"/>


<div class="main">
    <div class="content">
        <div class="option-box">
            <div class="option">
                <a href="${pageContext.request.contextPath}/author">
                    <button class="btn btn-primary">Authors</button>
                </a>
            </div>
            <div class="option">
                <a href="${pageContext.request.contextPath}/book">
                    <button class="btn btn-primary">Books</button>
                </a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="_templates/footer.jsp"/>
