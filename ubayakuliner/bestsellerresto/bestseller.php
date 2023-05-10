<?php
error_reporting(E_ERROR | E_PARSE);
$c = new mysqli("localhost", "root","mysql","ubayakuliner");
if($c->connect_errno) {
    $arr = array("result" => "ERROR", "message" => "Failed to Connect");
    echo json_encode($arr);
    die();
}

if (!empty($_GET['id'])) {
    $id = (int) $_GET['id'];
    $sql = "SELECT * FROM best_seller where id=$id;";
    
    $result = $c->query($sql);
    $array = array();

    if ($result->num_rows > 0) {
        while ($obj = $result -> fetch_object()) {
            $array = $obj;
        }
        echo json_encode($array);
    } else {
        echo json_encode(array('result'=> 'ERROR', 'message' => 'No data found'));
        die();
    }
}
else{
    $sql = "SELECT * FROM best_seller";
    $result = $c->query($sql);
    $array = array();



    if ($result->num_rows > 0) {
        while ($obj = $result -> fetch_object()) {
            $array[] = $obj;
        }
        echo json_encode($array);
    } else {
        echo json_encode(array('result'=> 'ERROR', 'message' => 'No data found'));
        die();
    }
}
?>


