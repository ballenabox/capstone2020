<?php 
    header('Content-Type: application/json; charset=utf8');

    $address = '172.30.1.20';
    $id = 'tester';
    $pw = '1234';
    $db = 'whattoeat';

    $con = mysqli_connect($address, $id, $pw, $db);
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["User_ID"];
    $food_theme = $_POST["Food_Theme"];

    $query = "UPDATE menu SET Count=Count+1,Latest_Date=NOW() WHERE menu_id=? AND Food_Theme=?";
    $statement = mysqli_prepare($con, $query);
    mysqli_stmt_bind_param($statement, "ss", $userID, $food_theme);
    mysqli_stmt_execute($statement);





    $response = array();
    $response["success"] = true;
   
    echo json_encode($response);

?>