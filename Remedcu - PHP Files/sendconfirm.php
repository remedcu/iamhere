<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$username = $_POST['Username'];
		$myusername = $_POST['User'];
		require_once('dbConnext.php');
		$sql = "UPDATE `registration` SET `key`=1, `sandr`='$myusername' where `Username`='$username'";
		$result = mysqli_query($con,$sql);
//		$check = mysqli_fetch_array($result);
		
/*		if (!$check) {
	    printf("Error: %s\n", mysqli_error($con));
	    exit();
		}
*/		
		if(isset($result))
		{
			echo 'success';
		}else{
			echo 'Username does not exist';
		}
	}

	?>