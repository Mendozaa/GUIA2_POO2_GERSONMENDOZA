<%-- 
    Document   : index
    Created on : 10-ago-2016, 21:07:17
    Author     : gersonfrancisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>GUIA2_POO2_GERSONMENDOZA</title>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">GUIA2_POO2_GERSONMENDOZA</a>
            </div>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i> Inicio</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Personas
                            <small>Mantenimiento</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Inicio</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-file"></i> Formulario Personas
                            </li>
                        </ol>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-6">

                        <form role="form">

                            <div class="form-group">
                                <label>Nombre</label>
                                <input class="form-control" type="text" name="NombPers">
                            </div>
                            <div class="form-group">
                                <label>Apellido</label>
                                <input class="form-control" type="text" name="ApelPers">
                            </div>
                            <div class="form-group">
                                <label>Tipo persona</label>
                                <select class="form-control" name="TipoPers">
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Genero</label>
                                <select class="form-control" name="GenePers">
                                    <option value="M">Masculino</option>
                                    <option value="F">Femenino</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Fecha nacimiento</label>
                                <input class="form-control" type="date" name="FechNaciPers">
                            </div>
                            <div class="form-group">
                                <label>DUI</label>
                                <input class="form-control" type="text" name="DuiPers">
                            </div>

                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                                <label>NIT</label>
                                <input class="form-control" type="text" name="NitPers">
                            </div>
                            <div class="form-group">
                                <label>Tipo de sangre</label>
                                <select class="form-control" name="TipoSangPers">
                                    <option value="RH+">RH+</option>
                                    <option value="RH-">RH-</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Ubicacion geografica</label>
                                <select class="form-control" name="UbicGeogPers">
                                </select>
                            </div>

                            <button type="submit" class="btn btn-default">Guardar</button>
                            <button type="reset" class="btn btn-default">Reset Button</button>

                        </form>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
