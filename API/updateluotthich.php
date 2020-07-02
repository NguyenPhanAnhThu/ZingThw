<?php
    require "connect.php";

    $luotthich = $_POST['luotthich'];
    $idbaihat = $_POST['idbaihat'];
    
    $query = "SELECT LuotThich FROM baihat WHERE IdBaiHat = '$idbaihat'";
    $dataluotthich = mysqli_query($conn, $query);
    $row = mysqli_fetch_assoc($dataluotthich);
    $tongluotthich = $row['LuotThich'];

    if(isset($luotthich)){
        $tongluotthich = $tongluotthich + $luotthich;
        $querysum = "UPDATE baihat SET LuotThich = '$tongluotthich' WHERE IdBaiHat = '$idbaihat' ";
        $dataupdate = mysqli_query($conn, $querysum);
        if($dataupdate){
            echo "Success";
        }else {
            echo "Fail";
        }
    }
?>