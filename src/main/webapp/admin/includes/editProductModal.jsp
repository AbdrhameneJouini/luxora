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
                        <label for="nameWithTitle" class="form-label">Nom article</label>
                        <input
                                type="text"
                                id="nameWithTitle"
                                class="form-control"
                                placeholder="Name" />
                    </div>
                    <div class="col mb-3">
                        <label for="descWithTitle" class="form-label">Description</label>
                        <input
                                type="text"
                                id="descWithTitle"
                                class="form-control"
                                placeholder="Description" />
                    </div>
                </div>

                <div class="row g-2">
                    <div class="col mb-0">
                        <label for="prixWithTitle" class="form-label">Prix</label>
                        <input
                                type="email"
                                id="prixWithTitle"
                                class="form-control"
                                placeholder="xxxxTND" />
                    </div>
                    <div class="col mb-3">
                        <label for="catWithTitle" class="form-label">Categorie</label>
                        <input
                                type="text"
                                id="catWithTitle"
                                class="form-control"
                                placeholder="Categorie" />
                    </div>
                    <div class="col mb-0">
                        <label for="sizeSelector" class="form-label">Selectionnez une taille :</label>
                        <select id="sizeSelector" class="form-select">
                            <option value="select">Choisir une taille</option>
                            <option value="XS">XS</option>
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                            <option value="XXL">XXL</option>
                        </select>
                    </div>
                    <div id="additionalInput" style="display: none;">
                        <div class="col mb-0">
                            <label for="otherInput" class="form-label">Quantite:</label>
                            <input type="number" id="otherInput" class="form-control" />
                        </div>
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
                        var description = button.getAttribute('data-article-category');

                        // Populate the modal fields with the article details
                        document.getElementById('nameWithTitle').value = name;
                        document.getElementById('prixWithTitle').value = price;
                        document.getElementById('catWithTitle').value = category;
                        document.getElementById('descWithTitle').value = description;
                    });
                });
                document.addEventListener('DOMContentLoaded', function () {
                    const sizeSelector = document.getElementById('sizeSelector');
                    const additionalInput = document.getElementById('additionalInput');

                    sizeSelector.addEventListener('change', function () {
                        const selectedSize = sizeSelector.value;

                        if (selectedSize !== 'select') {
                            additionalInput.style.display = 'block';

                        } else {
                            additionalInput.style.display = 'none';
                        }
                    });
                });
            </script>






        </div>
    </div>
</div>