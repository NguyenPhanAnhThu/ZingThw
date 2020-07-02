<?php
    require "connect.php";

    $query="SELECT DISTINCT * FROM playlist ORDER BY rand(" . date("Ymd") . ") LIMIT 3";
    class PlaylistToday{
        function PlaylistToday($idplaylist, $ten, $hinh, $icon){
            $this->IdPlaylist = $idplaylist;
            $this->Ten = $ten;
            $this->HinhNen = $hinh;
            $this->HinhIcon = $icon;
        }
    }
    $arrayplaylistfortoday = array();
    $data = mysqli_query($conn, $query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($arrayplaylistfortoday, new PlaylistToday($row['IdPlaylist']
                                                                , $row['Ten']
                                                                , $row['HinhNen']
                                                                , $row['HinhIcon']));
    }
    echo json_encode($arrayplaylistfortoday);
?>