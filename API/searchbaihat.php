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
    $arrcakhuc = array();
    if(isset($_POST['key'])){
        $key = $_POST['key'];
        $query = "SELECT * FROM baihat WHERE lower(TenBaiHat) LIKE '%key%'";
        $data = mysqli_query($conn, $query);
        while($row= mysqli_fetch_assoc($data)){
            array_push($arrcakhuc, new BaiHat($row['IdBaiHat']
                                                ,$row['TenBaiHat']
                                                ,$row['HinhBaiHat']
                                                ,$row['CaSi']
                                                ,$row['LinkBaiHat']
                                                ,$row['LuotThich']));
        }
        echo json_encode($arrcakhuc);
    }

    
?>