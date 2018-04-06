<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$username = $_POST['Username'];
		$email = $_POST['Email'];
		$password = $_POST['Password'];
		
		require_once('dbConnext.php');
		
		if($username==""||$password=="")
		{
			echo "Please fill in all the fields";
		}
		else
		{
		$sql = "INSERT INTO registration (Username,Email,Password) VALUES ('$username','$email','$password')";
		
		if(mysqli_query($con,$sql)){
			echo "Successfully Registered";
		}else{
			echo "Username/Email already exist";
		}
		}
	}
	else
	{
		echo 'error';
		}