<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$username = $_POST['Username'];		
		require_once('dbConnext.php');
		
		$sql = "SELECT * FROM registration WHERE Username='$username'";
		$result = mysqli_query($con,$sql);
		$check = mysqli_fetch_array($result);
		
		if(isset($check)&&$username!=""){
			echo 'found';
		}else{
			echo 'Username does not exist';
		}
	}