<?php
    require "connect.php";

    class BaiHat{
        function BaiHat($idbaihat, $tenbaihat, $hinhbaihat, $casi, $linkbaihat, $luotthich){
            $this->IdBaiHat = $idbaihat;
            $this->TenBaiHat = $tenbaihat;
            $this->HinhBaiHat = $hinhbaihat;
            $this->Casi = $casi;
            $this->LinkBaiHat = $linkbaihat;
            $this->LuotThich = $luotthich;        
        }
    }
    $arr_casi = array();
    $query = "SELECT * FROM baihat ORDER BY LuotThich DESC LIMIT 5";
    $data = mysqli_query($conn, $query);
    while($row = mysqli_fetch_assoc($data)){    
        array_push($arr_casi, new BaiHat($row['IdBaiHat']
                                        ,$row['TenBaiHat']
                                        ,$row['HinhBaiHat']
                                        ,$row['CaSi']
                                        ,$row['LinkBaiHat']
                                        ,$row['LuotThich']));
    }
    echo json_encode($arr_casi);
?>