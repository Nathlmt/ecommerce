<%@page import="controller.ults"%>
<%@page import="entity.ShoppingCartItem"%>
<%@page import="java.util.List"%>
<%@page import="controller.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title  -->
        <title>Hust Camera | Cart</title>

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
                <div class="cart-table-area section-padding-100">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-12 col-lg-8">
                                <div class="cart-title mt-50">
                                    <h2>Giỏ hàng</h2>
                                </div>

                                <div class="cart-table clearfix">
                                    <table class="table table-responsive">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Tên sản phẩm</th>
                                                <th>Giá</th>
                                                <th>Số lượng</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            if (session.getAttribute("cart") != null) {
                                                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                                                List<ShoppingCartItem> items = cart.getItems();
                                                for (ShoppingCartItem p : items) {
                                        %>
                                        <tr>
                                            <td class="cart_product_img">
                                                <a href="#"><img src="<%=p.getProduct().getImage1()%>.jpg" alt="Product"></a>
                                            </td>
                                            <td class="cart_product_desc">
                                                <h5><%=p.getProduct().getName()%></h5>
                                            </td>
                                            <td class="price">
                                                <span><%=p.getProduct().toStringPrice()%></span>
                                            </td>
                                            <td class="qty">
                                                <div class="qty-btn d-flex">
                                                    <p>SL</p>
                                                    <div class="quantity">
                                                        <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if (!isNaN(qty) & amp; & amp; qty & gt; 1) effect.value--; return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                                        <input type="number" class="qty-text" id="qty" step="1" min="1" max="300" name="quantity" value="<%=p.getQuantity()%>">
                                                        <span class="qty-plus" onclick="var effect = document.getElementById('qty');
                                                                var qty = effect.value;
                                                                if (!isNaN(qty))
                                                                    effect.value++;
                                                                return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <%
                                                }
                                            }
                                        %>  
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-12 col-lg-4">
                            <div class="cart-summary">
                                <h5>Thông tin</h5>
                                <ul class="summary-table">
                                    <% if (session.getAttribute("cart") != null) {
                                            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                                            double subTotal = cart.getSubtotal();
                                            double ship = cart.calculateTotal();
                                            double total = ship + subTotal;
                                            session.setAttribute("subTotal",subTotal); 
                                            session.setAttribute("ship",ship); 
                                            session.setAttribute("total",total); 


                                    %>
                                    <li><span>Tạm tính:</span> <span><%=ults.convertPrice(subTotal)%></span></li>
                                    <li><span>Phí vận chuyển:</span> <span><%=ults.convertPrice(ship)%></span></li>
                                    <li><span>Thành tiền</span> <span><%=ults.convertPrice(total)%></span></li>
                                        <%}%>
                                </ul>
                                <div class="cart-btn mt-100">
                                    <a href="checkout.jsp" class="btn amado-btn w-100">Thanh toán</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ##### Main Content Wrapper End ##### -->

        <!-- ##### Newsletter Area Start ##### -->
        <jsp:include page="/components/subcribe.jsp"></jsp:include>    

            <!-- ##### Newsletter Area End ##### -->

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