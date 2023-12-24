<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
       
      body {
    margin: 0px;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: rgb(33, 37, 41);
    text-align: left;
    background-color: rgb(255, 255, 255);
}
        .padding {
            padding: 3rem !important
        }
.row {
    display: flex;
    flex-wrap: wrap;
    margin-right: -15px;
    margin-left: -15px;
    }
.col-sm-8 { width: 50%;
    -webkit-box-flex: 0;
    flex: 0 0 66.6667%;
    max-width: 66.6667%;
    position: relative;
    width: 50%;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}
.container {
    width: 60%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}
        .user-card-full {
            overflow: hidden;
        }

        .card {
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);
            box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);
            border: none;
            margin-bottom: 30px;
        }

       .m-r-0 {
    margin-right: 0px;
}

.m-l-0 {
    margin-left: 0px;
}

.user-card-full .user-profile {
    border-radius: 5px 0 0 5px;
}

.bg-c-lite-green {
        background: -webkit-gradient(linear, left top, right top, from(#f29263), to(#ee5a6f));
    background: linear-gradient(to right, #ee5a6f, #f29263);
}

.user-profile {
    padding: 20px 0;
}

.card-block {
    padding: 1.25rem;
}

.m-b-25 {
    margin-bottom: 5px;
}

.img-radius {
    border-radius: 5px;
}


 
h6 {
    font-size: 14px;
}

.card .card-block p {
    line-height: 25px;
}

@media only screen and (min-width: 1400px){
p {
    font-size: 14px;
}
}

.card-block {
    padding: 1.25rem;
}

.b-b-default {
    border-bottom: 1px solid #e0e0e0;
}


.p-b-5 {
    padding-bottom: 5px !important;
}

.card .card-block p {
    line-height: 25px;
}

.m-b-10 {
    margin-bottom: 10px;
}

.text-muted {
    color: #919aa3 !important;
}

.b-b-default {
    border-bottom: 1px solid #e0e0e0;
     
}

.f-w-600 {
    font-weight: 600;
}



.m-t-40 {
    margin-top: 30px;
}

.p-b-5 {
    padding-bottom: 2px !important;
}




.m-b-20 {
    margin-bottom: 5px;
    margin-top: -5px;
  margin-left: 200px;
}
.m-t-40 {
    margin-top: 10px;
}

.user-card-full .social-link li {
    display: inline-block;
}

.user-card-full .social-link li a {
    font-size: 20px;
    margin: 0 10px 0 0;
    -webkit-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}
.bg-c-lite-green {
    background: -webkit-gradient(linear, left top, right top, from(#f29263), to(#ee5a6f));
    background: linear-gradient(to right, #ee5a6f, #f29263) #important!;
}
.col-xl-6{
    position: relative;
    width: 100%;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px s}
       
       .col-sm-4{
    
    width: 25%; }
   }
       
.col-sm-6 {
    position: relative;
    width: 100%;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}.col-sm-10 {
    position: relative;
    width: 100%;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}
.img-radius {
    margin-top: 150px; /* Vous pouvez ajuster cette valeur selon votre besoin */
}
    </style>
</head>
<%@ page import="com.luxora.beans.Client" %>
    <% Client clt = (Client) request.getAttribute("clt"); %>
    <% if (clt != null) { %>
<body>
    <div class="page-content page-container" id="page-content"> 
    <div class="padding">
        <div class="row container d-flex justify-content-center">
<div class="col-xl-6 col-md-12">
                                                <div class="card user-card-full">
                                                    <div class="row m-l-0 m-r-0">
                                                        <div class="col-sm-4 bg-c-lite-green user-profile">
                                                            <div class="card-block text-center text-white">
                                                                <div class="m-b-25">
                                                                    <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image">
                                                                </div>
                                                                <h6 class="f-w-600"><%=clt.getUsername() %></h6>
                                                                
                                                                <i class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-8">
                                                            <div class="card-block">
                                                               <p style="text-align: center;" class="m-b-10 m-t-40 p-b-5  f-w-600">Informations</p>
                                                                <div class="row">
                                                               
                                                                    <div class="col-sm-10">
                                                                        <p class="m-b-10 m-t-40 p-b-5 b-b-default f-w-600">Nom</p>
                                                                        <h6 class="text-muted f-w-400"><%=clt.getNom_uti() %></h6>
                                                                    </div>
                                                                   
                                                                    <div class="col-sm-10">
                                                                        <p class="m-b-10 m-t-40 p-b-5 b-b-default f-w-600 ">  Prenom </p>
                                                                        <h6 class="text-muted f-w-400"><%=clt.getPrenom_uti() %></h6>
                                                                    </div>
                                                                    
                                                                  </div>
                                                               
                                                                <p class="m-b-40 m-t-40 p-b-5 b-b-default f-w-600">Adresse</p>
                                                                <h6 class="text-muted f-w-400"><%=clt.getAddress() %></h6>
                                                                  
                                                                    <div class="col-sm-6">
                                                                        <p class="m-b-10 f-w-600  b-b-default f-w-600">Mail</p>
                                                                        <h6 class="text-muted f-w-400"><%=clt.getEmail() %></h6>
                                                                    </div>
                                                         <p class="m-b-40 m-t-40 p-b-5 b-b-default f-w-600">numéro de telephone</p>
                                                                <h6 class="text-muted f-w-400"><%=clt.getNum_Tel() %></h6>
                                                                  
                                                                
                                                                
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                             </div>
                                                </div>
                                                </div>
                                                <% } 
    else { %>
        <p>Aucun client trouvé</p>
    <% } %>
                                            </body>
                                            </html> 
                                            