<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.luxora.beans.Article" %>
<%@ page import="java.util.List" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>



<div class="container-xxl flex-grow-1 container-p-y">
    <div class="row g-4 mb-4">
        <div class="col-sm-6 col-xl-3">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex align-items-start justify-content-between">
                        <div class="content-left">
                            <span>Total</span>
                            <div class="d-flex align-items-center my-1">
                                <h4 class="mb-0 me-2">{fetch from db}</h4>
                                <span class="text-success">(+{fetch from db}%)</span>
                            </div>
                            <span>Total Products</span>
                        </div>
                        <span class="badge bg-label-primary rounded p-2">
                        <i class="ti ti-sum"></i>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex align-items-start justify-content-between">
                        <div class="content-left">
                            <span>Sales</span>
                            <div class="d-flex align-items-center my-1">
                                <h4 class="mb-0 me-2">{fetch from db}</h4>
                                <span class="text-success">(+{fetch from db}%)</span>
                            </div>
                            <span>Last week analytics </span>
                        </div>
                        <span class="badge bg-label-danger rounded p-2">
                         <i class="ti ti-report-money"></i>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex align-items-start justify-content-between">
                        <div class="content-left">
                            <span>Trending</span>
                            <div class="d-flex align-items-center my-1">
                                <h4 class="mb-0 me-2">{fetch from db}</h4>
                                <span class="text-danger">(-{fetch from db}%)</span>
                            </div>
                            <span>Last week analytics</span>
                        </div>
                        <span class="badge bg-label-success rounded p-2">
                         <i class="ti ti-trending-up"></i>
                        </span>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- Products List Table -->
    <div class="card" data-select2-id="7">
        <div class="card-header border-bottom">
            <h5 class="card-title mb-3">Search Filter</h5>
            <div class="d-flex justify-content-between align-items-center row pb-2 gap-3 gap-md-0">
                <div class="col-md-4 Product_role"></div>
                <div class="col-md-4 Product_plan"></div>
                <div class="col-md-4 Product_status"></div>
            </div>
        </div>
        <div class="card-datatable table-responsive">
            <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper dt-bootstrap5 no-footer"><div class="row me-2">
                <div class="col-md-2"><div class="me-3"><div class="dataTables_length" id="DataTables_Table_0_length">
                    <label>
                        <select name="DataTables_Table_0_length" aria-controls="DataTables_Table_0" class="form-select">
                            <option value="10">10</option><option value="25">25</option>
                            <option value="50">50</option><option value="100">100</option>
                        </select></label>
                </div>
                </div>
                </div>
                <div class="col-md-10">
                    <div class="dt-action-buttons text-xl-end text-lg-start text-md-end text-start d-flex align-items-center justify-content-end flex-md-row flex-column mb-3 mb-md-0">
                        <div id="DataTables_Table_0_filter" class="dataTables_filter">
                            <label>
                                <input type="search" class="form-control" placeholder="Search.." aria-controls="DataTables_Table_0">
                            </label>
                        </div>
                        <div class="dt-buttons btn-group flex-wrap">
                            <div class="btn-group">
                                <button class="btn btn-secondary buttons-collection dropdown-toggle btn-label-secondary mx-3" tabindex="0" aria-controls="DataTables_Table_0" type="button" aria-haspopup="dialog" aria-expanded="false">
                                    <span><i class="ti ti-screen-share me-1 ti-xs"></i>Export</span>
                                    <span class="dt-down-arrow"></span>
                                </button>
                            </div>
                            <button class="btn btn-secondary add-new btn-primary" tabindex="0" aria-controls="DataTables_Table_0" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasAddProduct">
                                <span><i class="ti ti-plus me-0 me-sm-1 ti-xs"></i>
                                    <span class="d-none d-sm-inline-block">Add New Product</span>
                                </span></button>
                        </div>
                    </div>
                </div>
            </div>
                <table class="datatables-Products table border-top dataTable no-footer dtr-column" id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
                    <thead>
                    <tr>
                        <th class="control sorting_disabled dtr-hidden" rowspan="1" colspan="1" style="width: 61.4844px; display: none;" aria-label=""></th>
                        <th class="sorting sorting_desc" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 148.531px;" aria-sort="descending" aria-label="Reference: activate to sort column ascending">Reference</th>
                        <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 146px;" aria-label="Name: activate to sort column ascending">Name</th>
                        <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 148.922px;" aria-label="Price: activate to sort column ascending">Price</th>
                        <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 192.109px;" aria-label="Category: activate to sort column ascending">Category</th>

                        <th class="sorting_disabled" rowspan="1" colspan="1" style="width: 194.891px;" aria-label="Actions">Actions</th>
                    </tr>
                    </thead>



                    <tbody>
                    <% List<Article> articleList = (List<Article>) request.getAttribute("articleList");

                        if (articleList != null && !articleList.isEmpty()) {
                            for (Article article : articleList) {
                    %>
                    <tr>
                        <td><%= article.getReference() %></td>
                        <td><%= article.getNom_Article() %></td>
                        <td><%= article.getPrix() %></td>
                        <td><%= article.getCategorie() %></td>

                        <td>

                            <%--                                edit button --%>
                                <button
                                        style=" background-color: transparent; color: white; border: none; padding: 5px 10px; text-align: center; text-decoration: none; display: inline-block; font-size: 12px; margin: 2px; cursor: pointer;"
                                        class="edit-button"
                                        data-bs-toggle="modal"
                                        data-bs-target="#modalCenter"
                                        data-article-reference="<%= article.getReference() %>"
                                        data-article-name="<%= article.getNom_Article() %>"
                                        data-article-price="<%= article.getPrix() %>"
                                        data-article-category="<%= article.getCategorie() %>"
                                    data-article-description="<%= article.getDescription() %>">
                                    data-article-liste-details="<%= article.getListDetailArticle() %>">


                                    <i class="ti ti-edit" style=" color: rgba(0,111,255,0.85) " ></i>
                                </button>

                                <jsp:include page="editProductModal.jsp" />

                                <%--                                    delete button--%>
                                <button type="button" class="delete-btn"
                                        style="cursor: pointer; border: none transparent;background-color: transparent"
                                        data-article-id="<%= article.getReference() %>">
                                    <i class="ti ti-trash"  style="color: #a10303;"></i>


                                </button>

                        </td>

                    </tr>
                    <% }
                    } else { %>
                    <tr class="odd">
                        <td valign="top" colspan="6" class="dataTables_empty">
                            Loading... <!-- You may want to add a loading spinner or message here -->
                        </td>
                    </tr>
                    <% } %>
                    </tbody>



                </table>
                <div class="row mx-2">
                    <div class="col-sm-12 col-md-6">
                        <div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">Showing 0 to 0 of 0 entries
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                        <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
                            <ul class="pagination">
                                <li class="paginate_button page-item previous disabled" id="DataTables_Table_0_previous">
                                    <a aria-controls="DataTables_Table_0" aria-disabled="true" aria-role="link" data-dt-idx="previous" tabindex="0" class="page-link">Previous</a>
                                </li>
                                <li class="paginate_button page-item next disabled" id="DataTables_Table_0_next">
                                    <a aria-controls="DataTables_Table_0" aria-disabled="true" aria-role="link" data-dt-idx="next" tabindex="0" class="page-link">Next</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Offcanvas to add new product -->
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasAddProduct" aria-labelledby="offcanvasAddProductLabel">
            <div class="offcanvas-header">
                <h5 id="offcanvasAddProductLabel" class="offcanvas-title">Add Product</h5>
                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body mx-0 flex-grow-0 pt-0 h-100" data-select2-id="6">




                <form  method="get" action="AddProduct"   class="add-new-Product pt-0 fv-plugins-bootstrap5 fv-plugins-framework" id="addNewProductForm"  data-select2-id="addNewProductForm">
                    <div class="mb-3 fv-plugins-icon-container">
                        <label class="form-label" for="add-product-reference">Reference</label>
                        <input type="text" class="form-control" id="add-product-reference" name="productReference" placeholder="reference..." required>
                        <div class="fv-plugins-message-container invalid-feedback"></div></div>
                    <div class="mb-3">
                        <label class="form-label" for="add-product-name">Name</label>
                        <input type="text" id="add-product-name" class="form-control"  name="productName"   placeholder="name..."  required>
                    </div>
                    <div class="mb-3 fv-plugins-icon-container">
                        <label class="form-label" for="add-product-price">Price</label>
                        <input type="text" id="add-product-price" class="form-control"  name="productPrice"   placeholder="price..." required>
                        <div class="fv-plugins-message-container invalid-feedback"></div></div>

                    <div class="mb-3  fv-plugins-icon-container ">
                        <label class="form-label" for="add-product-description">Description</label>
                        <textarea rows="3" class="form-control" name="productDescription"  id="add-Product-description" required></textarea>
                    </div>


                    <div class="mb-4">
                        <label   class="form-label" for="add-product-category">Select Clothing Category:</label>
                        <select  class="form-select" id="add-product-category" name="productCategory" required>
                            <option value="tShirts">T-Shirts</option>
                            <option value="dresses">Dresses</option>
                            <option value="tops">Tops</option>
                            <option value="bottoms">Bottoms</option>
                            <option value="jackets">Jackets</option>
                            <option value="sweaters">Sweaters</option>
                            <option value="activewear">Activewear</option>
                            <option value="lingerie">Lingerie</option>
                            <option value="sleepwear">Sleepwear</option>
                            <option value="suits">Suits</option>
                            <option value="blazers">Blazers</option>
                            <option value="jeans">Jeans</option>
                            <option value="skirts">Skirts</option>
                            <option value="swimwear">Swimwear</option>
                            <option value="outerwear">Outerwear</option>
                            <option value="hoodies">Hoodies</option>
                            <option value="shirts">Shirts</option>
                            <option value="pants">Pants</option>
                            <option value="shorts">Shorts</option>
                            <option value="jumpsuits">Jumpsuits</option>
                            <option value="workwear">Workwear</option>
                            <option value="maternityClothing">Maternity Clothing</option>
                            <option value="plusSize">Plus Size</option>
                            <option value="vintageClothing">Vintage Clothing</option>
                            <option value="costumes">Costumes</option>
                            <option value="sportswear">Sportswear</option>
                            <option value="ethnicWear">Ethnic Wear</option>
                            <option value="streetwear">Streetwear</option>
                            <option value="accessories">Accessories (Hats, Scarves, Gloves)</option>
                            <option value="footwear">Footwear</option>
                        </select>

                    </div>
                    <div class="mb-4">
                        <input name="sizes" hidden="true" id="sizes">
                        <input name="quantities" hidden="true" id="quantities">

                        <label >Available Sizes:</label>
                        <div id="sizesContainer">
                            <select id="sizeSelect" class="form-control">
                                <option value="XS">XS</option>
                                <option value="S">S</option>
                                <option value="M">M</option>
                                <option value="L">L</option>
                                <option value="XL">XL</option>
                                <option value="XXL">XXL</option>



                            </select>
                            <button type="button" onclick="addSizeField()"  class="btn btn-secondary">Add Size</button>
                        </div>
                    </div>



                    <button type="submit" class="btn btn-primary me-sm-3 me-1 data-submit waves-effect waves-light">Submit</button>
                    <button type="reset" class="btn btn-label-secondary waves-effect" data-bs-dismiss="offcanvas">Cancel</button>
                    <input type="hidden">


                </form>

            </div>
        </div>
    </div>





</div>


<script>


    function addSizeField() {
        const sizeSelect = document.getElementById("sizeSelect");
        const selectedSize = sizeSelect.value;

        if (selectedSize) {

            const sizeId = "size_" + selectedSize;
            const quantityId = "quantity_" + selectedSize;

            // Create input fields for size and quantity
            const sizeInput = document.createElement("input");
            sizeInput.type = "text";
            sizeInput.name = sizeId;
            sizeInput.value = selectedSize;
            sizeInput.id = sizeId;  // Set unique ID
            sizeInput.readOnly = true;
            sizeInput.className ="form-control";

            const quantityInput = document.createElement("input");
            quantityInput.type = "number";
            quantityInput.name = quantityId;
            quantityInput.placeholder = "Quantity";
            quantityInput.className ="form-control";
            quantityInput.min = 0;
            quantityInput.id = quantityId;

            sizeSelect.remove(sizeSelect.selectedIndex);


            if (sizeSelect.options.length === 0) {
                sizeSelect.disabled = true;
            }

            // Append inputs to the sizesContainer div
            const sizesContainer = document.getElementById("sizesContainer");
            sizesContainer.appendChild(sizeInput);
            sizesContainer.appendChild(quantityInput);
            sizesContainer.appendChild(document.createElement("br"));




        }
    }



    document.addEventListener('DOMContentLoaded', function () {
        // Get all elements with class 'delete-btn'
        var deleteButtons = document.querySelectorAll('.delete-btn');


        deleteButtons.forEach(function (button) {
            button.addEventListener('click', function () {

                var reference = button.getAttribute('data-article-id');
                console.log(reference)


                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes, delete it!',
                    customClass: {
                        confirmButton: 'btn btn-primary me-3',
                        cancelButton: 'btn btn-label-secondary'
                    },
                    buttonsStyling: false
                }).then(function (result) {
                    if (result.value) {

                        var contextPath = '<%= request.getContextPath() %>';

                        console.log("hhhhhhhhhhhhi"+contextPath);
                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', contextPath + '/admin/DeleteProduct?productIdToDelete='+reference, false);
                        xhr.send();
                        console.log("hiii");
                        if (xhr.responseText === "true"){





                                Swal.fire({
                                    icon: 'success',
                                    title: 'Deleted!',
                                    text: 'Your article has been deleted.',
                                    customClass: {
                                        confirmButton: 'btn btn-success'
                                    }
                                });

                            }



                        }
                    });
                });
            });
        });




</script>