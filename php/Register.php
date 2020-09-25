<?php 
    header('Content-Type: application/json; charset=utf8');

    $address = '172.30.1.20';
    $id = 'tester';
    $pw = '1234';
    $db = 'whattoeat';
    $port = '81';

    $con = mysqli_connect($address, $id, $pw, $db);
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["User_ID"];
    $userPassword = $_POST["Password"];
    $userEmail = $_POST["User_Email"];

    $statement = mysqli_prepare($con, "INSERT INTO users VALUES (?,?,?)");
    mysqli_stmt_bind_param($statement, "sss", $userID, $userEmail, $userPassword);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>