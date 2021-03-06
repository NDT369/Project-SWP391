<%-- 
    Document   : UserList
    Created on : May 28, 2022, 1:09:54 AM
    Author     : Pham Minh Giang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Fashi Template">
        <meta name="keywords" content="Fashi, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Fashi | Template</title>

        <!-- Google Font -->
        <!--<link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">-->


        <!-- Css Styles -->
<!--        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/elegant-icons.css" rel="stylesheet" type="text/css"/>
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/nice-select.css" rel="stylesheet" type="text/css"/>
        <link href="../css/owl.carousel.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/slicknav.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../css/themify-icons.css" rel="stylesheet" type="text/css"/>-->
        
        
    </head>

    <body>
        <!-- Page Preloder -->
<!--        <div id="preloder">
            <div class="loader"></div>
        </div>-->

        <!-- Header Section Begin -->
<!--        <header class="header-section">
            <div class="header-top">
                <div class="container">
                    <div class="ht-left">
                        <div class="mail-service">
                            <i class=" fa fa-envelope"></i>
                            hello.colorlib@gmail.com
                        </div>
                        <div class="phone-service">
                            <i class=" fa fa-phone"></i>
                            +65 11.188.888
                        </div>
                    </div>
                    <div class="ht-right">
                        <c:if test="${sessionScope.account==null}">
                            <a href="login" class="login-panel"><i class="fa fa-user"></i>Login</a>
                        </c:if>
                        <c:if test="${sessionScope.account!=null}">       
                            <a class="login-panel"><i class="fa fa-user"></i>Hello ${sessionScope.account.name}</a> -


                        </c:if> 
                        <div class="lan-selector">
                            <select class="language_drop" name="countries" id="countries" style="width:300px;">
                                <option value='yt' data-image="img/flag-1.jpg" data-imagecss="flag yt"
                                        data-title="English">English</option>
                                <option value='yu' data-image="img/flag-2.jpg" data-imagecss="flag yu"
                                        data-title="Bangladesh">German </option>
                            </select>
                        </div>
                        <div class="top-social">
                            <a href="#"><i class="ti-facebook"></i></a>
                            <a href="#"><i class="ti-twitter-alt"></i></a>
                            <a href="#"><i class="ti-linkedin"></i></a>
                            <a href="#"><i class="ti-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="inner-header">
                    <div class="row">
                        <div class="col-lg-2 col-md-2">
                            <div class="logo">
                                <a href="./index.html">
                                    <img src="img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-7 col-md-7">
                            <div class="advanced-search">
                                <button type="button" class="category-btn">All Categories</button>
                                <div class="input-group">
                                    <input type="text" placeholder="What do you need?">
                                    <button type="button"><i class="ti-search"></i></button>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 text-right col-md-3">
                            <ul class="nav-right">
                                <li class="heart-icon">
                                    <a href="#">
                                        <i class="icon_heart_alt"></i>
                                        <span>1</span>
                                    </a>
                                </li>
                                <li class="cart-icon">
                                    <a href="#">
                                        <i class="icon_bag_alt"></i>
                                        <span>3</span>
                                    </a>
                                    <div class="cart-hover">
                                        <div class="select-items">
                                            <table>
                                                <tbody>
                                                    <tr>
                                                        <td class="si-pic"><img src="img/select-product-1.jpg" alt=""></td>
                                                        <td class="si-text">
                                                            <div class="product-selected">
                                                                <p>$60.00 x 1</p>
                                                                <h6>Kabino Bedside Table</h6>
                                                            </div>
                                                        </td>
                                                        <td class="si-close">
                                                            <i class="ti-close"></i>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="si-pic"><img src="img/select-product-2.jpg" alt=""></td>
                                                        <td class="si-text">
                                                            <div class="product-selected">
                                                                <p>$60.00 x 1</p>
                                                                <h6>Kabino Bedside Table</h6>
                                                            </div>
                                                        </td>
                                                        <td class="si-close">
                                                            <i class="ti-close"></i>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="select-total">
                                            <span>total:</span>
                                            <h5>$120.00</h5>
                                        </div>
                                        <div class="select-button">
                                            <a href="#" class="primary-btn view-card">VIEW CARD</a>
                                            <a href="#" class="primary-btn checkout-btn">CHECK OUT</a>
                                        </div>
                                    </div>
                                </li>
                                <li class="cart-price">$150.00</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="nav-item">
                <div class="container">
                    <div class="nav-depart">
                        <div class="depart-btn">
                            <i class="ti-menu"></i>
                            <span>All departments</span>
                            <ul class="depart-hover">
                                <li class="active"><a href="#">Women???s Clothing</a></li>
                                <li><a href="#">Men???s Clothing</a></li>
                                <li><a href="#">Underwear</a></li>
                                <li><a href="#">Kid's Clothing</a></li>
                                <li><a href="#">Brand Fashion</a></li>
                                <li><a href="#">Accessories/Shoes</a></li>
                                <li><a href="#">Luxury Brands</a></li>
                                <li><a href="#">Brand Outdoor Apparel</a></li>
                            </ul>
                        </div>
                    </div>
                    <nav class="nav-menu mobile-menu">
                        <ul>
                            <li class="active"><a href="./index.html">Home</a></li>
                            <li><a href="./shop.html">Shop</a></li>
                            <li><a href="#">Collection</a>
                                <ul class="dropdown">
                                    <li><a href="#">Men's</a></li>
                                    <li><a href="#">Women's</a></li>
                                    <li><a href="#">Kid's</a></li>
                                </ul>
                            </li>
                            <li><a href="./blog.html">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="dropdown">
                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                    <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                    <li><a href="./check-out.html">Checkout</a></li>
                                    <li><a href="./faq.html">Faq</a></li>
                                    <li><a href="./register.html">Register</a></li>
                                    <li><a href="./login.html">Login</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                    <div id="mobile-menu-wrap"></div>
                </div>
            </div>
        </header>-->
        <!-- Header End -->

        <h1>User List</h1>
        <form action="search">

        </form><br>

        <form id="f" action="userlist" method="post">
            Search
            <input type="text" name="search" placeholder="Text in here" value = "${requestScope.search}"/> 
            <input type="submit" value="Search"/> <br>

            Gender
            <select name="gender" onchange="document.getElementById('f').submit()" value = "${requestScope.gender}">
                <option value="" >All</option>
                <option value="1" <%= request.getAttribute("gender").equals("1") ? "selected='selected'" : ""%> >Male</option>
                <option value="0" <%= request.getAttribute("gender").equals("0") ? "selected='selected'" : ""%> >Female</option>
            </select>
            Role
            <select name="role" onchange="document.getElementById('f').submit()" value = "${requestScope.role}">
                <option value="" >All</option>
                <option value="1" <%= request.getAttribute("role").equals("1") ? "selected='selected'" : ""%> >Admin</option>
                <option value="2" <%= request.getAttribute("role").equals("2") ? "selected='selected'" : ""%> >Customer</option>
                <option value="3" <%= request.getAttribute("role").equals("3") ? "selected='selected'" : ""%> >Sale</option>
                <option value="4" <%= request.getAttribute("role").equals("4") ? "selected='selected'" : ""%> >Marketing</option>
            </select>
            Status
            <select name="status" onchange="document.getElementById('f').submit()" value = "${requestScope.status}">
                <option value="" >All</option>
                <option value="1" <%= request.getAttribute("status").equals("1") ? "selected='selected'" : ""%> >Active</option>
                <option value="0" <%= request.getAttribute("status").equals("0") ? "selected='selected'" : ""%> >Deactive</option>
            </select><br>

            Sort by:
            <select name="sort" onchange="document.getElementById('f').submit()" value="${requestScope.sort}">
                <option value="Account_ID" <%= request.getAttribute("sort").equals("Account_ID") ? "selected='selected'" : ""%>  >Account_ID</option>
                <option value="Name" <%= request.getAttribute("sort").equals("Name") ? "selected='selected'" : ""%>>Name</option>
                <option value="Email" <%= request.getAttribute("sort").equals("Email") ? "selected='selected'" : ""%> >Email</option>
                <option value="Phone" <%= request.getAttribute("sort").equals("Phone") ? "selected='selected'" : ""%> >Phone</option>
                <option value="Role_ID" <%= request.getAttribute("sort").equals("Role_ID") ? "selected='selected'" : ""%> >Role</option>
            </select>

        </form>

        <table border = "1px" width = "80%">
            <tr>
                <th>User ID</th>
                <th>Full Name</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Role</th>
                <th>Status</th>
                <th>#</th>
            </tr>
            <c:forEach items="${requestScope.UserList}" var="a">
                <tr>
                    <td>${a.getAccountID()}</td>
                    <td>${a.getName()}</td>
                    <td>
                        <c:if test="${a.isGender()== true}">Male</c:if>
                        <c:if test="${a.isGender()== false}">Female</c:if>
                        </td>
                        <td>${a.getEmail()}</td>
                    <td>${a.getPhone()}</td>
                    <td>
                        <c:if test="${a.getRole()== 1}">Admin</c:if>
                        <c:if test="${a.getRole()== 2}">Customer</c:if>
                        <c:if test="${a.getRole()== 3}">Sale</c:if>
                        <c:if test="${a.getRole()== 4}">Marketing</c:if>
                        </td>
                        <td>
                        <c:if test="${a.isStatus()== true}">Active</c:if>
                        <c:if test="${a.isStatus()== false}">Deactive</c:if>
                        </td>
                        <td> <a href="userdetail?id=${a.getAccountID()}">Detail</a> </td>
                </tr>
            </c:forEach>
        </table>
        <a href="#"><input type="submit" value="Add User" /></a>

        <!-- Footer Section Begin -->
<!--        <footer class="footer-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="footer-left">
                            <div class="footer-logo">
                                <a href="#"><img src="img/footer-logo.png" alt=""></a>
                            </div>
                            <ul>
                                <li>Address: 60-49 Road 11378 New York</li>
                                <li>Phone: +65 11.188.888</li>
                                <li>Email: hello.colorlib@gmail.com</li>
                            </ul>
                            <div class="footer-social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 offset-lg-1">
                        <div class="footer-widget">
                            <h5>Information</h5>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Serivius</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="footer-widget">
                            <h5>My Account</h5>
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Shopping Cart</a></li>
                                <li><a href="#">Shop</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="newslatter-item">
                            <h5>Join Our Newsletter Now</h5>
                            <p>Get E-mail updates about our latest shop and special offers.</p>
                            <form action="#" class="subscribe-form">
                                <input type="text" placeholder="Enter Your Mail">
                                <button type="button">Subscribe</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright-reserved">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="copyright-text">
                                Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. 
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. 
                            </div>
                            <div class="payment-pic">
                                <img src="img/payment-method.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>-->
        <!-- Footer Section End -->

        <!-- Js Plugins -->
<!--        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/imagesloaded.pkgd.min.js" type="text/javascript"></script>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="../js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="../js/jquery.countdown.min.js" type="text/javascript"></script>
        <script src="../js/jquery.dd.min.js" type="text/javascript"></script>
        <script src="../js/jquery.nice-select.min.js" type="text/javascript"></script>
        <script src="../js/jquery.slicknav.js" type="text/javascript"></script>
        <script src="../js/jquery.zoom.min.js" type="text/javascript"></script>
        <script src="../js/main.js" type="text/javascript"></script>
        <script src="../js/owl.carousel.min.js" type="text/javascript"></script>-->

    </body>



</html>
