<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$myusername = $_POST['User'];
		require_once('dbConnext.php');
		$sql1 = "SELECT `sandr` FROM `registration` where `Username`='$myusername'";
		$result = mysqli_query($con,$sql1);
		if(isset($result))
		while($check = mysqli_fetch_assoc($result)){
		echo "{$check['sandr']}";
		}
		else{
			echo 'Username does not exist';
		}
		}
?>