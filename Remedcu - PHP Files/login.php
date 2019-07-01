<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$username = $_POST['Username'];
		$password = $_POST['Password'];
		
		require_once('dbConnext.php');
		
		$sql = "SELECT * FROM registration WHERE Username='$username' AND Password='$password'";
		$result = mysqli_query($con,$sql);
		$check = mysqli_fetch_array($result);
		
		if(isset($check)){
			echo 'success';
		}else{
			echo 'Invalid credentials';
		}
	}