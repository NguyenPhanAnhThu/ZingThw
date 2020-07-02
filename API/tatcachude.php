<?php
    require "connect.php";

    class ChuDe{
        function ChuDe($idchude, $tenchude, $hinhchude){
            $this->IdChuDe = $idchude;
            $this->TenChuDe = $tenchude;
            $this->HinhChuDe = $hinhchude; 
        }
    }
    $arrchude = array();
    $query = "SELECT * FROM chude";
    $data = mysqli_query($conn, $query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($arrchude, new ChuDe($row['IdChuDe']
                                        ,$row['TenChuDe']
                                        ,$row['HinhChuDe']));
    }
    echo json_encode($arrchude);
?>