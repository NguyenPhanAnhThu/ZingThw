<?php
    require "connect.php";

    $query = "SELECT * FROM playlist";
    $data = mysqli_query($conn, $query);

    class DanhSachPlaylist{
        function DanhSachPlaylist($idplaylist, $ten, $hinhnen, $hinhicon){
            $this->IdPlaylist = $idplaylist;
            $this->Ten = $ten;
            $this->HinhNen = $hinhnen;
            $this->HinhIcon = $hinhicon;
        }
    }
    $arrplaylist = array();
    while($row = mysqli_fetch_assoc($data)){
        array_push($arrplaylist, new DanhSachPlaylist($row['IdPlaylist']
                                                    , $row['Ten']
                                                    , $row['HinhNen']
                                                    , $row['HinhIcon'])); 
    }
    echo json_encode($arrplaylist);
?>