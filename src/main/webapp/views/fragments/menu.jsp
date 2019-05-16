
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<nav class="navbar navbar-expand-lg navbar-light bg-white" >
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon" ></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown" >
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/"></c:url>">Home<span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value="/login"></c:url>">Login<span class="sr-only">(current)</span></a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="<c:url value="register"></c:url>">Register<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/login"></c:url>">Admin<span class="sr-only">(current)</span></a>
      </li>
    </ul>
  </div>
</nav>


