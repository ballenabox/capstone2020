<?php
    header('Content-Type: application/json; charset=utf8');

    $address = '172.30.1.20';
    $id = 'tester';
    $pw = '1234';
    $db = 'whattoeat';

    $con = mysqli_connect($address, $id, $pw, $db);
    mysqli_query($con,'SET NAMES utf8');

    $response = array();
    $userID = $_POST["User_ID"];
    $userPassword = $_POST["Password"];

    $sql1 = sprintf("DELETE FROM menu WHERE menu_id = '%s';", mysqli_real_escape_string($con, $userID));
    $sql2 = sprintf("DELETE FROM users WHERE User_ID = '%s' AND Password = '%s';", mysqli_real_escape_string($con, $userID), mysqli_real_escape_string($con, $userPassword));
    
    $res = $sql1;
    $res .= $sql2;

    if(mysqli_multi_query($con, $res)) {
    	$response["success"] = true;
    }
    else {
    	$response["success"] = false;
    }
    
    mysqli_close($con);
 
    echo json_encode($response);

?>