<?php
    $hostname = "localhost";
    $username = "id13600731_gnudan98";
    $password="NguyenPhanAnhThu.98";
    $databasename="id13600731_spotify";
    $conn = mysqli_connect($hostname, $username, $password, $databasename);
    mysqli_query($conn, "SET_NAMES 'utf-8'");

?>