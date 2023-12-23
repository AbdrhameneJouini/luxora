<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="keywords" content="app, landing, corporate, Creative, Html Template, Template">
    <meta name="author" content="web-themes">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- title -->
    <title>Product details page</title>

    <!-- favicon -->
    <!-- <link href="img/favicon.png" type="image/png" rel="icon"> -->

    <!-- all css here -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="resources/vendor/bootstrap/css/fontawesome.min.css" rel="stylesheet" type="text/css" />
    <link href="resources/vendor/bootstrap/css/jquery.nice-number.css" rel="stylesheet" type="text/css" />
    <link href="resources/vendor/bootstrap/css/slick.css" rel="stylesheet" type="text/css" />
    <link href="resources/vendor/bootstrap/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@ page import="com.luxora.beans.Article" %>
    <% Article article = (Article) request.getAttribute("article"); %>
    <% if (article != null) { %>
    <!-- product detail area start -->
    <div class="product-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product-img-main-active">
                        <div class="product-img-box">
                            <p><i class="far fa-check-circle"></i>In stock</p>
                            <img class="img-fluid" src="resources/images/tempProductPage/prduct_main_image.png" alt="">
                        </div>
                        <div class="product-img-box">
                            <p><i class="far fa-check-circle"></i>In stock</p>
                            <img class="img-fluid" src="resources/images/tempProductPage/prduct_main_image.png" alt="">
                        </div>
                        <div class="product-img-box">
                            <p><i class="far fa-check-circle"></i>In stock</p>
                            <img class="img-fluid" src="resources/images/tempProductPage/prduct_main_image.png" alt="">
                        </div>
                        <div class="product-img-box">
                            <p><i class="far fa-check-circle"></i>In stock</p>
                            <img class="img-fluid" src="resources/images/tempProductPage/prduct_main_image.png" alt="">
                        </div>
                    </div>
                    <div class="product-img-mini-active">
                        <img class="img-fluid" src="resources/images/tempProductPage/product_main_smallimg.png" alt="">
                        <img class="img-fluid" src="resources/images/tempProductPage/product_main_smallimg.png" alt="">
                        <img class="img-fluid" src="resources/images/tempProductPage/product_main_smallimg.png" alt="">
                        <img class="img-fluid" src="resources/images/tempProductPage/product_main_smallimg.png" alt="">
                        <img class="img-fluid" src="resources/images/tempProductPage/product_main_smallimg.png" alt="">
                        <img class="img-fluid" src="resources/images/tempProductPage/product_main_smallimg.png" alt="">
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product-box">
                        <h2><%= article.getNom_Article() %></h2>
                        <span class="mt-30 d-inline-block">Description : <%= article.getDescription() %></span>
                        <div class="star-icon">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                        </div>
                       <div class="product-size mt-30">
    
              
                        <p><%=article.getPrix() %> <span>TND</span></p>
                         <select id="size" name="size">
        <option value="XS">XS</option>
        <option value="S">S</option>
        <option value="M">M</option>
        <option value="L">L</option>
        <option value="XL">XL</option>
    </select>
</div>
   
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="product-spinner mt-30">
                                    <input type="number" value="2">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <a class="product-button mt-30" href="#"><img class="img-fluid" src="resources/images/tempProductPage/product_card_icon.png" alt=""> Add to cart</a>
                            </div>
                            <div class="col-lg-6">
                                <a class="product-button wishlet-bg mt-30" href="#"><img class="img-fluid" src="resources/images/tempProductPage/product_wishlet_icon.png" alt="">Add to wishlet</a>
                            </div>
                            
                        </div>
                        
</div>
                       
                        
                    </div>
                </div>
            </div>
        </div>
    <% } 
    else { %>
        <p>Aucun article trouvé</p>
    <% } %>
    <!-- product detail area end -->
    
    <!-- all js here -->
    <script src="resources/vendor/bootstrap/js/jquery-3.4.1.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/vendor/bootstrap/js/jquery.nice-number.js"></script>
    <script src="resources/vendor/bootstrap/js/slick.min.js"></script>
    <script>
        
         $('.product-img-main-active').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          arrows: false,
          asNavFor: '.product-img-mini-active',
          arrows: true,
          autoplaySpeed: 3000,
          prevArrow:'<button type="button" class="slick-prev"><i class="far fa-arrow-left"></i></button>',
          nextArrow:'<button type="button" class="slick-next"><i class="far fa-arrow-right"></i></button>',
        });
        $('.product-img-mini-active').slick({
          slidesToShow: 3,
          slidesToScroll: 1,
          asNavFor: '.product-img-main-active',
          dots: false,
          centerMode: true,
          focusOnSelect: true,
          arrows: true,
          prevArrow:'<button type="button" class="slick-prev"><i class="far fa-arrow-left"></i></button>',
          nextArrow:'<button type="button" class="slick-next"><i class="far fa-arrow-right"></i></button>',
        });

        // product counter start
        $(function(){
            $('.product-spinner input[type="number"]').niceNumber();
         });


    </script>
</body>
</html>
