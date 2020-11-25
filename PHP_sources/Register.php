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
    $userEmail = $_POST["User_Email"];

    $sql1 = sprintf("INSERT INTO users VALUES('%s', '%s', '%s');", mysqli_real_escape_string($con, $userID), mysqli_real_escape_string($con, $userEmail), mysqli_real_escape_string($con, $userPassword));
    $sql2 = sprintf("INSERT INTO menu VALUES ('china', 0, NOW(), '%s');", mysqli_real_escape_string($con, $userID));
    $sql3 = sprintf("INSERT INTO menu VALUES ('fast', 0, NOW(), '%s');", mysqli_real_escape_string($con, $userID));
    $sql4 = sprintf("INSERT INTO menu VALUES ('japan', 0, NOW(), '%s');", mysqli_real_escape_string($con, $userID));
    $sql5 = sprintf("INSERT INTO menu VALUES ('korea', 0, NOW(), '%s');", mysqli_real_escape_string($con, $userID));
    $sql6 = sprintf("INSERT INTO menu VALUES ('usa', 0, NOW(), '%s');", mysqli_real_escape_string($con, $userID));

    $res = $sql1;
    $res .= $sql2;
    $res .= $sql3;
    $res .= $sql4;
    $res .= $sql5;
    $res .= $sql6;

    if(mysqli_multi_query($con, $res)) {
    	$response["success"] = true;
    }
    else {
    	$response["success"] = false;
    }
    
    mysqli_close($con);
 
    echo json_encode($response);

?>