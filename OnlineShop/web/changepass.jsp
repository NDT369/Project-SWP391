<%-- 
    Document   : profile
    Created on : May 30, 2022, 3:28:46 PM
    Author     : MSI
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="#"><i class="fa fa-home"></i> Home</a>
                    <span>Login</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Form Section Begin -->

<!-- Register Section Begin -->
<div class="register-login-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="login-form">
                    <h2>Change Password</h2>
                    <form action="changepass" method="POST">
                        <div class="group-input">
                            <label for="oldPass">Current Password *</label>
                            <input type="password" id="oldPass" name="oldPass" placeholder="Enter Current Password">
                        </div>
                        <div class="group-input">
                            <label for="newPass">New Password *</label>
                            <input type="password" id="newPass" name="newPass" placeholder="Enter New Password">
                        </div>
                        <div class="group-input">
                            <label for="confirmPass">Confirm New Password *</label>
                            <input type="password" id="confirmPass" name="confirmPass" placeholder="Confirm New Password">
                        </div>
                        <div class="group-input gi-check">
                            <div class="gi-more">
                                <!--                                <label for="save-pass">
                                                                    Save Password
                                                                    <input type="checkbox" id="save-pass">
                                                                    <span class="checkmark"></span>
                                                                </label>-->
                                <c:if test="${error != null && error != ''}">
                                    <h5 style="color: red">${requestScope.error}</h5>

                                </c:if>

                                <c:if test="${success != null && success != ''}">
                                    <h5 style="color: green">${requestScope.success}</h5>
                                </c:if>
                                <a href="#" class="forget-pass">Forget your Password</a>
                            </div>
                        </div>
                        <button type="submit" class="site-btn login-btn">Change</button>
                    </form>
                    <!--                    <div class="switch-login">
                                            <a href="./register.html" class="or-login">Or Create An Account</a>
                                        </div>-->
                </div>
            </div>
        </div>
    </div>
</div>