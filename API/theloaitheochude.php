<?php
    require "connect.php";

    class TheLoai{
        function TheLoai($idtheloai, $idchude, $tentheloai, $hinhtheloai){
            $this->IdTheLoai = $idchude;
            $this->IdKeyChuDe = $idchude;
            $this->TenTheLoai = $tentheloai;
            $this->HinhTheLoai = $hinhtheloai;
        }
    }
    $arrtheloai = array();

    $idchude = $_POST['idchude'];
    $query = "SELECT * FROM theloai WHERE IdChuDe = '$idchude'";
    $data = mysqli_query($conn, $query);
    while($row = mysqli_fetch_assoc($data)){ 
        array_push($arrtheloai, new TheLoai($row['IdTheLoai']
                                            ,$row['IdChuDe']
                                            ,$row['TenTheLoai']
                                            ,$row['HinhTheLoai']));

    }
    echo json_encode($arrtheloai);

?>