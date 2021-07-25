<?php
require_once 'connection.php';

if($con) {
    
    $email = $_POST['email'];
    $password = md5($_POST['password']);

    $query = "SELECT * FROM users WHERE email = '$email' AND password = '$password'";
    $result = mysqli_query($con, $query);
    $response = array();

    $row = mysqli_fetch_assoc($result);

    $_SESSION['email'] = $row['email'];
    $_SESSION['role'] = $row['role'];

    if ($row ['role'] == "Siswa") {
        array_push($response, array(
            'status' => 'OK'
        ));
    } else {
        array_push($response, array(
            'status' => 'Failed'
        ));
    }
} else {
    array_push($response, array(
        'status' => 'FAILED'
    ));
}

echo json_encode(array("server_response" => $response));
mysqli_close($con);
?>