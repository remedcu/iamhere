<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$myusername = $_POST['User'];
		require_once('dbConnext.php');
		$sql1 = "SELECT `sandr` FROM `registration` where `Username`='$myusername'";
		$result = mysqli_query($con,$sql1);
		while($check = mysqli_fetch_assoc($result)){
		$sql = "UPDATE `registration` SET `key`=1, `sandr`='$myusername' where `Username`='{$check['sandr']}'";
		$result1 = mysqli_query($con,$sql);
		}
//		$check = mysqli_fetch_array($result);
		
/*		if (!$check) {
	    printf("Error: %s\n", mysqli_error($con));
	    exit();
		}
*/		
		if(isset($result)&&isset($result1))
		{
			echo 'success';
		}else{
			echo 'Username does not exist';
		}
	}

	?>