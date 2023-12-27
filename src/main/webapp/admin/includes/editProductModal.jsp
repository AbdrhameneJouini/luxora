<%--
  Created by IntelliJ IDEA.
  User: abdou
  Date: 12/26/2023
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.luxora.beans.Article" %>
<%@ page import="java.util.List" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<div class="modal fade" id="modalCenter" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalCenterTitle">Modal title</h5>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col mb-3">
                        <label for="nameWithTitle" class="form-label">Name</label>
                        <input
                                type="text"
                                id="nameWithTitle"
                                class="form-control"
                                placeholder="Enter Name" />
                    </div>
                </div>

                <div class="row g-2">
                    <div class="col mb-0">
                        <label for="emailWithTitle" class="form-label">Email</label>
                        <input
                                type="email"
                                id="emailWithTitle"
                                class="form-control"
                                placeholder="xxxx@xxx.xx" />
                    </div>
                    <div class="col mb-0">
                        <label for="dobWithTitle" class="form-label">DOB</label>
                        <input type="date" id="dobWithTitle" class="form-control" />
                    </div>
                </div>
            </div>
            <script>
                console.log("hiiii oga boga")

            </script>
            <script>
                // JavaScript to handle the modal display
                document.querySelectorAll('.edit-button').forEach(function (button) {
                    button.addEventListener('click', function () {


                        // Retrieve article details from the data attributes
                        var reference = button.getAttribute('data-article-reference');
                        console.log("reference is "+ reference)
                        var name = button.getAttribute('data-article-name');
                        console.log("name is "+ name)
                        var price = button.getAttribute('data-article-price');
                        var category = button.getAttribute('data-article-category');

                        // Populate the modal fields with the article details
                        document.getElementById('nameWithTitle').value = name;
                    });
                });
            </script>






        </div>
    </div>
</div>