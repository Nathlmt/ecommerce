<%@page import="dao.ProductDAOImple"%>
<%@page import="dao.CategoryDAOImple"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <%
            String productID = "";
            if (request.getParameter("productID") != null) {
                productID = request.getParameter("productID");
            }
            ProductDAOImple productDAO = new ProductDAOImple();
            CategoryDAOImple categoryDAO = new CategoryDAOImple();
            Product currentProduct = productDAO.getProduct(Integer.parseInt(productID));
            String image1 = currentProduct.getImage1();
            String image2 = currentProduct.getImage2();
            String image3 = currentProduct.getImage3();
            String image4 = currentProduct.getImage4();
            String name = currentProduct.getName();
            String description = currentProduct.getDescription();
            String price = currentProduct.toStringPrice();
            int categoryID = currentProduct.getCategoryID();
            Category currentCategory = categoryDAO.getCategoryByID(categoryID);
        %>
        <!-- Title  -->
        <title>Hust Camera - <%=name%></title>

        <!-- Favicon  -->
        <link rel="icon" href="img/core-img/favicon.ico">

        <!-- Core Style CSS -->
        <link rel="stylesheet" href="css/core-style.css">
        <link rel="stylesheet" href="style.css">

    </head>

    <body>
        <!-- Search Wrapper Area Start -->
        <div class="search-wrapper section-padding-100">
            <div class="search-close">
                <i class="fa fa-close" aria-hidden="true"></i>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="search-content">
                            <form action="#" method="get">
                                <input type="search" name="search" id="search" placeholder="Type your keyword...">
                                <button type="submit"><img src="img/core-img/search.png" alt=""></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Search Wrapper Area End -->

        <!-- ##### Main Content Wrapper Start ##### -->
        <div class="main-content-wrapper d-flex clearfix">

            <!-- Mobile Nav (max width 767px)-->
            <div class="mobile-nav">
                <!-- Navbar Brand -->
                <div class="amado-navbar-brand">
                    <a href="index.jsp"><img src="img/core-img/logo.png" alt=""></a>
                </div>
                <!-- Navbar Toggler -->
                <div class="amado-navbar-toggler">
                    <span></span><span></span><span></span>
                </div>
            </div>

            <!-- Header Area Start -->
            <jsp:include page="/components/navbar.jsp"></jsp:include>   
            <jsp:include page="/components/userinfo.jsp"></jsp:include>    

                <!-- Header Area End -->
                <div class="single-product-area section-padding-100 clearfix">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-12">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb mt-50">
                                        <li class="breadcrumb-item"><a href="./index.jsp">Home</a></li>
                                        <li class="breadcrumb-item"><a href="#"><%=currentCategory.getName()%></a></li>
                                    <li class="breadcrumb-item"><a href="#"><%=name%></a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12 col-lg-7">
                            <div class="single_product_thumb">
                                <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                    <ol class="carousel-indicators">
                                        <li class="active" data-target="#product_details_slider" data-slide-to="0"
                                            style="background-image: url(<%=image1%>.jpg);">
                                        </li>
                                        <li data-target="#product_details_slider" data-slide-to="1"
                                            style="background-image: url(<%=image2%>.jpg);">
                                        </li>
                                        <li data-target="#product_details_slider" data-slide-to="2"
                                            style="background-image: url(<%=image3%>.jpg);">
                                        </li>
                                        <li data-target="#product_details_slider" data-slide-to="3"
                                            style="background-image: url(<%=image4%>.jpg);">
                                        </li>
                                    </ol>
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <a class="gallery_img" href="<%=image1%>.jpg">
                                                <img class="d-block w-100" src="<%=image1%>.jpg" alt="First slide">
                                            </a>
                                        </div>
                                        <div class="carousel-item">
                                            <a class="gallery_img" href="<%=image2%>.jpg">
                                                <img class="d-block w-100" src="<%=image2%>.jpg" alt="Second slide">
                                            </a>
                                        </div>
                                        <div class="carousel-item">
                                            <a class="gallery_img" href="<%=image3%>.jpg">
                                                <img class="d-block w-100" src="<%=image3%>.jpg" alt="Third slide">
                                            </a>
                                        </div>
                                        <div class="carousel-item">
                                            <a class="gallery_img" href="<%=image4%>.jpg">
                                                <img class="d-block w-100" src="<%=image4%>.jpg" alt="Fourth slide">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-5">
                            <div class="single_product_desc">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price"><%=price%></p>
                                    <a href="product-details.jsp">
                                        <h6><%=name%></h6>
                                    </a>
                                    <!-- Ratings & Review -->
                                    <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                        <div class="ratings">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </div>
                                        <div class="review">
                                            <a href="#">Write A Review</a>
                                        </div>
                                    </div>
                                    <!-- Avaiable -->
                                    <p class="avaibility"><i class="fa fa-circle"></i> In Stock</p>
                                </div>

                                <div class="short_overview my-5">
                                    <p><%=description%></p>
                                </div>

                                <!-- Add to Cart Form -->
                                <form class="cart clearfix" method="post" action="addToCart?productid=<%=request.getParameter("productID")%>">
                                    <div class="cart-btn d-flex mb-50">
                                        <p>Số lượng</p>
                                        <div class="quantity">
                                            <span class="qty-minus" onclick="var effect = document.getElementById('qty');
                                                    var qty = effect.value;
                                                    if (!isNaN(qty) & amp; & amp; qty & gt; 1) effect.value--; return false;"><i
                                                    class="fa fa-caret-down" aria-hidden="true"></i></span>
                                            <input type="number" class="qty-text" id="qty" step="1" min="1" max="300"
                                                   name="quantity" value="1">
                                            <span class="qty-plus"
                                                  onclick="var effect = document.getElementById('qty');
                                                          var qty = effect.value;
                                                          if (!isNaN(qty))
                                                              effect.value++;
                                                          return false;"><i
                                                    class="fa fa-caret-up" aria-hidden="true"></i></span>
                                        </div>
                                    </div>
                                    <button   name="addtocart" class="btn amado-btn">Thêm vào giỏ hàng
                                    </button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Product Details Area End -->
        </div>
        <!-- ##### Main Content Wrapper End ##### -->

        <!-- ##### Newsletter Area Start ##### -->

        <!-- ##### Newsletter Area End ##### -->
        <jsp:include page="/components/subcribe.jsp"></jsp:include>    

            <!-- ##### Footer Area Start ##### -->
        <jsp:include page="/components/footer.jsp"></jsp:include>    

        <!-- ##### Footer Area End ##### -->

        <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Plugins js -->
        <script src="js/plugins.js"></script>
        <!-- Active js -->
        <script src="js/active.js"></script>

    </body>

</html>