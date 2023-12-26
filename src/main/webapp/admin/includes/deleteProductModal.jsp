<%--
  Created by IntelliJ IDEA.
  User: abdou
  Date: 12/26/2023
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div
        class="modal fade animate__animated fadeIn"
        id="animationModal"
        tabindex="-1"
        aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel5">Delete Product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col mb-3">
                        <label for="nameAnimation" class="form-label">Name</label>
                        <input type="text" id="nameAnimation" class="form-control" placeholder="Enter Name" />
                    </div>
                </div>
                <div class="row g-2">
                    <div class="col mb-0">
                        <label for="emailAnimation" class="form-label">Email</label>
                        <input
                                type="email"
                                id="emailAnimation"
                                class="form-control"
                                placeholder="xxxx@xxx.xx" />
                    </div>
                    <div class="col mb-0">
                        <label for="dobAnimation" class="form-label">DOB</label>
                        <input type="date" id="dobAnimation" class="form-control" />
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-label-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
    </div>