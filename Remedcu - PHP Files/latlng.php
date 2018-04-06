<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$lat = $_POST['lat'];
		$lang = $_POST['lang'];
		$myusername = $_POST['User'];
		require_once('dbConnext.php');
		$sql = "UPDATE `registration` SET `latitude`='$lat', `longitude`='$lang' where `Username`='$myusername'";
		$result = mysqli_query($con,$sql);
//		$check = mysqli_fetch_array($result);
		
/*		if (!$check) {
	    printf("Error: %s\n", mysqli_error($con));
	    exit();
		}
*/		
		if(isset($result))
		{
			echo 'updated';
		}else{
			echo 'error';
		}
	}
?>