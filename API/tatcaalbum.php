<?php
    require "connect.php";

    class Album{
        function Album($idalbum, $tenalbum, $tencasialbum, $hinhalbum){
             $this->IdAlbum = $idalbum;
             $this->TenAlbum = $tenalbum;
             $this->TenCaSiAlbum = $tencasialbum;
             $this->HinhAlbum = $hinhalbum;
        }
    }
    $arralbum = array();
    $query = "SELECT * FROM album";
    $data = mysqli_query($conn, $query);
    while($row=mysqli_fetch_assoc($data)){
        array_push($arralbum, new Album($row['IdAlbum']
                                        ,$row['TenAlbum']
                                        ,$row['TenCaSiAlbum']
                                        ,$row['HinhAlbum']));
    }
    echo json_encode($arralbum);
?>