<?php

include 'connection.php';

if($_POST){

    $email = $_POST['email'] ?? '';
    $password = $_POST['password'] ?? '';

    $response = []; 

    $userQuery = $connection->prepare("SELECT * FROM users where email = ? AND role = 'Siswa'");
    $userQuery->execute(array($email));
    $query = $userQuery->fetch();

    if($userQuery->rowCount() == 0){
        $response['status'] = false;
        $response['message'] = "Email Tidak Terdaftar";
    } else {

        $passwordDB = $query['password'];

        if(strcmp(md5($password),$passwordDB) === 0){
            $response['status'] = true;
            $response['message'] = "Login Berhasil";
            $response['data'] = [
                'name' => $query['name'],
                'nomor_induk' => $query['nomor_induk'],
                'email' => $query['email']
            ];
        } else {
            $response['status'] = false;
            $response['message'] = "Password anda salah";
        }
    }

    $json = json_encode($response, JSON_PRETTY_PRINT);

    echo $json;

}