<%--
  Created by IntelliJ IDEA.
  User: blainebechtel
  Date: 10/29/23
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <%--  <!--CSS LINK-->--%>
    <link rel="stylesheet" type="text/css" href="style.css">

    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800&family=Pacifico&display=swap" rel="stylesheet">


</head>
<body>

<%--<!---NAV BAR -->--%>
<header>
    <a href="#" class="logo"><img src="img/hellogift.png"></a>

    <ul class="navbar">
        <li><a href="home.jsp">Home</a></li>
        <li><a href="cards.html">Cards</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="contact.html">Contact</a></li>
        <li><a href="login.html">Login</a></li>
    </ul>

    <div class="nav-icons">
        <input type="text" placeholder="Search..">
        <a href="cart.html"><i class='bx bxs-shopping-bag'></i> </a>
        <a href="contact.html"><i class='bx bxs-phone'></i></a>
        <a href="#"><i class='bx bxs-heart'></i></a>
        <a href="#"><i class='bx bx-user-circle' onclick="toggleMenu()"></i></a>
    </div>

    </div>
    <div class="dropdown">
        <div class="sub-menu-wrap" id="subMenu">
            <div class="sub-menu">
                <div class="user-info">
                    <img src="userpicture.png">
                    <h3>Your Name Here</h3>
                </div>
                <hr>

                <a href="#" class="sub-menu-link">
                    <img src="userpicture.png">
                    <p>Edit Profile</p>
                    <span> > </span>
                </a>
                <a href="#" class="sub-menu-link">
                    <img src="settings.png">
                    <p>Settings</p>
                    <span> > </span>
                </a>
                <a href="#" class="sub-menu-link">
                    <img src="contactus.png">
                    <p>Contact Us</p>
                    <span> > </span>
                </a>
                <a href="#" class="sub-menu-link">
                    <img src="logout.png">
                    <p>Logout</p>
                    <span> > </span>
                </a>
            </div>
        </div>
    </div>

</header>


<%--<!----header -->--%>
<section class="main-home">
    <div class="main-text">
        <h1>Customize Your Holiday Greeting</h1>
        <h5>Shop Our New Winter Customizable Cards</h5>
        <p>Where heartfelt connections come to life through <br> the art of gifting.</p>

        <a href="cards.html" class="main-btn">Choose A Card</a>
    </div>
</section>

<section id="feature" class="section-p1">
    <div class="fe-box">
        <img src="img/features/f1.png" alt="">
        <h6>Free Shipping</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f2.png" alt="">
        <h6>Online Order</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f3.png" alt="">
        <h6>Save Money</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f4.png" alt="">
        <h6>Promotions</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f6.png" alt="">
        <h6>F24/7 Support</h6>
    </div>
</section>

<%--<!----new collection--->--%>
<section class="winter-cards">
    <div class="center-text">
        <h1>Winter Card Colletion</h1>
    </div>

    <div class="new-content">
        <div class="row">
            <img src="img/christmas.png">
            <h4>CHRISTMAS CARD</h4>
            <h5>$5.00</h5>
            <div class="bbtn">
                <a href="#">Add to cart</a>
            </div>
        </div>


        <div class="row">
            <img src="img/christmas2.png">
            <h4>MERRY CHRISTMAS</h4>
            <h5>$5.00</h5>
            <div class="bbtn">
                <a href="#">Add to cart</a>
            </div>
        </div>

        <div class="row">
            <img src="img/christmas3.png">
            <h4>HAPPY HOLIDAYS</h4>
            <h5>$5.00</h5>
            <div class="bbtn">
                <a href="#">Add to cart</a>
            </div>
        </div>
    </div>
</section>


<%--<!-----FOOTER ---->--%>
<section class="contact">
    <div class="contact-box">
        <h4>MY ACCOUNT</h4>
        <li><a href="#">My account</a></li>
        <li><a href="#">Contact Us</a></li>
        <li><a href="#">Shopping Cart</a></li>
        <li><a href="#">WishList</a></li>
    </div>

    <div class="contact-box">
        <h4>QUICK LINKS</h4>
        <li><a href="#">Store Location</a></li>
        <li><a href="#">Orders Tracking</a></li>
        <li><a href="ProcessorLoginPage.jsp">Process LogIn</a></li>
        <li><a href="#">Cards</a></li>
        <li><a href="#">FAQs</a></li>

    </div>

    <div class="contact-box">
        <h4>INFORMATION</h4>
        <li><a href="#">Privacy Page</a></li>
        <li><a href="#">About us</a></li>
        <li><a href="#">Careers</a></li>
        <li><a href="#">Delivery Information</a></li>
        <li><a href="#">Term & Conditions</a></li>
    </div>
</section>
<script>
    let subMenu = document.getElementById("subMenu");

    function toggleMenu() {
        subMenu.classList.toggle("open-menu");
    }
</script>

</body>
</html>