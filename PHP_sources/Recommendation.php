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
    $query = "SELECT Food_Theme FROM menu WHERE menu_id=? ORDER BY DATEDIFF(NOW(), Latest_date)/Count DESC LIMIT 1";
	$statement = mysqli_prepare($con, $query);
	mysqli_stmt_bind_param($statement, "s", $userID);
	mysqli_stmt_execute($statement);

	mysqli_stmt_bind_result($statement, $res);
	while(mysqli_stmt_fetch($statement)) {
		$response["rec"] = $res;
		if($response["rec"] == 'china')
			$response["recommend"] = '중식';
		else if($response["rec"] == 'fast')
			$response["recommend"] = '분식';
		else if($response["rec"] == 'japan')
			$response["recommend"] = '일식';
		else if($response["rec"] == 'korea')
			$response["recommend"] = '한식';
		else if($response["rec"] == 'usa')
			$response["recommend"] = '양식';
	}

    $response["success"] = true;


    echo json_encode($response);

?>