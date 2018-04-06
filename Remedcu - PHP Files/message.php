<?php
require_once('dbConnect.php');
if($_SERVER['REQUEST_METHOD']=='POST')
{
 $receiverid = $_POST['senderid'];
 $json_output     = array();
 $jsonTempData  = array();

 $sql = "SELECT * FROM compose WHERE receiverid='$receiverid' AND deletion=0 ORDER BY id DESC";
$result = mysqli_query($con,$sql);
// $check = mysqli_fetch_array($result);
 
 if($result->num_rows> 0)
 {
	 for ($x=0; $row = $result->fetch_assoc(); $x++) {
$jTempData['num']=$row["id"];

			
			$jTempData['receiver']=$row["senderid"];
			$jTempData['subject']=$row["subject"];
			$jTempData['message']=$row["message"];
			$jTempData['date']=$row["date"];
			$jTempData['time']=$row["time"];
			
			
		
$jsonData[$x]=$jTempData;
}
$outputArr['Android'] = $jsonData;
// Encode Array To JSON Data
print_r( json_encode($outputArr));
 
 }

 
 
 else
 {
 echo "you have no messages yet";
 }
 }
else
{
echo 'error';
}



?>