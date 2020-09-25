<?php
	$address = '172.30.1.20';
	$id = 'tester';
	$pw = '1234';
	$db = 'whattoeat';
	$port = '81';

    $con = mysqli_connect($address, $id, $pw, $db);
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["User_ID"];
    $userPassword = $_POST["Password"];

    
    $statement = mysqli_prepare($con, "DELETE FROM users WHERE User_ID = ? AND Password = ?");
    mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;
 

    echo json_encode($response);



?>