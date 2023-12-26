<%--
  Created by IntelliJ IDEA.
  User: abdou
  Date: 12/25/2023
  Time: 2:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<aside id="layout-menu" class="layout-menu-horizontal menu-horizontal menu bg-menu-theme flex-grow-0">
    <div class="container-xxl d-flex h-100">
        <ul class="menu-inner">
            <!-- Dashboard -->
            <li class="menu-item active">
                <a href="index.jsp?component=dashboard"  class="menu-link ">
                    <i class="menu-icon tf-icons ti ti-smart-home"></i>
                    <div >Dashboard</div>
                </a>
            </li>

            <!-- Users -->
            <li class="menu-item">
                <a href="index.jsp?component=users" class="menu-link ">
                    <i class="menu-icon tf-icons ti ti-users"></i>
                    <div>Users</div>
                </a>

            </li>
            <!--/ Users -->

            <!--/ Products -->
            <li class="menu-item">
                <a href="GetAllProducts" class="menu-link  ">
                    <i class="ti ti-hanger"></i>
                    <div>Products</div>
                </a>

            </li>

            <!--/ Products -->



            <!--/ Invoice -->
            <li class="menu-item">
                <a href="javascript:void(0);" class="menu-link  ">
                    <i class="menu-icon tf-icons ti ti-file-dollar"></i>
                    <div>Invoice</div>
                </a>

            </li>

            <!--/ Invoice -->
        </ul>
    </div>
</aside>
