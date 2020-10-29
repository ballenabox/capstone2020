<?php 
    header('Content-Type: application/json; charset=utf8');

    $address = '172.30.1.20';
    $id = 'tester';
    $pw = '1234';
    $db = 'whattoeat';

    $con = mysqli_connect($address, $id, $pw, $db);
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["User_ID"];

    $query = "SELECT Count FROM menu WHERE menu_id = ?";

    $statement = mysqli_prepare($con, $query);
    mysqli_stmt_bind_param($statement, "s", $userID);
    mysqli_stmt_execute($statement);

    $response = array();

    mysqli_stmt_bind_result($statement, $Count);
    $cnt = 1;
    while (mysqli_stmt_fetch($statement)) {
    	if($cnt == 1)
    		$response["china"] = $Count;
    	else if($cnt == 2)
    		$response["fast"] = $Count;
    	else if($cnt == 3)
    		$response["japan"] = $Count;
    	else if($cnt == 4)
    		$response["korea"] = $Count;
    	else if($cnt == 5)
    		$response["usa"] = $Count;
    	$cnt++;
    }

    
    $response["success"] = true;


    echo json_encode($response);

?>