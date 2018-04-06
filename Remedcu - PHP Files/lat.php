<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$myusername = $_POST['User'];
		require_once('dbConnext.php');
		$sql = "SELECT latitude FROM `registration` WHERE `sandr`='$myusername' AND `key`=1";
		$result = mysqli_query($con,$sql);
//		$check = mysqli_fetch_array($result);		
		if(isset($result))
		{
		while($check = mysqli_fetch_assoc($result)){
		echo "{$check['latitude']}";
		}}else{
			echo 'Connection Error';
		}
	}
?>