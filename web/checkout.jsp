<%@page import="controller.ults"%>
<%@page import="dao.CustomerDAOImple"%>
<%@page import="entity.Customer"%>

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
        <title>Hust Camera | Thanh toán</title>

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

            <!-- Close Icon -->
            <jsp:include page="/components/navbar.jsp"></jsp:include>    
            <%  String username = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("username")) {
                            username = cookie.getValue();
                        }
                    }
                }%>
            <% if (username != null) {%> <div class="user-info" >Welcome <%=username%> </div> <% }%>

            <!-- Header Area End -->

            <div class="cart-table-area section-padding-100">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 col-lg-8">
                            <div class="checkout_details_area mt-50 clearfix">

                                <div class="cart-title">
                                    <h2>Thanh toán</h2>
                                </div>
                                <% if (username == null) { %>
                                <h4> Bạn phải <a class="h4 login" href="signin/">đăng nhập</a> để tiến hành mua hàng</h4>
                                <%} else {
                                    CustomerDAOImple customerDao = new CustomerDAOImple();
                                    Customer customer = customerDao.getCustomerByUserName(username);
                                    System.out.println(customer.getName());
                                %>

                                <form action="\Project_1/CheckOut" method="post" id="checkout">
                                    <div class="row">
                                        <div class="col-12 mb-3">
                                            <p>Họ và tên </p>
                                            <input type="text" name="name" class="form-control" id="name" value="<%=customer.getName()%>" placeholder="Họ và tên" required>
                                        </div>
                                        <div class="col-12 mb-3">
                                            <p>Địa chỉ</p>
                                            <input type="text" name="address" class="form-control" id="address" placeholder="Company Name" value="<%=customer.getAddress()%>">
                                        </div>
                                        <div class="col-12 mb-3">
                                            <p>Email</p>
                                            <input type="email" name="email" class="form-control" id="email" placeholder="Email" value="<%=customer.getEmail()%>">
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <p>Số điện thoại</p>
                                            <input type="number" name="phone" class="form-control" id="phone" min="0" placeholder="Số điện thoại" value="<%=customer.getPhoneNumber()%>">
                                        </div>
                                        <div class="col-12 mb-3">
                                            <p>Ghi chú đơn hàng</p>
                                            <textarea name="comment" class="form-control w-100" id="comment" cols="30" rows="10" placeholder="Thêm ghi chú của bạn"></textarea>
                                        </div>

                                        <div class="col-12">
                                            <div class="custom-control custom-checkbox d-block">
                                                <input type="checkbox" class="custom-control-input" id="customCheck3">
                                                <label class="custom-control-label" for="customCheck3">Nhận hàng ở địa chỉ khác</label>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <%}%>
                            </div>
                        </div>
                        <% if (session.getAttribute("cart") != null) {
                                Double subTotal = (Double) session.getAttribute("subTotal");
                                Double ship = (Double) session.getAttribute("ship");
                                Double total = (Double) session.getAttribute("total");

                        %>
                        <div class="col-12 col-lg-4">
                            <div class="cart-summary">
                                <h5>Cart Total</h5>
                                <ul class="summary-table">
                                    <li><span>Tạm tính:</span> <span><%=ults.convertPrice(subTotal)%></span></li>
                                    <li><span>Vận chuyển:</span> <span><%=ults.convertPrice(ship)%></span></li>
                                    <li><span>Tổng cộng:</span> <span><%=ults.convertPrice(total)%></span></li>
                                </ul>
                                <%}%>

                                <div class="cart-btn mt-100">
                                    <button id="test" form="checkout" class="btn amado-btn w-100">Thanh toán</button>
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
        <script src="js/sweetalert2@8.js"></script>
        <script>$("#test").click(function () {
                Swal.fire(
                        'Thành công!',
                        'Bạn đã thanh toán thành công!',
                        'success'
                        );
            });</script>
        <script>
            var my_form = document.getElementById("checkout"), button = document.getElementById("test");
            my_form.onsubmit = function () {
                return false;
            }

            button.onclick = function () {
                setTimeout(function () {
                    my_form.submit();
                }, 5000);
                return false;
            }</script>
    </body>

</html>